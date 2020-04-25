/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capsoftaccounting.dao;

import capsoftaccounting.model.Giocon;
import capsoftaccounting.model.Movcon;
import capsoftaccounting.model.Player;
import capsoftaccounting.model.Sottoc;
import capsoftaccounting.util.BDConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author viceeconomo
 */
public class MovconDAO {
    
    private static final String SELECT_ALL = "  SELECT giocon.iddoc,  "
            + "         giocon.datreg,"
            + "         giocon.desmov,"
            + "         giocon.codcentro,"
            + "         movcon.iddoc,"
            + "         movcon.idrig,"
            + "         movcon.keyconto,"
            + "         sottoc.des,"
            + "         movcon.dare,"
            + "         movcon.avere,"
            + "         movcon.note"
            + "    FROM giocon,"
            + "         movcon,"
            + "         sottoc"
            + "   WHERE ( movcon.keyconto = sottoc.cod ) and"
            + "         ( giocon.iddoc = movcon.iddoc ) and"
            + "         ( ( giocon.anno = ? ) )"
            + "ORDER BY giocon.iddoc ASC,"
            + "         giocon.datreg ASC,n";  
    
    private static final String SELECT_BY_YEAR = "  SELECT giocon.iddoc,  "
            + "         giocon.datreg,"
            + "         giocon.desmov,"
            + "         giocon.codcentro,"
            + "         movcon.iddoc,"
            + "         movcon.idrig,"
            + "         movcon.keyconto,"
            + "         sottoc.des,"
            + "         movcon.dare,"
            + "         movcon.avere,"
            + "         movcon.note"
            + "    FROM giocon,"
            + "         movcon,"
            + "         sottoc"
            + "   WHERE ( movcon.keyconto = sottoc.cod ) and"
            + "         ( giocon.iddoc = movcon.iddoc ) and"
            + "         ( ( giocon.anno = ? ) )"
            + "ORDER BY giocon.iddoc ASC,"
            + "         giocon.datreg ASC,n"
            + "         movcon.idrig ASC ";
    
    private static final String SELECT_BY_YEAR_DESC = "  SELECT giocon.iddoc,"
            + "         giocon.datreg,"
            + "         giocon.desmov,"
            + "         giocon.codcentro,"
            + "         movcon.iddoc,"
            + "         movcon.idrig,"
            + "         movcon.keyconto,"
            + "         sottoc.des,"
            + "         movcon.dare,"
            + "         movcon.avere,"
            + "         movcon.note"
            + "    FROM giocon,"
            + "         movcon,"
            + "         sottoc"
            + "   WHERE ( movcon.keyconto = sottoc.cod ) and"
            + "         ( giocon.iddoc = movcon.iddoc ) and"
            + "         ( ( giocon.anno = ? ) )"
            + "ORDER BY giocon.iddoc ASC,"
            + "         giocon.datreg ASC,"
            + "         movcon.idrig ASC ";
    
    
    
    
    public List<Movcon> findAll() {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
         List<Movcon> movcons = new ArrayList<>();
        try {
            conn = BDConnection.getConnection();
            ps = conn.prepareStatement(SELECT_ALL);                              
            rs = ps.executeQuery();
            while (rs.next()) {
                Movcon movcon = new Movcon();
                fillWithData(movcon, rs);
                movcons.add(movcon);
            }

        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            BDConnection.closeConnection(conn);
        }
        return movcons;
    }
    
    public List<Movcon> findMovconByDate(Date data) {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
         List<Movcon> movcons = new ArrayList<>();
        try {
            conn = BDConnection.getConnection();
            ps = conn.prepareStatement(SELECT_BY_YEAR);
            ps.setDate(1,  new java.sql.Date(data.getTime()));
            
           
            rs = ps.executeQuery();
            while (rs.next()) {
                Movcon movcon = new Movcon();
                fillWithData(movcon, rs);
                movcons.add(movcon);
            }

        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            BDConnection.closeConnection(conn);
        }
        return movcons;
    }
    
    
    
    
    
    private void fillWithData(Movcon movcon, ResultSet rs) {
        try {
                                  
            Giocon giocon = new Giocon();
            giocon.setIddoc(rs.getInt("iddoc"));
            giocon.setDatreg(rs.getDate("datreg"));
            giocon.setDesmov(rs.getString("desmov"));
            giocon.setCodcentro(rs.getString("codcentro"));
            
            Sottoc sottoc = new Sottoc();
            sottoc.setDescrizione(rs.getString("des"));
            
            movcon.setGiocon(giocon);
            movcon.setIddoc(rs.getInt("iddoc"));
            movcon.setIdrig(rs.getInt("idrig"));
            movcon.setKeyconto(rs.getString("keyconto"));
            movcon.setSottoc(sottoc);            
            movcon.setDare(rs.getDouble("dare"));
            movcon.setAvere(rs.getDouble("avere"));
            movcon.setNote(rs.getString("note"));
            
        } catch (SQLException ex) {
            System.err.println("Error ond data load: " + ex.getLocalizedMessage());
        }
    }
    
}
