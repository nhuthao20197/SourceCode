/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.CustomerDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Customer;
import entity.Customers;
import model.Products;

/**
 *
 * @author admin
 */
public class ControllerCustomers extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter(); 
        try{
            String action=request.getParameter("action");
            if(action.equals("Login")){
                String user=request.getParameter("txtUser");
                String pass=request.getParameter("txtPass");
                Customer cus=new Customer();
                boolean exist=cus.checkLogin(user, pass);
                String url="error.jsp";
                if(exist){
                    url="index.jsp";
                    HttpSession sesson=request.getSession(true);
                    sesson.setAttribute("USER",user);
                }
                RequestDispatcher rd=request.getRequestDispatcher(url);
                rd.forward(request, response);

            }else if(action.equals("Search")){
                String name=request.getParameter("txtname");
                List<Customers> list=CustomerDao.LayDanhSachKhachHang(name);
                request.setAttribute("listKH", list);
                String url="CustomerDAO.jsp";
                RequestDispatcher rd=request.getRequestDispatcher(url);
                rd.forward(request, response);
            }else if(action.equals("Delete")){
                String name=request.getParameter("txtCode");
                boolean delete=CustomerDao.Xoa(name);
                if(delete){
                  String url="CustomerDAO.jsp";
                  RequestDispatcher rd=request.getRequestDispatcher(url);
                  rd.forward(request, response);
                }
              
            }else if(action.equals("Insert")){
                String username=request.getParameter("txtUsername");
                String pass=request.getParameter("txtPassword");
                String ten=request.getParameter("txtHoten");      
                String gioitinh=request.getParameter("txtGioitinh");
                String mail=request.getParameter("txtGmail");
                String role=request.getParameter("txtRole");
                boolean gt=false;
                if(gioitinh.equals("nam")){
                    gt=true;
                }
                
                Customers cus=new Customers(username, pass, ten,gt , pass,false );
                
                 boolean them=CustomerDao.Them(cus);
                 if(them){
                  String url="CustomerDAO.jsp";
                  RequestDispatcher rd=request.getRequestDispatcher(url);
                  rd.forward(request, response);
                }
                
                
            }else if(action.equals("Add")){
                String url="insertCustomer.jsp";
                RequestDispatcher rd=request.getRequestDispatcher(url);
                rd.forward(request, response);}
             else if(action.equals("Edit")){
                String username=request.getParameter("txtUsername");
                String pass=request.getParameter("txtPassword");
                String ten=request.getParameter("txtHoten");
                String gioitinh=request.getParameter("txtGioitinh");
                String mail=request.getParameter("txtEmail");
                String role=request.getParameter("txtRole");
                boolean gt=false;
                if(gioitinh.equals("nam")){
                    gt=true;
                }
                boolean role1=false;
                if(gioitinh.equals("true")){
                    role1=true;
                }
                Customers sp=new Customers(username, pass, ten, gt, mail, role1);
                request.setAttribute("Cus",sp);
                String url="editCustomer.jsp";
                RequestDispatcher rd=request.getRequestDispatcher(url);
                rd.forward(request, response);
            }
            else if(action.equals("Update")){
                try{
               String username=request.getParameter("txtUsername");
                String pass=request.getParameter("txtPassword");
                String ten=request.getParameter("txtHoten");
                String gioitinh=request.getParameter("txtGioitinh");
                String mail=request.getParameter("txtEmail");
                String role=request.getParameter("txtRole");
                 boolean gt=false;
                if(gioitinh.equals("nam")){
                    gt=true;
                }
                boolean role1=false;
                if(gioitinh.equals("true")){
                    role1=true;
                }
               Customers sp=new Customers(username, pass, ten, gt, mail, role1);
                
               boolean sua=CustomerDao.sua(sp);
               if(sua){
                String url="CustomerDAO.jsp";
                RequestDispatcher rd=request.getRequestDispatcher(url);
                rd.forward(request, response);
               }
                }catch(Exception e){
                e.printStackTrace();
                }
            }
            
            
        }catch(Exception e ){
            e.printStackTrace();
        }
            
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}

