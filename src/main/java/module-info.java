module FileSorter {
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.fxml;

    opens org.example; // Экспорт пакета org.example для модуля javafx.graphics
}