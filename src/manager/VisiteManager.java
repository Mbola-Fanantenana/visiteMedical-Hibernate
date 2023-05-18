
package manager;

import bean.Visite;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;

/**
 *
 * @author learning
 */
public class VisiteManager {
    
    public Visite getVisiteById(int idVisite) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Visite visite = null;
        
        try {
            visite = session.get(Visite.class, idVisite);
        } catch (Exception e) {
            System.err.println("erreur lors de la récupération d'un visite");
        }
        return visite;
    }
    
    public List<Visite> getAllVisite() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        //Transaction transaction = null;
        List<Visite> visites = null;
            
        try {
            session.beginTransaction();
            String req = "FROM Visite";
            Query query = session.createQuery(req);
            visites = query.list();
            session.getTransaction().commit();
        } catch (Exception e) {
            System.err.println(e);
        }
        return visites;
    }
    
    public void ajoutVisite(Visite visite) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        
        try {
            Visite v = new Visite();
            v.setCodeMedVisite(visite.getCodeMedVisite());
            v.setCodePatVisite(visite.getCodePatVisite());
            v.setDateVisite(visite.getDateVisite());
            
            session.save(v);
            session.flush();
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
        } finally {
            session.close();
        }           
    }
    
    public void modifieVisite(Visite visite) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Query query = session.createQuery("FROM Visite WHERE codeMedVisite =: codeM OR codePatVisite =: codeP");
            query.setParameter("codeM", visite.getCodeMedVisite());
            query.setParameter("codeP", visite.getCodePatVisite());
            Visite existVisite = (Visite) query.uniqueResult();
            
            if(existVisite != null) {
                existVisite.setCodeMedVisite(visite.getCodeMedVisite());
                existVisite.setCodePatVisite(visite.getCodePatVisite());
                
                java.util.Date utilDate = visite.getDateVisite();
                java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
                existVisite.setDateVisite(sqlDate);
            
                session.update(existVisite);
                transaction.commit();
            } else {
                System.err.println("erreur de modification");
            }

        } catch (Exception e) {
            transaction.rollback();
        } finally {
            session.close();
        }
    }
    
    public void supprimeVisite(String codeMedVisite, String codePatVisite) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        
        try {
            Query query = session.createQuery("DELETE FROM Visite v WHERE v.codeMedVisite = :codeMedVisite OR v.codePatVisite = :codePatVisite");
            query.setParameter("codeMedVisite", codeMedVisite);
            query.setParameter("codePatVisite", codePatVisite);
            int deleted = query.executeUpdate();
            if(deleted == 0) {
                JOptionPane.showMessageDialog(null, "aucun medecin supprimer");
            } 
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            JOptionPane.showMessageDialog(null, "erreur de suppression");
        }
    }
}
