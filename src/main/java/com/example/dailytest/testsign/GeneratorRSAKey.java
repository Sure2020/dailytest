/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : GeneratorRSAKey
 * Date Created : 2021-04-20
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2021-04-20       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.dailytest.testsign;

/**
 * @program: com.example.dailytest.testsign
 * @description: xxx
 * @author: w15021
 * @create: 2021-04-20
 **/
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Base64;

/**
 * @author 01
 * @program demo
 * @description 生成RSA公/私钥对
 * @create 2018-12-15 21:25
 * @since 1.0
 **/
public class GeneratorRSAKey {

    public static void main(String[] args) {
        jdkRSA();
    }

    public static void jdkRSA() {
        GeneratorRSAKey generatorKey = new GeneratorRSAKey();

        try {
            // 初始化密钥，产生公钥私钥对
            Object[] keyPairArr = generatorKey.initSecretkey();
            RSAPublicKey rsaPublicKey = (RSAPublicKey) keyPairArr[0];
            RSAPrivateKey rsaPrivateKey = (RSAPrivateKey) keyPairArr[1];

            System.out.println("------------------PublicKey------------------");
            System.out.println(Base64.getEncoder().encodeToString(rsaPublicKey.getEncoded()));

            System.out.println("\n------------------PrivateKey------------------");
            System.out.println(Base64.getEncoder().encodeToString(rsaPrivateKey.getEncoded()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 初始化密钥，生成公钥私钥对
     *
     * @return Object[]
     * @throws NoSuchAlgorithmException NoSuchAlgorithmException
     */
    private Object[] initSecretkey() throws NoSuchAlgorithmException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(512);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        RSAPublicKey rsaPublicKey = (RSAPublicKey) keyPair.getPublic();
        RSAPrivateKey rsaPrivateKey = (RSAPrivateKey) keyPair.getPrivate();

        Object[] keyPairArr = new Object[2];
        keyPairArr[0] = rsaPublicKey;
        keyPairArr[1] = rsaPrivateKey;

        return keyPairArr;
    }
}