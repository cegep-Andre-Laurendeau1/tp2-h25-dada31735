package ca.cal.tp2.persistance;

import java.sql.*;

public abstract class RepositoryParent {
    static final String JDBC_DRIVER = "org.h2.Driver";
    static final String DB_URL = "jdbc:h2:mem:exercicejdbc;DB_CLOSE_DELAY=-1";
    //  Database credentials
    static final String USER = "sa";
    static final String PASS = "";
    static Connection conn = null;
    static Statement statement = null;


    static {
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            statement = conn.createStatement();
            String sql = "CREATE TABLE LIVRE " +
                    "(id INTEGER not NULL, " +
                    " titre VARCHAR(255), " +
                    " auteur VARCHAR(255), " +
                    " editeur VARCHAR(255), " +
                    " nombrePages INTEGER, " +
                    " PRIMARY KEY (id))";
            statement.executeUpdate(sql);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public <T> int save(T t) {
        String sql = getSaveSql();
        try(PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            prepareStatement(preparedStatement, t);
            preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                return generatedKeys.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return -1;
    }

    protected abstract String getSaveSql();
    protected  abstract <T> void prepareStatement(PreparedStatement preparedStatement, T t) throws SQLException;

    public <T> T get(int id) {
        String sql = getGetSql();
        try(PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return rehydrateT(resultSet);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    protected abstract String getGetSql();
    protected abstract <T> T rehydrateT(ResultSet resultSet) throws SQLException;
}
