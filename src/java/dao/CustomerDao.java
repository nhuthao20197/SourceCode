/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import entity.Customers;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author admin
 */
public class CustomerDao {
    public static List<Customers> LayDanhSachKhachHang(String name){
        Session session=HibernateUtil.getSessionFactory().getCurrentSession();
        try{
            session.beginTransaction();
            String sql="from Customers where hoten like '%"+name+"%'";
            Query cs=session.createQuery(sql);
            List<Customers> cs1=cs.list();
            return cs1;
            
            
            
        }catch(Exception e){
            e.printStackTrace();
            return null;
            
        }
        
    }
    public static Customers LayThongTinKH(String username){
        Session session=HibernateUtil.getSessionFactory().openSession();
        try{
          session.beginTransaction();
          Customers cs=(Customers) session.get(Customers.class, username);
          return cs;
            
        }catch(Exception e){
           return null;
        }finally{
            session.close();
        }
       
    }
    
    public static boolean Xoa(String username){
         Session session=HibernateUtil.getSessionFactory().getCurrentSession();
        try{
            
          Customers sp=CustomerDao.LayThongTinKH(username);
          if(sp==null)
          return false;
          session.beginTransaction();
          session.delete(sp);
          session.getTransaction().commit();
          return true;
         
        }catch(Exception e){
            session.getTransaction().rollback();
            System.out.println(e);
            return false;
        }
        
    }
    public static boolean Them(Customers name ){
        Session session=HibernateUtil.getSessionFactory().getCurrentSession();
        try{
//          name=CustomerDao.LayThongTinKH(name.getUsername());
//          if(name!=null)
//          return false;
          session.beginTransaction();
          session.save(name);
          session.getTransaction().commit();
          return true;
        }catch(Exception e){
            session.getTransaction().rollback();
            System.out.println(e);
            return false;
        }
    }
    public static boolean sua(Customers name){
        Session session=HibernateUtil.getSessionFactory().getCurrentSession();
        try{
//          name=CustomerDao.LayThongTinKH(name.getUsername());
//          if(name!=null)
//          return false;
          session.beginTransaction();
          session.update(name);
          session.getTransaction().commit();
          return true;
        }catch(Exception e){
            session.getTransaction().rollback();
            System.out.println(e);
            return false;
        }
    }
    
    public static void main(String[] args) {
       Customers a=new Customers("phuoc", "123666", "nguyen van phuoc", true, "giciungdc@gmail.com", false);
        System.out.println("dao.CustomerDao.main()"+CustomerDao.sua(a));
        
    }
}
    
    
    
    

