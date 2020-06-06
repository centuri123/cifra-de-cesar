package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Controller {

	private Integer pulo = 0;
	
	@FXML protected TextField inputCifrar;
	@FXML protected TextField outputResult;
	@FXML protected TextField inputPulo;
	
	@FXML
	protected void btnCifrar(ActionEvent event) {
		StringBuilder textoInput      = new StringBuilder(this.inputCifrar.getText().toLowerCase());
		StringBuilder textoModificado = new StringBuilder();
		
		if(!(this.inputPulo.getText().isEmpty())) {
			this.pulo = Integer.parseInt(this.inputPulo.getText());
			
			if(this.pulo > 0) {
				textoInput.chars().forEach(letra -> {
					if(letra == 32) {
						letra = 32;
						textoModificado.append((char)letra);
					}else if(letra + this.pulo > 122) {
						textoModificado.append((char)(letra - this.pulo));
					}else {
						textoModificado.append((char)(letra + this.pulo));
					}
					
				});
	
				this.inputCifrar.setText("");
				this.outputResult.setText(textoModificado.toString());
			}
		}
	}
	
	@FXML 
	protected void btnDecifrar(ActionEvent event) {
		StringBuilder textoInput      = new StringBuilder(this.inputCifrar.getText().toLowerCase());
		StringBuilder textoModificado = new StringBuilder();
		
		if(!(this.inputPulo.getText().isEmpty())) {
			this.pulo = Integer.parseInt(this.inputPulo.getText());
			
			if(this.pulo > 0) {
				textoInput.chars().forEach(letra -> {
					if(letra == 32) {
						letra = 32;
						textoModificado.append((char)letra);
					}else if(letra - this.pulo < 97){
						textoModificado.append((char)(letra + pulo));
					}else {
						textoModificado.append((char)(letra - pulo));
					}
					
				});
				
				this.inputCifrar.setText("");
				this.outputResult.setText(textoModificado.toString());
			}
		}
	}
	
}
