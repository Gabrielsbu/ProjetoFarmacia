package DAO;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Remedio;

public class RemedioDAO {

    public void create(Remedio rem) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO remedio(codBarras, nome, bula, fabricacao, validade, quantidade) VALUES(?, ?, ?, ?, ?, ?)");
            stmt.setInt(1, rem.getCodBarras());
            stmt.setString(2, rem.getNome());
            stmt.setString(3, rem.getBula());
            stmt.setString(4, rem.getFabricacao());
            stmt.setString(5, rem.getValidade());
            stmt.setInt(6, rem.getQuantidade());

            stmt.executeUpdate();

            JOptionPane.showConfirmDialog(null, "Salvo com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(null, "Erro ao salvar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public void remover(Remedio rem, int quantidade) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {

            stmt = con.prepareStatement("SELECT codBarras from remedio WHERE codBarras = ?");
            stmt.setInt(1, rem.getCodBarras());
            ResultSet resultado = stmt.executeQuery();

            if (resultado.next()) {
                stmt = con.prepareStatement("UPDATE remedio SET quantidade  = quantidade -? WHERE codBarras = ?");
                stmt.setInt(1, quantidade);
                stmt.setInt(2, rem.getCodBarras());
                stmt.executeUpdate();
                JOptionPane.showConfirmDialog(null, "Unidades removidas");
            } else {
                JOptionPane.showConfirmDialog(null, "Remédio não encontrado");
            }

        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(null, "Algo deu errado!: " + ex);

        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public void adicionar(Remedio rem, int quantidade) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {

            stmt = con.prepareStatement("SELECT codBarras from remedio WHERE codBarras = ?");
            stmt.setInt(1, rem.getCodBarras());
            ResultSet resultado = stmt.executeQuery();

            if (resultado.next()) {
                stmt = con.prepareStatement("UPDATE remedio SET quantidade  = quantidade +? WHERE codBarras = ?");
                stmt.setInt(1, quantidade);
                stmt.setInt(2, rem.getCodBarras());
                stmt.executeUpdate();
                JOptionPane.showConfirmDialog(null, "Unidades Adicionadas");
            } else {
                JOptionPane.showConfirmDialog(null, "Remédio não encontrado");
            }

        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(null, "Algo deu errado!: " + ex);

        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
    public void removUn(Remedio rem, int quantidade) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {

            stmt = con.prepareStatement("SELECT codBarras from remedio WHERE codBarras = ?");
            stmt.setInt(1, rem.getCodBarras());
            ResultSet resultado = stmt.executeQuery();

            if (resultado.next()) {
                stmt = con.prepareStatement("UPDATE remedio SET quantidade  = quantidade -? WHERE codBarras = ?");
                stmt.setInt(1, quantidade);
                stmt.setInt(2, rem.getCodBarras());
                stmt.executeUpdate();
                JOptionPane.showConfirmDialog(null, "Unidades Removidas");
            } else {
                JOptionPane.showConfirmDialog(null, "Remédio não encontrado");
            }

        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(null, "Algo deu errado!: " + ex);

        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    
    public void Atualizar(Remedio rem, String nome, int codBarras, String bula, String fabricacao, String validade) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {

            stmt = con.prepareStatement("SELECT nome from remedio WHERE nome = ?");
            stmt = con.prepareStatement("SELECT codBarras from remedio WHERE codBarras = ?");
            stmt = con.prepareStatement("SELECT bula from remedio WHERE bula = ?");
            stmt = con.prepareStatement("SELECT fabricacao from remedio WHERE fabricacao = ?");
            stmt = con.prepareStatement("SELECT validade from remedio WHERE validade = ?");
            stmt.setString(1, rem.getNome());
            stmt.setInt(2, rem.getCodBarras());
            stmt.setString(3, rem.getBula());
            stmt.setString(4, rem.getFabricacao());
            stmt.setString(5, rem.getValidade());
            ResultSet resultado = stmt.executeQuery();

            if (resultado.next()) {
                stmt = con.prepareStatement("UPDATE remedio SET nome  = nome ?");
                stmt = con.prepareStatement("UPDATE remedio SET codBarras  = codBarras?");
                stmt = con.prepareStatement("UPDATE remedio SET bula  = bula?");
                stmt = con.prepareStatement("UPDATE remedio SET fabricacao  = fabricacao?");
                stmt = con.prepareStatement("UPDATE remedio SET validade  = validade?");
                stmt.setString(1, rem.getNome());
                stmt.setInt(2, rem.getCodBarras());
                stmt.setString(3, rem.getBula());
                stmt.setString(4, rem.getFabricacao());
                stmt.setString(5, rem.getValidade());

                stmt.executeUpdate();
                JOptionPane.showConfirmDialog(null, "Dados Alterados");
            } else {
                JOptionPane.showConfirmDialog(null, "Erro na alteração");
            }

        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(null, "Algo deu errado!: " + ex);

        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

}
