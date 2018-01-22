package com.edwsoft.capitalGame;

import javax.swing.JOptionPane;


public class GUIGame extends GameMath {
	
	public GUIGame(int pNombreJeux, int pNombreChhiffre, char pNombreOperations ) {
		super(pNombreJeux, pNombreChhiffre, pNombreOperations);
	}
	
	@Override
	void entreeDonnee(){
		try {
			mResultatFinal = Integer.valueOf(JOptionPane.showInputDialog(null,"Quelle est le resultat  : " + 
					mPremierChiffre + " " + mNombreOperations + " " + mDeuxiemeChiffre));
		} catch (Exception e) {
		
		}
	}
	public void methodeFils() {
		System.out.println("estoy en la clase hija");
	}
}