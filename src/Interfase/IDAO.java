/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfase;

import Entity.Employee;
import java.util.List;

public interface IDAO {
    void connection();
    void getDate();
    List<Employee> getEmployees();//get all employees
}
