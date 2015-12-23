package View;

import Entity.Employee;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AddForm extends Stage {

    private StringProperty firstName = new SimpleStringProperty();
    private StringProperty surName = new SimpleStringProperty();
    private StringProperty middleName = new SimpleStringProperty();
    private StringProperty titleName = new SimpleStringProperty();
    private StringProperty birthDatePerson = new SimpleStringProperty();
    private BooleanProperty isResult = new SimpleBooleanProperty(false);

    private Employee newEmployee = null;
    private TextField fistNameTextField = null;
    private TextField surNameTextField = null;
    private TextField middleTextField = null;
    private TextField titleTextField = null;
    private DatePicker birthDatePicker = null;

    public AddForm() {
        Employee employee = new Employee();

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text scenetitle = new Text("Добавление/редактирование сотрудника");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label surname = new Label("Фамилия:");
        grid.add(surname, 0, 1);

        Label fistName = new Label("Имя:");
        grid.add(fistName, 0, 2);

        Label middlename = new Label("Отчество:");
        grid.add(middlename, 0, 3);

        Label title = new Label("Звание:");
        grid.add(title, 0, 4);

        Label birthDate = new Label("Дата рождения:");
        grid.add(birthDate, 0, 5);

        fistNameTextField = new TextField();
        grid.add(fistNameTextField, 1, 1);

        surNameTextField = new TextField();
        grid.add(surNameTextField, 1, 2);

        middleTextField = new TextField();
        grid.add(middleTextField, 1, 3);

        titleTextField = new TextField();
        grid.add(titleTextField, 1, 4);

        birthDatePicker = new DatePicker();
        grid.add(birthDatePicker, 1, 5);

        Button btn = new Button("Добавить");
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {              
                newEmployee = new Employee(surNameTextField.getText(), 
                                            fistNameTextField.getText(), 
                                            middleTextField.getText(), 
                                            titleTextField.getText(), 
                                            null);
                getIsResult().set(true);
                
            }
        });
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 6);

        HBox hbox = new HBox();
        hbox.getChildren().add(grid);
        this.setTitle("Добавление/редактирование сотрудника");
        this.setScene(new Scene(hbox, 450, 300));
        this.show();
    }

    AddForm(Employee employee) {
        this();//вызов конструктора по умолчанию
        fistNameTextField.setText(employee.getSurname());
        surNameTextField.setText(employee.getForename());
        middleTextField.setText(employee.getMiddlename());
        titleTextField.setText(employee.getTitle());
        //birthDatePicker.setValue(birthDatePicker.getConverter().fromString(employee.getBirthDate().toString()));
        //birthDatePicker.setValue(LocalDate.parse(employee.getBirthDate().toString(), DateTimeFormatter.ofPattern("yyyy/MM/dd")));
        birthDatePicker.setValue(null);//todo:"Это костыль", необходимо дописать
        
    }   

    /**
     * @return the firstName
     */
    public StringProperty getFirstName() {
        return firstName;
    }

    /**
     * @return the surName
     */
    public StringProperty getSurName() {
        return surName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(StringProperty firstName) {
        this.firstName = firstName;
    }

    /**
     * @param surName the surName to set
     */
    public void setSurName(StringProperty surName) {
        this.surName = surName;
    }

    /**
     * @return the middleName
     */
    public StringProperty getMiddleName() {
        return middleName;
    }

    /**
     * @param middleName the middleName to set
     */
    public void setMiddleName(StringProperty middleName) {
        this.middleName = middleName;
    }

    /**
     * @return the titleName
     */
    public StringProperty getTitleName() {
        return titleName;
    }

    /**
     * @param titleName the titleName to set
     */
    public void setTitleName(StringProperty titleName) {
        this.titleName = titleName;
    }

    /**
     * @return the birthDatePerson
     */
    public StringProperty getBirthDatePerson() {
        return birthDatePerson;
    }

    /**
     * @param birthDatePerson the birthDatePerson to set
     */
    public void setBirthDatePerson(StringProperty birthDatePerson) {
        this.birthDatePerson = birthDatePerson;
    }

    /**
     * @return the isResult
     */
    public BooleanProperty getIsResult() {
        return isResult;
    }

    /**
     * @return the newEmployee
     */
    public Employee getNewEmployee() {
        isResult.set(false);
        return newEmployee;
    }

}
