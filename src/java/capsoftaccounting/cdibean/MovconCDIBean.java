/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capsoftaccounting.cdibean;

import capsoftaccounting.dao.MovconDAO;
import capsoftaccounting.model.Movcon;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author informatica
 */
@Named(value = "movconCDIBean")
@SessionScoped
public class MovconCDIBean implements Serializable {

    MovconDAO movconDAO = new MovconDAO();
    Movcon movcon = new Movcon();
    List<Movcon> movcons = new ArrayList<>();
    List<Movcon> searchedMovcons = new ArrayList<>();

    private String descrizione;
    private Integer anno;

    @PostConstruct
    public void init() {
        //movcons = movconDAO.findAll();
    }

    public MovconDAO getMovconDAO() {
        return movconDAO;
    }

    public void setMovconDAO(MovconDAO movconDAO) {
        this.movconDAO = movconDAO;
    }

    public List<Movcon> getMovcons() {
        return movcons;
    }

    public void setMovcons(List<Movcon> movcons) {
        this.movcons = movcons;
    }

    //used
    public List<Movcon> listMovimentiByAnno(ActionEvent event) {
        searchedMovcons = movconDAO.findMovconByDate(anno);
        return searchedMovcons;

    }
//used

    public List<Movcon> listMovimentiByDescrizone(ActionEvent event) {
        searchedMovcons = movconDAO.findMovconByDescrizoine(descrizione);
        return searchedMovcons;

    }

    public void selectListenerMoviconAutoComplete(SelectEvent event) {
        String eventValue = event.getObject().toString();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Value:\t" + eventValue));
        //  searchedMovcons = movconDAO.findMovconByDescrizoine(eventValue);

    }

    public Double sommaDare(Integer orderNumber) {
        return movconDAO.sommaDare(orderNumber);

    }

    public Double sommaAvere(Integer orderNumber) {
        return movconDAO.sommaAvere(orderNumber);

    }

    public Double getSumaAvere() {
        Double valore = 0.0;
        Movcon mv = new Movcon();
        for (Movcon it : searchedMovcons) {
            valore += it.getAvere();
            mv.setTotaleAvere(valore);
        }
        return valore;
    }

    public Double getSumaDare() {
        Double valore = 0.0;

        for (Movcon it : searchedMovcons) {
            valore += it.getDare();
            movcon.setTotaleDare(valore);
        }
        return valore;
    }

    public List<Movcon> queryByDescrizoneAutoComplete(String descrizione) {
        List<Movcon> lista = new ArrayList<>();
        for (Movcon mv : movconDAO.findMovconByDescrizoine(descrizione)) {
            if (mv.getSottoc().getDescrizione().toLowerCase().startsWith(descrizione.toLowerCase())) {
                lista.add(mv);
            }
        }

        /* lista = movconDAO.findMovconByDescrizoine(descrizione);
        for (Movcon object : lista) {
            System.out.println("Value ==== ID DOC" + object.getIddoc());
        }
        System.out.println("======>>>>"+descrizione);*/
        return lista;
    }

    public List<Movcon> getContoByDescrizone(String descrizione) {
        searchedMovcons = movconDAO.findMovconByDescrizoine(descrizione);
        return searchedMovcons;

    }

    public void selectListenerDescrizione(SelectEvent event) {
        Movcon mv = (Movcon) event.getObject();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Conto:\t" + mv.getIddoc() + "\t" + mv.getSottoc().getDescrizione()));
        getContoByDescrizone(mv.getSottoc().getDescrizione());

    }

    public List<Movcon> getSearchedMovcons() {
        return searchedMovcons;
    }

    public void setSearchedMovcons(List<Movcon> searchedMovcons) {
        this.searchedMovcons = searchedMovcons;
    }

    public Movcon getMovcon() {
        return movcon;
    }

    public void setMovcon(Movcon movcon) {
        this.movcon = movcon;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public Integer getAnno() {
        return anno;
    }

    public void setAnno(Integer anno) {
        this.anno = anno;
    }

}
