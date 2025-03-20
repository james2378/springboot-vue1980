package com.controller;


import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.StringUtil;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import com.entity.ShuibiaoJiaofeiEntity;

import com.service.ShuibiaoJiaofeiService;
import com.entity.view.ShuibiaoJiaofeiView;
import com.service.ShuibiaoService;
import com.entity.ShuibiaoEntity;

import com.utils.PageUtils;
import com.utils.R;

/**
 * 水表缴费
 * 后端接口
 * @author
 * @email
 * @date 2021-04-23
*/
@RestController
@Controller
@RequestMapping("/shuibiaoJiaofei")
public class ShuibiaoJiaofeiController {
    private static final Logger logger = LoggerFactory.getLogger(ShuibiaoJiaofeiController.class);

    @Autowired
    private ShuibiaoJiaofeiService shuibiaoJiaofeiService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;



    //级联表service
    @Autowired
    private ShuibiaoService shuibiaoService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
     
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isNotEmpty(role) && "用户".equals(role)){
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        }
        params.put("orderBy","id");
        PageUtils page = shuibiaoJiaofeiService.queryPage(params);

        //字典表数据转换
        List<ShuibiaoJiaofeiView> list =(List<ShuibiaoJiaofeiView>)page.getList();
        for(ShuibiaoJiaofeiView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ShuibiaoJiaofeiEntity shuibiaoJiaofei = shuibiaoJiaofeiService.selectById(id);
        if(shuibiaoJiaofei !=null){
            //entity转view
            ShuibiaoJiaofeiView view = new ShuibiaoJiaofeiView();
            BeanUtils.copyProperties( shuibiaoJiaofei , view );//把实体数据重构到view中

            //级联表
            ShuibiaoEntity shuibiao = shuibiaoService.selectById(shuibiaoJiaofei.getShuibiaoId());
            if(shuibiao != null){
                BeanUtils.copyProperties( shuibiao , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setShuibiaoId(shuibiao.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody ShuibiaoJiaofeiEntity shuibiaoJiaofei, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,shuibiaoJiaofei:{}",this.getClass().getName(),shuibiaoJiaofei.toString());

        Integer shuibiaoId = shuibiaoJiaofei.getShuibiaoId();
        if(shuibiaoId == null){
            return R.error("水表不能为空");
        }
        ShuibiaoEntity shuibiaoEntity = shuibiaoService.selectById(shuibiaoId);
        if(shuibiaoEntity == null){
            return R.error("水表不能为空");
        }
        shuibiaoEntity.setShuibiaoNumber(shuibiaoEntity.getShuibiaoNumber()+ shuibiaoJiaofei.getShuibiaoJiaofeiMoney());
        shuibiaoService.updateById(shuibiaoEntity);
        shuibiaoJiaofei.setInsertTime(new Date());
        shuibiaoJiaofei.setCreateTime(new Date());
        shuibiaoJiaofeiService.insert(shuibiaoJiaofei);
        return R.ok();
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ShuibiaoJiaofeiEntity shuibiaoJiaofei, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,shuibiaoJiaofei:{}",this.getClass().getName(),shuibiaoJiaofei.toString());
        //根据字段查询是否有相同数据
        Wrapper<ShuibiaoJiaofeiEntity> queryWrapper = new EntityWrapper<ShuibiaoJiaofeiEntity>()
            .notIn("id",shuibiaoJiaofei.getId())
            .andNew()
            .eq("shuibiao_id", shuibiaoJiaofei.getShuibiaoId())
            .eq("shuibiao_jiaofei_yingshou_money", shuibiaoJiaofei.getShuibiaoJiaofeiYingshouMoney())
            .eq("shuibiao_jiaofei_money", shuibiaoJiaofei.getShuibiaoJiaofeiMoney())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShuibiaoJiaofeiEntity shuibiaoJiaofeiEntity = shuibiaoJiaofeiService.selectOne(queryWrapper);
        if(shuibiaoJiaofeiEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      shuibiaoJiaofei.set
            //  }
            shuibiaoJiaofeiService.updateById(shuibiaoJiaofei);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        shuibiaoJiaofeiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }






}

