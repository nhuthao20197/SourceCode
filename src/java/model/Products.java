/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class Products {
      List<Product> list=new ArrayList<Product>();
    public Products(){
    
}
    public void delete(String masp){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://mssql43107-haohnps04350.jelastic.skali.net:1433;databaseName=Assignment";
            Connection con=DriverManager.getConnection(url,"sa","MFVqie51944");
            String sql="delete from Products where Code=?";
            PreparedStatement stm=con.prepareStatement(sql);
            stm.setString(1, masp);
            stm.executeUpdate();
            stm.close();
            con.close();
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public List<Product> showProduct(String tensp){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://mssql43107-haohnps04350.jelastic.skali.net:1433;databaseName=Assignment";
            Connection con=DriverManager.getConnection(url, "sa", "MFVqie51944");
            String sql="select * from Products where Name like '%"+tensp+"%'";
            Statement stm=con.createStatement();
            ResultSet rs=stm.executeQuery(sql);
          
            while(rs.next()){
                String code=rs.getString("Code");
                String name=rs.getString("Name");
                float price=rs.getFloat("Price");
                Product sp=new Product(code,name,price);
                list.add(sp);
            }
            return list;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public boolean Add(String code,String name,float price){
        try{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://mssql43107-haohnps04350.jelastic.skali.net:1433;databaseName=Assignment";
            Connection con=DriverManager.getConnection(url,"sa","MFVqie51944");
            String sql="insert into Products(Code,Name,Price) values(?,?,?)";
            PreparedStatement stm=con.prepareStatement(sql);
            stm.setString(1, code);
            stm.setString(2, name);
            stm.setFloat(3, price);
            stm.executeUpdate();
            stm.close();
            con.close();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
    public void update(String masp,String tensp,float gia){
        try{
            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://mssql43107-haohnps04350.jelastic.skali.net:1433;databaseName=Assignment";
            Connection con=DriverManager.getConnection(url,"sa","MFVqie51944");
            String sql="update Products set Name=?,Price=? where Code=?";
            PreparedStatement stm=con.prepareStatement(sql);
            stm.setString(1, tensp);
            stm.setFloat(2,gia);
            stm.setString(3, masp);
            stm.executeUpdate();
            stm.close();
            con.close();
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
    public static void main(String[] args) {
        Products sp=new Products();
        sp.update("SP009", "nokia lumia", 600000000);
    }
}
    