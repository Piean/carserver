package com.maple.web.carserver.dao;

import com.maple.web.carserver.domain.RepairEntity;

/**
 * 用于报修单保存
 */
public class RepairParamsDto {

    private Long dateTime;
    private Long dateTimea;
    private Long dateTimeb;
    private String carType;
    private String matter;
    private String phone;

    public RepairEntity toEntity() {
        RepairEntity entity = new RepairEntity();
        entity.setDateTime(dateTime);
        entity.setCarType(carType);
        entity.setMatter(matter);
        entity.setPhone(phone);
        return entity;
    }

    public Long getDateTime() {
        return dateTime;
    }

    public void setDateTime(Long dateTime) {
        this.dateTime = dateTime;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getMatter() {
        return matter;
    }

    public void setMatter(String matter) {
        this.matter = matter;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Long getDateTimeb() {
        return dateTimeb;
    }

    public void setDateTimeb(Long dateTimeb) {
        this.dateTimeb = dateTimeb;
    }

    public Long getDateTimea() {
        return dateTimea;
    }

    public void setDateTimea(Long dateTimea) {
        this.dateTimea = dateTimea;
    }
}
