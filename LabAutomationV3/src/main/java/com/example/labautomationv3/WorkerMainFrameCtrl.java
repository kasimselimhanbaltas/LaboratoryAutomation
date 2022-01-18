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
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class WorkerMainFrameCtrl implements Initializable{

    @FXML
    ListView listView2;//mevcut numuneleri listeler

    ObservableList list1 = FXCollections.observableArrayList();
    private void loadData1() {//Numune listesine veri yukleyen fonksiyon
        list1.removeAll(list1);
        ArrayList<String> toload = new ArrayList<String>();
        for (int i =0;i< LabMain.Sample.Samples.size();i++){
            String msg = ("\t\t"+LabMain.Sample.Samples.get(i).sahibi+"\t"+LabMain.Sample.Samples.get(i).numuneTipi+"\t"+LabMain.Sample.Samples.get(i).teslimTarihi+"\t"+(i+1));
            toload.add(i,msg);
        }
        list1.addAll(toload);
        listView2.getItems().addAll(list1);
    }


    public void report() throws IOException {//Calisanin onaylama butonuna basmasiyla rapor olusturan fonsiyon
        String line = (String) listView2.getSelectionModel().getSelectedItem();
        if (line.contains("Kan")){
            XWPFDocument document = new XWPFDocument();
            GenerateDocument.createReport1(document,LabMain.Sample.Samples.get(0),LabMain.calisan);

        }
        if (line.contains("İdrar")){
            XWPFDocument document = new XWPFDocument();
            GenerateDocument.createReport2(document,LabMain.Sample.Samples.get(0),LabMain.calisan);
        }

    }

    @Override//Numune listesi icin override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadData1();
    }


    public void LogOut(ActionEvent event) throws IOException {//Giris ekranina donduren fonksiyon
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("UserLogin.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();
    }



}