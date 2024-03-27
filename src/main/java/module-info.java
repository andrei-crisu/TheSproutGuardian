module appcode.thesproutguardian {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;


    opens appcode.thesproutguardian to javafx.fxml;
    exports appcode.thesproutguardian;
    exports appcode.thesproutguardian.utile;
    opens appcode.thesproutguardian.utile to javafx.fxml;
}