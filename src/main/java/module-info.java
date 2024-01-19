module FileSorter {
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.fxml;

    opens org.example; // Экспорт пакета org.example
    opens org.example.controller to javafx.fxml;
}