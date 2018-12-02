package com.websystique.springmvc.jdbc;

import java.sql.*;

public class GetDataBase {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";   //JDBC 驱动名及数据库 URL
    static final String DB_URL = "jdbc:mysql://localhost:3306/mysql";
    // 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "root";
    static final String PASS = "20180324";
    public static String  getAll(){    //这里的static
        Connection conn = null;
        Statement stmt = null;
        //String [] result = new String[3];
        String  result = "";
        try{
            // 注册 JDBC 驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 打开链接
            System.out.println("连接数据库...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            // 执行查询
            System.out.println(" 实例化Statement对象...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM `mysql` .mouyao_test order by id desc";
            ResultSet rs = stmt.executeQuery(sql);    
            // 展开结果集数据库   
	            while(rs.next()){
	                // 通过字段检索
	                String id  = rs.getString("id");
	                String name = rs.getString("name");
	                String age = rs.getString("age");   
	                // 输出数据
	                System.out.print("ID: " + id);
	                System.out.print(", 站点名称: " + name);  
	                System.out.print("\n");
	                //infoOfPerson.push(id+","+name+","+age);     
	                result+=id+","+name+","+age;
	               }                               
            // 完成后关闭
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            // 处理 JDBC 错误
            se.printStackTrace();
        }catch(Exception e){
            // 处理 Class.forName 错误
            e.printStackTrace();
        }finally{
            // 关闭资源
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }// 什么都不做
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        return result;
    }
   /* public static void main(String[] args){
      String data=GetDataBase.getAll(); //为什么这里是可以获取到数据的，但是那边不可以呢？是否也存在异步的问题？
      System.out.println("获取的数据库数据：——"+data);     
    } */
}









