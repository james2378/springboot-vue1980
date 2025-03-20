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

import com.entity.RenshiEntity;

import com.service.RenshiService;
import com.entity.view.RenshiView;

import com.utils.PageUtils;
import com.utils.R;

/**
 * 人事信息
 * 后端接口
 * @author
 * @email
 * @date 2021-04-23
*/
@RestController
@Controller
@RequestMapping("/renshi")
public class RenshiController {
    private static final Logger logger = LoggerFactory.getLogger(RenshiController.class);

    @Autowired
    private RenshiService renshiService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;



    //级联表service


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
        PageUtils page = renshiService.queryPage(params);

        //字典表数据转换
        List<RenshiView> list =(List<RenshiView>)page.getList();
        for(RenshiView c:list){
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
        RenshiEntity renshi = renshiService.selectById(id);
        if(renshi !=null){
            //entity转view
            RenshiView view = new RenshiView();
            BeanUtils.copyProperties( renshi , view );//把实体数据重构到view中

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
    public R save(@RequestBody RenshiEntity renshi, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,renshi:{}",this.getClass().getName(),renshi.toString());
        Wrapper<RenshiEntity> queryWrapper = new EntityWrapper<RenshiEntity>()
            .eq("username", renshi.getUsername())
            .or()
            .eq("renshi_phone", renshi.getRenshiPhone())
            .or()
            .eq("gonghao", renshi.getGonghao())
            .or()
            .eq("renshi_id_number", renshi.getRenshiIdNumber());
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        RenshiEntity renshiEntity = renshiService.selectOne(queryWrapper);
        if(renshiEntity==null){
            renshi.setCreateTime(new Date());
            renshi.setPassword("123456");
        //  String role = String.valueOf(request.getSession().getAttribute("role"));
        //  if("".equals(role)){
        //      renshi.set
        //  }
            renshiService.insert(renshi);
            return R.ok();
        }else {
            return R.error(511,"账户或者身份证号或者手机号或者工号已经被使用");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody RenshiEntity renshi, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,renshi:{}",this.getClass().getName(),renshi.toString());
        //根据字段查询是否有相同数据
        Wrapper<RenshiEntity> queryWrapper = new EntityWrapper<RenshiEntity>()
            .notIn("id",renshi.getId())
            .andNew()
            .eq("username", renshi.getUsername())
            .or()
            .eq("gonghao", renshi.getGonghao())
            .or()
            .eq("renshi_phone", renshi.getRenshiPhone())
            .or()
            .eq("renshi_id_number", renshi.getRenshiIdNumber());
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        RenshiEntity renshiEntity = renshiService.selectOne(queryWrapper);
        if("".equals(renshi.getRenshiPhoto()) || "null".equals(renshi.getRenshiPhoto())){
                renshi.setRenshiPhoto(null);
        }
        if(renshiEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      renshi.set
            //  }
            renshiService.updateById(renshi);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"账户或者身份证号或者手机号或者工号已经被使用");
        }
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        renshiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

    /**
    * 登录
    */
    @IgnoreAuth
    @RequestMapping(value = "/login")
    public R login(String username, String password, String captcha, HttpServletRequest request) {
        RenshiEntity renshi = renshiService.selectOne(new EntityWrapper<RenshiEntity>().eq("username", username));
        if(renshi==null || !renshi.getPassword().equals(password)) {
            return R.error("账号或密码不正确");
        }
        //  // 获取监听器中的字典表
        // ServletContext servletContext = ContextLoader.getCurrentWebApplicationContext().getServletContext();
        // Map<String, Map<Integer, String>> dictionaryMap= (Map<String, Map<Integer, String>>) servletContext.getAttribute("dictionaryMap");
        // Map<Integer, String> role_types = dictionaryMap.get("role_types");
        // role_types.get(yonghu.getRoleTypes());
        String token = tokenService.generateToken(renshi.getId(),username, "renshi", "人事");
        R r = R.ok();
        r.put("token", token);
        r.put("role","人事");
        r.put("username",renshi.getRenshiName());
        r.put("tableName","renshi");
        r.put("userId",renshi.getId());
        return r;
    }

    /**
    * 注册
    */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody RenshiEntity renshi){
    //    	ValidatorUtils.validateEntity(user);
        if(renshiService.selectOne(new EntityWrapper<RenshiEntity>().eq("username", renshi.getUsername()).orNew().eq("renshi_phone",renshi.getRenshiPhone()).orNew().eq("renshi_id_number",renshi.getRenshiIdNumber())) !=null) {
            return R.error("账户已存在或手机号或身份证号已经被使用");
        }
        renshi.setCreateTime(new Date());
        renshiService.insert(renshi);
        return R.ok();
    }

    /**
     * 重置密码
     */
    @GetMapping(value = "/resetPassword")
    public R resetPassword(Integer  id){
        RenshiEntity renshi = new RenshiEntity();
        renshi.setPassword("123456");
        renshi.setId(id);
        renshiService.updateById(renshi);
        return R.ok();
    }

    /**
    * 获取用户的session用户信息
    */
    @RequestMapping("/session")
    public R getCurrRenshi(HttpServletRequest request){
        Integer id = (Integer)request.getSession().getAttribute("userId");
        RenshiEntity renshi = renshiService.selectById(id);
        return R.ok().put("data", renshi);
    }


    /**
    * 退出
    */
    @GetMapping(value = "logout")
    public R logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return R.ok("退出成功");
    }






}

