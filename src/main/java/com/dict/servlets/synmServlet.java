package com.dict.servlets;
import java.sql.*;
import com.disc.jdbc.SynmDBConnection;
//import com.disc.*;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author HP
 */
@WebServlet(name = "synmServlet", urlPatterns = "/synmServlet")
//@WebServlet(value ="/synmServlet")
//public class synmServlet extends HttpServlet {
//    
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {    
//        
//         System.out.println("inside the servlet");
//         
//        
//        try {
//            
//            PrintWriter pw = response.getWriter();
//            pw.println("<html><body>");  
//pw.println("Welcome to servlet");  
//pw.println("</body></html>");
//            
//            
//            
//        } catch (Exception ex) {
//            Logger.getLogger(synmServlet.class.getName()).log(Level.SEVERE, null, ex);
//        }}}
//    


public class synmServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {    
        
         System.out.println("inside the servlet");
         ArrayList<Thesu> map = new ArrayList<Thesu>();
         String searchedWord = request.getParameter("synonym");
         //System.out.println("Searched Keyword: "+searchedWord);
        
        try {
            Connection conn = SynmDBConnection.getConnection();
            map = getData(conn, request, response, searchedWord);
            Gson gson = new Gson();
            String result = gson.toJson(map);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            System.out.println("result:"+result);
            response.getWriter().write(result);
            
            
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(synmServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(synmServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {    
        
         //System.out.println("inside the servlet");
         ArrayList<Thesu> map = new ArrayList<>();
         String searchedWord = request.getParameter("synonym");
         //System.out.println("Searched Keyword: "+searchedWord);
        
        try {
            Connection conn = SynmDBConnection.getConnection();
            map = getData(conn, request, response, searchedWord);
            Gson gson = new Gson();
            String result = gson.toJson(map);
           response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
           // System.out.println("result:"+result);
            response.getWriter().write(result);
            //PrintWriter o = response.getWriter();
            //o.println(response.);
            
            
            
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(synmServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(synmServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void write(HttpServletResponse response, ArrayList<Thesu> map) throws IOException{
        response.setContentType(MediaType.APPLICATION_JSON);
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(new Gson().toJson(map));
    }
    
    
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

    private ArrayList getData(Connection conn, HttpServletRequest request, HttpServletResponse response, String searchedWord) throws SQLException, Exception {        
        ArrayList messageData = new ArrayList();
        
        String selectSQL = "select synonym from synonyms where word_id = (select word_id from synonyms where synonym = ?);";
        PreparedStatement preparedStatement = conn.prepareStatement(selectSQL);
        preparedStatement.setString(1, searchedWord);
        ResultSet rs = preparedStatement.executeQuery();
        
        
        
        
        while (rs.next()) {
            Thesu snm = new Thesu();
            snm.setSynonym(rs.getString("synonym"));
            messageData.add(snm);
            //PrintWriter out = response.getWriter();
            //out.println(rs.getString("synonym"));
        }
//        PrintWriter o = response.getWriter();
//        o.println(messageData);

          return messageData;
        
        
    }
}
                    