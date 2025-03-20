package com.entity.vo;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 服务
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email
 * @date 2021-04-23
 */
@TableName("fuwu")
public class FuwuVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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

}
