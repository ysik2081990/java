/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package military_base_fx;

import Controller.Controller;
import Interfase.IView;
import View.GeneralView;
import View.View;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Константин
 */
public class Military_Base_FX extends Application {
    
    @Override
    public void start(Stage primaryStage) {
//        Button btn = new Button();
//        btn.setText("Say 'Hello World'");
//        btn.setOnAction(new EventHandler<ActionEvent>() {
//            
//            @Override
//            public void handle(ActionEvent event) {
//                System.out.println("Hello World!");
//            }
//        });

        GeneralView root = new GeneralView();//твое главное окно
        Controller controller = new Controller(root);
        Scene scene = new Scene(root, 640, 480);

        primaryStage.setTitle("Program employees!!!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        IView view = new View();
        launch(args);
    }
    
}
