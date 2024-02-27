module textrpg {
  requires java.sql;
  requires javafx.controls;
  requires javafx.fxml;
  requires org.xerial.sqlitejdbc;
  requires ch.qos.logback.core;
  requires org.slf4j;

  opens textrpg to
      javafx.fxml;

  exports textrpg;
}
