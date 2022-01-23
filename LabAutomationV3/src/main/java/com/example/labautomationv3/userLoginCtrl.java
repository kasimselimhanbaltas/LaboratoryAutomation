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
import java.util.ArrayList;

public class userLoginCtrl {
    static ArrayList<LabMain.Musteri> users = new ArrayList<>();
    @FXML
    TextField userName, userTC;

    @FXML
    public void userLogin(){
        String username = userName.getText();
        String tc = userTC.getText();
        users.add(new LabMain.Musteri(username,tc));
        users.get(users.size()-1).Isim=username;users.get(users.size()-1).TCno=tc;
        System.out.println("Login Succesful, Welcome "+username+".");

    }
    public void Loginusr(ActionEvent event) throws IOException{
        if (userName.getText().equals("")==false){
            if (userTC.getText().equals("")==false){
                GoToMainFrameUser(event);
            }
        }
        else{
            System.out.println("Lütfen isminizi ve TCnizi girin.");
        }
    }

    public void GoToMainFrameUser(ActionEvent event) throws IOException {
        userLogin();

        Parent tableViewParent = FXMLLoader.load(getClass().getResource("UserMainFrame.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
    }
    public void GoToWorkerLoginScreeen(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("WorkerLogin.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
    }

}
