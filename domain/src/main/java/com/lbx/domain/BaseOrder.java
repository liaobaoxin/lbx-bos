package com.lbx.domain;

import java.util.Date;

public class BaseOrder {


    public BaseOrder(String name, String telephone, String address, String goodsDesc, String orderNum) {
        this.name = name;
        this.telephone = telephone;
        this.address = address;
        this.goodsDesc = goodsDesc;
        this.orderNum = orderNum;
    }

    public BaseOrder() {
    }

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column base_order.Id
     *
     * @mbggenerated Sun Mar 18 14:35:18 CST 2018
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column base_order.name
     *
     * @mbggenerated Sun Mar 18 14:35:18 CST 2018
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column base_order.telephone
     *
     * @mbggenerated Sun Mar 18 14:35:18 CST 2018
     */
    private String telephone;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column base_order.address
     *
     * @mbggenerated Sun Mar 18 14:35:18 CST 2018
     */
    private String address;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column base_order.goods_desc
     *
     * @mbggenerated Sun Mar 18 14:35:18 CST 2018
     */
    private String goodsDesc;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column base_order.order_num
     *
     * @mbggenerated Sun Mar 18 14:35:18 CST 2018
     */
    private String orderNum;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column base_order.add_time
     *
     * @mbggenerated Sun Mar 18 14:35:18 CST 2018
     */
    private Date addTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column base_order.update_time
     *
     * @mbggenerated Sun Mar 18 14:35:18 CST 2018
     */
    private Date updateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column base_order.is_delete
     *
     * @mbggenerated Sun Mar 18 14:35:18 CST 2018
     */
    private Boolean isDelete;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column base_order.export_courier
     *
     * @mbggenerated Sun Mar 18 14:35:18 CST 2018
     */
    private Boolean exportCourier;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column base_order.Id
     *
     * @return the value of base_order.Id
     *
     * @mbggenerated Sun Mar 18 14:35:18 CST 2018
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column base_order.Id
     *
     * @param id the value for base_order.Id
     *
     * @mbggenerated Sun Mar 18 14:35:18 CST 2018
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column base_order.name
     *
     * @return the value of base_order.name
     *
     * @mbggenerated Sun Mar 18 14:35:18 CST 2018
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column base_order.name
     *
     * @param name the value for base_order.name
     *
     * @mbggenerated Sun Mar 18 14:35:18 CST 2018
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column base_order.telephone
     *
     * @return the value of base_order.telephone
     *
     * @mbggenerated Sun Mar 18 14:35:18 CST 2018
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column base_order.telephone
     *
     * @param telephone the value for base_order.telephone
     *
     * @mbggenerated Sun Mar 18 14:35:18 CST 2018
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column base_order.address
     *
     * @return the value of base_order.address
     *
     * @mbggenerated Sun Mar 18 14:35:18 CST 2018
     */
    public String getAddress() {
        return address;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column base_order.address
     *
     * @param address the value for base_order.address
     *
     * @mbggenerated Sun Mar 18 14:35:18 CST 2018
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column base_order.goods_desc
     *
     * @return the value of base_order.goods_desc
     *
     * @mbggenerated Sun Mar 18 14:35:18 CST 2018
     */
    public String getGoodsDesc() {
        return goodsDesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column base_order.goods_desc
     *
     * @param goodsDesc the value for base_order.goods_desc
     *
     * @mbggenerated Sun Mar 18 14:35:18 CST 2018
     */
    public void setGoodsDesc(String goodsDesc) {
        this.goodsDesc = goodsDesc == null ? null : goodsDesc.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column base_order.order_num
     *
     * @return the value of base_order.order_num
     *
     * @mbggenerated Sun Mar 18 14:35:18 CST 2018
     */
    public String getOrderNum() {
        return orderNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column base_order.order_num
     *
     * @param orderNum the value for base_order.order_num
     *
     * @mbggenerated Sun Mar 18 14:35:18 CST 2018
     */
    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum == null ? null : orderNum.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column base_order.add_time
     *
     * @return the value of base_order.add_time
     *
     * @mbggenerated Sun Mar 18 14:35:18 CST 2018
     */
    public Date getAddTime() {
        return addTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column base_order.add_time
     *
     * @param addTime the value for base_order.add_time
     *
     * @mbggenerated Sun Mar 18 14:35:18 CST 2018
     */
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column base_order.update_time
     *
     * @return the value of base_order.update_time
     *
     * @mbggenerated Sun Mar 18 14:35:18 CST 2018
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column base_order.update_time
     *
     * @param updateTime the value for base_order.update_time
     *
     * @mbggenerated Sun Mar 18 14:35:18 CST 2018
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column base_order.is_delete
     *
     * @return the value of base_order.is_delete
     *
     * @mbggenerated Sun Mar 18 14:35:18 CST 2018
     */
    public Boolean getIsDelete() {
        return isDelete;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column base_order.is_delete
     *
     * @param isDelete the value for base_order.is_delete
     *
     * @mbggenerated Sun Mar 18 14:35:18 CST 2018
     */
    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column base_order.export_courier
     *
     * @return the value of base_order.export_courier
     *
     * @mbggenerated Sun Mar 18 14:35:18 CST 2018
     */
    public Boolean getExportCourier() {
        return exportCourier;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column base_order.export_courier
     *
     * @param exportCourier the value for base_order.export_courier
     *
     * @mbggenerated Sun Mar 18 14:35:18 CST 2018
     */
    public void setExportCourier(Boolean exportCourier) {
        this.exportCourier = exportCourier;
    }

    @Override
    public String toString() {
        return "BaseOrder{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", telephone='" + telephone + '\'' +
                ", address='" + address + '\'' +
                ", goodsDesc='" + goodsDesc + '\'' +
                ", orderNum='" + orderNum + '\'' +
                ", addTime=" + addTime +
                ", updateTime=" + updateTime +
                ", isDelete=" + isDelete +
                ", exportCourier=" + exportCourier +
                '}';
    }
}