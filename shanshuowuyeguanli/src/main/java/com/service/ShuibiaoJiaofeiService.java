package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ShuibiaoJiaofeiEntity;
import java.util.Map;

/**
 * 水表缴费 服务类
 * @author 
 * @since 2021-04-23
 */
public interface ShuibiaoJiaofeiService extends IService<ShuibiaoJiaofeiEntity> {

    /**
    * @param params 查询参数
    * @return 带分页的查询出来的数据
    */
     PageUtils queryPage(Map<String, Object> params);
}