package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CrudUtils {

    public static List<Goods> getStudentData(String query) {
        List<Goods> goods = new ArrayList<>();

        try (Connection connection = DBUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()){
                int id = rs.getInt("id");
                String title = rs.getString("title");
                float price = rs.getFloat("price");

                goods.add(new Goods(id,title, price));
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return goods;
    }
}
