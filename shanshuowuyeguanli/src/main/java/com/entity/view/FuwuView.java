package com.entity.view;

import com.baomidou.mybatisplus.annotations.TableName;
import com.entity.FuwuEntity;
import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

/**
 * 服务
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email
 * @date 2021-04-23
 */
@TableName("fuwu")
public class FuwuView extends FuwuEntity implements Serializable {
    private static final long serialVersionUID = 1L;



	public FuwuView() {

	}

	public FuwuView(FuwuEntity fuwuEntity) {
		try {
			BeanUtils.copyProperties(this, fuwuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



















}
