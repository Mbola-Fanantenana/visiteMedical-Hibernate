
package manager;

import IFace.IFacePatient;
import bean.Medecin;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;

/**
 *
 * @author learning
 */
public class MedecinManager {
    
    public List<Medecin> getAllMedecin() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Medecin> medecins = null;
        
        try {
            String req = "from Medecin";
            Query query = session.createQuery(req);
            medecins = query.list();
        } catch (Exception e) {
            System.err.println("erreur blablabla");
        }

        return medecins;
    }
    
    public Medecin getMedecinById(int idMedecin) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Medecin medecin = null;
        
        try {
            medecin = (Medecin) session.get(Medecin.class, idMedecin);
        } catch (HibernateException e) {
            System.err.println("erreur blablabla ");
        }
        return medecin;
    }
    
    
    public void ajoutMedecin(Medecin medecin) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        
        try {            
            Medecin m = new Medecin();
            m.setCodeMed(medecin.getCodeMed());
            m.setNom(medecin.getNom());
            m.setPrenom(medecin.getPrenom());
            m.setGrade(medecin.getGrade());

            session.save(m);
            session.flush();
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
        } 
       
    } 
    
    public void modifieMedecin(Medecin medecin) {
    Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    Transaction transaction = null;

    try {
        transaction = session.beginTransaction();

        Query query = session.createQuery("FROM Medecin WHERE codeMed = :code");
        query.setParameter("code", medecin.getCodeMed());
        Medecin existMedecin = (Medecin) query.uniqueResult();

        if (existMedecin != null) {
            existMedecin.setCodeMed(medecin.getCodeMed());
            existMedecin.setNom(medecin.getNom());
            existMedecin.setPrenom(medecin.getPrenom());
            existMedecin.setGrade(medecin.getGrade());

            session.update(existMedecin);
            transaction.commit();
        } else {
            System.out.println("Medecin introuvable avec le codeMedecin : " + medecin.getCodeMed());
        }
    } catch (HibernateException e) {
        if (transaction != null) {
            transaction.rollback();
        }
        e.printStackTrace();
    }
}
    
    /*public void supprimeMedecin(String codeMed) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        
        try {
            Medecin m = (Medecin) session.get(Medecin.class, codeMed);
            if(m != null) {
                session.delete(m);
            }
        transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
        } finally {
            session.close();
        }
    }*/
    
    public void supprimeMedecin(String codeMed) {
    Session session = HibernateUtil.getSessionFactory().getCurrentSession();
    Transaction transaction = session.beginTransaction();
        try {   
            Query query = session.createQuery("DELETE FROM Medecin m WHERE m.codeMed = :codeMed");
            query.setParameter("codeMed", codeMed);
            int deleted = query.executeUpdate();
            if (deleted == 0) {
                System.err.println("Aucun médecin n'a été supprimé");
            } else {
                System.out.println(deleted + " médecin(s) ont été supprimé(s)");
            }
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            System.err.println("Erreur lors de la suppression du médecin : " + e.getMessage());
        } finally {
            session.close();
        }
    }

}
