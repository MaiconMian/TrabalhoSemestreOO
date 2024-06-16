package tela;

import controle.Loja;
import excecoes.ExcecaoCamposObrigatoriosVazios;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import modelos.Produto;

public class PagEdicaoController {
    @FXML
    private TextField textProdutoEdicao;
    @FXML
    private TextField textPrecoEdicao;
    @FXML
    private TextField textCustoEdicao;
    @FXML
    private TextField textCategoriaEdicao;
    @FXML
    private TextField textDescricaoEdicao;
    @FXML
    private TextField textMarcaEdicao;
    private Produto produtoParaEditar;



    public void setProdutoEditar(Produto produto) {
        this.produtoParaEditar = produto;
        textProdutoEdicao.setText(produto.getNome());
        textPrecoEdicao.setText(String.valueOf(produto.getPreco()));
        textCustoEdicao.setText(String.valueOf(produto.getCusto()));
        textCategoriaEdicao.setText(produto.getCategoria());
        textMarcaEdicao.setText(produto.getMarca());
        textDescricaoEdicao.setText(produto.getDescricao());
    }

    @FXML
    protected void changeScreenToMenu(){
        Main.chanceScreen("pagInicial", null);
    }

    @FXML
    protected void buttonSalvar(){
        try{
            String produto = textProdutoEdicao.getText();
            String preco = textPrecoEdicao.getText();
            String custo = textCustoEdicao.getText();
            String marca = textMarcaEdicao.getText();
            String categoria = textCategoriaEdicao.getText();
            String descricao = textDescricaoEdicao.getText();

            if (produto == null || produto.trim().isEmpty() || preco == null || preco.trim().isEmpty()){
                throw new ExcecaoCamposObrigatoriosVazios("Campos obriatórios não preenchidos");
            }

            double custo_, preco_;

            if (custo != null){
                custo_ = Double.parseDouble(custo);
            } else {
                custo_ = 0.0;
            }
            if (preco != null){
                preco_ = Double.parseDouble(preco);
            } else {
                preco_ = 0.0;
            }

            Loja.modificar(produtoParaEditar.getID(), produto, descricao, categoria, marca, preco_, custo_);
            Main.chanceScreen("pagInicial", null);

        } catch (ExcecaoCamposObrigatoriosVazios ex){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle(ex.getMessage());
            alert.setHeaderText("Campos obrigatórios não preenchidos");
            alert.setContentText("Por favor, preencha os campos Produto e Preço.");
            alert.showAndWait();
        }
    }
}