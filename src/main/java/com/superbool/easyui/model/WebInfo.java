package com.superbool.easyui.model;

import java.sql.Date;

/**
 * Created by hp on 2016/12/30.
 */
public class WebInfo {

    private long webId;
    private String webName;
    private String domainName;
    private String ipAdress;
    private String departId;
    private String departIndex;
    private String department;
    private String charge;
    private String chargeTel;
    private String administor;
    private String houseTel;
    private String mobilePhone;
    private String email;
    private String qq;
    private String category;
    private String classification;
    private String indexOfTeach;
    private String priority;
    private String statue;
    private String closeTime;
    private String closeReason;
    private String openTime;
    private String remark;
    private String recordNum;
    private String inRecord;
    private String recordDate;
    private String isOpen;
    private String webApplyNum;
    private String isDisconnect;
    private String remark2;
    private String exploreRange;
    private String isSchoolDomain;
    private String isUseDataBase;
    private String webStatue;

    public long getWebId() {
        return webId;
    }

    public void setWebId(long webId) {
        this.webId = webId;
    }

    public String getWebName() {
        return webName;
    }

    public void setWebName(String webName) {
        this.webName = webName;
    }

    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    public String getIpAdress() {
        return ipAdress;
    }

    public void setIpAdress(String ipAdress) {
        this.ipAdress = ipAdress;
    }

    public String getDepartId() {
        return departId;
    }

    public void setDepartId(String departId) {
        this.departId = departId;
    }

    public String getDepartIndex() {
        return departIndex;
    }

    public void setDepartIndex(String departIndex) {
        this.departIndex = departIndex;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getCharge() {
        return charge;
    }

    public void setCharge(String charge) {
        this.charge = charge;
    }

    public String getChargeTel() {
        return chargeTel;
    }

    public void setChargeTel(String chargeTel) {
        this.chargeTel = chargeTel;
    }

    public String getAdministor() {
        return administor;
    }

    public void setAdministor(String administor) {
        this.administor = administor;
    }

    public String getHouseTel() {
        return houseTel;
    }

    public void setHouseTel(String houseTel) {
        this.houseTel = houseTel;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getIndexOfTeach() {
        return indexOfTeach;
    }

    public void setIndexOfTeach(String indexOfTeach) {
        this.indexOfTeach = indexOfTeach;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getStatue() {
        return statue;
    }

    public void setStatue(String statue) {
        this.statue = statue;
    }

    public String getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(String closeTime) {
        this.closeTime = closeTime;
    }

    public String getCloseReason() {
        return closeReason;
    }

    public void setCloseReason(String closeReason) {
        this.closeReason = closeReason;
    }

    public String getOpenTime() {
        return openTime;
    }

    public void setOpenTime(String openTime) {
        this.openTime = openTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRecordNum() {
        return recordNum;
    }

    public void setRecordNum(String recordNum) {
        this.recordNum = recordNum;
    }

    public String getInRecord() {
        return inRecord;
    }

    public void setInRecord(String inRecord) {
        this.inRecord = inRecord;
    }

    public String getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(String recordDate) {
        this.recordDate = recordDate;
    }

    public String getIsOpen() {
        return isOpen;
    }

    public void setIsOpen(String isOpen) {
        this.isOpen = isOpen;
    }

    public String getWebApplyNum() {
        return webApplyNum;
    }

    public void setWebApplyNum(String webApplyNum) {
        this.webApplyNum = webApplyNum;
    }

    public String getIsDisconnect() {
        return isDisconnect;
    }

    public void setIsDisconnect(String isDisconnect) {
        this.isDisconnect = isDisconnect;
    }

    public String getRemark2() {
        return remark2;
    }

    public void setRemark2(String remark2) {
        this.remark2 = remark2;
    }

    public String getExploreRange() {
        return exploreRange;
    }

    public void setExploreRange(String exploreRange) {
        this.exploreRange = exploreRange;
    }

    public String getIsSchoolDomain() {
        return isSchoolDomain;
    }

    public void setIsSchoolDomain(String isSchoolDomain) {
        this.isSchoolDomain = isSchoolDomain;
    }

    public String getIsUseDataBase() {
        return isUseDataBase;
    }

    public void setIsUseDataBase(String isUseDataBase) {
        this.isUseDataBase = isUseDataBase;
    }

    public String getWebStatue() {
        return webStatue;
    }

    public void setWebStatue(String webStatue) {
        this.webStatue = webStatue;
    }

    @Override
    public String toString() {
        return "WebInfo{" +
                "webId=" + webId +
                ", webName='" + webName + '\'' +
                ", domainName='" + domainName + '\'' +
                ", ipAdress='" + ipAdress + '\'' +
                ", departId='" + departId + '\'' +
                ", departIndex='" + departIndex + '\'' +
                ", department='" + department + '\'' +
                ", charge='" + charge + '\'' +
                ", chargeTel='" + chargeTel + '\'' +
                ", administor='" + administor + '\'' +
                ", houseTel='" + houseTel + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", email='" + email + '\'' +
                ", qq='" + qq + '\'' +
                ", category='" + category + '\'' +
                ", classification='" + classification + '\'' +
                ", indexOfTeach='" + indexOfTeach + '\'' +
                ", priority='" + priority + '\'' +
                ", statue='" + statue + '\'' +
                ", closeTime=" + closeTime +
                ", closeReason='" + closeReason + '\'' +
                ", openTime=" + openTime +
                ", remark='" + remark + '\'' +
                ", recordNum='" + recordNum + '\'' +
                ", inRecord='" + inRecord + '\'' +
                ", recordDate=" + recordDate +
                ", isOpen='" + isOpen + '\'' +
                ", webApplyNum='" + webApplyNum + '\'' +
                ", isDisconnect='" + isDisconnect + '\'' +
                ", remark2='" + remark2 + '\'' +
                ", exploreRange='" + exploreRange + '\'' +
                ", isSchoolDomain='" + isSchoolDomain + '\'' +
                ", isUseDataBase='" + isUseDataBase + '\'' +
                ", webStatue='" + webStatue + '\'' +
                '}';
    }
}
