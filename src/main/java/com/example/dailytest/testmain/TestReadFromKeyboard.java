package com.example.dailytest.testmain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class TestReadFromKeyboard {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.next();
        System.out.println(string);
        //scanner.close();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String string2 = bufferedReader.readLine();
        System.out.println(string2);
        //bufferedReader.close();
    }
}
