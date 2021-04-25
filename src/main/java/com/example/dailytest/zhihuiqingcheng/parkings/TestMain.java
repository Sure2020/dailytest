package com.example.dailytest.zhihuiqingcheng.parkings;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestMain {
    //旧key
    //public static String PRIVATE_KEY = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAIE06mxcTH4clxv6L40x7eEFtuJ3t1xGYkk36+CpgBdvjgjHwUKjp2ibThw4baAx9+AFY0/+MUvgFe2DRyR6TOn0Ubim70NCc1IsWERtt5s0dbGW2dnZOskhd0dcwOkqUXXJdD3nIi1LrZC6p1vJyOOIGhVP0fOPsA/QQ2GYFhTHAgMBAAECgYA3g4LNOALtlF8geCgCJFeufQQM3Z78mIkWKF7CUlFkwFtoTlssxJ/jBAdVfLEtSQrVR7tZ3T9U+FyzhdoFRD7TEe9j8YBAokUSRCQ8ag374fVDxP47PxADGiD4wC6KPkOftbI1YqTPimZE+6h1p5ZM4Jq8qMmKqKZqaypWrm9nkQJBALzPalsuAB8mldfsXLONLSlD4a6TsoQKJlBMlI7SEOMsnpx0WOiS0A/xHufpvW4+QI93I8OBmwVtdZF1Bb/r7tMCQQCvL6DbePJhx5NsyEU0NQf7gqN3KCriiLanTwCLf5QaJFTmZTNyXdBEUfz2BWAZIyJV8AKgWY0yVcam/QlEklG9AkBNiF8EUj96iz29DTKECNUivN1P8xa7Ye+Zydi3TUvh/dCkLqLT3nXSFhG66iD/xFB+mU32WqJt+CTvNj7GMPxBAkEAo+vyHUr3qezAEtr2flpc5Mehw15velcoajcvMFipMSjr1EW/tPT5auQ4yc/P0tWgTD9vhbElwIKohhpg8KvlFQJAK1BeFdBl+3tOTYl/J8iTsF5tnjdHdggtyZsvU6TG1G6gG2W2gmveODi6Ez8TM7TmaMI6AjxkGf3OYqD+Izhpug==";
    //正式key
    public static String PRIVATE_KEY = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBANZPkSLui86pdulK6A7lKV4BqeVEk7q3Xu7zzrvoqUlUBSYsJvc0T6xYcwqBjkimayygWvXgPEKdK2GAsHBFd/UxaFtI15P3xWBpS8neGyjDIm5KEn/ahKGVJZrtKXDU5dALxZn+zCAjofBtCl4hJl2hxhmZ6DuvWW+eRkclyIEXAgMBAAECgYBDDLHD1A45ohtp8d2Yi2nd13doG4R8rlItQGo1sB0GrBrQTpACV4N10FZtuwrg//AYDjNnKbiwvquL3c9V0OYuZYxgKL0ixtQttcSzJfaLPDoClfrZcKQ16Tp6l9x86fQOiVRgeRVYoZPcUGg/CE1Z5BlnQ7LDRlGmU+AheFZkgQJBAPRib0g+/JsOgSY2o2/acGHx1cgh2SAj4iqbFtYg6X3SQfHoRLtN9lBFqAVTO8vTJpMlKsbxGCAYu2yG3+Ufov8CQQDgfzVaOY8FurX8b27QBGA/kExlmvV9+mLBu+kK2+vXg4SLfrity6axWB0z0bXA8bOxZY942HzXaBmBrFvcLdnpAkEAw1Gk9U36IIdQK1WB/JTOO0nIfiKnYWusiDbZ4pv9YaVZNVlZDYZ69Z8mcdMbOIVzECmlbcklagm6Sjvl2D8XywJAbMGTkisSO39RTIKbV1DXY9O+/vYL+cTD9QDYi/cwkM5Y9s8kHqXrEj0SoJj2iQtOtyDxWWTfTedTe/uI4OihiQJBANlpUNNfpR6x8SSGPUerowYHqqXf5TFEJxziChGj3uGMtKF7z/zheOiUwvMnGbdieXdxOvqLlasyEdENJpMUb6o=";
    //测试key
    //public static String PRIVATE_KEY = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAJ9232hM7bZpBhlPvGrT08Ga5ZOQseKpQq6Osk0P1pw8RzOxomS8blWJqU3Ximnk0HeXVoM+F/yjwF1FqQ/w1J7tQUzitUqIjkryfmO7L5Wdiy+v1TlLnwBzkc89MuSmo19PxaL48VloHyKooCdZ5XIAKoKGjNK22dZGn3kXkslZAgMBAAECgYBR5iCJlfEEnV33g/82MoLwTViZeFgUHHBV7I3gjEDhzweWoiXQbQKRxfkBNLEu/8idk0locGyrYYK7pLpWqI7aHV8f7VD8l9Bxx6vCwz+yzDdWeDspt7Df4fmn9QtByzPCP11ez+zcrYSMF1GocLjlDEbB1ss3eN3v1ScgWRo3fQJBAMskjGd8EMnjVKEv5zt+D84KWCqMZDQqskClwDAEHlM8f5uWwh3AXBC324rzuAClXBUxkvqsTTF9aeOG95dkx18CQQDI9OFtBEpnHF27OCcYKzqHsmkavyt0kuvvPCWyJ/n4+Tv/e304KnOlI7Y4i+B3F6+Y4Md3wnJWuEWiqhcYZ0JHAkEAjbHroY8/YqMH9/qi7rNqsMw0XVFZ361cco1q9dMZl/OeCtfohLoVPbARGeYQFZtCFKJkpCclHP0erA8LinVIPwJBAI6fhhJqVigCMN/8RXrYy2ydig0KmtvcnoinZpWf28EBmryDN2cScgtFYkGVvNSpQd49wjPUFHRJylpdX5DZUGcCQCjWiWCfy4g/Eu9oK+WKjTkH4s8HDtaEy3A7pNlohsdYRpeExgCBMLt3fTqnWocUWs5xUlR61x12vQf/xORxBCE=";
    //demo 自带key
    //public static String PRIVATE_KEY = "MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBAIc1KmG5mg2xuD7aZRmx/lzQzkAXR+9jiQ0HlgRDTkn/kz7yV/T6vv86LURSUeXyvGBsAa8+0yVe6YWr//ttWYxPqJnOQFH+MEr6hVFNHczTNI6/j5L9wDt+bVCCktJdzPy1/RCMd6YUXdh+QQr2Mzu6DG/BYWRqJKOEx9nuAiYDAgMBAAECgYB4xCMT4LzaKHhCI74T4mkpLBRdKK5HA2fBrJnxOtDtxYsWuU2Y8nKw85zFHqYqNtLNaQtkJUBha9I3ZDcjszs8fWTKvwY/exCcmehPSxmYwwBrwIP5EnMT/sw7YXny22cMA6qVbP1EKCN3/JlHtbl482NNvkakH5I+ZZAeOlwQ8QJBAPxrd7x/ECIspMb2OsHis4+xfq/m9pohTqmDJq8kspk9Q8T9bvuJVtJ3dOh+dY7rjSxSpxIOmpukiPEe5w7ATHsCQQCJIBo80Z/TxAudswpEJuzdA5qacTUTp4Drxv8zWk2GLllZ2+adG4ZH0ZSNdVmIbKn2Vp+DFfQ0cwBlCc4fA6oZAkAbfBgtjihTkEjg4S7ErcqfetQwkxWG8tl926n6qCRKS0F10aKkAPBTOm6gYiSqyzsz+Ev4y15KVEAVAShnksjBAkBJ8frUI0KqAsU01FDL8aW3hXMAp920bJaUDqqd+atmmWXrlC7nN+mQnw8ZvVd7vwVkZs/784HOKtnioof5p5M5AkAW0Q4u7Nbr6FC3nlrA/Si0SQde4FFMK1P9ehbAIemf69ddgNvIuV7ojn/uott8ELTG6+wU2p19ltqEhZat7Ftq";
    public static String URL = "https://parking.smarthohhot.com/api/v1/parkings";
    public static void main(String[] args) throws Exception {
        ParkingResponse parkingResponse = ParkingUtil.getParkingList(URL,PRIVATE_KEY,createParkingsRequest());
        log.info(parkingResponse.toString());
    }

    public static ParkingRequestContent createParkingsRequest() throws Exception {
        ParkingRequestBody parkingRequestBody = new ParkingRequestBody();
        //parkingRequestBody.setParkingCode("01A002");
        //parkingRequestBody.setRegionCode("150104");

        ParkingRequestContent parkingRequestContent = new ParkingRequestContent();
        //parkingRequestContent.setAccess_id("A20210401174520");
        //parkingRequestContent.setAccess_id("A00002");
        parkingRequestContent.setAccess_id("A20210419173334");

        parkingRequestContent.setBiz_context(parkingRequestBody);
        parkingRequestContent.setTimestamp(System.currentTimeMillis());
        log.info(parkingRequestContent.toString());

        /*String sign = CciSignature.sign(JSON.parseObject(JSON.toJSONString(parkingRequestContent)), PRIVATE_KEY);
        parkingRequestContent.setSign(sign);
        log.info(parkingRequestContent.toString());*/

        return parkingRequestContent;
    }
}
