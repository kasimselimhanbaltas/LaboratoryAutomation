package com.example.labautomationv3;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;


public class workerLoginCtrl {
    @FXML
    TextField workerTC,workerPassword;

    public void GoToUserLoginScreeen(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("UserLogin.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
    }
    public void GoToMainFrameWorker(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("MainFrame.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
    }

    public void Login(ActionEvent event) throws IOException{
        if (workerTC.getText().equals("admin")){
            if (workerPassword.getText().equals("admin")){
                GoToMainFrameWorker(event);
            }
        }
        else{
            System.out.println("Invalid tc or password.");
        }
    }

}





