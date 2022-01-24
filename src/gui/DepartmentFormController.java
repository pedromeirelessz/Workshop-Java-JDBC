package gui;

import java.net.URL;
import java.util.ResourceBundle;

import gui.util.Constraints;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class DepartmentFormController implements Initializable {

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
}
