package ca.cal.tp2.persistance;

import ca.cal.tp2.modele.CD;
import ca.cal.tp2.modele.DVD;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DVDRepositoryJPA implements DVDRepository {
    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tp2");

    @Override
    public void save(DVD dvd) {
        try (EntityManager em = entityManagerFactory.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(dvd);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public DVD get(long id) {
        try(EntityManager em = entityManagerFactory.createEntityManager()) {
            return em.createQuery("SELECT d FROM DVD d WHERE d.documentID = :id", DVD.class)
                    .setParameter("id", id)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
