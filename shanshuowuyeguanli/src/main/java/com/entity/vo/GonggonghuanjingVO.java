package com.entity.vo;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 公共环境
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email
 * @date 2021-04-23
 */
@TableName("gonggonghuanjing")
public class GonggonghuanjingVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 公共环境名字
     */

    @TableField(value = "gonggonghuanjing_name")
    private String gonggonghuanjingName;


    /**
     * 公共环境详情
     */

    @TableField(value = "gonggonghuanjing_content")
    private String gonggonghuanjingContent;


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
	 * 设置：公共环境名字
	 */
    public String getGonggonghuanjingName() {
        return gonggonghuanjingName;
    }


    /**
	 * 获取：公共环境名字
	 */

    public void setGonggonghuanjingName(String gonggonghuanjingName) {
        this.gonggonghuanjingName = gonggonghuanjingName;
    }
    /**
	 * 设置：公共环境详情
	 */
    public String getGonggonghuanjingContent() {
        return gonggonghuanjingContent;
    }


    /**
	 * 获取：公共环境详情
	 */

    public void setGonggonghuanjingContent(String gonggonghuanjingContent) {
        this.gonggonghuanjingContent = gonggonghuanjingContent;
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
