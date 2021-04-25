/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : JdkSignatureUtil
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
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

/**
 * @author 01
 * @program demo
 * @description RSA签名工具类
 * @create 2018-12-15 21:26
 * @since 1.0
 **/
public class JdkSignatureUtil {

    private final static String RSA = "RSA";

    private final static String MD5_WITH_RSA = "MD5withRSA";

    /**
     * 执行签名
     *
     * @param rsaPrivateKey 私钥
     * @param src           参数内容
     * @return 签名后的内容，base64后的字符串
     * @throws InvalidKeyException      InvalidKeyException
     * @throws NoSuchAlgorithmException NoSuchAlgorithmException
     * @throws InvalidKeySpecException  InvalidKeySpecException
     * @throws SignatureException       SignatureException
     */
    public static String executeSignature(String rsaPrivateKey, String src) throws InvalidKeyException,
            NoSuchAlgorithmException, InvalidKeySpecException, SignatureException {
        // base64解码私钥
        byte[] decodePrivateKey = Base64.getDecoder().decode(rsaPrivateKey.replace("\r\n", ""));

        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(decodePrivateKey);
        KeyFactory keyFactory = KeyFactory.getInstance(RSA);
        PrivateKey privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
        Signature signature = Signature.getInstance(MD5_WITH_RSA);
        signature.initSign(privateKey);
        signature.update(src.getBytes());
        // 生成签名
        byte[] result = signature.sign();

        // base64编码签名为字符串
        return Base64.getEncoder().encodeToString(result);
    }

    /**
     * 验证签名
     *
     * @param rsaPublicKey 公钥
     * @param sign         签名
     * @param src          参数内容
     * @return 验证结果
     * @throws NoSuchAlgorithmException NoSuchAlgorithmException
     * @throws InvalidKeySpecException  InvalidKeySpecException
     * @throws InvalidKeyException      InvalidKeyException
     * @throws SignatureException       SignatureException
     */
    public static boolean verifySignature(String rsaPublicKey, String sign, String src) throws NoSuchAlgorithmException,
            InvalidKeySpecException, InvalidKeyException, SignatureException {
        // base64解码公钥
        byte[] decodePublicKey = Base64.getDecoder().decode(rsaPublicKey.replace("\r\n", ""));

        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(decodePublicKey);
        KeyFactory keyFactory = KeyFactory.getInstance(RSA);
        PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
        Signature signature = Signature.getInstance(MD5_WITH_RSA);
        signature.initVerify(publicKey);
        signature.update(src.getBytes());
        // base64解码签名为字节数组
        byte[] decodeSign = Base64.getDecoder().decode(sign);

        // 验证签名
        return signature.verify(decodeSign);
    }
}