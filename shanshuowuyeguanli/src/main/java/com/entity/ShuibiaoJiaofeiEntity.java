package com.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

/**
 * 水表缴费
 *
 * @author 
 * @email
 * @date 2021-04-23
 */
@TableName("shuibiao_jiaofei")
public class ShuibiaoJiaofeiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ShuibiaoJiaofeiEntity() {

	}

	public ShuibiaoJiaofeiEntity(T t) {
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
     * 水表
     */
    @TableField(value = "shuibiao_id")

    private Integer shuibiaoId;


    /**
     * 应收金额
     */
    @TableField(value = "shuibiao_jiaofei_yingshou_money")

    private Integer shuibiaoJiaofeiYingshouMoney;


    /**
     * 缴费金额
     */
    @TableField(value = "shuibiao_jiaofei_money")

    private Integer shuibiaoJiaofeiMoney;


    /**
     * 缴费时间
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
	 * 设置：水表
	 */
    public Integer getShuibiaoId() {
        return shuibiaoId;
    }


    /**
	 * 获取：水表
	 */

    public void setShuibiaoId(Integer shuibiaoId) {
        this.shuibiaoId = shuibiaoId;
    }
    /**
	 * 设置：应收金额
	 */
    public Integer getShuibiaoJiaofeiYingshouMoney() {
        return shuibiaoJiaofeiYingshouMoney;
    }


    /**
	 * 获取：应收金额
	 */

    public void setShuibiaoJiaofeiYingshouMoney(Integer shuibiaoJiaofeiYingshouMoney) {
        this.shuibiaoJiaofeiYingshouMoney = shuibiaoJiaofeiYingshouMoney;
    }
    /**
	 * 设置：缴费金额
	 */
    public Integer getShuibiaoJiaofeiMoney() {
        return shuibiaoJiaofeiMoney;
    }


    /**
	 * 获取：缴费金额
	 */

    public void setShuibiaoJiaofeiMoney(Integer shuibiaoJiaofeiMoney) {
        this.shuibiaoJiaofeiMoney = shuibiaoJiaofeiMoney;
    }
    /**
	 * 设置：缴费时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：缴费时间
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
        return "ShuibiaoJiaofei{" +
            "id=" + id +
            ", shuibiaoId=" + shuibiaoId +
            ", shuibiaoJiaofeiYingshouMoney=" + shuibiaoJiaofeiYingshouMoney +
            ", shuibiaoJiaofeiMoney=" + shuibiaoJiaofeiMoney +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
