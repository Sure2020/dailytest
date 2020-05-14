package com.example.dailytest.testParentAndChildrenClass;

public class TestChildren extends TestParent {

    private String lastName;

    TestChildren(String lastName) {
        //super("Stev");
        this.lastName = lastName;
    }
    public void callMe () {
        System.out.println(lastName);
    }
}
