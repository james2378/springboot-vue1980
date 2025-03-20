package com.entity.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;


/**
 * 物业费
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author 
 * @email
 * @date 2021-04-23
 */
public class WuyefeiModel implements Serializable {
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
     * 年份
     */
    private String wuyefeiTime;


    /**
     * 物业费单价
     */
    private Integer wuyefeiDanjia;


    /**
     * 应收金额
     */
    private Integer wuyefeiYingshouNumber;


    /**
     * 缴费金额
     */
    private Integer wuyefeiNumber;


    /**
     * 是否缴费
     */
    private Integer wuyefeiTypes;


    /**
     * 缴费时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


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
	 * 获取：年份
	 */
    public String getWuyefeiTime() {
        return wuyefeiTime;
    }


    /**
	 * 设置：年份
	 */
    public void setWuyefeiTime(String wuyefeiTime) {
        this.wuyefeiTime = wuyefeiTime;
    }
    /**
	 * 获取：物业费单价
	 */
    public Integer getWuyefeiDanjia() {
        return wuyefeiDanjia;
    }


    /**
	 * 设置：物业费单价
	 */
    public void setWuyefeiDanjia(Integer wuyefeiDanjia) {
        this.wuyefeiDanjia = wuyefeiDanjia;
    }
    /**
	 * 获取：应收金额
	 */
    public Integer getWuyefeiYingshouNumber() {
        return wuyefeiYingshouNumber;
    }


    /**
	 * 设置：应收金额
	 */
    public void setWuyefeiYingshouNumber(Integer wuyefeiYingshouNumber) {
        this.wuyefeiYingshouNumber = wuyefeiYingshouNumber;
    }
    /**
	 * 获取：缴费金额
	 */
    public Integer getWuyefeiNumber() {
        return wuyefeiNumber;
    }


    /**
	 * 设置：缴费金额
	 */
    public void setWuyefeiNumber(Integer wuyefeiNumber) {
        this.wuyefeiNumber = wuyefeiNumber;
    }
    /**
	 * 获取：是否缴费
	 */
    public Integer getWuyefeiTypes() {
        return wuyefeiTypes;
    }


    /**
	 * 设置：是否缴费
	 */
    public void setWuyefeiTypes(Integer wuyefeiTypes) {
        this.wuyefeiTypes = wuyefeiTypes;
    }
    /**
	 * 获取：缴费时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：缴费时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
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
