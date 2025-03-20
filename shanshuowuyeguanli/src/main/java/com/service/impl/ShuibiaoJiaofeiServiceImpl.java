package com.service.impl;

import com.utils.StringUtil;
import org.springframework.stereotype.Service;
import java.lang.reflect.Field;
import java.util.*;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;

import com.dao.ShuibiaoJiaofeiDao;
import com.entity.ShuibiaoJiaofeiEntity;
import com.service.ShuibiaoJiaofeiService;
import com.entity.view.ShuibiaoJiaofeiView;

/**
 * 水表缴费 服务实现类
 * @author 
 * @since 2021-04-23
 */
@Service("shuibiaoJiaofeiService")
@Transactional
public class ShuibiaoJiaofeiServiceImpl extends ServiceImpl<ShuibiaoJiaofeiDao, ShuibiaoJiaofeiEntity> implements ShuibiaoJiaofeiService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<ShuibiaoJiaofeiView> page =new Query<ShuibiaoJiaofeiView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
