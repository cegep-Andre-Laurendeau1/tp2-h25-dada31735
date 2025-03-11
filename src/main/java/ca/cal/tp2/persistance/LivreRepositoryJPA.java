package ca.cal.tp2.persistance;

import ca.cal.tp2.modele.Livre;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Persistence;

public class LivreRepositoryJPA implements LivreRepository {
    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tp2");

    @Override
    public void save(Livre livre) {
        try (EntityManager em = entityManagerFactory.createEntityManager()) {
            em.getTransaction().begin();

            Livre livreExistant = recherche(livre.getTitre(), livre.getAuteur());

            if (livreExistant != null) {
                livreExistant.setNombreExemplaires(livreExistant.getNombreExemplaires() + livre.getNombreExemplaires());
                em.merge(livreExistant);
                em.getTransaction().commit();
                return;
            }
            em.persist(livre);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Livre get(long id) {
        try(EntityManager em = entityManagerFactory.createEntityManager()) {
            return em.createQuery("SELECT l FROM Livre l WHERE l.documentID = :id", Livre.class)
                    .setParameter("id", id)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Livre recherche(String titre, String auteur) {
        try (EntityManager em = entityManagerFactory.createEntityManager()) {
            return em.createQuery("SELECT l FROM Livre l WHERE Lower(l.titre) LIKE :titre AND l.auteur = :auteur", Livre.class)
                    .setParameter("titre", "%" + titre.toLowerCase() + "%")
                    .setParameter("auteur", auteur)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
