package ca.cal.tp2.persistance;

import ca.cal.tp2.modele.CD;
import ca.cal.tp2.modele.Livre;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class CDRepositoryJPA implements CDRepository {
    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tp2");

    @Override
    public void save(CD cd) {
        try (EntityManager em = entityManagerFactory.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(cd);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public CD get(long id) {
        try(EntityManager em = entityManagerFactory.createEntityManager()) {
            return em.createQuery("SELECT c FROM CD c WHERE c.documentID = :id", CD.class)
                    .setParameter("id", id)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
