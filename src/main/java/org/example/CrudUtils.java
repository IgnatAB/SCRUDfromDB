package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CrudUtils {
    //в этом класе описаны методы для команд CRUD

    private static String INSERT_GOOD = "INSERT INTO list_of_goods (title, price) VALUES ( ?, ? )";
    private static String UPDATE_GOOD = "UPDATE list_of_goods SET price = ? WHERE id= ?";
    private static String DELETE_GOOD = "DELETE FROM list_of_goods WHERE title = ? AND id>?";

    public static List<Goods> getGoodData(String query) {
        List<Goods> goods = new ArrayList<>();

        try (Connection connection = DBUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                float price = rs.getFloat("price");

                goods.add(new Goods(id, title, price));
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return goods;
    }

    public static List<Goods> saveGoods(Goods goods) {
        List<Goods> goods1 = new ArrayList<>();
        try (Connection connection = DBUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_GOOD)) {
            preparedStatement.setString(1, goods.getTitle());
            preparedStatement.setFloat(2, goods.getPrice());
            preparedStatement.executeUpdate();

            PreparedStatement allGoods = connection.prepareStatement("SELECT * FROM list_of_goods");
            ResultSet rs = allGoods.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                float price = rs.getFloat("price");

                goods1.add(new Goods(id, title, price));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return goods1;
    }

    public static List<Goods> updateGoods(int goodId, float goodPrice) {
        List<Goods> updatedGoods = new ArrayList<>();
        try (Connection connection = DBUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_GOOD)) {
            preparedStatement.setFloat(1, goodPrice);
            preparedStatement.setInt(2, goodId);
            preparedStatement.executeUpdate();

            PreparedStatement allGoods = connection.prepareStatement("SELECT * FROM list_of_goods");
            ResultSet rs = allGoods.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                float price = rs.getFloat("price");

                updatedGoods.add(new Goods(id, title, price));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return updatedGoods;
    }

    public static void deleteGoods (int goodId, String goodTitle) {

        try (Connection connection = DBUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_GOOD)) {
            preparedStatement.setString(1, goodTitle);
            preparedStatement.setInt(2, goodId);
            preparedStatement.executeUpdate();

            PreparedStatement allGoods = connection.prepareStatement("SELECT * FROM list_of_goods");
            ResultSet rs = allGoods.executeQuery();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


}
