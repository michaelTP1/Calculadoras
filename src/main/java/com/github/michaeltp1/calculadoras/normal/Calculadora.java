package com.github.michaeltp1.calculadoras.normal;

import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * Implementación de la lógica de una calculadora.
 * @author Fran Vargas
 */
public class Calculadora {
	
	public static final char IGUAL = '='; 
	public static final char SUMAR = '+'; 
	public static final char RESTAR = '-'; 
	public static final char DIVIDIR = '/'; 
	public static final char MULTIPLICAR = '*';
	
	private static final char COMA = '.'; 
	
	private Double operando;
	private char operador;
	private Boolean nuevoOperando;
	private StringProperty pantalla = new SimpleStringProperty();
	
	public Calculadora() {
		borrar();
	}

	/**
	 * Inicializa por completo la calculadora, borrando la información que tiene memorizada y la pantalla.
	 */
	public void borrar() {
		operando = 0.0;
		operador = '=';
		borrarTodo();
	}
	
	/**
	 * Borra lo que hay en la pantalla (el último operando introducido).
	 */
	public void borrarTodo() {
		nuevoOperando = true;
		setPantalla("0.0");
	}
	
	/**
	 * Indica a la calculadora que realice la operación indicada. 
	 * @param operador Operación a realizar; usar una constante: IGUAL, SUMAR, RESTAR, MULTIPLCIAR, DIVIDIR.
	 */
	public void operar(char operador) {
		nuevoOperando = true;
		double operando2 = Double.parseDouble(pantalla.get());
		switch (this.operador) {
			case SUMAR: operando += operando2; break;
			case RESTAR: operando -= operando2; break;
			case MULTIPLICAR: operando *= operando2; break;
			case DIVIDIR: operando /= operando2; break;
			case IGUAL: operando = operando2; break;
		}
		this.operador = operador;
		setPantalla("" + operando);
	}
	
	/**
	
	* Inserta una coma en el operando actual (pantalla).
	 */
	public void insertarComa() {
		if (!getPantalla().contains("" + COMA)) {
			setPantalla(getPantalla() + COMA);
		}
	}
	
	/**
	 * Inserta un dígito en el operando actual (pantalla).
	 * @param digito Digito a introducir en la pantalla.
	 */
	public void insertar(char digito) {
		if (digito >= '0' && digito <= '9') {
			if (nuevoOperando) {
				nuevoOperando = false;
				setPantalla("");
			}
			setPantalla(getPantalla() + digito);
		} else if (digito == COMA) {
			insertarComa();
		}
	}

	public final StringProperty pantallaProperty() {
		return this.pantalla;
	}
	
	/**
	 * Devuelve el contenido de la pantalla de la calculadora.
	 * @return Cadena de texto con el contenido de la pantalla de la calculdora.
	 */
	public final String getPantalla() {
		return pantalla.get();
	}

	public final void setPantalla(String pantalla) {
		this.pantalla.set(pantalla);
	}
	
	public static void main(String[] args) {
		Calculadora calc = new Calculadora();

		// para sumar 15 + 8,5 
		
		// insertamos el 15
		calc.insertar('1');
		calc.insertar('5');
		
		// pulsamos el botón "+"
		calc.operar(Calculadora.SUMAR);
		
		// insertamos 8,5
		calc.insertar('8');
		calc.insertarComa();
		calc.insertar('5');
		
		// pulsamos el botón "="
		calc.operar(Calculadora.IGUAL);
		
		// muestra el contenido de la pantalla de la calculadora (23.5)
		System.out.println(calc.getPantalla());
	}
	
}
