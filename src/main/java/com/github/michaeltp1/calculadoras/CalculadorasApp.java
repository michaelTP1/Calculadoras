package com.github.michaeltp1.calculadoras;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CalculadorasApp extends Application {

	RootController controller ;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		controller=new RootController();
		
		Scene scene=new Scene(controller.getView());
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
public static void main(String[] args) {
	launch(args);
}
}
