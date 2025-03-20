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

import com.entity.RoomEntity;

import com.service.RoomService;
import com.entity.view.RoomView;
import com.service.YonghuService;
import com.entity.YonghuEntity;

import com.utils.PageUtils;
import com.utils.R;

/**
 * 房间
 * 后端接口
 * @author
 * @email
 * @date 2021-04-23
*/
@RestController
@Controller
@RequestMapping("/room")
public class RoomController {
    private static final Logger logger = LoggerFactory.getLogger(RoomController.class);

    @Autowired
    private RoomService roomService;


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
        PageUtils page = roomService.queryPage(params);

        //字典表数据转换
        List<RoomView> list =(List<RoomView>)page.getList();
        for(RoomView c:list){
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
        RoomEntity room = roomService.selectById(id);
        if(room !=null){
            //entity转view
            RoomView view = new RoomView();
            BeanUtils.copyProperties( room , view );//把实体数据重构到view中

            //级联表
            YonghuEntity yonghu = yonghuService.selectById(room.getYonghuId());
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
    public R save(@RequestBody RoomEntity room, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,room:{}",this.getClass().getName(),room.toString());
        Wrapper<RoomEntity> queryWrapper = new EntityWrapper<RoomEntity>()
            .eq("building", room.getBuilding())
            .eq("unit", room.getUnit())
            .eq("room_number", room.getRoomNumber())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        RoomEntity roomEntity = roomService.selectOne(queryWrapper);
        if(roomEntity==null){
            room.setInsertTime(new Date());
            room.setCreateTime(new Date());
        //  String role = String.valueOf(request.getSession().getAttribute("role"));
        //  if("".equals(role)){
        //      room.set
        //  }
            roomService.insert(room);
            return R.ok();
        }else {
            return R.error(511,"房间已被使用");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody RoomEntity room, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,room:{}",this.getClass().getName(),room.toString());
        //根据字段查询是否有相同数据
        Wrapper<RoomEntity> queryWrapper = new EntityWrapper<RoomEntity>()
            .notIn("id",room.getId())
            .andNew()
            .eq("building", room.getBuilding())
            .eq("unit", room.getUnit())
            .eq("room_number", room.getRoomNumber())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        RoomEntity roomEntity = roomService.selectOne(queryWrapper);
        if(roomEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      room.set
            //  }
            roomService.updateById(room);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"房间已被使用");
        }
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        roomService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }






}

