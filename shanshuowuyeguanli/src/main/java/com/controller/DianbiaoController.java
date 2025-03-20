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

import com.entity.DianbiaoEntity;

import com.service.DianbiaoService;
import com.entity.view.DianbiaoView;
import com.service.YonghuService;
import com.entity.YonghuEntity;

import com.utils.PageUtils;
import com.utils.R;

/**
 * 售电
 * 后端接口
 * @author
 * @email
 * @date 2021-04-23
*/
@RestController
@Controller
@RequestMapping("/dianbiao")
public class DianbiaoController {
    private static final Logger logger = LoggerFactory.getLogger(DianbiaoController.class);

    @Autowired
    private DianbiaoService dianbiaoService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;



    //级联表service
    @Autowired
    private YonghuService yonghuService;


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
        PageUtils page = dianbiaoService.queryPage(params);

        //字典表数据转换
        List<DianbiaoView> list =(List<DianbiaoView>)page.getList();
        for(DianbiaoView c:list){
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
        DianbiaoEntity dianbiao = dianbiaoService.selectById(id);
        if(dianbiao !=null){
            //entity转view
            DianbiaoView view = new DianbiaoView();
            BeanUtils.copyProperties( dianbiao , view );//把实体数据重构到view中

            //级联表
            YonghuEntity yonghu = yonghuService.selectById(dianbiao.getYonghuId());
            if(yonghu != null){
                BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setYonghuId(yonghu.getId());
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
    public R save(@RequestBody DianbiaoEntity dianbiao, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,dianbiao:{}",this.getClass().getName(),dianbiao.toString());
        Wrapper<DianbiaoEntity> queryWrapper = new EntityWrapper<DianbiaoEntity>()
            .eq("dianbiao_name", dianbiao.getDianbiaoName())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        DianbiaoEntity dianbiaoEntity = dianbiaoService.selectOne(queryWrapper);
        if(dianbiaoEntity==null){
            dianbiao.setCreateTime(new Date());
        //  String role = String.valueOf(request.getSession().getAttribute("role"));
        //  if("".equals(role)){
        //      dianbiao.set
        //  }
            dianbiaoService.insert(dianbiao);
            return R.ok();
        }else {
            return R.error(511,"电表编号已被使用");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody DianbiaoEntity dianbiao, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,dianbiao:{}",this.getClass().getName(),dianbiao.toString());
        //根据字段查询是否有相同数据
        Wrapper<DianbiaoEntity> queryWrapper = new EntityWrapper<DianbiaoEntity>()
            .notIn("id",dianbiao.getId())
            .andNew()
            .eq("dianbiao_name", dianbiao.getDianbiaoName())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        DianbiaoEntity dianbiaoEntity = dianbiaoService.selectOne(queryWrapper);
        if(dianbiaoEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      dianbiao.set
            //  }
            dianbiaoService.updateById(dianbiao);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"电表编号已被使用");
        }
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        dianbiaoService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }






}

