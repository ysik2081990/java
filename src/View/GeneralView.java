/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Entity.Employee;
import Interfase.IView;
import java.util.List;
import javafx.scene.layout.StackPane;

/**
 *
 * @author Константин
 */
public class GeneralView extends StackPane implements IView{
    List<Employee> employees = null;
    public GeneralView(List<Employee> _employees) {
        List nodes = this.getChildren();
        EmployeesTab tabPane = new EmployeesTab(_employees);
        nodes.add(tabPane);
    }
    
    public GeneralView(){
        
    }
    
    public void showDate(){
        List nodes = this.getChildren();
        EmployeesTab tabPane = new EmployeesTab(employees);
        nodes.add(tabPane);
    }

    @Override
    public void setEmployee(List<Employee> _employees) {
        employees = _employees;
        showDate();
    }

   
}
