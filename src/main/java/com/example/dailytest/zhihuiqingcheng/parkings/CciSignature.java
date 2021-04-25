package com.example.dailytest.zhihuiqingcheng.parkings;



//import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;

import java.util.*;

/**
 * @author 陶肖寅
 * @version V1.0
 * <p>
 * date: 2020/7/1 上午10:45
 * email:fromlx@126.com
 * @Copyright: 2020-2021 城云科技(中国)有限公司
 * </p>
 */
public class CciSignature {
    /**
     * 根据请求参数组件成param
     * @param param
     * @return
     */
    public static String concatSignString(String param) {
        /**
         * 获取参数值
         */
        String[] split = param.trim().split("&");
        List<String> list = new ArrayList<>();
        Arrays.stream(split).forEach(s->{
            if(!s.startsWith("sign") & !s.startsWith("sign_type")){
                list.add(s);
            }
        });
        StringBuilder sb = new StringBuilder();
        list.forEach(s -> {
            // 参数值为空，则不参与签名
            sb.append(s).append("&");
        });

        return sb.toString();
    }

    /**
     * 签名方法
     * @param param 请求参数
     * @param privateKey 私钥
     * @return 加密结果
     */
    public static String sign(JSONObject param, String privateKey) throws Exception{
        String content = removeSignAndSignType(param);
        return RSAUtil.sign(content,privateKey);
    }

    private static String removeSignAndSignType(JSONObject param) {
        param.remove("sign");
        param.remove("sign_type");
        //return JSON.toJSONString(param);

        return param.toString();
    }

