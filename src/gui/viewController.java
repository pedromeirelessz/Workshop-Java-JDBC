package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Consumer;

import application.Main;
import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import model.services.DepartmentService;

public class viewController implements Initializable {

	@FXML
	private MenuItem menuItemSeller;

	@FXML
	private MenuItem menuItemDepartment;

	@FXML
	private MenuItem menuItemAbout;

	@FXML
	private void onMenuItemSellerAction() {
		System.out.println("Action");
	}

	@FXML
	private void onMenuItemDepartmentAction() {
		loadView("/gui/DepartmentList.fxml", (DepartmentListController controller) -> {
			controller.setDepartmentService(new DepartmentService());
			controller.updateTableView();
		});
	}

	@FXML
	private void onMenuItemAboutAction() {
		loadView("/gui/About.fxml", x -> {
		});
	}

	// Se você quer garantir que todo esse processamento ocorra sem que seja
	// interrompido, você coloca antes do void a palavra synchronized
	private synchronized <T> void loadView(String absoluteName, Consumer<T> initializingAction) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
			VBox newVBox = loader.load();

			// Nossa janela principal começa com scrollPane, tendo após uma hierarquia de
			// nodos, então eu vou ter que pegar uma referência para o VBox da Janela
			// principal e quero acrescentar nele os childrens do VBox do About.fxml.
			Scene mainScene = Main.getMainScene();

			// Vou pegar minha cena principal e chamar através dela o método getRoot().
			// getRoot pega o primeiro elemento do meu arquivo fxml, no caso da minha View
			// principal o primeiro é o scrollPane, então terei que fazer um casting, para o
			// compilador entender que estou utilizando um scrollPane.

			// Dentro do scrollPane eu tenho um elemento chamado "Content", como acesso ele?
			// Utilizando o .getContent()

			// É importante entender que o getContent ja é uma referência para o que tem
			// dentro do scrollPane, que no caso é o VBox

			// Vou pegar toda essa expressão e fazer um casting para o VBox, dessa forma eu
			// pego para o VBox que está na minha janela principal
			VBox mainVBox = (VBox) ((ScrollPane) mainScene.getRoot()).getContent();

			// Vou pegar o children do VBox na posição 0, ou seja o menuBar
			Node mainMenu = mainVBox.getChildren().get(0);
			// Limpar todos os childrens do meu VBox
			mainVBox.getChildren().clear();
			mainVBox.getChildren().add(mainMenu);
			// Utilizo addAll para adicionar uma coleção
			mainVBox.getChildren().addAll(newVBox.getChildren());

			// Meu getController vai retornar um controlador do tipo que eu chamar na
			// instaciação
			T controller = loader.getController();
			initializingAction.accept(controller);

		} catch (IOException e) {
			Alerts.showAlert("IO Exception", "Error loading view", e.getMessage(), AlertType.ERROR);
		}
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO Auto-generated method stub

	}
}
