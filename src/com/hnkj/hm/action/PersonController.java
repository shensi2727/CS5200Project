package com.hnkj.hm.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hnkj.hm.dao.PersonDAO;
import com.hnkj.hm.vo.UserVO;

/**
*

*/
@WebServlet(name = "PersonController", urlPatterns = {"/PersonController"})
public class PersonController extends HttpServlet {

   private static final long serialVersionUID = 1L;
   private static String insert_or_edit = "/Person.jsp";
   private static String list_person = "/ListPerson.jsp";
   private PersonDAO persondao;

   public PersonController() {
       super();
       persondao = new PersonDAO();
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String forward = "";
       String action = request.getParameter("action");
       if (action.equalsIgnoreCase("delete")) {
			// the other page is sending the person id, so we can get here and
           // call the remove method
           int personid = Integer.parseInt(request.getParameter("personId"));
           // we remove the person from the database
           persondao.removePerson(personid);
			// set the forward string to list and put all persons in request
           // attribute so we can use them inside the other page
           forward = list_person;
           try {
               request.setAttribute("persons", persondao.getPersons());
           } catch (SQLException e) {
               e.printStackTrace();
           }
           // if the user is trying to edit a person
       } else if (action.equalsIgnoreCase("edit")) {

           forward = insert_or_edit;
           int personid = Integer.parseInt(request.getParameter("personId"));
           try {
               UserVO person = persondao.getPersonById(personid);
               request.setAttribute("person", person);
           } catch (SQLException e) {
               e.printStackTrace();
           }

       } else if (action.equalsIgnoreCase("listPerson")) {
           forward = list_person;
           try {
               request.setAttribute("persons", persondao.getPersons());
           } catch (SQLException e) {
               e.printStackTrace();
           }
       } else {
           forward = insert_or_edit;
       }
       RequestDispatcher view = request.getRequestDispatcher(forward);
       view.forward(request, response);
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       UserVO person = new UserVO();

       person.setUserName(request.getParameter("user_name"));
       person.setMobile(request.getParameter("user_mobile"));
       person.setAddress(request.getParameter("user_address"));
       person.setBirthday(request.getParameter("user_birthday"));
       person.setUserId(request.getParameter("user_id"));
        System.out.println("ola");
       System.out.println(request.getParameter("user_id"));
		// what i'm trying to mean here is: if the personid coming from the
       // request is null
       // then, the user is trying to add someone, otherwise, he's trying to
       // update someone
       if (request.getParameter("user_id") == null || request.getParameter("user_id").isEmpty()) {
           persondao.addPerson(person);
       } else {
           person.setUserId(request.getParameter("user_id"));
           persondao.updatePerson(person);
       }

       response.sendRedirect(request.getContextPath() + "/index.jsp");
   }

}