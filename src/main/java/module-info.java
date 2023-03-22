module appcode.thesproutguardian {
    requires javafx.controls;
    requires javafx.fxml;


    opens appcode.thesproutguardian to javafx.fxml;
    exports appcode.thesproutguardian;
}