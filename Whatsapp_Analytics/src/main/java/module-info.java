module com.example.whatsapp_analytics {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.whatsapp_analytics to javafx.fxml;
    exports com.example.whatsapp_analytics;
}