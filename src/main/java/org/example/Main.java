package org.example;


import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Goods> goods = CrudUtils.getStudentData("SELECT * FROM list_of_goods");
        System.out.print(goods);
    }


}