    /**
     * 验证方法
     * @param param 请求参数
     * @param publicKey 公钥
     * @param sign 签名
     * @return 验证成功true|false
     */
    public static Boolean verifySign(JSONObject param, String publicKey, String sign) throws Exception{
//        String content = concatSignString(params);
        String content = removeSignAndSignType(param);
        boolean verify = RSAUtil.verify(content, publicKey, sign);
        return verify;
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
//        JSONObject p = new JSONObject();
//        p.put("result_url",null);
//        p.put("access_id","1231");
        try {
           /* String param = "{\n" +
                    "    \"access_id\": \"A00002\",\n" +
                    "    \"timestamp\": 1607138656518,\n" +
                    "    \"sign\":\"P/BYIvW5sipHFKAY7iO8fpxU6PEL5Mt3fPQk0GZacW3hA4DxGJvV6ZLyAietb7IPepfBw26cYysacF0Nm3Xhf1YhdW39QjB858GJmSeavyFh/Sf3yFGk/ZvNdG13BUva+5efAFCgQ5ff0yvkjeEzE/RXd3ZOq96dt9qvzmSRml0=\",\n" +
                    "    \"biz_context\": {\n" +
                    "        \"arrive_id\": \"1\",\n" +
                    "        \"gate_no\": \"1\",\n" +
                    "        \"operator_code\": \"01C001\",\n" +
                    "        \"entry_num\": \"1\",\n" +
                    "        \"total_berth_num\": 150,\n" +
                    "        \"open_berth_num\": 130,\n" +
                    "        \"parking_code\": \"1001\",\n" +
                    "        \"free_berth_num\": 70,\n" +
                    "        \"plate_color\": \"1\",\n" +
                    "        \"plate_no\": \"浙A01C01\",\n" +
                    "        \"parking_type\": 1,\n" +
                    "        \"uid\": \"01001120181012093022567\",\n" +
                    "        \"arrive_time\": \"2020-04-26 17:28:33\",\n" +
                    "        \"upload_time\":\"2020-04-26 17:28:33\"\n" +
                    "    }\n" +
                    "}";*/

            String param = "{\"sign\":\"LNFqLoJEg9X6Ww9CnW8df7G6vR/m/pNNPkelomADzijEM+850KlIRo/vC2MD/FlTgwNPsOqQWLa3rgzuBWftf0AorcAA4XpJ9IFr29mODNGQPpIRh50FrV1/OeRQCDrwH8IXFa6E216YAgSu+nLbLUz2Q5Uo95YZGusZSWdNOc0=\",\"access_id\":\"A00002\",\"biz_context\":\"{\\\"parkingCode\\\":\\\"01A002\\\",\\\"regionCode\\\":\\\"150104\\\"}\",\"timestamp\":\"1617358318881\"}";

            //demo 自带key
            //String privateKey="MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBAIc1KmG5mg2xuD7aZRmx/lzQzkAXR+9jiQ0HlgRDTkn/kz7yV/T6vv86LURSUeXyvGBsAa8+0yVe6YWr//ttWYxPqJnOQFH+MEr6hVFNHczTNI6/j5L9wDt+bVCCktJdzPy1/RCMd6YUXdh+QQr2Mzu6DG/BYWRqJKOEx9nuAiYDAgMBAAECgYB4xCMT4LzaKHhCI74T4mkpLBRdKK5HA2fBrJnxOtDtxYsWuU2Y8nKw85zFHqYqNtLNaQtkJUBha9I3ZDcjszs8fWTKvwY/exCcmehPSxmYwwBrwIP5EnMT/sw7YXny22cMA6qVbP1EKCN3/JlHtbl482NNvkakH5I+ZZAeOlwQ8QJBAPxrd7x/ECIspMb2OsHis4+xfq/m9pohTqmDJq8kspk9Q8T9bvuJVtJ3dOh+dY7rjSxSpxIOmpukiPEe5w7ATHsCQQCJIBo80Z/TxAudswpEJuzdA5qacTUTp4Drxv8zWk2GLllZ2+adG4ZH0ZSNdVmIbKn2Vp+DFfQ0cwBlCc4fA6oZAkAbfBgtjihTkEjg4S7ErcqfetQwkxWG8tl926n6qCRKS0F10aKkAPBTOm6gYiSqyzsz+Ev4y15KVEAVAShnksjBAkBJ8frUI0KqAsU01FDL8aW3hXMAp920bJaUDqqd+atmmWXrlC7nN+mQnw8ZvVd7vwVkZs/784HOKtnioof5p5M5AkAW0Q4u7Nbr6FC3nlrA/Si0SQde4FFMK1P9ehbAIemf69ddgNvIuV7ojn/uott8ELTG6+wU2p19ltqEhZat7Ftq";
            //String publicKey="MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCHNSphuZoNsbg+2mUZsf5c0M5AF0fvY4kNB5YEQ05J/5M+8lf0+r7/Oi1EUlHl8rxgbAGvPtMlXumFq//7bVmMT6iZzkBR/jBK+oVRTR3M0zSOv4+S/cA7fm1QgpLSXcz8tf0QjHemFF3YfkEK9jM7ugxvwWFkaiSjhMfZ7gImAwIDAQAB";


            //旧key
            //String privateKey="MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAIE06mxcTH4clxv6L40x7eEFtuJ3t1xGYkk36+CpgBdvjgjHwUKjp2ibThw4baAx9+AFY0/+MUvgFe2DRyR6TOn0Ubim70NCc1IsWERtt5s0dbGW2dnZOskhd0dcwOkqUXXJdD3nIi1LrZC6p1vJyOOIGhVP0fOPsA/QQ2GYFhTHAgMBAAECgYA3g4LNOALtlF8geCgCJFeufQQM3Z78mIkWKF7CUlFkwFtoTlssxJ/jBAdVfLEtSQrVR7tZ3T9U+FyzhdoFRD7TEe9j8YBAokUSRCQ8ag374fVDxP47PxADGiD4wC6KPkOftbI1YqTPimZE+6h1p5ZM4Jq8qMmKqKZqaypWrm9nkQJBALzPalsuAB8mldfsXLONLSlD4a6TsoQKJlBMlI7SEOMsnpx0WOiS0A/xHufpvW4+QI93I8OBmwVtdZF1Bb/r7tMCQQCvL6DbePJhx5NsyEU0NQf7gqN3KCriiLanTwCLf5QaJFTmZTNyXdBEUfz2BWAZIyJV8AKgWY0yVcam/QlEklG9AkBNiF8EUj96iz29DTKECNUivN1P8xa7Ye+Zydi3TUvh/dCkLqLT3nXSFhG66iD/xFB+mU32WqJt+CTvNj7GMPxBAkEAo+vyHUr3qezAEtr2flpc5Mehw15velcoajcvMFipMSjr1EW/tPT5auQ4yc/P0tWgTD9vhbElwIKohhpg8KvlFQJAK1BeFdBl+3tOTYl/J8iTsF5tnjdHdggtyZsvU6TG1G6gG2W2gmveODi6Ez8TM7TmaMI6AjxkGf3OYqD+Izhpug==";
            //测试key
            //String privateKey="MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAJ9232hM7bZpBhlPvGrT08Ga5ZOQseKpQq6Osk0P1pw8RzOxomS8blWJqU3Ximnk0HeXVoM+F/yjwF1FqQ/w1J7tQUzitUqIjkryfmO7L5Wdiy+v1TlLnwBzkc89MuSmo19PxaL48VloHyKooCdZ5XIAKoKGjNK22dZGn3kXkslZAgMBAAECgYBR5iCJlfEEnV33g/82MoLwTViZeFgUHHBV7I3gjEDhzweWoiXQbQKRxfkBNLEu/8idk0locGyrYYK7pLpWqI7aHV8f7VD8l9Bxx6vCwz+yzDdWeDspt7Df4fmn9QtByzPCP11ez+zcrYSMF1GocLjlDEbB1ss3eN3v1ScgWRo3fQJBAMskjGd8EMnjVKEv5zt+D84KWCqMZDQqskClwDAEHlM8f5uWwh3AXBC324rzuAClXBUxkvqsTTF9aeOG95dkx18CQQDI9OFtBEpnHF27OCcYKzqHsmkavyt0kuvvPCWyJ/n4+Tv/e304KnOlI7Y4i+B3F6+Y4Md3wnJWuEWiqhcYZ0JHAkEAjbHroY8/YqMH9/qi7rNqsMw0XVFZ361cco1q9dMZl/OeCtfohLoVPbARGeYQFZtCFKJkpCclHP0erA8LinVIPwJBAI6fhhJqVigCMN/8RXrYy2ydig0KmtvcnoinZpWf28EBmryDN2cScgtFYkGVvNSpQd49wjPUFHRJylpdX5DZUGcCQCjWiWCfy4g/Eu9oK+WKjTkH4s8HDtaEy3A7pNlohsdYRpeExgCBMLt3fTqnWocUWs5xUlR61x12vQf/xORxBCE=";
            //正式key
            String privateKey="MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBANZPkSLui86pdulK6A7lKV4BqeVEk7q3Xu7zzrvoqUlUBSYsJvc0T6xYcwqBjkimayygWvXgPEKdK2GAsHBFd/UxaFtI15P3xWBpS8neGyjDIm5KEn/ahKGVJZrtKXDU5dALxZn+zCAjofBtCl4hJl2hxhmZ6DuvWW+eRkclyIEXAgMBAAECgYBDDLHD1A45ohtp8d2Yi2nd13doG4R8rlItQGo1sB0GrBrQTpACV4N10FZtuwrg//AYDjNnKbiwvquL3c9V0OYuZYxgKL0ixtQttcSzJfaLPDoClfrZcKQ16Tp6l9x86fQOiVRgeRVYoZPcUGg/CE1Z5BlnQ7LDRlGmU+AheFZkgQJBAPRib0g+/JsOgSY2o2/acGHx1cgh2SAj4iqbFtYg6X3SQfHoRLtN9lBFqAVTO8vTJpMlKsbxGCAYu2yG3+Ufov8CQQDgfzVaOY8FurX8b27QBGA/kExlmvV9+mLBu+kK2+vXg4SLfrity6axWB0z0bXA8bOxZY942HzXaBmBrFvcLdnpAkEAw1Gk9U36IIdQK1WB/JTOO0nIfiKnYWusiDbZ4pv9YaVZNVlZDYZ69Z8mcdMbOIVzECmlbcklagm6Sjvl2D8XywJAbMGTkisSO39RTIKbV1DXY9O+/vYL+cTD9QDYi/cwkM5Y9s8kHqXrEj0SoJj2iQtOtyDxWWTfTedTe/uI4OihiQJBANlpUNNfpR6x8SSGPUerowYHqqXf5TFEJxziChGj3uGMtKF7z/zheOiUwvMnGbdieXdxOvqLlasyEdENJpMUb6o=";


            //旧key
            //String publicKey="MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCBNOpsXEx+HJcb+i+NMe3hBbbid7dcRmJJN+vgqYAXb44Ix8FCo6dom04cOG2gMffgBWNP/jFL4BXtg0ckekzp9FG4pu9DQnNSLFhEbbebNHWxltnZ2TrJIXdHXMDpKlF1yXQ95yItS62QuqdbycjjiBoVT9Hzj7AP0ENhmBYUxwIDAQAB";
            //测试key
            //String publicKey="MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDWT5Ei7ovOqXbpSugO5SleAanlRJO6t17u88676KlJVAUmLCb3NE+sWHMKgY5IpmssoFr14DxCnSthgLBwRXf1MWhbSNeT98VgaUvJ3hsowyJuShJ/2oShlSWa7Slw1OXQC8WZ/swgI6HwbQpeISZdocYZmeg7r1lvnkZHJciBFwIDAQAB";
            //正式key
            String publicKey="MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDWT5Ei7ovOqXbpSugO5SleAanlRJO6t17u88676KlJVAUmLCb3NE+sWHMKgY5IpmssoFr14DxCnSthgLBwRXf1MWhbSNeT98VgaUvJ3hsowyJuShJ/2oShlSWa7Slw1OXQC8WZ/swgI6HwbQpeISZdocYZmeg7r1lvnkZHJciBFwIDAQAB";

            /*
            .net 、php 开发与Java 有所不同，故使用上述方法保证入参一致性做法 ：
            接入方使用入参解密，我方使用入参解密，运行期间入参不得更改顺序，否则会解密失败。
             */


            ParkingRequestContent parkingRequestContent = new ParkingRequestContent();
            parkingRequestContent.setAccess_id("A20210401174520");
            parkingRequestContent.setTimestamp(System.currentTimeMillis());

            String  jsonString  = JSON.toJSONString(parkingRequestContent);
            JSONObject jsonObject = JSON.parseObject(jsonString, Feature.OrderedField);

            String sign = sign(jsonObject, privateKey);
            System.out.println(sign);
            System.out.println(System.currentTimeMillis());
            Boolean ver = verifySign(jsonObject, publicKey, sign);
            System.out.println(ver);
        }catch (Exception e) {
            e.printStackTrace();
        }

    }
}
