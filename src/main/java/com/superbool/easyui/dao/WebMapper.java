package com.superbool.easyui.dao;

import com.superbool.easyui.model.WebInfo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by hp on 2016/11/16.
 */
public class WebMapper implements RowMapper<WebInfo>{

    @Override
    public WebInfo mapRow(ResultSet rs, int i) throws SQLException{
        WebInfo webInfo = new WebInfo();
        webInfo.setWebId(rs.getInt(1));
        webInfo.setWebName(rs.getString(2));
        webInfo.setDomainName(rs.getString(3));
        webInfo.setIpAdress(rs.getString(4));
        webInfo.setDepartId(rs.getString(5));
        webInfo.setDepartIndex(rs.getString(6));
        webInfo.setDepartment(rs.getString(7));
        webInfo.setCharge(rs.getString(8));
        webInfo.setChargeTel(rs.getString(9));
        webInfo.setAdministor(rs.getString(10));
        webInfo.setHouseTel(rs.getString(11));
        webInfo.setMobilePhone(rs.getString(12));
        webInfo.setEmail(rs.getString(13));
        webInfo.setQq(rs.getString(14));
        webInfo.setCategory(rs.getString(15));
        webInfo.setClassification(rs.getString(16));
        webInfo.setIndexOfTeach(rs.getString(17));
        webInfo.setPriority(rs.getString(18));
        webInfo.setStatue(rs.getString(19));
        webInfo.setCloseTime(rs.getString(20));
        webInfo.setCloseReason(rs.getString(21));
        webInfo.setOpenTime(rs.getString(22));
        webInfo.setRemark(rs.getString(23));
        webInfo.setRecordNum(rs.getString(24));
        webInfo.setInRecord(rs.getString(25));
        webInfo.setRecordDate(rs.getString(26));
        webInfo.setIsOpen(rs.getString(27));
        webInfo.setWebApplyNum(rs.getString(28));
        webInfo.setIsDisconnect(rs.getString(29));
        webInfo.setRemark2(rs.getString(30));
        webInfo.setExploreRange(rs.getString(31));
        webInfo.setIsSchoolDomain(rs.getString(32));
        webInfo.setIsUseDataBase(rs.getString(33));
        webInfo.setWebStatue(rs.getString(34));
        return webInfo;
    }
}
