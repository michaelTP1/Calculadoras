package com.github.michaeltp1.calculadoras;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.github.michaeltp1.calculadoras.compleja.ComplexCalculatorController;
import com.github.michaeltp1.calculadoras.normal.CalculadoraFxmlController;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.layout.BorderPane;

public class RootController implements Initializable{
	
	    @FXML
	    private Tab complexTab;

	    @FXML
	    private Tab simpleTab;

	    @FXML
	    private BorderPane view;
	    
	    
	    public BorderPane getView() {
			return view;
		}

		public void setView(BorderPane view) {
			this.view = view;
		}

		ComplexCalculatorController complexController=new ComplexCalculatorController();
	    CalculadoraFxmlController simpleController=new CalculadoraFxmlController();
	    
	    
	public RootController() throws IOException {
		FXMLLoader loader=new FXMLLoader(getClass().getResource("/fxml/RootView.fxml"));
		loader.setController(this);
		loader.load();	
		}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		complexTab.setContent(complexController.getRoot());
		simpleTab.setContent(simpleController.getView());
	}

}
