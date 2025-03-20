package com.entity.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;


/**
 * 售水
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author 
 * @email
 * @date 2021-04-23
 */
public class ShuibiaoModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


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


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：用户
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：水表编号
	 */
    public String getShuibiaoName() {
        return shuibiaoName;
    }


    /**
	 * 设置：水表编号
	 */
    public void setShuibiaoName(String shuibiaoName) {
        this.shuibiaoName = shuibiaoName;
    }
    /**
	 * 获取：水表余额
	 */
    public Integer getShuibiaoNumber() {
        return shuibiaoNumber;
    }


    /**
	 * 设置：水表余额
	 */
    public void setShuibiaoNumber(Integer shuibiaoNumber) {
        this.shuibiaoNumber = shuibiaoNumber;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
