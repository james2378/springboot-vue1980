package com.entity.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;


/**
 * 水表缴费
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author 
 * @email
 * @date 2021-04-23
 */
public class ShuibiaoJiaofeiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 水表
     */
    private Integer shuibiaoId;


    /**
     * 应收金额
     */
    private Integer shuibiaoJiaofeiYingshouMoney;


    /**
     * 缴费金额
     */
    private Integer shuibiaoJiaofeiMoney;


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
	 * 获取：水表
	 */
    public Integer getShuibiaoId() {
        return shuibiaoId;
    }


    /**
	 * 设置：水表
	 */
    public void setShuibiaoId(Integer shuibiaoId) {
        this.shuibiaoId = shuibiaoId;
    }
    /**
	 * 获取：应收金额
	 */
    public Integer getShuibiaoJiaofeiYingshouMoney() {
        return shuibiaoJiaofeiYingshouMoney;
    }


    /**
	 * 设置：应收金额
	 */
    public void setShuibiaoJiaofeiYingshouMoney(Integer shuibiaoJiaofeiYingshouMoney) {
        this.shuibiaoJiaofeiYingshouMoney = shuibiaoJiaofeiYingshouMoney;
    }
    /**
	 * 获取：缴费金额
	 */
    public Integer getShuibiaoJiaofeiMoney() {
        return shuibiaoJiaofeiMoney;
    }


    /**
	 * 设置：缴费金额
	 */
    public void setShuibiaoJiaofeiMoney(Integer shuibiaoJiaofeiMoney) {
        this.shuibiaoJiaofeiMoney = shuibiaoJiaofeiMoney;
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
