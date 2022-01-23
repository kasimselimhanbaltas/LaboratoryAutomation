package com.example.labautomationv3;


import org.apache.poi.xwpf.usermodel.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class GenerateDocument {
    public static void createReport1(XWPFDocument doc, LabMain.Sample sample, LabMain.Calisan calisan) throws IOException {
        //Kan tahlili raporu olusturan fonksiyon
        String space = "                          ";
        String space2 = "              ";//POI kutuphanesinde \t ile tab birakilmadigindan bosluklari manuel olarak ayarladim

        XWPFParagraph p1 = doc.createParagraph();//standart paragraf olusturma komutlari
        p1.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun r1 = p1.createRun();
        r1.setBold(true);
        r1.setFontSize(30);
        r1.setText("Laboratory Report");
        r1.setFontFamily("Courier");

        XWPFParagraph p2 = doc.createParagraph();
        XWPFRun r2 = p2.createRun();
        r2.setBold(true);
        r2.setFontSize(12);
        r2.setText("Analysis Type: "+sample.numuneTipi);r2.setText(space2);
        r2.setFontFamily("Courier");

        XWPFParagraph p4 = doc.createParagraph();
        XWPFRun r4 = p4.createRun();
        r4.setBold(true);
        r4.setFontSize(12);
        r4.setText("Analysis Date: "+sample.teslimTarihi);
        r4.setFontFamily("Courier");

        XWPFParagraph p3 = doc.createParagraph();
        XWPFRun r3 = p3.createRun();
        r3.setBold(true);
        r3.setFontSize(12);
        r3.setText("Sample Owner: "+sample.sahibi);
        r3.setFontFamily("Courier");

        XWPFParagraph p7 = doc.createParagraph();
        XWPFRun r7 = p7.createRun();
        r7.setBold(true);
        r7.setFontSize(12);
        r7.setText("Confirmed by "+calisan.Isim);
        r7.setFontFamily("Courier");


        XWPFTable table = doc.createTable();//Raporun en onemli kismi olan tabloyu olusturma
        table.setWidth("100%");//Tablonun dokumanın enini doldurur
        Random r=new Random();
        //Creating first Row

        XWPFTableRow row0 = table.getRow(0);//tablo elementleri tek tek yazdirilir
        row0.getCell(0).setText(space+"Variables");
        row0.addNewTableCell().setText(space+space + "Values");

        XWPFTableRow row1 = table.createRow();
        row1.getCell(0).setText(space+"Hemoglobin");
        row1.getCell(1).setText(space+space+((double) r.nextInt(5)+11));

        //Creating second Row
        XWPFTableRow row2 = table.createRow();
        row2.getCell(0).setText(space+"RBC");
        row2.getCell(1).setText(space+space + ((double) r.nextInt(3)+3.5));

        XWPFTableRow row3 = table.createRow();
        row3.getCell(0).setText(space+"HCT");
        row3.getCell(1).setText(space+space + ((double) r.nextInt(7)+82));

        XWPFTableRow row4 = table.createRow();
        row4.getCell(0).setText(space+"MCV");
        row4.getCell(1).setText(space+space + ((double) r.nextInt(4)+27));

        XWPFTableRow row5 = table.createRow();
        row5.getCell(0).setText(space+"MCH");
        row5.getCell(1).setText(space+space + ((double) r.nextInt(4)+32));

        XWPFTableRow row6 = table.createRow();
        row6.getCell(0).setText(space+"MCHC");
        row6.getCell(1).setText(space+space + ((double) r.nextInt(3)+11.5));

        XWPFTableRow row7 = table.createRow();
        row7.getCell(0).setText(space+"RDW-CV");
        row7.getCell(1).setText(space+space + ((double) r.nextInt(21)+35));

        XWPFTableRow row8 = table.createRow();
        row8.getCell(0).setText(space+"RDW-CD");
        row8.getCell(1).setText(space+space + ((double) r.nextInt(7)+4.5));

        XWPFTableRow row9 = table.createRow();
        row9.getCell(0).setText(space+"WBC");
        row9.getCell(1).setText(space+space + ((double) r.nextInt(21)+40));

        XWPFTableRow row10 = table.createRow();
        row10.getCell(0).setText(space+"NEU%");
        row10.getCell(1).setText(space+space + ((double) r.nextInt(4)+32));

        XWPFTableRow row11 = table.createRow();
        row11.getCell(0).setText(space+"LYM%");
        row11.getCell(1).setText(space+space + ((double) r.nextInt(3)+11.5));

        XWPFTableRow row12 = table.createRow();
        row12.getCell(0).setText(space+"GRA#");
        row12.getCell(1).setText(space+space + ((double) r.nextInt(21)+35));

        XWPFTableRow row13 = table.createRow();
        row13.getCell(0).setText(space+"PLT");
        row13.getCell(1).setText(space+space + ((double) r.nextInt(5)+11));

        XWPFTableRow row14 = table.createRow();
        row14.getCell(0).setText(space+"ESR");
        row14.getCell(1).setText(space+space + ((double) r.nextInt(3)+3.5));



        // Dosyayi kaydetme, kendi path'inizi bu kisma yerlestirin
        try (FileOutputStream out = new FileOutputStream("C:\\Users\\kasim\\IdeaProjects\\LabAutomationV4\\src\\reports\\Report.docx")) {
            doc.write(out);
            System.out.println("Rapor olusturuldu.");
        }


    }

    public static void createReport2(XWPFDocument doc, LabMain.Sample sample, LabMain.Calisan calisan) throws IOException{
        //Idrar tahlili raporu olusturan fonsiyon
        String space = "                          ";
        String space2 = "              ";

        XWPFParagraph p1 = doc.createParagraph();
        p1.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun r1 = p1.createRun();
        r1.setBold(true);
        r1.setFontSize(30);
        r1.setText("Laboratory Report");
        r1.setFontFamily("Courier");

        XWPFParagraph p2 = doc.createParagraph();
        XWPFRun r2 = p2.createRun();
        r2.setBold(true);
        r2.setFontSize(12);
        r2.setText("Analysis type: "+sample.numuneTipi);r2.setText(space2);
        r2.setFontFamily("Courier");

        XWPFParagraph p4 = doc.createParagraph();
        XWPFRun r4 = p4.createRun();
        r4.setBold(true);
        r4.setFontSize(12);
        r4.setText("Analysis Date: "+sample.teslimTarihi);
        r4.setFontFamily("Courier");

        XWPFParagraph p3 = doc.createParagraph();
        XWPFRun r3 = p3.createRun();
        r3.setBold(true);
        r3.setFontSize(12);
        r3.setText("Sample Owner: "+sample.sahibi);
        r3.setFontFamily("Courier");

        XWPFParagraph p7 = doc.createParagraph();
        XWPFRun r7 = p7.createRun();
        r7.setBold(true);
        r7.setFontSize(12);
        r7.setText("Confirmed by "+calisan.Isim);
        r7.setFontFamily("Courier");



        XWPFTable table = doc.createTable();
        table.setWidth("100%");
        Random r=new Random();
        //Creating first Row
        XWPFTableRow row0 = table.getRow(0);
        row0.getCell(0).setText(space+ "Variables");
        row0.addNewTableCell().setText(space + space + "Values");

        XWPFTableRow row1 = table.createRow();
        row1.getCell(0).setText(space+"Epinephrine");
        row1.getCell(1).setText(space+space+((double) r.nextInt(20)));

        //Creating second Row
        XWPFTableRow row2 = table.createRow();
        row2.getCell(0).setText(space+"Metanephrine");
        row2.getCell(1).setText(space+space + ((double) r.nextInt(1)));

        XWPFTableRow row3 = table.createRow();
        row3.getCell(0).setText(space+"Norepinephrine");
        row3.getCell(1).setText(space+space + ((double) r.nextInt(65)+15));

        XWPFTableRow row4 = table.createRow();
        row4.getCell(0).setText(space+"Normetanephrine");
        row4.getCell(1).setText(space+space + ((double) r.nextInt(400)+109));

        XWPFTableRow row5 = table.createRow();
        row5.getCell(0).setText(space+"Dopamine");
        row5.getCell(1).setText(space+space + ((double) r.nextInt(350)+65));




        // Dosyayi kaydetme
        try (FileOutputStream out = new FileOutputStream("C:\\Users\\kasim\\IdeaProjects\\LabAutomationV4\\src\\reports\\Report.docx")) {
            doc.write(out);
            System.out.println("Rapor olusturuldu.");
        }
    }

}
