package com.entity.view;

import com.baomidou.mybatisplus.annotations.TableName;
import com.entity.GonggonghuanjingEntity;
import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

/**
 * 公共环境
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email
 * @date 2021-04-23
 */
@TableName("gonggonghuanjing")
public class GonggonghuanjingView extends GonggonghuanjingEntity implements Serializable {
    private static final long serialVersionUID = 1L;



	public GonggonghuanjingView() {

	}

	public GonggonghuanjingView(GonggonghuanjingEntity gonggonghuanjingEntity) {
		try {
			BeanUtils.copyProperties(this, gonggonghuanjingEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



















}
