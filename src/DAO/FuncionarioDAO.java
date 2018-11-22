
package DAO;

import connection.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Funcionario;
import view.Principal;



public class FuncionarioDAO {
    public void create(Funcionario func){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
         try {
            stmt = con.prepareStatement("insert into funcionario (cpf, nome, endereco, telefone, cidade, email, senha, sexo) values(?,?,?,?,?,?,?,?)");
            stmt.setString(1, func.getCpf());
            stmt.setString(2, func.getNome());
            stmt.setString(3, func.getEndereco());
            stmt.setString(4, func.getTelefone());
            stmt.setString(5, func.getCidade());
            stmt.setString(6, func.getEmail());
            stmt.setString(7, func.getSenha());
            stmt.setString(8, func.getSexo());
            
            stmt.executeUpdate();
           JOptionPane.showMessageDialog(null, "Salvo com sucesso","Alerta",JOptionPane.WARNING_MESSAGE);
          
           
        } catch (SQLException ex) {
               JOptionPane.showConfirmDialog(null, "Erro ao salvar: " + ex);
        } finally{
             ConnectionFactory.closeConnection(con, stmt);
         }
        
        
        
    }
    
   public void remover(Funcionario funcionario){

      String sql = "DELETE FROM funcionario WHERE cpf = ? ";
      Connection con = ConnectionFactory.getConnection();
      PreparedStatement stmt = null;
      
     try {
         
           stmt = con.prepareStatement("SELECT cpf from funcionario WHERE cpf = ?");
           stmt.setString(1, funcionario.getCpf()); 
           ResultSet resultado = stmt.executeQuery();
        
           if(resultado.next()){   
                stmt = con.prepareStatement(sql);
                stmt.setString(1, funcionario.getCpf());      
                stmt.executeUpdate();
                JOptionPane.showConfirmDialog(null, "Adeus, até mais");
            } else{
                JOptionPane.showConfirmDialog(null, "Funcionário não localizado, verifique seu CPF! ");
            }
           
           
                 } catch (SQLException ex) {
        JOptionPane.showConfirmDialog(null, "Erro! " + ex);
        
     }finally{
         ConnectionFactory.closeConnection(con, stmt);
     }
 }

    
}
