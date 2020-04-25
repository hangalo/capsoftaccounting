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

/**
 *
 * @author informatica
 */
@Named(value = "movconCDIBean")
@RequestScoped
public class MovconCDIBean {

     MovconDAO movconDAO = new MovconDAO();

    List<Movcon> movcons = new ArrayList<>();
    
    
    @PostConstruct
    public void init() {
        movcons = movconDAO.findAll();
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
    
    
    
}
