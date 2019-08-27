package com.sdze.sevlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdze.beans.Client;
import com.sdze.form.Form;


@WebServlet("/Serv")
public class Serv extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String vu="/WEB-INF/page.jsp";
	//private String nom="nom";
       
   
    public Serv() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher(vu).forward(request, response);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Form form = new Form();
		Client client=form.clt(request);
		
		
		request.setAttribute("form", form);
		request.setAttribute("client", client);
	
		
		this.getServletContext().getRequestDispatcher(vu).forward(request, response);
		
		
	}

}
