package modelos;
import java.util.*;
import modelos.*;
import bancodedados.conexaoProdutos.*;
import bancodedados.conexao.*;

public class Loja {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Produto p = new Produto();

        String leitor;
        Double leitor_;

        System.out.println("Digite o nome do produto:");
        leitor = sc.nextLine();
        p.setName(leitor);

        System.out.println("Digite uma breve descrição:");
        leitor = sc.nextLine();
        p.setDescription(leitor);

        System.out.println("Digite a marca do produto:");
        leitor = sc.nextLine();
        p.setMarca(leitor);

        System.out.println("Digite a categoria do produto:");
        leitor = sc.nextLine();
        p.setCategoria(leitor);

        System.out.println("Digite o preço do produto:");
        leitor_ = sc.nextDouble();
        p.setPreco(leitor_);

        System.out.println("Digite o custo do produto:");
        leitor_ = sc.nextDouble();
        p.setCusto(leitor_);

        ProdutoDAO dao = new ProdutoDAO();

        // testes

        dao.create(p);
        readtTable();
        modificar((long)2);
        remover((long)2);
    }

    public static void readtTable(){

        ProdutoDAO pdao = new ProdutoDAO();

        for (Produto p : pdao.read()){
            System.out.println("nome...:" + p.getName());
            System.out.println("Descricao...:" + p.getDescription());
            System.out.println("Categoria...:" + p.getCategoria());
            System.out.println("Marca...:" + p.getMarca());
            System.out.println("Preco...:" + p.getPreco());
            System.out.println("Custo...:" + p.getCusto());
        }
    }

    public static void modificar (Long ID){
        ProdutoDAO pdao = new ProdutoDAO();
        Produto analisado = null;
        for (Produto p : pdao.read()){
            if (p.getID() == ID){
                analisado = p;
                break;
            }
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o novo custo");
        analisado.setCusto(sc.nextLong());
        pdao.update(analisado);
        readtTable();

    }

    public static void remover (Long ID){
        ProdutoDAO pdao = new ProdutoDAO();
        Produto analisado = null;
        for (Produto p : pdao.read()){
            if (p.getID() == ID){
                analisado = p;
                break;
            }
        }

        pdao.delete(analisado);
        readtTable();
    }
}
