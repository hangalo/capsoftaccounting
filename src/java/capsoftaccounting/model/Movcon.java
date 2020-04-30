/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capsoftaccounting.model;

import java.util.Objects;

/**
 *
 * @author viceeconomo
 */
public class Movcon {
        private Integer iddoc;
        private Integer idrig;
        private String keyconto;
        private Double dare;
        private Double avere;
        private String note; 
        private Sottoc sottoc;
        private Giocon giocon;
        
        public Double totaleAvere;
        public Double totaleDare;

    public Movcon() {
    }

    public Movcon(Integer iddoc, Integer idrig, String keyconto, Double dare, Double avere, String note, Sottoc sottoc, Giocon giocon) {
        this.iddoc = iddoc;
        this.idrig = idrig;
        this.keyconto = keyconto;
        this.dare = dare;
        this.avere = avere;
        this.note = note;
        this.sottoc = sottoc;
        this.giocon = giocon;
    }

    public Sottoc getSottoc() {
        return sottoc;
    }

    public void setSottoc(Sottoc sottoc) {
        this.sottoc = sottoc;
    }


    public Integer getIddoc() {
        return iddoc;
    }

    public void setIddoc(Integer iddoc) {
        this.iddoc = iddoc;
    }

    public Integer getIdrig() {
        return idrig;
    }

    public void setIdrig(Integer idrig) {
        this.idrig = idrig;
    }

    public String getKeyconto() {
        return keyconto;
    }

    public void setKeyconto(String keyconto) {
        this.keyconto = keyconto;
    }

    public Double getDare() {
        return dare;
    }

    public void setDare(Double dare) {
        this.dare = dare;
    }

    public Double getAvere() {
        return avere;
    }

    public void setAvere(Double avere) {
        this.avere = avere;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Giocon getGiocon() {
        return giocon;
    }

    public void setGiocon(Giocon giocon) {
        this.giocon = giocon;
    }

    public Double getTotaleAvere() {
        return totaleAvere;
    }

    public void setTotaleAvere(Double totaleAvere) {
        this.totaleAvere = totaleAvere;
    }

    public Double getTotaleDare() {
        return totaleDare;
    }

    public void setTotaleDare(Double totaleDare) {
        this.totaleDare = totaleDare;
    }

    
    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.iddoc);
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
        final Movcon other = (Movcon) obj;
        if (!Objects.equals(this.iddoc, other.iddoc)) {
            return false;
        }
        return true;
    }
    
    
        
        

}
