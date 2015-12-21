/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.io.File;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

/**
 *
 * @author Константин
 */
public class ControlPanel extends FlowPane {
    private StringProperty statusControl = new SimpleStringProperty();
    
    public ControlPanel() {
        ImageView[] masImageView = new ImageView[3];
        VBox vboxControlPanel = new VBox();
        this.getChildren().add(vboxControlPanel);
        this.setPadding(new Insets(5, 0, 5, 0));
        this.setVgap(4);
        this.setHgap(4);
        this.setPrefWrapLength(170); 
        this.setStyle("-fx-background-color: DAE6F3;");

        File file = new File("src\\View\\img\\img1.png");
        Image image = new Image(file.toURI().toString());
        ImageView difImageView = new ImageView();
        difImageView.setImage(image);
        vboxControlPanel.getChildren().add(difImageView);
        difImageView.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                setStatusControl("ChangeDef");
            }
        });

        file = new File("src\\View\\img\\img2.png");
        image = new Image(file.toURI().toString());
        ImageView plusImageView = new ImageView();
        plusImageView.setImage(image);
        vboxControlPanel.getChildren().add(plusImageView);
        plusImageView.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                setStatusControl("ChangePlus");
                
            }
        });

        file = new File("src\\View\\img\\img3.png");
        image = new Image(file.toURI().toString());
        ImageView panImageView = new ImageView();
        panImageView.setImage(image);
        vboxControlPanel.getChildren().add(panImageView);
        panImageView.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                setStatusControl("ChangePan");
            }
        });
    }
    public StringProperty getStatusControl()
    {
        return statusControl;
    }
    
     public void setStatusControl(String _value)
     {
         statusControl.set(_value); //новое
     }
}
