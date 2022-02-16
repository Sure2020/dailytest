/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : TestDES
 * Date Created : 2022-02-17
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2022-02-17       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.dailytest.testmain;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.AES;
import cn.hutool.crypto.symmetric.DES;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;

/**
 * @program: com.example.dailytest.testmain
 * https://www.daimajiaoliu.com/daima/479c03b59100400
 * @description: xxx
 * @author: w15021
 * @create: 2022-02-17
 **/
public class TestAESandDES {
    public static void main(String[] args) {
        /*
        //String content = "/h3coasis/local_volumes/iotdevops/upload/platform/test_p";
        String content = "test";

//随机生成密钥
        byte[] key = SecureUtil.generateKey(SymmetricAlgorithm.AES.getValue()).getEncoded();

//构建
        AES aes = SecureUtil.aes(key);

//加密
        byte[] encrypt = aes.encrypt(content);
//解密
        byte[] decrypt = aes.decrypt(encrypt);

//加密为16进制表示
        String encryptHex = aes.encryptHex(content);
        System.out.println(encryptHex);
//解密为原字符串g
        String decryptStr = aes.decryptStr(encryptHex);
        System.out.println(decryptStr);
*/

        String content = "/h3coasis/local_volumes/iotdevops/upload/platform/test_p";

//随机生成密钥
        byte[] key = SecureUtil.generateKey(SymmetricAlgorithm.DES.getValue()).getEncoded();

//构建
        DES des = SecureUtil.des(key);

//加密解密
        byte[] encrypt = des.encrypt(content);
        byte[] decrypt = des.decrypt(encrypt);

//加密为16进制，解密为原字符串
        String encryptHex = des.encryptHex(content);
        System.out.println(encryptHex);
        String decryptStr = des.decryptStr(encryptHex);
        System.out.println(decryptStr);
    }
}