package com.dao;

import com.entity.WuyefeiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.WuyefeiView;

/**
 * 物业费 Dao 接口
 *
 * @author 
 * @since 2021-04-23
 */
public interface WuyefeiDao extends BaseMapper<WuyefeiEntity> {

   List<WuyefeiView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
