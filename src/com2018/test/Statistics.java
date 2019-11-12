package com2018.test;

import com2018.util.ConnectUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Statistics {
    public static void main(String[] args) throws SQLException {
        Connection connect = ConnectUtil.getConnect();
        System.out.println(connect);
        PreparedStatement statement = connect.prepareStatement("select count(*) amount,f_tablesecrecy secrecy from w_sec_dec_itemapply where to_char(f_itemdate,'yyyy') = ? group by f_tablesecrecy");
        statement.setString(1, "2017");
        ResultSet executeQuery = statement.executeQuery();
        while (executeQuery.next()) {
            int amount = executeQuery.getInt("amount");
            String secrecy = executeQuery.getString("secrecy");
            System.out.println("数量是：" + amount + "---密级是：" + secrecy);
        }
    }
}
