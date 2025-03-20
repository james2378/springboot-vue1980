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

import com.dao.WuyefeiDao;
import com.entity.WuyefeiEntity;
import com.service.WuyefeiService;
import com.entity.view.WuyefeiView;

/**
 * 物业费 服务实现类
 * @author 
 * @since 2021-04-23
 */
@Service("wuyefeiService")
@Transactional
public class WuyefeiServiceImpl extends ServiceImpl<WuyefeiDao, WuyefeiEntity> implements WuyefeiService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<WuyefeiView> page =new Query<WuyefeiView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
