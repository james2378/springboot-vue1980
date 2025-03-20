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
 * 服务
 *
 * @author 
 * @email
 * @date 2021-04-23
 */
@TableName("fuwu")
public class FuwuEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public FuwuEntity() {

	}

	public FuwuEntity(T t) {
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
     * 服务名字
     */
    @TableField(value = "fuwu_name")

    private String fuwuName;


    /**
     * 服务详情
     */
    @TableField(value = "fuwu_content")

    private String fuwuContent;


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
	 * 设置：服务名字
	 */
    public String getFuwuName() {
        return fuwuName;
    }


    /**
	 * 获取：服务名字
	 */

    public void setFuwuName(String fuwuName) {
        this.fuwuName = fuwuName;
    }
    /**
	 * 设置：服务详情
	 */
    public String getFuwuContent() {
        return fuwuContent;
    }


    /**
	 * 获取：服务详情
	 */

    public void setFuwuContent(String fuwuContent) {
        this.fuwuContent = fuwuContent;
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
        return "Fuwu{" +
            "id=" + id +
            ", fuwuName=" + fuwuName +
            ", fuwuContent=" + fuwuContent +
            ", createTime=" + createTime +
        "}";
    }
}
