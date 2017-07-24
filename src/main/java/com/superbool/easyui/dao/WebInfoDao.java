package com.superbool.easyui.dao;

import com.superbool.easyui.model.WebInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by hp on 2016/12/30.
 */
@Repository
public class WebInfoDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public List<WebInfo> getByPage(int start, int rows) throws Exception {
        String sql = "SELECT * FROM WebInfo ORDER BY webId, webName limit ? offset ?";

        List<WebInfo> webInfoList = jdbcTemplate.query(
                sql,
                new Object[]{rows, start},
                new WebMapper()
        );

        return webInfoList;
    }

    public int getCount() throws Exception {
        String sql = "SELECT count(*) FROM WebInfo";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    public WebInfo getByWebId(long webId) throws Exception {

        String sql = "SELECT * FROM WebInfo Where webId = ?";

        WebInfo webInfo = jdbcTemplate.queryForObject(
                sql,
                new Object[]{webId},
                new WebMapper()
        );
        return webInfo;
    }

    public WebInfo getByWebName(String webName) throws Exception {

        String sql = "SELECT * FROM WebInfo Where webName = ?";

        WebInfo webInfo = jdbcTemplate.queryForObject(
                sql,
                new Object[]{webName},
                new WebMapper()
        );
        return webInfo;
    }

    public int webDelete(int webId) throws Exception {
        String sql = "DELETE FROM WebRegister.WebInfo WHERE webId=?";
        WebInfo webInfo = getByWebId(webId);
        int result = jdbcTemplate.update(sql, webId);
        System.out.println("产出数据");
        return result;
    }

    public int webAdd(WebInfo webInfo) throws Exception{
        String sql = "INSERT INTO WebInfo(webId, webName, domainName, ipAdress, departId, departIndex,department, charge, chargeTel, administor," +
                " houseTel, mobilePhone, email, qq, category, classification, indexOfTeach, priority, statue, closeTime, " +
                "closeReason, openTime, remark, recordNum, inrecord, recordDate, isOpen, webApplyNum, isDisconnect, remark2, " +
                "exploreRange, isSchoolDomain, isUseDataBase, webStatue) " +
                "VALUES (?,?,?,?,?,?,?,?,?,?," +
                        "?,?,?,?,?,?,?,?,?,?," +
                        "?,?,?,?,?,?,?,?,?,?," +
                        "?,?,?,?)";

        int result = jdbcTemplate.update(sql,   webInfo.getWebId(), webInfo.getWebName().trim(), webInfo.getDomainName().trim(),
                                                webInfo.getIpAdress().trim(), webInfo.getDepartId().trim(), webInfo.getDepartIndex().trim(),
                                                webInfo.getDepartment(),webInfo.getCharge().trim(), webInfo.getChargeTel().trim(),
                                                webInfo.getAdministor().trim(),
                                                webInfo.getHouseTel().trim(), webInfo.getMobilePhone().trim(), webInfo.getEmail().trim(),
                                                webInfo.getQq().trim(), webInfo.getCategory().trim(), webInfo.getClassification().trim(),
                                                webInfo.getIndexOfTeach().trim(), webInfo.getPriority().trim(), webInfo.getStatue().trim(),
                                                webInfo.getCloseTime().trim(),
                                                webInfo.getCloseReason().trim(),webInfo.getOpenTime().trim(), webInfo.getRemark().trim(),
                                                webInfo.getRecordNum().trim(),webInfo.getInRecord().trim(), webInfo.getRecordDate().trim(),
                                                webInfo.getIsOpen().trim(), webInfo.getWebApplyNum().trim(), webInfo.getIsDisconnect().trim(),
                                                webInfo.getRemark2().trim(),
                                                webInfo.getExploreRange().trim(), webInfo.getIsSchoolDomain().trim(), webInfo.getIsUseDataBase().trim(),
                                                webInfo.getWebStatue().trim());
        return result;
    }

    public int webModify(WebInfo webInfo, int webId) throws Exception {

        String sql = "UPDATE WebInfo webName=?, domainName=?, ipAdress=?, departId=?," +
                "departIndex=?, department=?, charge = ?, chargeTel = ?, administor = ?," +
                "houseTel = ?, mobilePhone = ?, email = ?, qq = ?, category = ?, " +
                "classification = ?, indexOfTech = ?, priority = ?, statue = ?, closeTime = ?," +
                "closeReason = ?, openTime = ?, remark = ?, recordNum = ?, inrecord = ?," +
                "recordDate = ?, isOpen = ?, webApplyNum = ?, isDisconnect = ?, remark2 = ?," +
                "exploreRange = ?, isSchoolDomain = ?, isUseDataBase = ?, webStatue = ? WHERE webId=?";


        int result = jdbcTemplate.update(sql,
                webInfo.getWebName().trim(), webInfo.getDomainName().trim(), webInfo.getIpAdress().trim(),webInfo.getDepartId().trim(),
                webInfo.getDepartIndex().trim(), webInfo.getDepartment(), webInfo.getCharge().trim(), webInfo.getChargeTel().trim(), webInfo.getAdministor().trim(),
                webInfo.getHouseTel().trim(), webInfo.getMobilePhone().trim(), webInfo.getEmail().trim(), webInfo.getQq().trim(), webInfo.getCategory().trim(),
                webInfo.getClassification().trim(), webInfo.getIndexOfTeach().trim(), webInfo.getPriority().trim(), webInfo.getStatue().trim(), webInfo.getCloseTime(),
                webInfo.getCloseReason().trim(), webInfo.getOpenTime(), webInfo.getRemark().trim(), webInfo.getRecordNum().trim(),webInfo.getInRecord().trim(),
                webInfo.getRecordDate(), webInfo.getIsOpen().trim(), webInfo.getWebApplyNum().trim(), webInfo.getIsDisconnect().trim(), webInfo.getRemark2().trim(),
                webInfo.getExploreRange().trim(),webInfo.getIsSchoolDomain().trim(), webInfo.getIsUseDataBase(), webInfo.getWebStatue().trim());
        return result;
    }
}
