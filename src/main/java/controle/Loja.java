package controle;
import java.util.*;

import conexaoSQL.DAO.*;
import modelos.Produto;

public class Loja {

    private static List<Produto> produtos;
    public static void readtTable(){
        ProdutoDAO pdao = new ProdutoDAO();
        produtos = new LinkedList<>();
        produtos = pdao.read(produtos);
    }

    public static List<Produto> showTable(){
        readtTable();
        Collections.sort(produtos);
        return produtos;
    }

    public static void create(String nome, String descricao, String categoria, String marca, double preco, double custo){
        Produto p = new Produto(nome, descricao, categoria, marca, preco, custo);

        ProdutoDAO pdao = new ProdutoDAO();
        pdao.create(p);
    }
    public static void modificar (Long ID, String nome, String descricao, String categoria, String marca, double preco, double custo){

        ProdutoDAO pdao = new ProdutoDAO();

        Produto analisado = null;
        for (Produto p : produtos){
            if (p.getID() == ID){
                analisado = p;
                break;
            }
        }

        analisado.setNome(nome);
        analisado.setDescricao(descricao);
        analisado.setCategoria(categoria);
        analisado.setMarca(marca);
        analisado.setPreco(preco);
        analisado.setCusto(custo);

        pdao.update(analisado);
    }

    public static void remover (Long ID){
        ProdutoDAO pdao = new ProdutoDAO();
        Produto analisado = null;
        for (Produto p : produtos){
            if (p.getID() == ID){
                analisado = p;
                break;
            }
        }

        pdao.delete(analisado);
    }
}
