module ProgPatternsApp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
	requires java.desktop;

    opens app.controller to javafx.fxml;
    exports app.controller;
}
