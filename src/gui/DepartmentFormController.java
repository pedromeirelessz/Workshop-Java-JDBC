package gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import db.DbException;
import gui.listeners.DataChangeListener;
import gui.util.Alerts;
import gui.util.Constraints;
import gui.util.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.entities.Department;
import model.services.DepartmentService;

public class DepartmentFormController implements Initializable {

	private Department entity;

	private DepartmentService service;

	private List<DataChangeListener> dataChangeListeners = new ArrayList<>();	

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

	public void setDepartmentService(DepartmentService service) {
		this.service = service;
	}
	
	public void subscribeDataChangeListener(DataChangeListener listener) {
		dataChangeListeners.add(listener);
	}

	@FXML
	public void onBtSaveAction(ActionEvent event) {
		// Estamos fazendo uma programa��o defensiva pois estamos injetando a
		// depend�ncia manualmente
		if (entity == null) {
			throw new IllegalStateException("Entity was null");
		}
		if (service == null) {
			throw new IllegalStateException("Service was null");
		}
		try {
			entity = getFormData();
			service.saveOrUpdate(entity);
			notifyDataChangeListener();
			Utils.currentStage(event).close();
		} catch (DbException DB) {
			Alerts.showAlert("Error saving object", null, DB.getMessage(), AlertType.ERROR);
		}
	}

	private void notifyDataChangeListener() {
		for(DataChangeListener listener : dataChangeListeners) {
			listener.onDataChanged();
		}
		
	}

	private Department getFormData() {
		Department obj = new Department();

		obj.setId(Utils.tryParseToInt(txtId.getText()));
		obj.setName(txtName.getText());

		return obj;
	}

	@FXML
	public void onBtCancelAction(ActionEvent event) {
		Utils.currentStage(event).close();
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
		// Programa��o defensiva caso a entidade esteja nula
		if (entity == null) {
			throw new IllegalStateException("Entity was null");
		}
		// Por que utilizei o valueOf? Por que a caixinha de texto trabalha com String,
		// ent�o uso o valueOf para converter meu int para string
		txtId.setText(String.valueOf(entity.getId()));
		txtName.setText(entity.getName());
	}
}
