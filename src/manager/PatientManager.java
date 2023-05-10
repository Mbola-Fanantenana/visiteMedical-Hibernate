
package manager;

import bean.Patient;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author learning
 */
public class PatientManager {
    
    public Patient getPatientById(int idPat) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Patient patient = null;
        
        try {
            patient = (Patient) session.get(Patient.class, idPat);
        } catch (Exception e) {
            System.err.println("erreur lors de la récupération d'un patient");
        }
        return patient;
    }
    
    public void ajoutPatient(Patient patient) {
        Session session = HibernateUtil.getSessionFactory().openSession();
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
        }
    }
    
    public void modifiePatient(Patient patient) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        
        try {
            session.beginTransaction();
            Patient existPatient = session.get(Patient.class, patient.getIdPat());
            
            existPatient.setCodePat(patient.getCodePat());
            existPatient.setNomPat(patient.getNomPat());
            existPatient.setPrenomPat(patient.getPrenomPat());
            existPatient.setSexe(patient.getSexe());
            existPatient.setAdresse(patient.getAdresse());
            
            session.update(existPatient);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
    }
    
    public void supprimePatient(int idPat) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        
        try {
            Patient p = session.get(Patient.class, idPat);
            if(p != null) {
                session.delete(p);
            }
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
    }
}
