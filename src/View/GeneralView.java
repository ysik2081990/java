/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Entity.Employee;
import Interfase.IView;
import java.util.List;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.layout.StackPane;

/**
 *
 * @author Константин
 */
public class GeneralView extends StackPane implements IView{
    Employee newEmployee = null;
    List<Employee> employees = null;
    
    EmployeesTab tabPane = new EmployeesTab(employees);
    
    public GeneralView(List<Employee> _employees) {
        List nodes = this.getChildren();
        nodes.add(tabPane);
        tabPane.getNewEmployeeFlag().addListener(new ChangeListener<Boolean>() {

            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (newValue)
                tabPane.getNewEmployee();//отсутствует метод
            }
        });
    
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
