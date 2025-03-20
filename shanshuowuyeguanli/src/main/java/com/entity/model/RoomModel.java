package com.entity.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;


/**
 * 房间
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author 
 * @email
 * @date 2021-04-23
 */
public class RoomModel implements Serializable {
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
     * 楼幢
     */
    private String building;


    /**
     * 单元
     */
    private String unit;


    /**
     * 房间号
     */
    private String roomNumber;


    /**
     * 房产编号
     */
    private String fangchanNumber;


    /**
     * 房间信息
     */
    private String roomContent;


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
	 * 获取：楼幢
	 */
    public String getBuilding() {
        return building;
    }


    /**
	 * 设置：楼幢
	 */
    public void setBuilding(String building) {
        this.building = building;
    }
    /**
	 * 获取：单元
	 */
    public String getUnit() {
        return unit;
    }


    /**
	 * 设置：单元
	 */
    public void setUnit(String unit) {
        this.unit = unit;
    }
    /**
	 * 获取：房间号
	 */
    public String getRoomNumber() {
        return roomNumber;
    }


    /**
	 * 设置：房间号
	 */
    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }
    /**
	 * 获取：房产编号
	 */
    public String getFangchanNumber() {
        return fangchanNumber;
    }


    /**
	 * 设置：房产编号
	 */
    public void setFangchanNumber(String fangchanNumber) {
        this.fangchanNumber = fangchanNumber;
    }
    /**
	 * 获取：房间信息
	 */
    public String getRoomContent() {
        return roomContent;
    }


    /**
	 * 设置：房间信息
	 */
    public void setRoomContent(String roomContent) {
        this.roomContent = roomContent;
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
