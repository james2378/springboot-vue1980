package com.controller;


import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;

import com.entity.ShuibiaoEntity;
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

import com.entity.DianbiaoJiaofeiEntity;

import com.service.DianbiaoJiaofeiService;
import com.entity.view.DianbiaoJiaofeiView;
import com.service.DianbiaoService;
import com.entity.DianbiaoEntity;

import com.utils.PageUtils;
import com.utils.R;

/**
 * 电表缴费
 * 后端接口
 * @author
 * @email
 * @date 2021-04-23
*/
@RestController
@Controller
@RequestMapping("/dianbiaoJiaofei")
public class DianbiaoJiaofeiController {
    private static final Logger logger = LoggerFactory.getLogger(DianbiaoJiaofeiController.class);

    @Autowired
    private DianbiaoJiaofeiService dianbiaoJiaofeiService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;



    //级联表service
    @Autowired
    private DianbiaoService dianbiaoService;


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
        PageUtils page = dianbiaoJiaofeiService.queryPage(params);

        //字典表数据转换
        List<DianbiaoJiaofeiView> list =(List<DianbiaoJiaofeiView>)page.getList();
        for(DianbiaoJiaofeiView c:list){
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
        DianbiaoJiaofeiEntity dianbiaoJiaofei = dianbiaoJiaofeiService.selectById(id);
        if(dianbiaoJiaofei !=null){
            //entity转view
            DianbiaoJiaofeiView view = new DianbiaoJiaofeiView();
            BeanUtils.copyProperties( dianbiaoJiaofei , view );//把实体数据重构到view中

            //级联表
            DianbiaoEntity dianbiao = dianbiaoService.selectById(dianbiaoJiaofei.getDianbiaoId());
            if(dianbiao != null){
                BeanUtils.copyProperties( dianbiao , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setDianbiaoId(dianbiao.getId());
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
    public R save(@RequestBody DianbiaoJiaofeiEntity dianbiaoJiaofei, HttpServletRequest request){

        Integer dianbiaoId = dianbiaoJiaofei.getDianbiaoId();
        if(dianbiaoId == null){
            return R.error("电表不能为空");
        }
        DianbiaoEntity dianbiaoEntity = dianbiaoService.selectById(dianbiaoId);
        if(dianbiaoEntity == null){
            return R.error("电表不能为空");
        }
        dianbiaoEntity.setDianbiaoNumber(dianbiaoEntity.getDianbiaoNumber()+ dianbiaoJiaofei.getDianbiaoJiaofeiMoney());
        dianbiaoService.updateById(dianbiaoEntity);
        dianbiaoJiaofei.setInsertTime(new Date());
        dianbiaoJiaofei.setCreateTime(new Date());
        dianbiaoJiaofeiService.insert(dianbiaoJiaofei);
        return R.ok();

    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody DianbiaoJiaofeiEntity dianbiaoJiaofei, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,dianbiaoJiaofei:{}",this.getClass().getName(),dianbiaoJiaofei.toString());
        //根据字段查询是否有相同数据
        Wrapper<DianbiaoJiaofeiEntity> queryWrapper = new EntityWrapper<DianbiaoJiaofeiEntity>()
            .notIn("id",dianbiaoJiaofei.getId())
            .andNew()
            .eq("dianbiao_id", dianbiaoJiaofei.getDianbiaoId())
            .eq("dianbiao_jiaofei_yingshou_money", dianbiaoJiaofei.getDianbiaoJiaofeiYingshouMoney())
            .eq("dianbiao_jiaofei_money", dianbiaoJiaofei.getDianbiaoJiaofeiMoney())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        DianbiaoJiaofeiEntity dianbiaoJiaofeiEntity = dianbiaoJiaofeiService.selectOne(queryWrapper);
        if(dianbiaoJiaofeiEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      dianbiaoJiaofei.set
            //  }
            dianbiaoJiaofeiService.updateById(dianbiaoJiaofei);//根据id更新
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
        dianbiaoJiaofeiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }






}

