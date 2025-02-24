package org.example;


import java.util.List;

public class Main {
    public static void main(String[] args) {
        // тут мы выполняем команды CRUD

        // выполнение команды SELECT, показываем текущее состояние таблицы.
        List<Goods> goods = CrudUtils.getGoodData("SELECT * FROM list_of_goods");
        System.out.print(goods);

        //выполнение команды CREATE, создаем новый товара мобильный телефон.
        Goods goods1 = new Goods();
        goods1.setTitle("mobile phone");
        goods1.setPrice(215.5f);
        System.out.println(CrudUtils.saveGoods(goods1));

        //выполнение команды UPDATE изменяем цену товара table
        System.out.println(CrudUtils.updateGoods(4, 20.6f));

        //выполнение команды DELETE, удаляем дублирующие записи мобильных телефонов
        CrudUtils.deleteGoods(5, "mobile phone");
        System.out.print(goods);

    }


}