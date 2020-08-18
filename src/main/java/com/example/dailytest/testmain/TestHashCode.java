package com.example.dailytest.testmain;

import java.util.ArrayList;
import java.util.List;

public class TestHashCode {
    public static void main(String[] args) {
        String str1 = "通话";
        String str2 = "重地";
        System.out.println(String.format("str1：%d | str2：%d",  str1.hashCode(),str2.hashCode()));
        System.out.println(str1.equals(str2));

        List lista = new ArrayList();
        lista.add("a");
        List listb = new ArrayList();
        listb.add("a");
        System.out.println(lista.hashCode() + "\n" + listb.hashCode());

        String stra = "a";
        String strb = "97";
        Integer inta = 97;
        System.out.println(stra.hashCode() + "  " + strb.hashCode() + "  " + inta.hashCode());
    }
}
