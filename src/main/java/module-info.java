module textrpg {
  requires java.sql;
  requires javafx.controls;
  requires javafx.fxml;
  requires org.xerial.sqlitejdbc;

  opens textrpg to
      javafx.fxml;

  exports textrpg;
}
