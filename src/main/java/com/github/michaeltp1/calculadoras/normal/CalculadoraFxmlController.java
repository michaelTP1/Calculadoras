package com.github.michaeltp1.calculadoras.normal;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class CalculadoraFxmlController implements Initializable{

	// modelo
	
	private Calculadora model = new Calculadora();
	
	// vistas
    @FXML
    private GridPane rootView;

    @FXML
    private TextField resultField;

    @FXML
    private Button nSevenButton;

    @FXML
    private Button nFourButton;

    @FXML
    private Button nOneButton;

    @FXML
    private Button nZeroButton;

    @FXML
    private Button nEightButton;

    @FXML
    private Button nFiveButton;

    @FXML
    private Button nTwoButton;

    @FXML
    private Button nNineButton;

    @FXML
    private Button nSixButton;

    @FXML
    private Button nThreeButton;

    @FXML
    private Button dotButton;

    @FXML
    private Button CeButton;

    @FXML
    private Button MultipButton;

    @FXML
    private Button SubButton;

    @FXML
    private Button AddButton;

    @FXML
    private Button CButton;

    @FXML
    private Button DivideButton;

    @FXML
    private Button EqualsButton;
    
    // vistas action event - fix

    @FXML
    void onCButtonAction(ActionEvent event) {
    	model.borrar();
    }

    @FXML
    void onCeButtonAction(ActionEvent event) {
    	model.borrarTodo();
    }

    @FXML
    void onDivideButtonAction(ActionEvent event) {
    	model.operar('/');
    }

    @FXML
    void onEqualsButtonAction(ActionEvent event) {
    	model.operar('=');
    }

    @FXML
    void onMultiButtonAction(ActionEvent event) {
    	model.operar('*');
    }

    @FXML
    void onSubButtonAction(ActionEvent event) {
    	model.operar('-');
    }
    
    @FXML
    void onAddButtonAction(ActionEvent event) {
    	model.operar('+');
    }

    @FXML
    void ondotButtonAction(ActionEvent event) {
    	model.operar('.');
    }

    @FXML
    void onnEightButtonAction(ActionEvent event) {
    	model.insertar('8');
    }

    @FXML
    void onnFiveButtonAction(ActionEvent event) {
    	model.insertar('5');
    }

    @FXML
    void onnFourButtonAction(ActionEvent event) {
    	model.insertar('4');
    }

    @FXML
    void onnNineButtonAction(ActionEvent event) {
    	model.insertar('9');
    }

    @FXML
    void onnOneButtonAction(ActionEvent event) {
    	model.insertar('1');
    }

    @FXML
    void onnSevenButtonAction(ActionEvent event) {
    	model.insertar('7');
    }

    @FXML
    void onnSixButtonAction(ActionEvent event) {
    	model.insertar('4');
    }

    @FXML
    void onnThreeButtonAction(ActionEvent event) {
    	model.insertar('3');
    }

    @FXML
    void onnTwoButtonAction(ActionEvent event) {
    	model.insertar('2');
    }

    @FXML
    void onnZeroButtonAction(ActionEvent event) {
    	model.insertar('0');
    }
    
	public GridPane getView() {
		return rootView;
	}
    
	public CalculadoraFxmlController() throws IOException {
		FXMLLoader loader=new FXMLLoader(getClass().getResource("/fxml/CalculadoraFXML.fxml"));
		loader.setController(this);
		loader.load();
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		resultField.textProperty().bindBidirectional(model.pantallaProperty());
		
	}

}
