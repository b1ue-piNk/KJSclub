package com.chenxin.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
	private Connection con;
//    private PreparedStatement p s t m;
    private String user = "root";
    private String password = "123456";
    private String className = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/java_login?useUnicode=true&characterEncoding=UTF-8";

    public DB() {
        try {
            Class.forName(this.className);
        } catch (ClassNotFoundException var2) {
            System.out.println("加载数据库驱动失败！");
            var2.printStackTrace();
        }

    }

    public Connection getCon() {
        try {
            this.con = DriverManager.getConnection(this.url, this.user, this.password);
        } catch (SQLException var2) {
            System.out.println("创建数据库连接失败！");
            this.con = null;
            var2.printStackTrace();
        }

        return this.con;
    }


//    public ResultSet getRs() throws SQLException {
//        return this.pstm.getResultSet();
//    }
//
//    public i n t getCount() throws SQLException {
//        return this.pstm.getUpdateCount();
//    }

    public void closed() {
//        try {
//            if (this.pstm != null) {
//                this.pstm.close();
//            }
//        } catch (SQLException var3) {
//            System.out.println("关闭p s t m对象失败！");
//            var3.printStackTrace();
//        }

        try {
            if (this.con != null) {
                this.con.close();
            }
        } catch (SQLException var2) {
            System.out.println("关闭con对象失败！");
            var2.printStackTrace();
        }
        
        this.con = null;

    }
}
