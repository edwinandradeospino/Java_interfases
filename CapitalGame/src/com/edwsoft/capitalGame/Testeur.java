package com.edwsoft.capitalGame;

public class Testeur {
	public static void main(String[] args) {
		//(NombreJeux, Nombre de Chiffre, Operations)
		new GUIGame(2, 1, '-').startGame();

		// Utilizacion de una clase hija con (casting)
		((GUIGame)(new GUIGame(4, 4, '+'))).methodeFils();
		
		

	}
}