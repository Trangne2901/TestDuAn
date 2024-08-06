module com.example.duan {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.duan to javafx.fxml;
    exports com.example.duan;
}