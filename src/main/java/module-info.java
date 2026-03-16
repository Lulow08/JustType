module com.lulow.justtype {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;

    opens com.lulow.justtype to javafx.fxml;
    opens com.lulow.justtype.controller to javafx.fxml;
    exports com.lulow.justtype;
}