package com.entity.view;

import com.baomidou.mybatisplus.annotations.TableName;
import com.entity.ShuibiaoJiaofeiEntity;
import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

/**
 * 水表缴费
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email
 * @date 2021-04-23
 */
@TableName("shuibiao_jiaofei")
public class ShuibiaoJiaofeiView extends ShuibiaoJiaofeiEntity implements Serializable {
    private static final long serialVersionUID = 1L;



		//级联表 shuibiao
			/**
			* 用户
			*/
			private Integer yonghuId;
			/**
			* 水表编号
			*/
			private String shuibiaoName;
			/**
			* 水表余额
			*/
			private Integer shuibiaoNumber;

	public ShuibiaoJiaofeiView() {

	}

	public ShuibiaoJiaofeiView(ShuibiaoJiaofeiEntity shuibiaoJiaofeiEntity) {
		try {
			BeanUtils.copyProperties(this, shuibiaoJiaofeiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}























				//级联表的get和set shuibiao
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
					* 获取： 水表编号
					*/
					public String getShuibiaoName() {
						return shuibiaoName;
					}
					/**
					* 设置： 水表编号
					*/
					public void setShuibiaoName(String shuibiaoName) {
						this.shuibiaoName = shuibiaoName;
					}
					/**
					* 获取： 水表余额
					*/
					public Integer getShuibiaoNumber() {
						return shuibiaoNumber;
					}
					/**
					* 设置： 水表余额
					*/
					public void setShuibiaoNumber(Integer shuibiaoNumber) {
						this.shuibiaoNumber = shuibiaoNumber;
					}










}
