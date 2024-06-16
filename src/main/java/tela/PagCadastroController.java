package tela;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import controle.*;
import java.lang.Exception;

public class PagCadastroController {
    @FXML
    private TextField textProdutoCadastro;
    @FXML
    private TextField textPrecoCadastro;
    @FXML
    private TextField textCustoCadastro;
    @FXML
    private TextField textCategoriaCadastro;
    @FXML
    private TextField textDescricaoCadastro;
    @FXML
    private TextField textMarcaCadastro;

    @FXML
    protected void changeScreenToMenu() {
        Main.chanceScreen("pagInicial", null);
    }

    protected void clean(){
        textProdutoCadastro.setText(null);
        textPrecoCadastro.setText(null);
        textCustoCadastro.setText(null);
        textCategoriaCadastro.setText(null);
        textMarcaCadastro.setText(null);
        textDescricaoCadastro.setText(null);
    }


    @FXML
    protected void buttonCadastrar() {

        try{
            String produto = textProdutoCadastro.getText();
            String preco = textPrecoCadastro.getText();
            String custo = textCustoCadastro.getText();
            String marca = textMarcaCadastro.getText();
            String categoria = textCategoriaCadastro.getText();
            String descricao = textDescricaoCadastro.getText();

            if (produto == null || produto.trim().isEmpty() || preco == null || preco.trim().isEmpty()){
                throw new Exception("Campos obriatórios não preenchidos");
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

            Loja.create(produto, descricao, categoria, marca, preco_, custo_);
            Main.chanceScreen("pagInicial", null);

        } catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro de Validação");
            alert.setHeaderText("Campos obrigatórios não preenchidos");
            alert.setContentText("Por favor, preencha os campos Produto e Preço.");
            alert.showAndWait();
        }

    }
}