package com.codingblocks.listfragment;

/**
 * Created by the-dagger on 23/06/17.
 */

public class Student {

    String name;
    String age;
    String course;

    public Student(String name, String age, String course) {
        this.name = name;
        this.age = age;
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }


    public String getCourse() {
        return course;
    }

}