
package manager;

import bean.Medecin;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author learning
 */
public class MedecinManager {
    
    public Medecin getMedecinById(int idMedecin) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Medecin medecin = null;
        
        try {
            medecin = (Medecin) session.get(Medecin.class, idMedecin);
        } catch (HibernateException e) {
            System.err.println("erreur lors de la récupération du médecin ");
        }
        return medecin;
    }
    
    
    public void ajoutMedecin(Medecin medecin) {
        Session session = HibernateUtil.getSessionFactory().openSession();
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
        
        try {
            session.beginTransaction();
            Medecin existMedecin = session.get(Medecin.class, medecin.getIdMedecin());
            
            existMedecin.setCodeMed(medecin.getCodeMed());
            existMedecin.setNom(medecin.getNom());
            existMedecin.setPrenom(medecin.getPrenom());
            existMedecin.setGrade(medecin.getGrade());
            
            session.update(existMedecin);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        }
    } 
    
    public void supprimeMedecin(int idMedecin) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        
        try {
            Medecin m = (Medecin) session.get(Medecin.class, idMedecin);
            if(m != null) {
                session.delete(m);
            }
        transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
        } finally {
            session.close();
        }
    }
}
