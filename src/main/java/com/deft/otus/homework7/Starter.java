package com.deft.otus.homework7;

import com.deft.otus.homework7.tree.BaseTree;

/*
 * Created by sgolitsyn on 6/19/20
 */
public class Starter {

    public static void main(String[] args) {
        BaseTree baseTree = Tester.test1FillRandom();
        Tester.test1SearchRandom(baseTree, 2000);
        baseTree = Tester.test1FillConsequentially();
        Tester.test1SearchConsequentially(baseTree, 2000);

    }
}
