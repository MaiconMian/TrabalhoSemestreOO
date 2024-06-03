package bancodedados.conexaoProdutos;

import java.sql.*;
import javax.swing.JOptionPane;
import java.util.*;

import bancodedados.conexao.*;
import modelos.*;

public class ProdutoDAO {

    public void create( Produto p ){
        Connection con = ConectionFactory.getConection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT PRODUTOS (NOME, DESCRICAO, MARCA, CATEGORIA, PRECO, CUSTO) VALUES(?, ?, ?, ?, ?, ?)");
            stmt.setString(1, p.getName());
            stmt.setString(2, p.getDescription());
            stmt.setString(3, p.getMarca());
            stmt.setString(4, p.getCategoria());
            stmt.setDouble(5, p.getPreco());
            stmt.setDouble(6, p.getCusto());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível salvar");
            e.printStackTrace();
        } finally {
            ConectionFactory.closeConnection(con, stmt);
        }
    }

    public List<Produto> read (){

        Connection con = ConectionFactory.getConection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Produto> produtos = new ArrayList<>();

        try {

            stmt = con.prepareStatement("SELECT * FROM PRODUTOS");
            rs = stmt.executeQuery();

            while(rs.next()){
                Produto produto = new Produto();
                produto.setID(rs.getLong("PRODUTOS_ID"));
                produto.setName(rs.getString("NOME"));
                produto.setDescription(rs.getString("DESCRICAO"));
                produto.setMarca(rs.getString("MARCA"));
                produto.setCategoria(rs.getString("CATEGORIA"));
                produto.setPreco(rs.getDouble("PRECO"));
                produto.setCusto(rs.getDouble("CUSTO"));
                produtos.add(produto);
            }
        } catch (SQLException e) {

        } finally {
            ConectionFactory.closeConnection(con, stmt, rs);
        }

        return produtos;
    }

    public void update( Produto p ){
        Connection con = ConectionFactory.getConection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE PRODUTOS SET NOME = ?, DESCRICAO = ?, MARCA = ?, CATEGORIA = ?, PRECO = ?, CUSTO = ? WHERE PRODUTOS_ID = ?");
            stmt.setString(1, p.getName());
            stmt.setString(2, p.getDescription());
            stmt.setString(3, p.getMarca());
            stmt.setString(4, p.getCategoria());
            stmt.setDouble(5, p.getPreco());
            stmt.setDouble(6, p.getCusto());
            stmt.setLong(7, p.getID());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível Atualizar");
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            ConectionFactory.closeConnection(con, stmt);
        }
    }

    public void delete( Produto p ){
        Connection con = ConectionFactory.getConection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM PRODUTOS WHERE PRODUTOS_ID = ?");
            stmt.setLong(1, p.getID());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível Atualizar");
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            ConectionFactory.closeConnection(con, stmt);
        }
    }
}
