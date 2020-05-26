package gui;

import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;

public class ViewController {
	@FXML
	private Button btTest;
	//criar metodo para botao
	@FXML
	public void onBtTestAction()
	{
	Alerts.showAlert("titulo: Atencao boiola", null, "Boiola", AlertType.WARNING);	
	}
}
