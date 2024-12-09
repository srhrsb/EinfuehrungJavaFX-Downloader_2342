module com.brh.einfuehrungjavafx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.brh.einfuehrungjavafx to javafx.fxml;
    exports com.brh.einfuehrungjavafx;
}