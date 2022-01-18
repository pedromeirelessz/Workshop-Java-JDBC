package gui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.entities.Department;
import model.services.DepartmentService;

public class DepartmentListController implements Initializable {

	private DepartmentService service;

	@FXML
	private TableView<Department> tableViewDepartment;

	// São dois tipos, o primeiro é o tipo da entidade, o segundo é o tipo da coluna
	@FXML
	private TableColumn<Department, Integer> tableColumnId;

	@FXML
	private TableColumn<Department, String> tableColumnName;

	@FXML
	private Button btNew;

	@FXML
	private ObservableList<Department> obsList;

	@FXML
	public void onBtNewAction() {
		System.out.println("Tu cricou no botao safado");
	}

	public void setDepartmentService(DepartmentService service) {
		this.service = service;
	}

	@Override
	public void initialize(URL url, ResourceBundle rs) {
		initializeNodes();
	}

	// O simples fato de você declarar as colunas não faz com que a tabela vai
	// funcionar, então criei um metódo para iniciar apropiadamente o comportamento
	// das colunas da tabela
	private void initializeNodes() {
		tableColumnId.setCellValueFactory(new PropertyValueFactory<>("Id"));
		tableColumnName.setCellValueFactory(new PropertyValueFactory<>("Name"));

		// getWindow() é uma função que pega a referência para janela, o window é uma
		// superclass do Stage, então para que eu possa atribuir pro stage vou ter que
		// fazer um downcasting
		Stage stage = (Stage) Main.getMainScene().getWindow();
		// Isso é um macete para eu fazer meu tableView acompanhar a altura da janela
		tableViewDepartment.prefHeightProperty().bind(stage.heightProperty());
	}

	public void updateTableView() {
		if (service == null) {
			throw new IllegalStateException("Service was null");
		}
		List<Department> list = service.findAll();
		obsList = FXCollections.observableArrayList(list);
		tableViewDepartment.setItems(obsList);
	}
}
