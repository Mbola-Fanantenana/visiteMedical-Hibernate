
package manager;

import bean.Patient;
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
public class PatientManager {
    
    public List<Patient> getAllPatient() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Patient> patients = null;
        
        try {
            String req = "from Patient";
            Query query = session.createQuery(req);
            patients = query.list();
        } catch (Exception e) {
            System.err.println("erreur");
        }
        session.close();
        return patients;
    }
    
    public Patient getPatientById(int idPat) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Patient patient = null;
        
        try {
            patient = (Patient) session.get(Patient.class, idPat);
        } catch (Exception e) {
            System.err.println("erreur lors de la récupération d'un patient");
        }
        session.close();
        return patient;
    }
    
    public void ajoutPatient(Patient patient) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        
        try {
            Patient p = new Patient();
            p.setCodePat(patient.getCodePat());
            p.setNomPat(patient.getNomPat());
            p.setPrenomPat(patient.getPrenomPat());
            p.setSexe(patient.getSexe());
            p.setAdresse(patient.getAdresse());
            
            session.save(p);
            session.flush();
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            //System.err.println("erreur add");
        }
        session.close();
    }
    
    public void modifiePatient(Patient patient) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        
        try {
            session.beginTransaction();
            Query query = session.createQuery("FROM Patient where codePat = :code");
            query.setParameter("code", patient.getCodePat());
            Patient existPatient = (Patient) query.uniqueResult();
            if(existPatient != null) {
                existPatient.setCodePat(patient.getCodePat());
                existPatient.setNomPat(patient.getNomPat());
                existPatient.setPrenomPat(patient.getPrenomPat());
                existPatient.setSexe(patient.getSexe());
                existPatient.setAdresse(patient.getAdresse());

                session.update(existPatient);
                session.getTransaction().commit();   
            }
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
        session.close();
    }
    
    public void supprimePatient(String codePat) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        
        try {
            Query query = session.createQuery("DELETE FROM Patient m WHERE m.codePat = :codePat");
            query.setParameter("codePat", codePat);
            int deleted = query.executeUpdate();
            if (deleted == 0) {
                System.err.println("Aucun patient n'a été supprimé");
            } else {
                System.out.println(deleted + " patient(s) ont été supprimé(s)");
            }
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
        session.close();
    }
    
    public Patient recherchePatient(Patient patient) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        //Patient patient = null;
        
        try {            
            Query<Patient> query = session.createQuery("FROM Patient WHERE codePat = :codePat OR nomPat = :nomPat", Patient.class);
            query.setParameter("codePat", patient.getCodePat());
            query.setParameter("nomPat", patient.getNomPat());
            patient = query.uniqueResult();
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            session.close();
        }
        return patient;
    }
}
