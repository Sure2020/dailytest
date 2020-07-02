/*
 * Copyright (c) 2018, New H3C Technologies Co., Ltd All rights reserved
 * <http://www.h3c.com/>
 * --------------------------------------------------------------------
 * Product      : NERV
 * Module Name  : TestShallowAndDeepCopy
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

import lombok.extern.slf4j.Slf4j;

/**
 * @program: com.example.dailytest.testmain.shallowAndDeepCopy
 * @description: xxx
 * @author: w15021
 * @create: 2020-07-01
 **/
@Slf4j
public class TestShallowAndDeepCopy {


    public static void main(String[] args) {
        Author author1 = new Author();
        author1.setAge("28");
        author1.setName("Sure");
        Book book1 = new Book();
        book1.setId("book_a");
        book1.setPrice("0");
        book1.setAuthor(author1);
        //log.info("book: {}", book.toString());
        System.out.println(book1.toString());

        Book book2 = new Book();
        //直接用等号赋值，这跟深浅拷贝没关系，是将两个对象的引用指向了同一个地址。
        book2 = book1;
        //通过book2修改price
        book2.setPrice("99");
        //通过book2修改author的age
        book2.getAuthor().setAge("37");

        System.out.println(book1.toString());
        System.out.println(book2.toString());

        //这里会发现 book1和 book2的author的age都被改变了
        System.out.println(book1.toString());
        System.out.println(book2.toString());


        System.out.println("###########浅拷贝###########");
        Author author2 = new Author("Sure2", "18");
        Book book3 = new Book("book_b", "100", author2);

        //Author(name=Sure2, age=18)
        System.out.println(author2.toString());
        //Book(id=book_b, price=100, author=Author(name=Sure2, age=18))
        System.out.println(book3.toString());

        Book book4 = (Book) book3.clone();

        book3.setPrice("300");
        //Book(id=book_b, price=300, author=Author(name=Sure2, age=18))
        System.out.println(book3.toString());
        //Book(id=book_b, price=100, author=Author(name=Sure2, age=18))
        System.out.println(book4.toString());
        book4.setPrice("400");
        //Book(id=book_b, price=300, author=Author(name=Sure2, age=18))
        System.out.println(book3.toString());
        //Book(id=book_b, price=400, author=Author(name=Sure2, age=18))
        System.out.println(book4.toString());

        book3.getAuthor().setName("Sure3");
        //Book(id=book_b, price=300, author=Author(name=Sure3, age=18))
        System.out.println(book3.toString());
        //Book(id=book_b, price=400, author=Author(name=Sure3, age=18))
        System.out.println(book4.toString());
        book4.getAuthor().setName("Sure4");
        //Book(id=book_b, price=300, author=Author(name=Sure4, age=18))
        System.out.println(book3.toString());
        //Book(id=book_b, price=400, author=Author(name=Sure4, age=18))
        System.out.println(book4.toString());
        //可以看到book3 和 book4 的author指向的是同一个对象，通过book3或book4更改author的值，book3和book4都会生效


        System.out.println("###########深拷贝###########");
        Author author3 = new Author("Sure3", "18");
        Book book5 = new Book("book_c", "100", author3);

        //Author(name=Sure3, age=18)
        System.out.println(author3.toString());
        //Book(id=book_c, price=100, author=Author(name=Sure3, age=18))
        System.out.println(book5.toString());

        Book book6 = (Book) book5.deepClone();

        book5.getAuthor().setAge("555");
        //Book(id=book_c, price=100, author=Author(name=Sure3, age=555))
        System.out.println(book5.toString());
        //Book(id=book_c, price=100, author=Author(name=Sure3, age=18))
        System.out.println(book6.toString());

        book6.getAuthor().setAge("666");
        //Book(id=book_c, price=100, author=Author(name=Sure3, age=555))
        System.out.println(book5.toString());
        //Book(id=book_c, price=100, author=Author(name=Sure3, age=666))
        System.out.println(book6.toString());
        //可以看到深拷贝的book5和book6各自的author对象已经不指向同一个地址了，互不影响了。

    }
}