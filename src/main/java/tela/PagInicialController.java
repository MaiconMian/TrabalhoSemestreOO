package tela;

import controle.Loja;
import excecoes.ExcecaoNenhumProdutoSelecionado;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import modelos.Produto;

import java.util.List;
import java.util.ArrayList;

public class PagInicialController {

    @FXML
    public TableView<Produto> tvProdutos;

    @FXML
    private TextField txtPesquisa;



    private static final int ITEMS_PER_PAGE = 10;

    @FXML
    private Pagination pagination;

    private ObservableList<Produto> allProducts;

    


    @FXML
    protected void removerProdutoSelecionado(){
        try{
            if (tvProdutos.getSelectionModel().getSelectedItem() != null){
                Produto produtoSelecionado = tvProdutos.getSelectionModel().getSelectedItem();
                Loja.remover(produtoSelecionado.getID());
                atualiza();
            } else {
                throw new ExcecaoNenhumProdutoSelecionado("Nenhum produto foi selecionado");
            }

        } catch (ExcecaoNenhumProdutoSelecionado ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro: " + ex.getMessage());
            alert.setContentText("Por favor, selecione algum item para remover.");
            alert.showAndWait();
        }

    }

    @FXML
    protected void initialize() {
        TableColumn<Produto, String> colNome = new TableColumn<>("Nome");
        colNome.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNome()));

        TableColumn<Produto, String> colDescricao = new TableColumn<>("Descrição");
        colDescricao.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getDescricao()));

        TableColumn<Produto, String> colMarca = new TableColumn<>("Marca");
        colMarca.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getMarca()));

        TableColumn<Produto, String> colCategoria = new TableColumn<>("Categoria");
        colCategoria.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getCategoria()));

        TableColumn<Produto, Double> colPreco = new TableColumn<>("Preço");
        colPreco.setCellValueFactory(data -> new SimpleDoubleProperty(data.getValue().getPreco()).asObject());

        TableColumn<Produto, Double> colCusto = new TableColumn<>("Custo");
        colCusto.setCellValueFactory(data -> new SimpleDoubleProperty(data.getValue().getCusto()).asObject());

        tvProdutos.getColumns().addAll(colNome, colDescricao, colMarca, colCategoria, colPreco, colCusto);

        atualiza();
    }

    private void atualizaTabela(int pageIndex) {
        int start = pageIndex * ITEMS_PER_PAGE;
        int end = Math.min(start + ITEMS_PER_PAGE, allProducts.size());
        tvProdutos.getItems().setAll(allProducts.subList(start, end));
    }

    public void atualiza() {
        tvProdutos.getItems().clear();
        List<Produto> produtos = Loja.showTable();
        tvProdutos.getItems().addAll(produtos);

        // Inicializa a lista de produtos
        allProducts = FXCollections.observableArrayList(Loja.showTable());
        // Configura a paginação
        int pageCount = (int) Math.ceil((double) allProducts.size() / ITEMS_PER_PAGE);
        pagination.setPageCount(pageCount);
        pagination.currentPageIndexProperty().addListener((obs, oldIndex, newIndex) -> atualizaTabela(newIndex.intValue()));
    }
    @FXML
    public void pesquisa() {
        String nomeProduto = txtPesquisa.getText();
        if (nomeProduto == null || nomeProduto.trim().isEmpty()){
            atualiza();
        } else {
            List<Produto> produtos = Loja.showTable();
            List<Produto> produtosFiltrados = new ArrayList<>();

            for (Produto p : produtos) {

                String nomeProdutoMinusculo = nomeProduto.toLowerCase();
                String nomeProdutoTabela = p.getNome().toLowerCase();

                if (nomeProdutoTabela.contains(nomeProdutoMinusculo)) {
                    produtosFiltrados.add(p);
                }
            }

            tvProdutos.getItems().clear();
            tvProdutos.getItems().addAll(produtosFiltrados);
        }
    }


    @FXML
    protected void changeScreenToCadastrar(){
        Main.chanceScreen("pagCadastro", null);
    }
    @FXML
    protected void changeScreenToEdicao(){
        try{
            if(tvProdutos.getSelectionModel().getSelectedItem() != null){
                Produto produtoSelecionado = tvProdutos.getSelectionModel().getSelectedItem();
                System.out.println("Peguei o produto com ID" + produtoSelecionado.getID() + "E nome" + produtoSelecionado.getNome());
                Main.chanceScreen("pagEdicao", produtoSelecionado);
            } else {
                throw new ExcecaoNenhumProdutoSelecionado("Nenhum Produto Selecionado");
            }
        } catch (ExcecaoNenhumProdutoSelecionado ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro: " + ex.getMessage());
            alert.setContentText("Por favor, selecione algum item para editar.");
            alert.showAndWait();
        }

    }


}