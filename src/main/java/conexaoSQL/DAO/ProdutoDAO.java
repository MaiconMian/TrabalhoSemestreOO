package conexaoSQL.DAO;

import java.sql.*;
import java.util.*;

import conexaoSQL.FabricaConecao;
import modelos.*;

public class ProdutoDAO {

    public void create(Produto p){
        Connection con = FabricaConecao.getConection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT PRODUTOS (NOME, DESCRICAO, MARCA, CATEGORIA, PRECO, CUSTO) VALUES(?, ?, ?, ?, ?, ?)");
            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getDescricao());
            stmt.setString(3, p.getMarca());
            stmt.setString(4, p.getCategoria());
            stmt.setDouble(5, p.getPreco());
            stmt.setDouble(6, p.getCusto());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            FabricaConecao.closeConnection(con, stmt);
        }
    }

    public List<Produto> read (List<Produto> produtos){

        Connection con = FabricaConecao.getConection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement("SELECT * FROM PRODUTOS");
            rs = stmt.executeQuery();

            while(rs.next()){
                Produto produto = new Produto();
                produto.setID(rs.getLong("PRODUTOS_ID"));
                produto.setNome(rs.getString("NOME"));
                produto.setDescricao(rs.getString("DESCRICAO"));
                produto.setMarca(rs.getString("MARCA"));
                produto.setCategoria(rs.getString("CATEGORIA"));
                produto.setPreco(rs.getDouble("PRECO"));
                produto.setCusto(rs.getDouble("CUSTO"));
                produtos.add(produto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            FabricaConecao.closeConnection(con, stmt, rs);
        }

        return produtos;
    }

    public void update( Produto p ){
        Connection con = FabricaConecao.getConection();
        PreparedStatement stmt = null;

        try {

            stmt = con.prepareStatement("UPDATE PRODUTOS SET NOME = ?, DESCRICAO = ?, MARCA = ?, CATEGORIA = ?, PRECO = ?, CUSTO = ? WHERE PRODUTOS_ID = ?");
            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getDescricao());
            stmt.setString(3, p.getMarca());
            stmt.setString(4, p.getCategoria());
            stmt.setDouble(5, p.getPreco());
            stmt.setDouble(6, p.getCusto());
            stmt.setLong(7, p.getID());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            FabricaConecao.closeConnection(con, stmt);
        }
    }

    public void delete( Produto p ){
        Connection con = FabricaConecao.getConection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM PRODUTOS WHERE PRODUTOS_ID = ?");
            stmt.setLong(1, p.getID());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            FabricaConecao.closeConnection(con, stmt);
        }
    }
}
