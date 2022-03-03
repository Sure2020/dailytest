/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : TestReadJSONFile
 * Date Created : 2022-02-22
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2022-02-22       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.dailytest.testmain;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
//import net.sf.json.JSONArray;
//import net.sf.json.JSONObject;

/**
 * @program: com.example.dailytest.testmain
 * @description: xxx
 * @author: w15021
 * @create: 2022-02-22
 **/
public class TestReadJSONFile {
    public static void main(String[] args) throws IOException {
        String path = "src/main/webapp/testfile/testjson.json";
        String jsonStr = readJsonFile(path);

        JSONObject jsonObject = JSONObject.parseObject(jsonStr);
        jsonObject.put("node", "a");

        JSONArray jsonArray = jsonObject.getJSONArray("local_disk");
        JSONObject jsonObjectLocalDisk = jsonArray.getJSONObject(0);
        jsonObjectLocalDisk.put("host","192.168.110.226");

        String newJsonString = jsonObject.toString();

        //writeJsonFile(newJsonString, path);

        // https://blog.csdn.net/zyf_balance/article/details/85691217
        org.codehaus.jackson.map.ObjectMapper mapper = new ObjectMapper();
        try {
            System.out.println("Default JSON String:" + mapper.writeValueAsString(jsonObject));
            System.out.println("formatted JSON String:" + mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonObject));
        } catch (Exception e) {
            e.printStackTrace();
        }

        writeJsonFile(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonObject), path);

    }
    /**
     * 读取json文件
     */
    public static String readJsonFile(String path){
        String laststrJson = "";
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(new File(path)));
            String tempString = null;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                laststrJson = laststrJson + tempString;
                line++;
            }
            reader.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return laststrJson;
    }

    /**
     * 写出json文件
     */
    public static void writeJsonFile(String newJsonString, String path){
        try {
            FileWriter fw = new FileWriter(path);
            PrintWriter out = new PrintWriter(fw);
            out.write(newJsonString);
            out.println();
            fw.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 将JSON数据格式化并保存到文件中
     * @param jsonData 需要输出的json数
     * @param filePath 输出的文件地址
     * @return
     */
    public static boolean createJsonFile(Object jsonData, String filePath) {
        String content = JSON.toJSONString(jsonData, SerializerFeature.PrettyFormat, SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteDateUseDateFormat);
        // 标记文件生成是否成功
        boolean flag = true;
        // 生成json格式文件
        try {
            // 保证创建一个新文件
            File file = new File(filePath);
            if (!file.getParentFile().exists()) { // 如果父目录不存在，创建父目录
                file.getParentFile().mkdirs();
            }
            if (file.exists()) { // 如果已存在,删除旧文件
                file.delete();
            }
            file.createNewFile();
            // 将格式化后的字符串写入文件
            Writer write = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
            write.write(content);
            write.flush();
            write.close();
        } catch (Exception e) {
            flag = false;
            e.printStackTrace();
        }
        return flag;
    }

}