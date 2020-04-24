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

/**
 *
 * @author informatica
 */
@Named(value = "playerMbean")
@RequestScoped
public class PlayerMbean {

    SampleDAO sampleDAO = new SampleDAO();

    List<Player> players = new ArrayList<>();

    @PostConstruct
    public void init() {
        players = sampleDAO.findAll();
    }

    public List<Player> getPlayers() {
         players = sampleDAO.findAll();
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

   
    
}
