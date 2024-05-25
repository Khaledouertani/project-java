module com.example.gestion_cabinet {
    requires javafx.controls;
    requires javafx.fxml;
    //requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires java.sql;
    // requires net.synedra.validatorfx;
   // requires org.kordamp.ikonli.javafx;
   // requires org.kordamp.bootstrapfx.core;
   // requires eu.hansolo.tilesfx;
    //requires com.almasb.fxgl.all;
    //requires java.sql;

    opens com.example.gestion_cabinet to javafx.fxml;
    exports com.example.gestion_cabinet;
}