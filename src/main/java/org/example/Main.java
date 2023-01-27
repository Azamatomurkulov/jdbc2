package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private final String URL = "jdbc:postgresql://localhost:5432/restaurant";
    private final String USER = "postgres";
    private final String PASSWORD = "postgres";
    public Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;

    }


    public List<cafe_orders> getOrders() {
        String SQL = "select cafe.name_of_cafe,dishes.name_of_dish,dishes.price\n" +
                "from orders\n" +
                "join cafe on cafe.id = orders.id_of_cafe\n" +
                "join dishes on dishes.id = orders.id_of_dish\n";
        List<cafe_orders> cafe_orders = new ArrayList<>();

        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(SQL);

             ResultSet rs = stmt.executeQuery())
        {       while(rs.next()) {
            String name_of_cafe = rs.getString(1);
            String name_of_dish = rs.getString(2);
            int prices = rs.getInt(3);
            cafe_orders.add(new cafe_orders(name_of_cafe, name_of_dish, prices));
        }
        }
        catch (SQLException ex)
        {        System.out.println(ex.getMessage());    }
        return cafe_orders;
    }


    public void getPrices() {
        String SQL = "select name_of_dish, price\n" +
                "from dishes\n" +
                "order by price;";

        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL))
        {       while (rs.next()){
            System.out.print(rs.getString(1)+" ");
            System.out.println(rs.getInt(2));
               } }
        catch (SQLException ex)
        {        System.out.println(ex.getMessage());    }

    }
    public void famousDishes() {
        String SQL = "select dishes.name_of_dish, count(orders.id_of_dish)\n" +
                "from orders\n" +
                "join dishes on dishes.id = orders.id_of_dish\n" +
                "group by name_of_dish\n" +
                "order by count(orders.id_of_dish) desc;";

        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL))
        {      while(rs.next()){
            System.out.print(rs.getString(1)+" - ");
            System.out.println(rs.getInt(2));
              } }
        catch (SQLException ex)
        {        System.out.println(ex.getMessage());    }

    }

    public void notOrderedDishes() {
        String SQL = "select * from dishes where dishes.id not in (select id_of_dish from orders);";

        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL))
        {      while (rs.next()) {
            System.out.print(rs.getString(2)+" ");
            System.out.println(rs.getInt(3));
        }

               }
        catch (SQLException ex)
        {        System.out.println(ex.getMessage());    }

    }
    public static void main(String[] args) {

        Main main = new Main();
        List<cafe_orders> orderList = main.getOrders();

        for(int i=0; i<orderList.size();i++){
            System.out.println(orderList.get(i).getName_of_cafe()+" - "+orderList.get(i).getName_of_dish()
                    +" - "+orderList.get(i).getPrice());
        }
        System.out.println("Сортировка блюд по ценам: ");
        main.getPrices();
        System.out.println("Самые популярные блюда: ");
        main.famousDishes();
        System.out.println("Блюда которых нету в заказах: ");
        main.notOrderedDishes();



    }
}