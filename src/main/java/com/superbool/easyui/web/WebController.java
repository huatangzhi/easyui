package com.superbool.easyui.web;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
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

@Controller
public class WebController {

    private static final Logger LOGGER = LoggerFactory.getLogger(WebController.class);

    @Autowired
    WebInfoDao webInfoDao;

    @RequestMapping(value = "/webDelete", method = RequestMethod.POST)
    @ResponseBody
    public String delete(@RequestParam(value = "delId") Integer delId){

        LOGGER.info("web delete web={}", delId);

        JsonObject jsonObject = new JsonObject();

        try {
            int delNums = webInfoDao.webDelete(delId);
            if (delNums == 1) {
                jsonObject.addProperty("success", "true");
            } else {
                jsonObject.addProperty("errorMsg", "删除失败");
            }
        }catch (Exception e) {
            LOGGER.error("webDelete error");
            jsonObject.addProperty("errMsg", "服务器错误");
        }

        return jsonObject.toString();
    }

    @RequestMapping(value = "/webSave", method = RequestMethod.POST)
    @ResponseBody
    public String save(WebInfo webInfo){

        LOGGER.info("save web={}", webInfo);
        JsonObject jsonObject = new JsonObject();

        try {
            int saveNums = 0;
            if (webInfo.getWebId() != 0) {
                saveNums = webInfoDao.webModify(webInfo);
            } else {
                saveNums = webInfoDao.webAdd(webInfo);
            }
            LOGGER.info("saveNums={}", saveNums);

            if (saveNums == 1) {
                jsonObject.addProperty("success", "true");
            } else {
                jsonObject.addProperty("success", "true");
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

}
