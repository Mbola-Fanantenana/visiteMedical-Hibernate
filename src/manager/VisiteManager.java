
package manager;

import bean.Visite;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author learning
 */
public class VisiteManager {
    
    public Visite getVisiteById(int idVisite) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Visite visite = null;
        
        try {
            visite = session.get(Visite.class, idVisite);
        } catch (Exception e) {
            System.err.println("erreur lors de la récupération d'un visite");
        }
        return visite;
    }
    
    public void ajoutVisite(Visite visite) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.getTransaction();
        
        try {
            Visite v = new Visite();
            v.setCodeMed(visite.getCodeMed());
            v.setCodePat(visite.getCodePat());
            v.setDateVisite(visite.getDateVisite());
            
            session.save(v);
            session.flush();
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }           
    }
    
    public void modifieVisite(Visite visite) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        
        try {
            session.beginTransaction();
            Visite existVisite = session.get(Visite.class, visite.getIdVisite());
            
            existVisite.setCodeMed(visite.getCodeMed());
            existVisite.setCodePat(visite.getCodePat());
            existVisite.setDateVisite(visite.getDateVisite());
            
            session.update(existVisite);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
    }
    
    public void supprimeVisite(int idVisite) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        
        try {
            Visite v = session.get(Visite.class, idVisite);
            if(v != null) {
                session.delete(v);
            }
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
    }
}
