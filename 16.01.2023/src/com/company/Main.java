package com.company;

import javax.jws.soap.SOAPBinding;
import java.sql.*;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        //Class.forName - Вызывает все блоки static внутри приведенного класса
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.100.101:3306/test","admin", "12345");


        /////////////////
//        PreparedStatement st = conn.prepareStatement("select * from users");
//        ResultSet data = st.executeQuery();
//        while (data.next()){
//            String name =  data.getString(1);
//            String bday =  data.getString("bday");
//            int age = data.getInt("age");
//            System.out.println(name + " " + bday + " " + age);
//        }
        /////////////////

//        PreparedStatement st = conn.prepareStatement("select * from users where id > ? and age > ?");
//        st.setInt(1, 2);
//        st.setInt(2, 10);
//        ResultSet data = st.executeQuery();
//        while (data.next()){
//            String name =  data.getString(1);
//            String bday =  data.getString("bday");
//            int age = data.getInt("age");
//            System.out.println(name + " " + bday + " " + age);
//        }
        ///////////////////
        UsersRepository up = new UsersRepository(conn);
        up.getAll().stream().forEach(System.out::println);

        User u = new User();
        u.setName("Larisa");
        u.setBday("2012-01-02 10:11:12");
        u.setAge(20);
        up.addUser(u);

        System.out.println(up.avgAge("2000-02-05"));


    }



}




