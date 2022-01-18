package com.example.labautomationv3;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

public class UserMainFrameCtrl implements Initializable {

    @FXML
    ListView listview1;
    ObservableList list1 = FXCollections.observableArrayList();
    @Override//for list view
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadData1();
    }
    private void loadData1() {
        list1.removeAll(list1);
        String a = "Kan Tahlili";
        String b = "İdrar Tahlili";
        list1.addAll(a, b);
        listview1.getItems().addAll(list1);
    }
    public void numuneTeslimi() throws ParseException {
        String numunetipi = (String) listview1.getSelectionModel().getSelectedItem();
        //Numune nesnesi burada olusturuluyor
        LabMain.Sample numune1 = new LabMain.Sample(numunetipi);
        numune1.musteri = userLoginCtrl.musteri;
        numune1.sahibi= LabMain.Sample.musteri.Isim;
        System.out.println("Numune Bilgileri: Numune Sahibi:"+numune1.musteri.Isim+", Numune Tipi:"+numune1.numuneTipi + ", Numune Teslim Tarihi:" + numune1.teslimTarihi);
    }

    public void LogOut(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("UserLogin.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
    }

}
