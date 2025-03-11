package ca.cal.tp2.persistance;

import ca.cal.tp2.modele.CD;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Persistence;

public class CDRepositoryJPA implements CDRepository {
    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tp2");

    @Override
    public void save(CD cd) {
        try (EntityManager em = entityManagerFactory.createEntityManager()) {
            em.getTransaction().begin();

            CD cdExistant = recherche(cd.getTitre(), cd.getArtiste());

            if (cdExistant != null) {
                cdExistant.setNombreExemplaires(cdExistant.getNombreExemplaires() + cd.getNombreExemplaires());
                em.merge(cdExistant);
                em.getTransaction().commit();
                return;
            }
            em.persist(cd);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public CD get(long id) {
        try (EntityManager em = entityManagerFactory.createEntityManager()) {
            return em.createQuery("SELECT c FROM CD c WHERE c.documentID = :id", CD.class)
                    .setParameter("id", id)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public CD recherche(String titre, String artiste) {
        try (EntityManager em = entityManagerFactory.createEntityManager()) {
            return em.createQuery("SELECT c FROM CD c WHERE Lower(c.titre) LIKE :titre AND c.artiste = :artiste", CD.class)
                    .setParameter("titre", "%" + titre.toLowerCase() + "%")
                    .setParameter("artiste", artiste)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}