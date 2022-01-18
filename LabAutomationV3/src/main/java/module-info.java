module com.example.labautomationv3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.apache.poi.ooxml;


    opens com.example.labautomationv3 to javafx.fxml;
    exports com.example.labautomationv3;
}