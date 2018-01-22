package com.edwsoft.capitalGame;

import java.util.Random;

import javax.swing.JOptionPane;

abstract public class GameMath  {
	protected int mNombreJeux;
	protected long mNombreChhiffre;
	protected char mNombreOperations;
	private int mTentativesPartiels = 0;
	private long mTempsInit;
	private long mTempsFinal;
	protected int mPremierChiffre;
	protected int mDeuxiemeChiffre;
	protected long mResultatOperationPrealable;
	protected long mResultatFinal;
	
	abstract void entreeDonnee();
	
	public GameMath(int pNombreJeux, int pNombreChhiffre, char pNombreOperations) {
		mNombreJeux = pNombreJeux;
		mNombreChhiffre = pNombreChhiffre;
		mNombreOperations = pNombreOperations;
	}
	
	public void startGame() {
		// premier etape: initialisation du temps
		initialisationDuTemps();
		
		// deuxieme etape: initialisation des variables 
		// nombre de jeux
		for (int i = 0; i < mNombreJeux ; i++ ){
			do {
				//jeux partiels
				processusPrealable();
				entreeDonnee();
				// somme de tentatives partiels
				mTentativesPartiels += 1;
			} while (mResultatOperationPrealable != mResultatFinal);
			JOptionPane.showMessageDialog(null,String.format("Felicitations!!!."));
		}
		finalisationDuTemps();
		resultat();
	}
	
	private void initialisationDuTemps(){
		mTempsInit =  System.currentTimeMillis();
	}
	private void finalisationDuTemps(){
		mTempsFinal = System.currentTimeMillis();
	}
	public  void resultat() {
		long tempDecoule = (mTempsFinal - mTempsInit)/1000;
		JOptionPane.showConfirmDialog(null, String.format("nombre de tentatives : "
				+ "%d Temps decoulé : %s secondes", mTentativesPartiels, tempDecoule));
	}
	private void processusPrealable(){
		//definition du nombre de chiffre a utiliser
		int expon = (int) Math.pow(10, mNombreChhiffre);
	
		//les chiffre soient différents
		do {
			mPremierChiffre = new Random().nextInt(expon);
			mDeuxiemeChiffre = new Random().nextInt(expon);
		} while (mPremierChiffre == mDeuxiemeChiffre);
		
		// selectionner operation
		
		switch (mNombreOperations)
		{
		case '+':
			mResultatOperationPrealable = mPremierChiffre + mDeuxiemeChiffre;
			break;
		case '-':
			mResultatOperationPrealable = mPremierChiffre - mDeuxiemeChiffre;
			break;
		case '*':
			mResultatOperationPrealable = mPremierChiffre * mDeuxiemeChiffre;
			break;
		case '/':
			mResultatOperationPrealable = mPremierChiffre / mDeuxiemeChiffre;
			default:
		}
	
	}
}
