package com.deft.otus.homework7;

import com.deft.otus.homework7.AVLTree.AVLTree;
import com.deft.otus.homework7.model.Person;
import com.deft.otus.homework7.tree.BaseTree;
import com.deft.otus.homework7.tree.BinarySearchTree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/*
 * Created by sgolitsyn on 6/17/20
 */
public class Tester {

    public static BaseTree test1FillRandom() {
        long start = System.currentTimeMillis();
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            double val = Math.random() * 10000 + 1;
            persons.add(new Person((int) val));
        }

        BaseTree<Integer, Person> tree = new BinarySearchTree<>();
        persons.forEach(tree::insert);
        long end = System.currentTimeMillis();
        System.out.println("Fill time : " + (end - start));
        return tree;
    }

    public static BaseTree test1FillConsequentially() {
        long start = System.currentTimeMillis();
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            persons.add(new Person(i));
        }

        BaseTree<Integer, Person> tree = new BinarySearchTree<>();
        persons.forEach(tree::insert);
        long end = System.currentTimeMillis();
        System.out.println("Fill time : " + (end - start));
        return tree;
    }

    public static void test1SearchRandom(BaseTree<Integer, Person> tree, int param) {
        long start = System.currentTimeMillis();
        for (int i = 1; i < param; i++) {
            double val = Math.random() * 1000000 + 1;
            System.out.println(tree.find((int) val));
        }
        long end = System.currentTimeMillis();
        System.out.println("Execution time : " + (end - start));
    }

    public static void test1SearchConsequentially(BaseTree<Integer, Person> tree, int param) {
        long start = System.currentTimeMillis();
        for (int i = 1; i < param; i++) {
            double val = Math.random() * 1000000 + 1;
            System.out.println(tree.find((int) val));
        }
        long end = System.currentTimeMillis();
        System.out.println("Execution time : " + (end - start));
    }


    static void test2(BaseTree tree) {
        Person p1 = new Person(50);
        Person p3 = new Person(17);
        Person p2 = new Person(76);
        Person p6 = new Person(9);
        Person p5 = new Person(23);
        Person p8 = new Person(54);
        Person p7 = new Person(14);
        Person p9 = new Person(19);
        Person p10 = new Person(72);
        Person p4 = new Person(12);
        Person p67 = new Person(67);
        Stream.of(p1, p3, p2, p6, p5, p8, p7, p9, p10, p4, p67).forEach(tree::insert);
        tree.preOrder();
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        tree.inOrder();
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        tree.postOrder();
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        System.out.println("delete");
        tree.delete(17);
        tree.postOrder();
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-");

    }

    static void test3(BaseTree tree) {
        Person p1 = new Person(11);
        Person p3 = new Person(4);
        Person p2 = new Person(20);
        Person p6 = new Person(9);
//        Person p5 = new Person(12);
//        Person p8 = new Person(30);
        Person p7 = new Person(7);
        Person p9 = new Person(10);
        Stream.of(p1, p3, p2, p6,/* p5, p8,*/ p7, p9).forEach(tree::insert);
        tree.preOrder();
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        tree.inOrder();
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        tree.postOrder();
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        System.out.println("delete");
//        tree.delete(17);
//        tree.postOrder();
//        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-");

    }

}
