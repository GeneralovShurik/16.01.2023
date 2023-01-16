package com.company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsersRepository {
    private Connection conn;

    public UsersRepository(Connection conn){
        this.conn = conn;
    }

    public ArrayList<User> getAll() throws SQLException {
        PreparedStatement st = conn.prepareStatement("select * from users");
        ResultSet data = st.executeQuery();
        ArrayList<User> users = new ArrayList<>();
        while (data.next()){
            User user = new User();
            user.setAge(data.getInt("age"));
            user.setBday(data.getString("bday"));
            user.setAge(data.getInt("id"));
            user.setName(data.getString("name"));
            users.add(user);
        }
        return users;
    }

    public void addUser(User user) throws SQLException {
        PreparedStatement st = conn.prepareStatement("insert into users(age, name, bday) values(?,?,?)"
        );
        st.setInt(1, user.getAge());
        st.setString(2,user.getName());
        st.setString(3,user.getBday());
        st.execute();

    }

    public float avgAge(String date) throws SQLException {
        PreparedStatement st = conn.prepareStatement("select avgAge(?) as avg_age");
        st.setString(1, date);
        ResultSet data = st.executeQuery();
        // для перехода к первой строке
        data.next();

        return data.getFloat("avg_age");
    }

}
