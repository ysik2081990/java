/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Entity.Employee;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author Константин
 */
public class EmployeesTable extends TableView<Employee>{
    ObservableList<Employee> employees = null;
    public EmployeesTable(List<Employee> _employees){
       if (_employees != null){
                employees = FXCollections.observableArrayList (_employees);
       }
        this.setEditable(true);
        TableColumn firstNameCol = new TableColumn("Фамилия");
        firstNameCol.setCellValueFactory(
                new PropertyValueFactory<Employee, String>("surname"));
        TableColumn lastNameCol = new TableColumn("Имя");
        lastNameCol.setCellValueFactory(
                new PropertyValueFactory<Employee, String>("forename"));
        TableColumn middleNameCol = new TableColumn("Отчество");
        middleNameCol.setCellValueFactory(
                new PropertyValueFactory<Employee, String>("middlename"));
        TableColumn titleNameCol = new TableColumn("Звание");
        titleNameCol.setCellValueFactory(
                new PropertyValueFactory<Employee, String>("title"));
        TableColumn birthDateNameCol = new TableColumn("Дата рождения");
        birthDateNameCol.setCellValueFactory(
                new PropertyValueFactory<Employee, String>("birthDate"));

        this.getColumns().addAll(firstNameCol, lastNameCol, middleNameCol, titleNameCol, birthDateNameCol);
        
        this.setItems(employees);
        
        
    }
    
    public void addEmployee(Employee _employee){
        employees.add(_employee);
    }
}
