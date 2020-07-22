package com.deft.otus.homework9;

import java.util.Objects;

/*
 * Created by sgolitsyn on 6/21/20
 */
public class MyObj {

    int value;

    public MyObj(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyObj myObj = (MyObj) o;
        return value == myObj.value;
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
