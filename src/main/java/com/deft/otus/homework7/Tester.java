package com.deft.otus.homework7;

import com.deft.otus.homework7.model.Person;
import com.deft.otus.homework7.tree.BaseTree;
import com.deft.otus.homework7.tree.BinarySearchTree;

import java.util.stream.Stream;

/*
 * Created by sgolitsyn on 6/17/20
 */
public class Tester {

    public static void main(String[] args) {
        test2();

    }

    private static void test1() {
        Person p1 = new Person(1);
        Person p3 = new Person(3);
        Person p2 = new Person(2);
        Person p6 = new Person(6);
        Person p5 = new Person(5);
        Person p8 = new Person(8);
        Person p7 = new Person(7);
        Person p9 = new Person(9);
        Person p10 = new Person(10);
        Person p4 = new Person(4);

        BaseTree<Integer, Person> tree = new BinarySearchTree<>();
        Stream.of(p1, p3, p2, p6, p5, p8, p7, p9, p10, p4).forEach(tree::insert);

        tree.preOrder();
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        tree.inOrder();
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        tree.postOrder();
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        System.out.println(tree.find(10));
        System.out.println(tree.find(1));
        System.out.println(tree.find(4));
        System.out.println(tree.find(50));
    }


    private static void test2() {
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
        BaseTree<Integer, Person> tree = new BinarySearchTree<>();
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

}
