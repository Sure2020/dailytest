/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : KeylessEntry
 * Date Created : 2020-10-19
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2020-10-19       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.dailytest.testoom;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: com.example.dailytest.testoom
 * @description: xxx
 * @author: w15021
 * @create: 2020-10-19
 **/

/*
9847    49848
9848    49849
9849    49850
9850    49851
Exception in thread "main" java.lang.OutOfMemoryError: GC overhead limit exceeded
	at com.example.dailytest.testoom.KeylessEntry.main(KeylessEntry.java:70)

Process finished with exit code 1
 */
public class KeylessEntry {

    static class Key {
        Integer id;

        Key(Integer id) {
            this.id = id;
        }

        @Override
        public int hashCode() {
            return id.hashCode();
        }

        /*@Override
        public boolean equals(Object o) {
            boolean response = false;
            if (o instanceof Key) {
                response = (((Key)o).id).equals(this.id);
            }
            return response;
        }*/
    }
/*
9848    49849
9849    49850
9850    49851
9851    49852
Exception in thread "main" java.lang.OutOfMemoryError: GC overhead limit exceeded
	at java.util.Arrays.copyOfRange(Arrays.java:3664)
	at java.lang.String.<init>(String.java:207)
	at java.lang.StringBuilder.toString(StringBuilder.java:407)
	at com.example.dailytest.testoom.KeylessEntry.main(KeylessEntry.java:52)
 */
    public static void main(String[] args) {
        Map<Key,String> m = new HashMap<Key,String>();
        while(true) {
            for(int i=0;i<10000;i++) {
                if(!m.containsKey(new Key(i))) {
                    m.put(new Key(i), "Number:" + i);
                    System.out.println(i + "    " + m.size());
                }
            }
        }
    }
}