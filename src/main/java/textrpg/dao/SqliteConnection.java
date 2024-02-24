package textrpg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.sqlite.SQLiteDataSource;

public class SqliteConnection {

    private static final String sqliteFile = "jdbc:sqlite:src/main/resources/db/textrpg-db.sqlite";

    private static SQLiteDataSource sqliteDataSource;

    static {
        sqliteDataSource = new SQLiteDataSource();
        sqliteDataSource.setUrl(sqliteFile);
    }

    public static Connection getConnection() throws SQLException {
        return sqliteDataSource.getConnection();
    }
}
