package ca.cal.tp2.persistance;

import ca.cal.tp2.modele.Emprunteur;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EmprunteurRepositoryJPA implements EmprunteurRepository {
    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tp2");

    @Override
    public void save(Emprunteur emprunteur) {
        try(EntityManager em = entityManagerFactory.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(emprunteur);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Emprunteur get(long id) {
        try(EntityManager em = entityManagerFactory.createEntityManager()) {
            return em.createQuery("SELECT e FROM Emprunteur e WHERE e.id = :id", Emprunteur.class)
                    .setParameter("id", id)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Emprunteur recherche(String nom) {
        try(EntityManager em = entityManagerFactory.createEntityManager()) {
            return em.createQuery("SELECT e FROM Emprunteur e WHERE e.name = :nom", Emprunteur.class)
                    .setParameter("nom", nom)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Emprunteur findByIdWithEmprunts(long emprunteurId) {
        try (EntityManager em = entityManagerFactory.createEntityManager()) {
            return em.createQuery("SELECT e FROM Emprunteur e LEFT JOIN FETCH e.emprunts WHERE e.userID = :emprunteurId", Emprunteur.class)
                    .setParameter("emprunteurId", emprunteurId)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
