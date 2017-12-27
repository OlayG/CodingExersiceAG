package com.example.admin.codingexersice;

public class MyTree<T> {

    T data;
    MyTree<T> left;
    MyTree<T> right;

    public MyTree(T data) {
        this.data = data;
    }

}
