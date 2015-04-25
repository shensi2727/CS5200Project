package com.hnkj.hm.dao;
import java.util.List;

import com.hnkj.hm.db.ConnectionClass;
import com.hnkj.hm.db.DBConnection;
import com.hnkj.hm.vo.UserVO;

import java.sql.*;
import java.util.*;

public class PersonDAO {
	private Connection connection;
	
	public PersonDAO() {
        ConnectionClass con = new ConnectionClass();
        try {
            connection = con.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	public void addPerson(UserVO t_userVO) {
     /*   try {
            String query = "insert into person(name, phone, profession) values ('" + person.getName() + "', '" + person.getPhone() + "', '" + person.getProfession() + "')";
 
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        */
    }
 
    public void removePerson(int personid) {
        String query = "delete from t_user where person.idperson = " + personid + " ";
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
 
    public void updatePerson(UserVO t_userVO) {
    	
     //   String query = "update t_user set t_user.user_name='" + person.getName() + "', person.phone='" + person.getPhone()
     //           + "', person.profession='" + person.getProfession() + "' where person.idperson = " + person.getPersonId() + " ";
    //    System.out.println(query);
        try {
            Statement stmt = connection.createStatement();
    //        stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
 
    public ArrayList<UserVO> getPersons() throws SQLException {
        String query = "select * from t_user";
        ArrayList<UserVO> persons = new ArrayList<UserVO>();
        Statement stmt = connection.createStatement();
        ResultSet res = stmt.executeQuery(query);
        while (res.next()) {
        	UserVO person = new UserVO();
            person.setUserName(res.getString("user_name"));
            person.setMobile(res.getString("user_mobile"));
            person.setAddress(res.getString("user_address"));
            person.setBirthday(res.getString("user_birthday"));
            person.setUserId(res.getString("user_id"));
            persons.add(person);
        }
        return persons;
    }
 
    public UserVO getPersonById(int personid) throws SQLException {
    	UserVO person = new UserVO();
        String query = "select * from t_user where person.user_id = " + personid + " ";
        Statement stmt = connection.createStatement();
        ResultSet res = stmt.executeQuery(query);
        if (res.next()) {
            person.setUserName(res.getString("user_name"));
            person.setMobile(res.getString("user_mobile"));
            person.setAddress(res.getString("user_address"));
            person.setBirthday(res.getString("user_birthday"));
            person.setUserId(res.getString("user_id"));
        }
        return person;
    }
}
	

