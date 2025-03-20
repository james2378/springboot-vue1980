package com.dao;

import com.entity.ShuibiaoJiaofeiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ShuibiaoJiaofeiView;

/**
 * 水表缴费 Dao 接口
 *
 * @author 
 * @since 2021-04-23
 */
public interface ShuibiaoJiaofeiDao extends BaseMapper<ShuibiaoJiaofeiEntity> {

   List<ShuibiaoJiaofeiView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
