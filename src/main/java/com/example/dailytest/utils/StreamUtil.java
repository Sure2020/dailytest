/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : StreamUtil
 * Date Created : 2020-03-05
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2020-03-05       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.dailytest.utils;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @program: com.example.lishuiduijie_test.utils
 * @description: xxx
 * @author: w15021
 * @create: 2020-03-05
 **/

public class StreamUtil
{


    private static final String DEFAULT_ENCODING = "utf-8";

    public static String inputStream2String(InputStream in, String charsetName)
    {
        if (in == null)
        {
            return null;
        }

        InputStreamReader inReader = null;

        try
        {
            if (StringUtil.strIsNullOrEmpty(charsetName))
            {
                inReader = new InputStreamReader(in, DEFAULT_ENCODING);
            }
            else
            {
                inReader = new InputStreamReader(in, charsetName);
            }

            int readLen = 0;
            char[] buffer = new char[1024];
            StringBuffer strBuf = new StringBuffer();
            while ((readLen = inReader.read(buffer)) != -1)
            {
                strBuf.append(buffer, 0, readLen);
            }

            return strBuf.toString();
        }
        catch (IOException e)
        {
            System.out.println(e);
        }
        finally
        {
            closeStream(inReader);
        }

        return null;
    }

    public static void closeStream(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }
}