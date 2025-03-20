package com.entity.vo;

import com.entity.CheweiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 车位
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email
 * @date 2021-04-23
 */
@TableName("chewei")
public class CheweiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 停车编号
     */

    @TableField(value = "chewei_number")
    private String cheweiNumber;


    /**
     * 车位位置
     */

    @TableField(value = "chewei_address")
    private String cheweiAddress;


    /**
     * 租用开始日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "chewei_shiyong_start_time")
    private Date cheweiShiyongStartTime;


    /**
     * 租用结束日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "chewei_shiyong_end_time")
    private Date cheweiShiyongEndTime;


    /**
     * 租金
     */

    @TableField(value = "chewei_zujin")
    private Integer cheweiZujin;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：停车编号
	 */
    public String getCheweiNumber() {
        return cheweiNumber;
    }


    /**
	 * 获取：停车编号
	 */

    public void setCheweiNumber(String cheweiNumber) {
        this.cheweiNumber = cheweiNumber;
    }
    /**
	 * 设置：车位位置
	 */
    public String getCheweiAddress() {
        return cheweiAddress;
    }


    /**
	 * 获取：车位位置
	 */

    public void setCheweiAddress(String cheweiAddress) {
        this.cheweiAddress = cheweiAddress;
    }
    /**
	 * 设置：租用开始日期
	 */
    public Date getCheweiShiyongStartTime() {
        return cheweiShiyongStartTime;
    }


    /**
	 * 获取：租用开始日期
	 */

    public void setCheweiShiyongStartTime(Date cheweiShiyongStartTime) {
        this.cheweiShiyongStartTime = cheweiShiyongStartTime;
    }
    /**
	 * 设置：租用结束日期
	 */
    public Date getCheweiShiyongEndTime() {
        return cheweiShiyongEndTime;
    }


    /**
	 * 获取：租用结束日期
	 */

    public void setCheweiShiyongEndTime(Date cheweiShiyongEndTime) {
        this.cheweiShiyongEndTime = cheweiShiyongEndTime;
    }
    /**
	 * 设置：租金
	 */
    public Integer getCheweiZujin() {
        return cheweiZujin;
    }


    /**
	 * 获取：租金
	 */

    public void setCheweiZujin(Integer cheweiZujin) {
        this.cheweiZujin = cheweiZujin;
    }
    /**
	 * 设置：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：添加时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
