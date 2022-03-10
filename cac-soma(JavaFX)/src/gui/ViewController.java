package gui;

import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class ViewController {

	@FXML
	private TextField txtNumero1;

	@FXML
	private TextField txtNumero2;

	@FXML
	private Label labelResultado;

	@FXML
	private Button btSoma;

	@FXML
	public void onBtSomaActtion() {
		try {
			double num1 = Double.parseDouble(txtNumero1.getText());
			double num2 = Double.parseDouble(txtNumero2.getText());

			double soma = num1 + num2;
			
			if(soma%2 == 0) {
				labelResultado.setText(String.format("%.0f", soma));													
			}else {
				labelResultado.setText(String.format("%.2f", soma));				
			}

		} catch (NumberFormatException e) {
			Alerts.showAlert("Error", "Parse error", e.getMessage(), AlertType.ERROR);
		}
	}

}
