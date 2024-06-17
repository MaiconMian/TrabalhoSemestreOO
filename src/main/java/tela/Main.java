package tela;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import modelos.Produto;

public class Main extends Application {
    private static Stage stage;
    private static Scene pagInicialScene;
    private static Scene pagCadastroScene;
    private static Scene pagEdicaoScene;

    private static PagInicialController pagInicialController;
    private static PagEdicaoController pagEdicaoController;
    private static PagCadastroController pagCadastroController;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        stage = primaryStage;

        primaryStage.setResizable(false);
        primaryStage.setTitle("Controle de Produtos");

        FXMLLoader fxmlInicial = new FXMLLoader(Main.class.getResource("PagInicial.fxml"));
        pagInicialScene = new Scene(fxmlInicial.load(), 1000, 540);
        pagInicialController = fxmlInicial.getController();

        FXMLLoader fxmlCadastro = new FXMLLoader(Main.class.getResource("PagCadastro.fxml"));
        pagCadastroScene = new Scene(fxmlCadastro.load(), 1000, 540);
        pagCadastroController = fxmlCadastro.getController();

        FXMLLoader fxmlEdicao = new FXMLLoader(Main.class.getResource("PagEdicao.fxml"));
        pagEdicaoScene = new Scene(fxmlEdicao.load(), 1000, 540);
        pagEdicaoController = fxmlEdicao.getController();

        primaryStage.setScene(pagInicialScene);
        primaryStage.show();
    }

    public static void chanceScreen(String scr, Produto p){
        switch (scr){
            case "pagInicial":
                stage.setScene(pagInicialScene);
                stage.setTitle("Controle de Produtos");
                pagInicialController.atualiza();
                break;
            case "pagCadastro":
                stage.setScene(pagCadastroScene);
                stage.setTitle("Cadastro de Produtos");
                pagCadastroController.clean();
                break;
            case "pagEdicao":
                stage.setScene(pagEdicaoScene);
                stage.setTitle("Edição de Produtos");
                pagEdicaoController.setProdutoEditar(p);
                break;
        }
    }



}