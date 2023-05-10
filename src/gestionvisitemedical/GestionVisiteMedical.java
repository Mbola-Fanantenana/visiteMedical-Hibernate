
package gestionvisitemedical;

import bean.Medecin;
import bean.Patient;
import bean.Visite;
import java.util.Date;
import manager.MedecinManager;
import manager.PatientManager;
import manager.VisiteManager;
import util.HibernateUtil;

/**
 *
 * @author learning
 */
public class GestionVisiteMedical {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        MedecinManager medecinManager = new MedecinManager();
//        PatientManager patientManager = new PatientManager();

        
/*        Patient pat = new Patient();
        pat.setCodePat("P7");
        pat.setNomPat("Anthony");
        pat.setPrenomPat("Far");
        pat.setSexe("Feminin");
        pat.setAdresse("Giv");
        
        patientManager.ajoutPatient(pat); */
//        patientManager.supprimePatient(3);
        
/*      Medecin mdc = new Medecin();
        
        mdc.setCodeMed("C12");
        mdc.setNom("boom");
        mdc.setPrenom("til");
        mdc.setGrade("click");
        
        medecinManager.ajoutMedecin(mdc); */
        
       // medecinManager.supprimeMedecin(1);
       
/*       Medecin medecinToUpdate = medecinManager.getMedecinById(2);
       
       medecinToUpdate.setCodeMed("C4");
       medecinToUpdate.setNom("BILL");

       
       medecinManager.modifieMedecin(medecinToUpdate); */

 /*   Patient patientToUpdate = patientManager.getPatientById(2);
    patientToUpdate.setAdresse("tana");
    
    patientManager.modifiePatient(patientToUpdate);*/
        
        HibernateUtil.sessionFactory.close();
    }
    
}
