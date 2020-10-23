/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : OOM
 * Date Created : 2020-10-20
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2020-10-20       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.dailytest.testoom;

/**
 * @program: com.example.dailytest.testoom
 * @description: xxx
 * @author: w15021
 * @create: 2020-10-20
 **/

/*
下面的代码试图创建2 x 1024 x 1024个元素的整型数组，
当你尝试编译并指定12M堆空间运行时（java -Xmx12m OOM）
将会失败并抛出java.lang.OutOfMemoryError: Java heap space错误，
而当你指定13M堆空间时，将正常的运行
 */
class OOM {
    static final int SIZE=2*1024*1024;
    public static void main(String[] a) {
        int[] i = new int[SIZE];
    }
}

// https://blog.csdn.net/m0_38110132/article/details/79848426