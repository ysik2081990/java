/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Entity.Employee;
import java.sql.Date;
import java.util.List;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.HBox;

/**
 *
 * @author Константин
 */
public class EmployeesTab extends TabPane {
    AddForm addForm = null;
    AddForm editForm = null;
    String fistname = "";
    String surname = "";
    String middlename = "";
    String title = "";
    Date birthDate = null;
    EmployeesTable employeesTable = null;
    Employee newEmployee = null;
    ControlPanel controlPanel = null;

    public EmployeesTab(List<Employee> _employees) {

        Tab tab = new Tab();
        tab.setClosable(false);
        tab.setText("Сотрудники");
        HBox hbox = new HBox();

        employeesTable = new EmployeesTable(_employees);

        hbox.getChildren().add(employeesTable);
        hbox.setAlignment(Pos.CENTER_LEFT);
        tab.setContent(hbox);
        this.getTabs().add(tab);

        controlPanel = new ControlPanel();

        controlPanel.getStatusControl().addListener(new ChangeListener<String>() {

            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue.equalsIgnoreCase("ChangePlus")) {
                    addForm = new AddForm();
                    addForm.getIsResult().addListener(new ChangeListener<Boolean>() {

                        @Override
                        public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                            if(newValue){
                                newEmployee = addForm.getNewEmployee();
                                employeesTable.addEmployee(newEmployee);
                                newEmployee = null;
                            }
                        }
                    });
                    
                    addForm.show();
                    controlPanel.resetStatus();
                } else if (newValue.equalsIgnoreCase("ChangePan")) {
                    Employee employee = employeesTable.getSelectionModel().getSelectedItem();
                    System.out.println(employee);
                    controlPanel.resetStatus();
                    editForm = new AddForm(employee);
                    newEmployee = editForm.getNewEmployee();
                    employeesTable.addEmployee(newEmployee);
                    //newEmployee = null;

                } else if (newValue.equalsIgnoreCase("ChangeDef")) {
                    controlPanel.resetStatus();
                }

            }
        });

        //controlPanel.setStatusControl("e"); стартовое
        //List<Boolean> list = new ArrayList<Boolean>();
        //ObservableList<Boolean> observableList = FXCollections.observableList(list);
        hbox.getChildren().add(controlPanel);

    }
}
