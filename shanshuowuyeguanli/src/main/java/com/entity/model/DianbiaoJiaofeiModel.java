package com.entity.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;


/**
 * 电表缴费
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author 
 * @email
 * @date 2021-04-23
 */
public class DianbiaoJiaofeiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 电表
     */
    private Integer dianbiaoId;


    /**
     * 应收金额
     */
    private Integer dianbiaoJiaofeiYingshouMoney;


    /**
     * 缴费金额
     */
    private Integer dianbiaoJiaofeiMoney;


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
	 * 获取：电表
	 */
    public Integer getDianbiaoId() {
        return dianbiaoId;
    }


    /**
	 * 设置：电表
	 */
    public void setDianbiaoId(Integer dianbiaoId) {
        this.dianbiaoId = dianbiaoId;
    }
    /**
	 * 获取：应收金额
	 */
    public Integer getDianbiaoJiaofeiYingshouMoney() {
        return dianbiaoJiaofeiYingshouMoney;
    }


    /**
	 * 设置：应收金额
	 */
    public void setDianbiaoJiaofeiYingshouMoney(Integer dianbiaoJiaofeiYingshouMoney) {
        this.dianbiaoJiaofeiYingshouMoney = dianbiaoJiaofeiYingshouMoney;
    }
    /**
	 * 获取：缴费金额
	 */
    public Integer getDianbiaoJiaofeiMoney() {
        return dianbiaoJiaofeiMoney;
    }


    /**
	 * 设置：缴费金额
	 */
    public void setDianbiaoJiaofeiMoney(Integer dianbiaoJiaofeiMoney) {
        this.dianbiaoJiaofeiMoney = dianbiaoJiaofeiMoney;
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
