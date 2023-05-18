
package bean;

import java.util.Date;

/**
 *
 * @author learning
 */
public class Visite {
    private int idVisite;
    private String codeMedVisite;
    private String codePatVisite;
    private Date dateVisite;
    
    public Visite() {}
    
    public Visite(int idVisite, String codeMedVisite, String codePatVisite, Date dateVisite) {
        super();
        this.idVisite = idVisite;
        this.codeMedVisite = codeMedVisite;
        this.codePatVisite = codePatVisite;
        this.dateVisite = dateVisite;
    }
    
    public int getIdVisite() {
        return idVisite;
    }
    public void setIdVisite(int idVisite) {
        this.idVisite = idVisite;
    }
    
    public String getCodeMedVisite() {
        return codeMedVisite;
    }
    public void setCodeMedVisite(String codeMedVisite) {
        this.codeMedVisite = codeMedVisite;
    }
    
    public String getCodePatVisite() {
        return codePatVisite;
    }
    public void setCodePatVisite(String codePatVisite) {
        this.codePatVisite = codePatVisite;
    }
    
    public Date getDateVisite() {
        return dateVisite;
    }
    public void setDateVisite(Date dateVisite) {
        this.dateVisite = dateVisite;
    }
}
