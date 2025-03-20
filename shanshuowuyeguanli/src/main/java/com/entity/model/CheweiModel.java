package com.entity.model;

import com.entity.CheweiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 车位
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author 
 * @email
 * @date 2021-04-23
 */
public class CheweiModel implements Serializable {
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
     * 停车编号
     */
    private String cheweiNumber;


    /**
     * 车位位置
     */
    private String cheweiAddress;


    /**
     * 租用开始日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date cheweiShiyongStartTime;


    /**
     * 租用结束日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date cheweiShiyongEndTime;


    /**
     * 租金
     */
    private Integer cheweiZujin;


    /**
     * 添加时间
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
	 * 获取：停车编号
	 */
    public String getCheweiNumber() {
        return cheweiNumber;
    }


    /**
	 * 设置：停车编号
	 */
    public void setCheweiNumber(String cheweiNumber) {
        this.cheweiNumber = cheweiNumber;
    }
    /**
	 * 获取：车位位置
	 */
    public String getCheweiAddress() {
        return cheweiAddress;
    }


    /**
	 * 设置：车位位置
	 */
    public void setCheweiAddress(String cheweiAddress) {
        this.cheweiAddress = cheweiAddress;
    }
    /**
	 * 获取：租用开始日期
	 */
    public Date getCheweiShiyongStartTime() {
        return cheweiShiyongStartTime;
    }


    /**
	 * 设置：租用开始日期
	 */
    public void setCheweiShiyongStartTime(Date cheweiShiyongStartTime) {
        this.cheweiShiyongStartTime = cheweiShiyongStartTime;
    }
    /**
	 * 获取：租用结束日期
	 */
    public Date getCheweiShiyongEndTime() {
        return cheweiShiyongEndTime;
    }


    /**
	 * 设置：租用结束日期
	 */
    public void setCheweiShiyongEndTime(Date cheweiShiyongEndTime) {
        this.cheweiShiyongEndTime = cheweiShiyongEndTime;
    }
    /**
	 * 获取：租金
	 */
    public Integer getCheweiZujin() {
        return cheweiZujin;
    }


    /**
	 * 设置：租金
	 */
    public void setCheweiZujin(Integer cheweiZujin) {
        this.cheweiZujin = cheweiZujin;
    }
    /**
	 * 获取：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：添加时间
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
