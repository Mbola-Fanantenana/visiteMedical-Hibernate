
package bean;

/**
 *
 * @author learning
 */
public class Patient {
    private int idPat;
    private String codePat;
    private String nomPat;
    private String prenomPat;
    private String sexe;
    private String adresse;
    
    public Patient() {}
    
    public Patient(int idPat, String codePat, String nomPat, String prenomPat, String sexe, String adresse) {
        super();
        this.idPat = idPat;
        this.codePat = codePat;
        this.nomPat = nomPat;
        this.prenomPat = prenomPat;
        this.sexe = sexe;
        this.adresse = adresse;
    }
    
    public int getIdPat() {
        return idPat;
    }
    public void setIdPat(int idPat) {
        this.idPat = idPat;
    }
    
    public String getCodePat() {
        return codePat;
    }
    public void setCodePat(String codePat) {
        this.codePat = codePat;
    }
    
    public String getNomPat() {
        return nomPat;
    }
    public void setNomPat(String nomPat) {
        this.nomPat = nomPat;
    }
    
    public String getPrenomPat() {
        return prenomPat;
    }
    public void setPrenomPat(String prenomPat) {
        this.prenomPat = prenomPat;
    }
    
    public String getSexe() {
        return sexe;
    }
    public void setSexe(String sexe) {
        this.sexe = sexe;
    }
    
    public String getAdresse() {
        return adresse;
    }
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
}
