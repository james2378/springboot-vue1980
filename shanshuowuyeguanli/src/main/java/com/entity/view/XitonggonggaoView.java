package com.entity.view;

import com.baomidou.mybatisplus.annotations.TableName;
import com.entity.XitonggonggaoEntity;
import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

/**
 * 系统公告
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email
 * @date 2021-04-23
 */
@TableName("xitonggonggao")
public class XitonggonggaoView extends XitonggonggaoEntity implements Serializable {
    private static final long serialVersionUID = 1L;



	public XitonggonggaoView() {

	}

	public XitonggonggaoView(XitonggonggaoEntity xitonggonggaoEntity) {
		try {
			BeanUtils.copyProperties(this, xitonggonggaoEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



















}
