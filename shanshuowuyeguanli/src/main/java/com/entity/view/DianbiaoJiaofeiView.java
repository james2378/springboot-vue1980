package com.entity.view;

import com.baomidou.mybatisplus.annotations.TableName;
import com.entity.DianbiaoJiaofeiEntity;
import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

/**
 * 电表缴费
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email
 * @date 2021-04-23
 */
@TableName("dianbiao_jiaofei")
public class DianbiaoJiaofeiView extends DianbiaoJiaofeiEntity implements Serializable {
    private static final long serialVersionUID = 1L;



		//级联表 dianbiao
			/**
			* 用户
			*/
			private Integer yonghuId;
			/**
			* 电表编号
			*/
			private String dianbiaoName;
			/**
			* 电表余额
			*/
			private Integer dianbiaoNumber;

	public DianbiaoJiaofeiView() {

	}

	public DianbiaoJiaofeiView(DianbiaoJiaofeiEntity dianbiaoJiaofeiEntity) {
		try {
			BeanUtils.copyProperties(this, dianbiaoJiaofeiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}









				//级联表的get和set dianbiao
					/**
					* 获取： 用户
					*/
					public Integer getYonghuId() {
						return yonghuId;
					}
					/**
					* 设置： 用户
					*/
					public void setYonghuId(Integer yonghuId) {
						this.yonghuId = yonghuId;
					}
					/**
					* 获取： 电表编号
					*/
					public String getDianbiaoName() {
						return dianbiaoName;
					}
					/**
					* 设置： 电表编号
					*/
					public void setDianbiaoName(String dianbiaoName) {
						this.dianbiaoName = dianbiaoName;
					}
					/**
					* 获取： 电表余额
					*/
					public Integer getDianbiaoNumber() {
						return dianbiaoNumber;
					}
					/**
					* 设置： 电表余额
					*/
					public void setDianbiaoNumber(Integer dianbiaoNumber) {
						this.dianbiaoNumber = dianbiaoNumber;
					}
























}
