package com.superbool.easyui.dao;

import com.superbool.easyui.EasyUIApplication;
import com.superbool.easyui.model.WebInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = EasyUIApplication.class)
public class WebInfoDaoTest {

    @Autowired
    WebInfoDao webInfoDao;


/** 
* 
* Method: getByPage(int start, int rows) 
* 
*/ 
@Test
public void testGetByPage() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getByWebId(long webId) 
* 
*/ 
@Test
public void testGetByWebId() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getByWebName(String webName) 
* 
*/ 
@Test
public void testGetByWebName() throws Exception {
    try {

        WebInfo webInfo = webInfoDao.getByWebName("111111");

        System.out.println(webInfo);
    } catch (Exception e) {
        e.printStackTrace();
    }
}

/** 
* 
* Method: webDelete(int webId) 
* 
*/ 
@Test
public void testWebDelete() throws Exception {
    try {

        WebInfo webInfo = webInfoDao.getByWebId(11112);

        System.out.println(webInfo);
    } catch (Exception e) {
        e.printStackTrace();
    }

} 

/** 
* 
* Method: webAdd(WebInfo webInfo) 
* 
*/

@Test
public void testWebAdd() throws Exception {
    WebInfo webInfo = new WebInfo();
    webInfo.setWebId(11111);
    webInfo.setWebName("111111");
    webInfo.setDomainName("chd");
    webInfo.setIpAdress("www.chd.edu.cn");
    webInfo.setDepartId("1111");
    webInfo.setDepartIndex("chd");
    webInfo.setDepartment("chd");
    webInfo.setCharge("111");
    webInfo.setChargeTel("1111");
    webInfo.setAdministor("111");
    webInfo.setHouseTel("111");
    webInfo.setMobilePhone("111");
    webInfo.setEmail("111");
    webInfo.setQq("111");
    webInfo.setCategory("111");
    webInfo.setClassification("111");
    webInfo.setIndexOfTeach("1111");
    webInfo.setPriority("11");
    webInfo.setStatue("111");
    webInfo.setCloseTime("111");
    webInfo.setCloseReason("111");
    webInfo.setOpenTime("111");
    webInfo.setRemark("1111");
    webInfo.setRecordNum("111");
    webInfo.setInRecord("111");
    webInfo.setRecordDate("111");
    webInfo.setIsOpen("yes");
    webInfo.setWebApplyNum("123456");
    webInfo.setIsDisconnect("yes");
    webInfo.setRemark2("1111");
    webInfo.setExploreRange("111");
    webInfo.setIsSchoolDomain("no");
    webInfo.setIsUseDataBase("no");
    webInfo.setWebStatue("open");
    try {
        int num = webInfoDao.webAdd(webInfo);
    } catch (Exception e) {
        e.printStackTrace();
    }
}

/** 
* 
* Method: webModify(WebInfo webInfo) 
* 
*/ 
@Test
public void testWebModify() throws Exception { 
//TODO: Test goes here... 
} 


} 
