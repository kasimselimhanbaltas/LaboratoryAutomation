package com.example.labautomationv3;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Date;

public class LabMain extends Application {
    //Default calisan
    //Giris icin kullanici adi ve sifre "admin"
    static Calisan calisan = new Calisan("Gwen Stacy","admin","admin");
    @Override
    public void start(Stage stage) throws IOException {
        //stage.getIcons().add(new Image("C:\\Users\\kasim\\IdeaProjects\\LabAutomationV4\\src\\icons\\icons8-laboratory-64.png"));
        stage.setResizable(false);
        //Kullanici, musteri giris ekrani ile karsilanir
        FXMLLoader fx1 = new FXMLLoader(LabMain.class.getResource("UserLogin.fxml"));
        Scene scene1 = new Scene(fx1.load());
        stage.setTitle("Laboratory XV");
        stage.setScene(scene1);
        stage.show();
        }
    //Numune classi
    public static class Sample{
        public String numuneTipi;
        public String teslimTarihi;
        public String sahibi;
        public static Musteri musteri;

        public Sample(String numuneTipi) {
            Date simdikiZaman = new Date();//Anlik zaman bilgilerini ceken nesne
            this.numuneTipi = numuneTipi;
            this.teslimTarihi = simdikiZaman.toString();//Anlik zaman bilgisi
        }
        }
    public static class Kullanici{
        public String Isim;
        public String TCno;

        //Kullanici main class
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
    //Musteri subclass
    public static class Musteri extends Kullanici{
        public Musteri(String isim, String TCno) {
            super(isim, TCno);
            System.out.println(TCno+ " TC nolu "+isim+" müşteri sisteme giriş yaptı.");
        }

    }
    //Calisan subclass
    public static class Calisan extends Kullanici{
        public String password;
        public Calisan(String isim, String password,String tc) {
            super(isim,tc);
            this.password=password;
        }
    }
    //Programı calistirma
    public static void main(String[] args) {
        launch();
    }

}
