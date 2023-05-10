
package bean;

import java.util.Date;

/**
 *
 * @author learning
 */
public class Visite {
    private int idVisite;
    private String codeMed;
    private String codePat;
    private Date dateVisite;
    
    public Visite() {}
    
    public Visite(int idVisite, String codeMed, String codePat, Date dateVisite) {
        super();
        this.idVisite = idVisite;
        this.codeMed = codeMed;
        this.codePat = codePat;
        this.dateVisite = dateVisite;
    }
    
    public int getIdVisite() {
        return idVisite;
    }
    public void setIdVisite(int idVisite) {
        this.idVisite = idVisite;
    }
    
    public String getCodeMed() {
        return codeMed;
    }
    public void setCodeMed(String codeMed) {
        this.codeMed = codeMed;
    }
    
    public String getCodePat() {
        return codePat;
    }
    public void setCodePat(String codePat) {
        this.codePat = codePat;
    }
    
    public Date getDateVisite() {
        return dateVisite;
    }
    public void setDateVisite(Date dateVisite) {
        this.dateVisite = dateVisite;
    }
}
