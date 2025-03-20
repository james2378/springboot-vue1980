package com.entity.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;


/**
 * 服务
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author 
 * @email
 * @date 2021-04-23
 */
public class FuwuModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 服务名字
     */
    private String fuwuName;


    /**
     * 服务详情
     */
    private String fuwuContent;


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
	 * 获取：服务名字
	 */
    public String getFuwuName() {
        return fuwuName;
    }


    /**
	 * 设置：服务名字
	 */
    public void setFuwuName(String fuwuName) {
        this.fuwuName = fuwuName;
    }
    /**
	 * 获取：服务详情
	 */
    public String getFuwuContent() {
        return fuwuContent;
    }


    /**
	 * 设置：服务详情
	 */
    public void setFuwuContent(String fuwuContent) {
        this.fuwuContent = fuwuContent;
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
