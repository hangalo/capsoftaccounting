/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capsoftaccounting.cdibean;

import capsoftaccounting.dao.SampleDAO;
import capsoftaccounting.model.Player;
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
@Named(value = "playerMbean")
@RequestScoped
public class PlayerMbean {

    SampleDAO sampleDAO = new SampleDAO();

    List<Player> players = new ArrayList<>();
    Player player = new Player();
    
    private String descrizione;

    @PostConstruct
    public void init() {
       // players = sampleDAO.findAll();
    }

    public List<Player> getPlayers() {
       //  players = sampleDAO.findAll();
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    
    
    
   
     public List<Player> queryByDescrizoneAutoComplete(String descrizione) {
        List<Player> lista = new ArrayList<>();
        for (Player mv : sampleDAO.findByNamel(descrizione)) {
            if (mv.getName().toLowerCase().startsWith(descrizione.toLowerCase())) {
                lista.add(mv);
            }
        }

        return lista;
    }

    public List<Player> getContoByDescrizone(String descrizione) {
        players = sampleDAO.findByNamel(descrizione);
        return players;

    }
    
    
    public List<Player> listContoByDescrizone(ActionEvent actionEvent) {
        System.out.println("Passed =====>>> Sucess");
        System.out.println("Value =====>>> " +descrizione);
        players = sampleDAO.findByNamel(descrizione);
        return players;

    }

    
    public void selectListenerDescrizione(SelectEvent event) {
        Player mv = (Player) event.getObject();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Conto:\t" + mv.getName() + "\t" + mv.getAge()));
        getContoByDescrizone(mv.getName());

    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
    
    
    
    
}
