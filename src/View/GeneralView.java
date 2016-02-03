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
 * Главный класс view. Содержит в себе EmployeesTab
 * @author konstantin
 */
public class GeneralView extends StackPane implements IView{
    Employee newEmployee = null;
    List<Employee> employees = null;
    
    EmployeesTab tabPane = new EmployeesTab(employees);
    
    /**
     * Конструктор с параметром.
     * @param _employees список сотрудников
     */
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
    
    /**
     * конструктоор по-умолчанию
     */
    public GeneralView(){
        
    }
    
    /**
     * метод, посылающий EmployeesTab список сотрудников для отображения
     */
    public void showDate(){
        List nodes = this.getChildren();
        EmployeesTab tabPane = new EmployeesTab(employees);
        nodes.add(tabPane);
    }
    
    /**
     * Метод, принимающий список сотрудников с контроллера
     * @param _employees 
     */
    @Override
    public void setEmployee(List<Employee> _employees) {
        employees = _employees;
        showDate();
    }

   
}
