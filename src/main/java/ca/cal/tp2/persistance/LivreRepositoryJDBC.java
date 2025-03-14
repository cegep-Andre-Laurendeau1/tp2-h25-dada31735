package ca.cal.tp2.persistance;

import ca.cal.tp2.modele.Livre;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LivreRepositoryJDBC extends RepositoryJDBCParent implements LivreRepository {
    @Override
    protected String getSaveSql() {
        return "INSERT INTO LIVRE (id, titre, auteur, editeur, nombrePages) VALUES (?, ?, ?, ?, ?)";
    }

    @Override
    protected <T> void prepareStatement(PreparedStatement preparedStatement, T t) throws SQLException {
        Livre livre = (Livre) t;
        preparedStatement.setLong(1, livre.getDocumentID());
        preparedStatement.setString(2, livre.getTitre());
        preparedStatement.setString(3, livre.getAuteur());
        preparedStatement.setString(4, livre.getEditeur());
        preparedStatement.setInt(5, livre.getNombrePages());
    }

    @Override
    protected String getGetSql() {
        return "SELECT * FROM LIVRE WHERE id = ?";
    }

    @Override
    protected Livre rehydrateT(ResultSet resultSet) throws SQLException {
        Livre livre = new Livre();
        livre.setDocumentID(resultSet.getInt("id"));
        livre.setAuteur(resultSet.getString("auteur"));
        livre.setEditeur(resultSet.getString("editeur"));
        livre.setNombrePages(resultSet.getInt("nombrePages"));
        return livre;
    }


    @Override
    public void save(Livre livre) {
        super.save(livre);
    }

    @Override
    public Livre get(long id) {
        return super.get(id);
    }

    @Override
    public Livre recherche(String titre, String auteur) {
        return null;
    }
}
