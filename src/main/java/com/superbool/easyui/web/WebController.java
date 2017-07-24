package com.superbool.easyui.web;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.superbool.easyui.dao.WebInfoDao;

import com.superbool.easyui.model.WebInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.*;

@Controller
public class WebController {

    private static final Logger LOGGER = LoggerFactory.getLogger(WebController.class);

    @Autowired
    WebInfoDao webInfoDao;

    @RequestMapping(value = "/webDelete", method = RequestMethod.POST)
    @ResponseBody
    public String delete(@RequestParam(value = "delId") Integer delId) {

        LOGGER.info("web delete web={}", delId);

        JsonObject jsonObject = new JsonObject();

        try {
            int delNums = webInfoDao.webDelete(delId);
            if (delNums == 1) {
                jsonObject.addProperty("success", "true");
            } else {
                jsonObject.addProperty("errorMsg", "删除失败");
            }
        } catch (Exception e) {
            LOGGER.error("webDelete error");
            jsonObject.addProperty("errMsg", "服务器错误");
        }

        return jsonObject.toString();
    }

    @RequestMapping(value = "/webModify", method = RequestMethod.POST)
    @ResponseBody
    public String save(@RequestParam(value = "id") Integer modId, WebInfo webInfo) {


        LOGGER.info("save web={}", modId);
        LOGGER.info("save web={}", webInfo);
//        LOGGER.info(webInfo.getIndexOfTeach());
        JsonObject jsonObject = new JsonObject();

        try {
            int saveNums = 0;

            if (modId != null) {
                webInfoDao.webDelete(modId);
            }
            saveNums = webInfoDao.webAdd(webInfo);
            LOGGER.info("saveNums={}", saveNums);
            if (saveNums == 1) {
                jsonObject.addProperty("success", "true");
            } else {
                jsonObject.addProperty("success", "false");
                jsonObject.addProperty("errorMsg", "没有需要的更新");
            }
            JsonElement element = new Gson().toJsonTree(webInfo);
            jsonObject.add("data", element);

        } catch (Exception e) {
            LOGGER.error("web save error", e);
            jsonObject.addProperty("errorMsg", "信息已存在请重新输入");
        }

        return jsonObject.toString();
    }


    @RequestMapping(value = "/webSave", method = RequestMethod.POST)
    @ResponseBody
    public String modify(WebInfo webInfo) {
        LOGGER.info("save web={}", webInfo);
//        LOGGER.info(webInfo.getIndexOfTeach());
        JsonObject jsonObject = new JsonObject();

        try {
            int saveNums = 0;
            saveNums = webInfoDao.webAdd(webInfo);
            LOGGER.info("saveNums={}", saveNums);
            if (saveNums == 1) {
                jsonObject.addProperty("success", "true");
            } else {
                jsonObject.addProperty("success", "false");
                jsonObject.addProperty("errorMsg", "没有需要的更新");
            }
            JsonElement element = new Gson().toJsonTree(webInfo);
            jsonObject.add("data", element);

        } catch (Exception e) {
            LOGGER.error("web save error", e);
            jsonObject.addProperty("errorMsg", "信息已存在请重新输入");
        }

        return jsonObject.toString();
    }

    @RequestMapping(value = "/webList", method = RequestMethod.POST, produces = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ResponseBody
    public String list(@RequestParam(value = "page") Integer page, @RequestParam(value = "rows") Integer rows) {

        LOGGER.info("page={},rows={}", page, rows);
        JsonObject result = new JsonObject();

        try {
            page--;

            JsonElement jsonElement = new Gson().toJsonTree(webInfoDao.getByPage(page * rows, rows));
            int total = webInfoDao.getCount();
            result.add("rows", jsonElement);
            result.addProperty("total", total);

            LOGGER.info("result={}", result);


        } catch (Exception e) {

            LOGGER.error("userList error!", e);
            result.addProperty("errorMsg", "服务器错误");
        }

        return result.toString();
    }

    @RequestMapping(value = "/data", method = RequestMethod.POST)
    @ResponseBody
    public String returnDepartJson() {
        String fileName = "/root/WebManage/city_data.json";
        File departFile = new File(fileName);
        StringBuffer departStr = new StringBuffer();
        String line;
        BufferedReader br = null;

        try {
            br=new BufferedReader(new FileReader(departFile));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            while((line=br.readLine())!=null){
                departStr.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String departS = departStr.toString();
        LOGGER.info(departS);


//        JsonObject departJson = new JsonParser().parse(departS).getAsJsonObject();

        return departS;

    }
}
