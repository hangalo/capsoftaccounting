/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capsoftaccounting.model;

import java.util.Date;

/**
 *
 * @author viceeconomo
 */
public class Giocon {

    private Integer iddoc;
    private Date datreg;
    private String desmov;
    private String codcentro;

    public Giocon() {
    }

    public Giocon(int iddoc, Date datreg, String desmov, String codcentro) {
        this.iddoc = iddoc;
        this.datreg = datreg;
        this.desmov = desmov;
        this.codcentro = codcentro;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.iddoc;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Giocon other = (Giocon) obj;
        if (this.iddoc != other.iddoc) {
            return false;
        }
        return true;
    }

    public int getIddoc() {
        return iddoc;
    }

    public void setIddoc(int iddoc) {
        this.iddoc = iddoc;
    }

    public Date getDatreg() {
        return datreg;
    }

    public void setDatreg(Date datreg) {
        this.datreg = datreg;
    }

    public String getDesmov() {
        return desmov;
    }

    public void setDesmov(String desmov) {
        this.desmov = desmov;
    }

    public String getCodcentro() {
        return codcentro;
    }

    public void setCodcentro(String codcentro) {
        this.codcentro = codcentro;
    }
    
    

}
