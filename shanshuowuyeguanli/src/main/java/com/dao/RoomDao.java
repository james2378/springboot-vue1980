package com.dao;

import com.entity.RoomEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.RoomView;

/**
 * 房间 Dao 接口
 *
 * @author 
 * @since 2021-04-23
 */
public interface RoomDao extends BaseMapper<RoomEntity> {

   List<RoomView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
