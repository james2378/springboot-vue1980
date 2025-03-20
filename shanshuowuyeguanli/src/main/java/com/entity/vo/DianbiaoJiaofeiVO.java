package com.entity.vo;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 电表缴费
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email
 * @date 2021-04-23
 */
@TableName("dianbiao_jiaofei")
public class DianbiaoJiaofeiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 电表
     */

    @TableField(value = "dianbiao_id")
    private Integer dianbiaoId;


    /**
     * 应收金额
     */

    @TableField(value = "dianbiao_jiaofei_yingshou_money")
    private Integer dianbiaoJiaofeiYingshouMoney;


    /**
     * 缴费金额
     */

    @TableField(value = "dianbiao_jiaofei_money")
    private Integer dianbiaoJiaofeiMoney;


    /**
     * 缴费时间
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
	 * 设置：电表
	 */
    public Integer getDianbiaoId() {
        return dianbiaoId;
    }


    /**
	 * 获取：电表
	 */

    public void setDianbiaoId(Integer dianbiaoId) {
        this.dianbiaoId = dianbiaoId;
    }
    /**
	 * 设置：应收金额
	 */
    public Integer getDianbiaoJiaofeiYingshouMoney() {
        return dianbiaoJiaofeiYingshouMoney;
    }


    /**
	 * 获取：应收金额
	 */

    public void setDianbiaoJiaofeiYingshouMoney(Integer dianbiaoJiaofeiYingshouMoney) {
        this.dianbiaoJiaofeiYingshouMoney = dianbiaoJiaofeiYingshouMoney;
    }
    /**
	 * 设置：缴费金额
	 */
    public Integer getDianbiaoJiaofeiMoney() {
        return dianbiaoJiaofeiMoney;
    }


    /**
	 * 获取：缴费金额
	 */

    public void setDianbiaoJiaofeiMoney(Integer dianbiaoJiaofeiMoney) {
        this.dianbiaoJiaofeiMoney = dianbiaoJiaofeiMoney;
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

}
