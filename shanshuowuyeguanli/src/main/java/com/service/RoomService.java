package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.RoomEntity;
import java.util.Map;

/**
 * 房间 服务类
 * @author 
 * @since 2021-04-23
 */
public interface RoomService extends IService<RoomEntity> {

    /**
    * @param params 查询参数
    * @return 带分页的查询出来的数据
    */
     PageUtils queryPage(Map<String, Object> params);
}