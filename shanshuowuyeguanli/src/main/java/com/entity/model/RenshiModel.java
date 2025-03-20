package com.entity.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;


/**
 * 人事信息
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author 
 * @email
 * @date 2021-04-23
 */
public class RenshiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 账户
     */
    private String username;


    /**
     * 密码
     */
    private String password;


    /**
     * 工号
     */
    private String gonghao;


    /**
     * 姓名
     */
    private String renshiName;


    /**
     * 手机号
     */
    private String renshiPhone;


    /**
     * 身份证号
     */
    private String renshiIdNumber;


    /**
     * 头像
     */
    private String renshiPhoto;


    /**
     * 性别
     */
    private Integer sexTypes;


    /**
     * 住址
     */
    private String renshiAddress;


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
	 * 获取：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 设置：账户
	 */
    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 获取：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 设置：密码
	 */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 获取：工号
	 */
    public String getGonghao() {
        return gonghao;
    }


    /**
	 * 设置：工号
	 */
    public void setGonghao(String gonghao) {
        this.gonghao = gonghao;
    }
    /**
	 * 获取：姓名
	 */
    public String getRenshiName() {
        return renshiName;
    }


    /**
	 * 设置：姓名
	 */
    public void setRenshiName(String renshiName) {
        this.renshiName = renshiName;
    }
    /**
	 * 获取：手机号
	 */
    public String getRenshiPhone() {
        return renshiPhone;
    }


    /**
	 * 设置：手机号
	 */
    public void setRenshiPhone(String renshiPhone) {
        this.renshiPhone = renshiPhone;
    }
    /**
	 * 获取：身份证号
	 */
    public String getRenshiIdNumber() {
        return renshiIdNumber;
    }


    /**
	 * 设置：身份证号
	 */
    public void setRenshiIdNumber(String renshiIdNumber) {
        this.renshiIdNumber = renshiIdNumber;
    }
    /**
	 * 获取：头像
	 */
    public String getRenshiPhoto() {
        return renshiPhoto;
    }


    /**
	 * 设置：头像
	 */
    public void setRenshiPhoto(String renshiPhoto) {
        this.renshiPhoto = renshiPhoto;
    }
    /**
	 * 获取：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 设置：性别
	 */
    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 获取：住址
	 */
    public String getRenshiAddress() {
        return renshiAddress;
    }


    /**
	 * 设置：住址
	 */
    public void setRenshiAddress(String renshiAddress) {
        this.renshiAddress = renshiAddress;
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
