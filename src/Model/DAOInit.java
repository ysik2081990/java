/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Entity.Employee;
import Interfase.IDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOInit implements IDAO{ //подключение к базе и связь с интерфейсом
    Connection connection= null;
    Statement stmt = null;
    public void connection(){
        try{
            Class.forName("org.postgresql.Driver");
            try{
                connection = DriverManager.getConnection("jdbc:postgresql://localhost:5433/ClothingService","postgres", "555555");
                
            } catch (SQLException ex){
                System.out.println(ex);
            }
        } catch (ClassNotFoundException ex){
            Logger.getLogger(DAOInit.class.getName()).log(Level.SEVERE, null,ex);
        }
    }
    
    public void getDate(){
        try {
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM nameofsubject;" );
            while ( rs.next() ) {
                int id = rs.getInt("id");
                int countitems = rs.getInt("countitems");
                int periodwears = rs.getInt("periodwears");
                String  nameofsubject = rs.getString("nameofsubject");
                //String sname  = rs.getString("secondname");
                System.out.println( "ID = " + id + " countitems = " + countitems 
                        + " periodwears = " + periodwears 
                        + " nameofsubject = " + nameofsubject);
            }
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAOInit.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Employee> getEmployees() {
        List<Employee> employees = new ArrayList<>();
        
        try {
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM employees;" );
            while ( rs.next() ) {
                int id = rs.getInt("id");
                String surname = rs.getString("surname");
                String forename = rs.getString("forename");
                String middlename = rs.getString("middlename");
                String title = rs.getString("title");
                Date birthDate = rs.getDate("birthDate");

                Employee employee = new Employee(surname, forename, middlename, title, (java.sql.Date) birthDate);
                employees.add(employee);
            }
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAOInit.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return employees;
    }
}
