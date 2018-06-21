/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KD1_Blakis;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Lietotajs
 */
public class JavaApplication29 extends Application{
   @Override
        public void start(Stage primaryStage){
            primaryStage.setTitle("Java FX Welcome");
            // Start grid
            GridPane grid = new GridPane();
            grid.setAlignment(Pos.CENTER);
            grid.setHgap(10);
            grid.setVgap(10);
            grid.setPadding(new Insets(25, 25,25, 25));
            
            Text sceneTitle = new Text("Welcome to Eternal Suffering");
            sceneTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
            grid.add(sceneTitle, 0, 0, 2, 1);
            Label userName = new Label("Username: ");
            grid.add(userName, 0, 1);
            TextField userTextField = new TextField();
            grid.add(userTextField, 1, 1);
            Label pw = new Label("Password: ");
            grid.add(pw, 0, 2);
            PasswordField pwBox = new PasswordField();
            grid.add(pwBox, 1, 2);
            Button btn = new Button("Log in");
            HBox hbBtn = new HBox(10);
            hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
            hbBtn.getChildren().add(btn);
            grid.add(hbBtn, 1, 4);
            // Text - where changes will happen on button press
            Text actiontarget = new Text();
            grid.add(actiontarget, 1, 6);
            GridPane newGrid = new GridPane();
            newGrid.setAlignment(Pos.CENTER);
            Text afterLoginTitle = new Text("You have succesfuly logged in");
            newGrid.add(afterLoginTitle, 0, 0);
            // Setting what will happen when button is pressed
            btn.setOnAction(new EventHandler<ActionEvent>() {
                GridPane newGrid = new GridPane();
                Scene sceneNew = new Scene(newGrid, 200, 200);
                @Override
                public void handle(ActionEvent e){
                    actiontarget.setFill(Color.FIREBRICK);
                    actiontarget.setText(userTextField.getText());
                    if( "root".equals(userTextField.getText())){
                        Scene newScene = new Scene(newGrid, 300, 300);
                        primaryStage.setScene(newScene);
                    }
                }
            });
            // Creates new scene with grid as root
            Scene scene = new Scene(grid, 300, 275);
            // Changes primary stage to new scene
            primaryStage.setScene(scene);
            // Shows primary stage
            primaryStage.show();
        }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}

