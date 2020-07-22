package com.deft.otus;

import java.util.HashMap;
import java.util.Map;

/*
 * Created by sgolitsyn on 4/29/20
 */
public class OtusAlgo {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put(null, "qwe");
        map.put("1", null);
        System.out.println(map.get(null));
        System.out.println(map.get("1"));
    }
}
