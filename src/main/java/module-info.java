module org.dzenan {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.j;

    opens org.dzenan to javafx.fxml;
    exports org.dzenan;
}
