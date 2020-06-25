package com.deft.otus.homework9;

import java.util.Map;

/*
 * Created by sgolitsyn on 6/21/20
 */
public class Tester {

    public static void main(String[] args) {
//        fistTest();
        secondTest();
    }

    private static void secondTest() {
        Map<MyObj, String> map = new GolitsynMapOpenAddresses<>();
        MyObj one = new MyObj(1);
        MyObj two = new MyObj(11);
        MyObj three = new MyObj(31);
        MyObj four = new MyObj(41);
        MyObj five = new MyObj(51);
        map.put(one, "one");
        map.put(two, "two");
        map.put(three, "three");
        map.put(four, "four");
        map.put(five, "five");

        System.out.println("Map size is : " + map.size());
        System.out.println(String.format("Key : %s, Value : %s", one, map.get(one)));
        System.out.println(String.format("Key : %s, Value : %s", two, map.get(two)));
        System.out.println(String.format("Key : %s, Value : %s", three, map.get(three)));
        System.out.println(String.format("Key : %s, Value : %s", four, map.get(four)));
        System.out.println(String.format("Key : %s, Value : %s", five, map.get(five)));
        map.remove(one);
        map.remove(three);

        System.out.println(String.format("Key : %s, Value : %s", one, map.get(one)));
        System.out.println(String.format("Key : %s, Value : %s", two, map.get(two)));
        System.out.println(String.format("Key : %s, Value : %s", three, map.get(three)));
        System.out.println(String.format("Key : %s, Value : %s", four, map.get(four)));
        System.out.println(String.format("Key : %s, Value : %s", five, map.get(five)));
        map.put(one, "one");

        Map<String, String> otherMap = new GolitsynMapOpenAddresses<>();
        otherMap.put("one", "one");
        otherMap.put("two", "two");
        otherMap.put("three", "three");
        otherMap.put("four", "four");
        otherMap.put("five", "five");

        System.out.println("Map size is : " + otherMap.size());
        System.out.println(String.format("Key : %s, Value : %s", "one", otherMap.get("one")));
        System.out.println(String.format("Key : %s, Value : %s", "two", otherMap.get("two")));
        System.out.println(String.format("Key : %s, Value : %s", "three", otherMap.get("three")));
        System.out.println(String.format("Key : %s, Value : %s", "four", otherMap.get("four")));
        System.out.println(String.format("Key : %s, Value : %s", "five", otherMap.get("five")));
    }

    private static void fistTest() {
        Map<MyObj, String> map = new GolitsynsMap<>();
        MyObj one = new MyObj(1);
        MyObj two = new MyObj(2);
        MyObj three = new MyObj(3);
        MyObj four = new MyObj(4);
        MyObj five = new MyObj(5);
        map.put(one, "one");
        map.put(two, "two");
        map.put(three, "three");
        map.put(four, "four");
        map.put(five, "five");

        System.out.println("Map size is : " + map.size());
        System.out.println(String.format("Key : %s, Value : %s", one, map.get(one)));
        System.out.println(String.format("Key : %s, Value : %s", two, map.get(two)));
        System.out.println(String.format("Key : %s, Value : %s", three, map.get(three)));
        System.out.println(String.format("Key : %s, Value : %s", four, map.get(four)));
        System.out.println(String.format("Key : %s, Value : %s", five, map.get(five)));

        Map<String, String> otherMap = new GolitsynsMap<>();
        otherMap.put("one", "one");
        otherMap.put("two", "two");
        otherMap.put("three", "three");
        otherMap.put("four", "four");
        otherMap.put("five", "five");

        System.out.println("Map size is : " + otherMap.size());
        System.out.println(String.format("Key : %s, Value : %s", "one", otherMap.get("one")));
        System.out.println(String.format("Key : %s, Value : %s", "two", otherMap.get("two")));
        System.out.println(String.format("Key : %s, Value : %s", "three", otherMap.get("three")));
        System.out.println(String.format("Key : %s, Value : %s", "four", otherMap.get("four")));
        System.out.println(String.format("Key : %s, Value : %s", "five", otherMap.get("five")));
    }
}
