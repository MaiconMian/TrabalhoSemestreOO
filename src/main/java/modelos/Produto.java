package modelos;

public class Produto implements Comparable<Produto> {
    private String nome;
    private String descricao;
    private String marca;
    private String categoria;
    private double preco;
    private double custo;
    private long ID;

    public Produto(){

    }

    public Produto(String nome, String descricao, String categoria, String marca, double preco, double custo){
        this.nome = nome;
        this.descricao = descricao;
        this.categoria = categoria;
        this.marca = marca;
        this.preco = preco;
        this.custo = custo;
    }

    public void setID(long ID){
        this.ID = ID;
    }

    public long getID(){
        return ID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String name) {
        this.nome = name;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getCusto() {
        return custo;
    }

    public void setCusto(double custo) {
        this.custo = custo;
    }

    @Override
    public int compareTo(Produto o) {
        return this.nome.compareTo(o.nome);
    }
}