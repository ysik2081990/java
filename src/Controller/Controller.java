/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Employee;
import Interfase.IDAO;
import Interfase.IView;
import Model.DAOInit;
import java.util.ArrayList;

public class Controller {
    IView view; //вид view
    IDAO dao; // интерф. база

    /**
     * Конструктор контроллера
     * @param _view интерфейс вьюхи
     */
    public Controller(IView _view){
        view = _view;
        dao = new DAOInit();
        dao.connection();
        view.setEmployee(dao.getEmployees()); 
        
    }
}
