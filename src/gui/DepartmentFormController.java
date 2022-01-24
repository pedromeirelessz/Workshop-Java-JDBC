package gui;

import java.net.URL;
import java.util.ResourceBundle;

import gui.util.Constraints;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.entities.Department;

public class DepartmentFormController implements Initializable {

	private Department entity;

	@FXML
	private TextField txtId;

	@FXML
	private TextField txtName;

	@FXML
	private Button btSave;

	@FXML
	private Button btCancel;

	@FXML
	private Label labelError1;

	@FXML
	private Label labelError2;

	public void setDepartment(Department entity) {
		this.entity = entity;
	}

	@FXML
	public void onBtSaveAaction() {
		System.out.println("tu clico no botao safado");
	}

	@FXML
	public void onBtCancelAaction() {
		System.out.println("tu clico no botao safado");
	}

	@Override
	public void initialize(URL URL, ResourceBundle RB) {
		initializeNodes();
	}

	private void initializeNodes() {
		Constraints.setTextFieldInteger(txtId);
		Constraints.setTextFieldLength(txtName, 30);
	}

	public void updateFormData() {
		// Programação defensiva caso a entidade esteja nula
		if (entity == null) {
			throw new IllegalStateException("Entity was null");
		}
		// Por que utilizei o valueOf? Por que a caixinha de texto trabalha com String,
		// então uso o valueOf para converter meu int para string
		txtId.setText(String.valueOf(entity.getId()));
		txtName.setText(entity.getName());
	}
}
