/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Dont1
 */

public class ShoppingListServlet extends HttpServlet {
    
    ArrayList itemList = new ArrayList();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");

        if (username == null || username.equals("")) {
            
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp")
                    .forward(request, response);
        } else {
            
        if (request.getParameter("action").equals("logout")) {
                session.invalidate();
                getServletContext().getRequestDispatcher("/WEB-INF/register.jsp")
                        .forward(request, response);
            }
        
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp")
                    .forward(request, response);
        }

    }
    
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NullPointerException {
        
            HttpSession session = request.getSession();
            String action = request.getParameter("action");
            
   
        if (action.equals("add")) {
            String item = request.getParameter("item");
            itemList.add(item);
            session.setAttribute("itemList", itemList); 
        } else if (action.equals("delete")) {
            String item = request.getParameter("item");
            ArrayList list = (ArrayList) session.getAttribute("itemList");  
            list.remove(item); 
            session.setAttribute("itemList", list); 
        }

        getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp")
                    .forward(request, response);

    }
    
}
