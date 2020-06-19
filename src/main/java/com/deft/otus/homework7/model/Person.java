package com.deft.otus.homework7.model;

import com.deft.otus.homework7.tree.Key;

/*
 * Created by sgolitsyn on 6/17/20
 */
public class Person implements Key<Integer> {

    private Integer key;
    private Integer age;

    public Person(int key) {
        this.key = key;
    }
    //todo other fields

    @Override
    public Integer getKey() {
        return key;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "key=" + key +
                ", age=" + age +
                '}';
    }
}
