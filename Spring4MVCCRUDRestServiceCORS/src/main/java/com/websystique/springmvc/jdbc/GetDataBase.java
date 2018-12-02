package com.websystique.springmvc.jdbc;

import java.sql.*;

public class GetDataBase {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";   //JDBC �����������ݿ� URL
    static final String DB_URL = "jdbc:mysql://localhost:3306/mysql";
    // ���ݿ���û��������룬��Ҫ�����Լ�������
    static final String USER = "root";
    static final String PASS = "20180324";
    public static String  getAll(){    //�����static
        Connection conn = null;
        Statement stmt = null;
        //String [] result = new String[3];
        String  result = "";
        try{
            // ע�� JDBC ����
            Class.forName("com.mysql.jdbc.Driver");
            // ������
            System.out.println("�������ݿ�...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            // ִ�в�ѯ
            System.out.println(" ʵ����Statement����...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM `mysql` .mouyao_test order by id desc";
            ResultSet rs = stmt.executeQuery(sql);    
            // չ����������ݿ�   
	            while(rs.next()){
	                // ͨ���ֶμ���
	                String id  = rs.getString("id");
	                String name = rs.getString("name");
	                String age = rs.getString("age");   
	                // �������
	                System.out.print("ID: " + id);
	                System.out.print(", վ������: " + name);  
	                System.out.print("\n");
	                //infoOfPerson.push(id+","+name+","+age);     
	                result+=id+","+name+","+age;
	               }                               
            // ��ɺ�ر�
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            // ���� JDBC ����
            se.printStackTrace();
        }catch(Exception e){
            // ���� Class.forName ����
            e.printStackTrace();
        }finally{
            // �ر���Դ
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }// ʲô������
            try{
                if(conn!=null) conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        return result;
    }
   /* public static void main(String[] args){
      String data=GetDataBase.getAll(); //Ϊʲô�����ǿ��Ի�ȡ�����ݵģ������Ǳ߲������أ��Ƿ�Ҳ�����첽�����⣿
      System.out.println("��ȡ�����ݿ����ݣ�����"+data);     
    } */
}









