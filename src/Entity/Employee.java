/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.sql.Date;

/**
 *
 * @author Константин
 */
public class Employee {
    private String surname;
    private String forename;
    private String middlename;
    private String title;
    private Date birthDate;
    //отчество
    public Employee(){} //constructor по умолчанию
    public Employee(String _surname, String _forename, String _middlename, String _title, Date _birthDate){
        surname = _surname;
        forename = _forename;
        middlename = _middlename;
        title = _title;
        birthDate = _birthDate;
    }
    
    /*todo: дописать конструктор
        дописать гетеры
    **/
    
    @Override
    public String toString(){
        return this.getSurname() + "\n" + this.getForename() + "\n" + this.getMiddlename() + "\n" + this.getTitle() + "\n" + this.getBirthDate(); 
    }

    /**
     * @return the surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * @param surname the surname to set
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * @return the forename
     */
    public String getForename() {
        return forename;
    }

    /**
     * @param forename the forename to set
     */
    public void setForename(String forename) {
        this.forename = forename;
    }

    /**
     * @return the middlename
     */
    public String getMiddlename() {
        return middlename;
    }

    /**
     * @param middlename the middlename to set
     */
    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the birthDate
     */
    public Date getBirthDate() {
        return birthDate;
    }

    /**
     * @param birthDate the birthDate to set
     */
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
