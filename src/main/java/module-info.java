module org.example.bmi {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.bmi to javafx.fxml;
    exports org.example.bmi;
}