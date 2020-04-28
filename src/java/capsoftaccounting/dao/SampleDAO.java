/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capsoftaccounting.dao;

import capsoftaccounting.util.BDConnection;
import capsoftaccounting.model.Player;
import capsoftaccounting.util.BDConnectionSample;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import static javax.swing.UIManager.getString;

/**
 *
 * @author informatica
 */
public class SampleDAO {

    /*public class SampleDAO implements GenericDAO<Participante> {*/

    private static final String SELECT_BY_ID = "SELECT id_participante, nome_participante, sobrenome_participante, sexo_participante, nome_municipio, data_nascimento_participante FROM participante p INNER JOIN municipio m ON (p.id_municipio = m.id_municipio) WHERE id_participante = ?;";
    private static final String SELECT_ALL = "SELECT id_participante, nome_participante, sobrenome_participante, sexo_participante, nome_municipio, data_nascimento_participante FROM participante p INNER JOIN municipio m ON (p.id_municipio = m.id_municipio);";

    private static final String Players = "SELECT * FROM PLAYER";
    
    private static final String PLAYERSBYNAME = "SELECT * FROM PLAYER WHERE PLAYER.Name LIKE ?";
    
   

    public SampleDAO() {

    }

    
     public List<Player> findByNamel(String name) {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet resultSet = null;
        List<Player> players = new ArrayList<>();
        try {
            conn = BDConnectionSample.getConnection();
            ps = conn.prepareStatement(PLAYERSBYNAME);
            System.out.println("DAO- findByName ==== Value "+name);
            ps.setString(1, "%"+ name +"%");
            System.out.println(getString("%"+ name +"%"));
            
            resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Player player = new Player();
                System.out.println(resultSet.getInt(1) + "\t"
                        + resultSet.getString(2) + "\t"
                        + resultSet.getString(3) + "\t"
                        + resultSet.getString(4));

                fillWithData(player, resultSet);
                players.add(player);
            }

        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            BDConnection.closeConnection(conn);
        }
        return players;
    }

    
    public List<Player> findAll() {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet resultSet = null;
        List<Player> players = new ArrayList<>();
        try {
            conn = BDConnectionSample.getConnection();
            ps = conn.prepareStatement(Players);
            resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Player player = new Player();
                System.out.println(resultSet.getInt(1) + "\t"
                        + resultSet.getString(2) + "\t"
                        + resultSet.getString(3) + "\t"
                        + resultSet.getString(4));

                fillWithData(player, resultSet);
                players.add(player);
            }

        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            BDConnection.closeConnection(conn);
        }
        return players;
    }

    /*
   
    public Participante findById(Integer id) {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        Participante participante = new Participante();

        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(SELECT_BY_ID);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (!rs.next()) {
                System.err.println("Não foi encontrado nenhum registo com o id: " + id);
            }
            popularComDados(participante, rs);
        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }

        return participante;
    }

  
    
    public List<Participante> findAll() {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        List<Participante> participantes = new ArrayList<>();
        try {
            conn = Conexao.getConnection();
            ps = conn.prepareStatement(SELECT_ALL);
            rs = ps.executeQuery();
            while (rs.next()) {
                Participante participante = new Participante();
                popularComDados(participante, rs);
                participantes.add(participante);
            }

        } catch (SQLException ex) {
            System.err.println("Erro ao ler dados: " + ex.getLocalizedMessage());
        } finally {
            Conexao.closeConnection(conn);
        }
        return participantes;
    }

    private void fillWithData(Participante participante, ResultSet rs) {
        try {
            participante.setIdParticipanete(rs.getInt("id_participante"));
            participante.setNomeParticipante(rs.getString("nome_participante"));
            participante.setSobrenomeParticipante(rs.getString("sobrenome_participante"));
            participante.setDataNascimento(rs.getDate("data_nascimento_participante"));
            participante.setSexo(Sexo.getAbreviatura(rs.getString("sexo_participante")));
            Municipio municipio = new Municipio();
            municipio.setNomeMunicipio(rs.getString("nome_municipio"));
            participante.setMunicipio(municipio);
        

        } catch (SQLException ex) {
            System.err.println("Erro ao carregar dados: " + ex.getLocalizedMessage());
        }
    }
    
    {
     */

    private void fillWithData(Player player, ResultSet rs) {
        try {
            player.setId(rs.getInt("PLAYER_ID"));
            player.setName(rs.getString("Name"));
            player.setAge(rs.getInt("Age"));
            player.setMatches(rs.getInt("Matches"));

        } catch (SQLException ex) {
            System.err.println("Erro ao carregar dados: " + ex.getLocalizedMessage());
        }
    }

   
}