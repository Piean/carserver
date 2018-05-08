package com.maple.web.carserver.domain;

import java.util.Date;

public class SaleEntity {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_sale.id
     *
     * @mbg.generated Wed Mar 28 21:23:26 CST 2018
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_sale.amount
     *
     * @mbg.generated Wed Mar 28 21:23:26 CST 2018
     */
    private Double amount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_sale.car_type
     *
     * @mbg.generated Wed Mar 28 21:23:26 CST 2018
     */
    private String carType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_sale.saler_name
     *
     * @mbg.generated Wed Mar 28 21:23:26 CST 2018
     */
    private String salerName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_sale.introduction
     *
     * @mbg.generated Wed Mar 28 21:23:26 CST 2018
     */
    private String introduction;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_sale.create_time
     *
     * @mbg.generated Wed Mar 28 21:23:26 CST 2018
     */
    private Date createTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_sale.id
     *
     * @return the value of tb_sale.id
     *
     * @mbg.generated Wed Mar 28 21:23:26 CST 2018
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_sale.id
     *
     * @param id the value for tb_sale.id
     *
     * @mbg.generated Wed Mar 28 21:23:26 CST 2018
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_sale.amount
     *
     * @return the value of tb_sale.amount
     *
     * @mbg.generated Wed Mar 28 21:23:26 CST 2018
     */
    public Double getAmount() {
        return amount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_sale.amount
     *
     * @param amount the value for tb_sale.amount
     *
     * @mbg.generated Wed Mar 28 21:23:26 CST 2018
     */
    public void setAmount(Double amount) {
        this.amount = amount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_sale.car_type
     *
     * @return the value of tb_sale.car_type
     *
     * @mbg.generated Wed Mar 28 21:23:26 CST 2018
     */
    public String getCarType() {
        return carType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_sale.car_type
     *
     * @param carType the value for tb_sale.car_type
     *
     * @mbg.generated Wed Mar 28 21:23:26 CST 2018
     */
    public void setCarType(String carType) {
        this.carType = carType == null ? null : carType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_sale.saler_name
     *
     * @return the value of tb_sale.saler_name
     *
     * @mbg.generated Wed Mar 28 21:23:26 CST 2018
     */
    public String getSalerName() {
        return salerName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_sale.saler_name
     *
     * @param salerName the value for tb_sale.saler_name
     *
     * @mbg.generated Wed Mar 28 21:23:26 CST 2018
     */
    public void setSalerName(String salerName) {
        this.salerName = salerName == null ? null : salerName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_sale.introduction
     *
     * @return the value of tb_sale.introduction
     *
     * @mbg.generated Wed Mar 28 21:23:26 CST 2018
     */
    public String getIntroduction() {
        return introduction;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_sale.introduction
     *
     * @param introduction the value for tb_sale.introduction
     *
     * @mbg.generated Wed Mar 28 21:23:26 CST 2018
     */
    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_sale.create_time
     *
     * @return the value of tb_sale.create_time
     *
     * @mbg.generated Wed Mar 28 21:23:26 CST 2018
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_sale.create_time
     *
     * @param createTime the value for tb_sale.create_time
     *
     * @mbg.generated Wed Mar 28 21:23:26 CST 2018
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}