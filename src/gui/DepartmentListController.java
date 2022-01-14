package gui;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.entities.Department;

public class DepartmentListController implements Initializable {

	@FXML
	private TableView<Department> tableViewDepartment;

	// S�o dois tipos, o primeiro � o tipo da entidade, o segundo � o tipo da coluna
	@FXML
	private TableColumn<Department, Integer> tableColumnId;

	@FXML
	private TableColumn<Department, String> tableColumnName;

	@FXML
	private Button btNew;

	@FXML
	public void onBtNewAction() {
		System.out.println("Tu cricou no botao safado");
	}

	@Override
	public void initialize(URL url, ResourceBundle rs) {
		initializeNodes();
	}

	// O simples fato de voc� declarar as colunas n�o faz com que a tabela vai
	// funcionar, ent�o criei um met�do para iniciar apropiadamente o comportamento
	// das colunas da tabela
	private void initializeNodes() {
		tableColumnId.setCellValueFactory(new PropertyValueFactory<>("Id"));
		tableColumnName.setCellValueFactory(new PropertyValueFactory<>("Name"));

		// getWindow() � uma fun��o que pega a refer�ncia para janela, o window � uma
		// superclass do Stage, ent�o para que eu possa atribuir pro stage vou ter que
		// fazer um downcasting
		Stage stage = (Stage) Main.getMainScene().getWindow();
		// Isso � um macete para eu fazer meu tableView acompanhar a altura da janela
		tableViewDepartment.prefHeightProperty().bind(stage.heightProperty());
	}
}
