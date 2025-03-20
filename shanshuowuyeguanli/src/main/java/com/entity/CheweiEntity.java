package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 车位
 *
 * @author 
 * @email
 * @date 2021-04-23
 */
@TableName("chewei")
public class CheweiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public CheweiEntity() {

	}

	public CheweiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
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
    @TableField(value = "chewei_shiyong_start_time",fill = FieldFill.UPDATE)

    private Date cheweiShiyongStartTime;


    /**
     * 租用结束日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "chewei_shiyong_end_time",fill = FieldFill.UPDATE)

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
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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

    @Override
    public String toString() {
        return "Chewei{" +
            "id=" + id +
            ", yonghuId=" + yonghuId +
            ", cheweiNumber=" + cheweiNumber +
            ", cheweiAddress=" + cheweiAddress +
            ", cheweiShiyongStartTime=" + cheweiShiyongStartTime +
            ", cheweiShiyongEndTime=" + cheweiShiyongEndTime +
            ", cheweiZujin=" + cheweiZujin +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
