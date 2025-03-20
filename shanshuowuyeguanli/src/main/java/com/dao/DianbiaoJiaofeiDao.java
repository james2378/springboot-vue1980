package com.dao;

import com.entity.DianbiaoJiaofeiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.DianbiaoJiaofeiView;

/**
 * 电表缴费 Dao 接口
 *
 * @author 
 * @since 2021-04-23
 */
public interface DianbiaoJiaofeiDao extends BaseMapper<DianbiaoJiaofeiEntity> {

   List<DianbiaoJiaofeiView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
