module textrpg {
    requires javafx.controls;
    requires javafx.fxml;

    opens textrpg to javafx.fxml;
    exports textrpg;
}
