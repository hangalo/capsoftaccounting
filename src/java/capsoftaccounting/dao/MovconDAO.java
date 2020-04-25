/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capsoftaccounting.dao;

import capsoftaccounting.model.Movcon;
import capsoftaccounting.model.Player;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author viceeconomo
 */
public class MovconDAO {

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

    private void fillWithData(Movcon movcon, ResultSet rs) {
        try {
            movcon.setIddoc(rs.getInt("iddoc"));
            movcon.setIdrig(rs.getInt("idrig"));
            movcon.setKeyconto(rs.getString("keyconto"));
            movcon.setDare(rs.getDouble("dare"));
            movcon.setAvere(rs.getDouble("avere"));
            movcon.setNote(rs.getString("note"));

        } catch (SQLException ex) {
            System.err.println("Error ond data load: " + ex.getLocalizedMessage());
        }
    }

}
