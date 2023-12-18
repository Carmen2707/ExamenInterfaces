module com.example.exameninterfaces {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;


    opens com.example.exameninterfaces to javafx.fxml;
    exports com.example.exameninterfaces;
}