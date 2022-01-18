package com.example.labautomationv3;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class LabMain extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        stage.setResizable(false);
        //Kullanici, musteri giris ekrani ile karsilanir
        FXMLLoader fx1 = new FXMLLoader(LabMain.class.getResource("UserLogin.fxml"));
        Scene scene1 = new Scene(fx1.load());
        stage.setTitle("Laboratory XV");
        stage.setScene(scene1);
        stage.show();
        }

    public static class Sample{
        public String numuneTipi;
        public String teslimTarihi;
        public String sahibi;
        public static Musteri musteri;
        public static ArrayList<Sample> Samples = new ArrayList<>();

        public Sample(String numuneTipi) {
            Date simdikiZaman = new Date();
            this.numuneTipi = numuneTipi;
            this.teslimTarihi = simdikiZaman.toString();
            Samples.add(this);
        }
        public Sample(String sahibi,String numuneTipi) {
            Date simdikiZaman = new Date();
            this.numuneTipi = numuneTipi;
            this.teslimTarihi = simdikiZaman.toString();
            this.sahibi = sahibi;
            Samples.add(this);
            }
        }
    public static class Kullanici{
        public String Isim;
        public String TCno;

        public Kullanici() {
        }
        public Kullanici(String isim){
            this.Isim = isim;
        }

        public Kullanici(String isim, String TCno) {
            Isim = isim;
            TCno = TCno;
        }


    }
    public static class Musteri extends Kullanici{
        public Musteri(){
            super();
        }
        public Musteri(String isim, String TCno) {
            super(isim, TCno);
            System.out.println(TCno+ " TC nolu "+isim+" müşteri sisteme giriş yaptı.");
        }

    }
    public static class Calisan extends Kullanici{
        public String password;
        public Calisan(String isim, String password,String tc) {
            super(isim,tc);
            this.password=password;


        }
    }

    public static void main(String[] args) {
        launch();
    }
        //Default calisan
        //Giris icin kullanici adi ve sifre "admin"
        static Calisan calisan = new Calisan("Gwen Stacy","admin","admin");

}