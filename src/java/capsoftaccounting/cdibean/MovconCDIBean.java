/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capsoftaccounting.cdibean;

import capsoftaccounting.dao.MovconDAO;
import capsoftaccounting.model.Movcon;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author informatica
 */
@Named(value = "movconCDIBean")
@RequestScoped
public class MovconCDIBean {

    MovconDAO movconDAO = new MovconDAO();
    Movcon movcon = new Movcon();
    List<Movcon> movcons = new ArrayList<>();
    List<Movcon> searchedMovcons = new ArrayList<>();

    private String descrizione;

    @PostConstruct
    public void init() {
     ///  movcons = movconDAO.findAll();
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

    public List<Movcon> queryByDescrizoneAutoComplete(String descrizione) {
        List<Movcon> lista = new ArrayList<>();
        for (Movcon mv : movconDAO.findMovconByDescrizoine(descrizione)) {
            if (mv.getSottoc().getDescrizione().toLowerCase().startsWith(descrizione.toLowerCase())) {
                lista.add(mv);
            }
        }

        return lista;
    }

    public List<Movcon> getContoByDescrizone(String descrizione) {
        searchedMovcons = movconDAO.findMovconByDescrizoine(descrizione);
        return searchedMovcons;

    }

    public List<Movcon> listContoByDescrizone(ActionEvent event) {
        System.err.println("Passs Sucess");
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

}
