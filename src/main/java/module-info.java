module FileSorter {
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.fxml;

    opens ua.skushnerov; // Экспорт пакета org.example
    opens ua.skushnerov.controller to javafx.fxml;
}