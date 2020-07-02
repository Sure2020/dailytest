/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : Book
 * Date Created : 2020-07-01
 * Creator      : w15021
 * Description  : xxx
 *
 * --------------------------------------------------------------------
 * Modification History
 * DATE             NAME                DESCRIPTION
 * --------------------------------------------------------------------
 * 2020-07-01       w15021     xxx
 * --------------------------------------------------------------------
 */

package com.example.dailytest.testmain.shallowAndDeepCopy;

import lombok.Data;

/**
 * @program: com.example.dailytest.testmain.shallowAndDeepCopy
 * @description: xxx
 * @author: w15021
 * @create: 2020-07-01
 **/
@Data
public class Book implements Cloneable{
    private String id;
    private String price;
    private Author author;


    public Book (String id, String price, Author author) {
        this.id = id;
        this.price = price;
        this.author = author;
    }

    public Book () {}

    public Object clone() {
        Book b = null;
        try{
            b = (Book) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return b;
    }

    public Object deepClone() {
        Author a = new Author (this.getAuthor().getName(),this.getAuthor().getAge());
        Book b = new Book(this.id, this.price, a);
        return b;
    }
}