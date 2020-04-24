/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capsoftaccounting.dao;

/**
 *
 * @author viceeconomo
 */
public class MovconDAO {
    private static final String SELECT_BY_YEAR = "  SELECT giocon.iddoc,   \n" +
"         giocon.datreg,   \n" +
"         giocon.desmov,   \n" +
"         giocon.codcentro,   \n" +
"         movcon.iddoc,   \n" +
"         movcon.idrig,   \n" +
"         movcon.keyconto,   \n" +
"         sottoc.des,   \n" +
"         movcon.dare,   \n" +
"         movcon.avere,   \n" +
"         movcon.note  \n" +
"    FROM giocon,   \n" +
"         movcon,   \n" +
"         sottoc  \n" +
"   WHERE ( movcon.keyconto = sottoc.cod ) and  \n" +
"         ( giocon.iddoc = movcon.iddoc ) and  \n" +
"         ( ( giocon.anno = ? ) )   \n" +
"ORDER BY giocon.iddoc ASC,   \n" +
"         giocon.datreg ASC,   \n" +
"         movcon.idrig ASC ";

    private static final String SELECT_BY_YEAR_DESC = "  SELECT giocon.iddoc,   \n" +
"         giocon.datreg,   \n" +
"         giocon.desmov,   \n" +
"         giocon.codcentro,   \n" +
"         movcon.iddoc,   \n" +
"         movcon.idrig,   \n" +
"         movcon.keyconto,   \n" +
"         sottoc.des,   \n" +
"         movcon.dare,   \n" +
"         movcon.avere,   \n" +
"         movcon.note  \n" +
"    FROM giocon,   \n" +
"         movcon,   \n" +
"         sottoc  \n" +
"   WHERE ( movcon.keyconto = sottoc.cod ) and  \n" +
"         ( giocon.iddoc = movcon.iddoc ) and  \n" +
"         ( ( giocon.anno = ? ) )   \n" +
"ORDER BY giocon.iddoc ASC,   \n" +
"         giocon.datreg ASC,   \n" +
"         movcon.idrig ASC ";
    
}
