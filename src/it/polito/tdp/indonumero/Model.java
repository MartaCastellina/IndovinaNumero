package it.polito.tdp.indonumero;

import java.security.InvalidParameterException;

//Dentro questa andiamo a trasferire l'algoritmo

public class Model {

	private int NMAX=100;
	private int TMAX=7; //bastano 7 tentativi per indovinare un numero da 1 a 100 (basta dimezzare ogni volta)
	private int segreto; //numero da indovinare
	private int tentativi; // tentativi già fatti
	private boolean inGame=false; //c'è una partita in corso?
	public Model() {
		this.inGame=false;
	}
	
	/**
	 * Avvia nuova partita generanddo un nuovo numero segreto
	 */
	
	
	
	/* Quali sono le azioni che posso fare?
	 * Iniziare una partita nuova o fare un tentativo.
	 */
	
	public void newGame() {
		this.segreto=(int)(Math.random()*NMAX) +1; //ho numero compreso tra 0 e 99, quindi aggiungo un numero
    	this.tentativi=0;
    	this.inGame=true;
		
	}
	
	/**
	 * Fai un tentativo di indovinare il numero segreto
	 * @param t valore numerico del tentativo
	 * @return 0 se è indovinato, +1 se troppo grande, -1 se troppo piccolo
	 */
	
	
	public int tentativo(int t) {
		//t è valore tentato dall'utente, quello inserito dall'utente
		if (! inGame) {
			throw new IllegalStateException("Partita non attiva");
		}
		if (!valoreValido(t)) {
			throw new InvalidParameterException("Tentativo fuori range");
		}
		this.tentativi++;
		if (this.tentativi==this.TMAX) {
			this.inGame=false;
		}
		if (t==this.segreto) {
		this.inGame=false;
			return 0;
		}
		if (t<this.segreto)
			return -1;
		return +1;
		/* come fa il controller a sapere se sono in game o no?
		 * vado a definire un getter (NB Nelle var booleane il getter non è get, ma IS
		 */
		
	}
	
	/**
	 * Controlla se il tentativo formito rispetta le regole formali del gioco cioè è nel range [1,NMAX]
	 * @param tentativo
	 * @return {code true} se il tentativo è valido
	 */


	public boolean valoreValido(int tentativo) {
		return tentativo>=1&& tentativo<=this.NMAX;
	}
	
	
	public boolean isInGame() {
		return inGame;
	}


	public void setInGame(boolean inGame) {
		this.inGame = inGame;
	}
	
	public int getTentativi() {
		return this.tentativi;
	}

	public int getNMAX() {
		return NMAX;
	}

	public int getTMAX() {
		return TMAX;
	}

	public int getSegreto() {
		return segreto;
	}
	
	
	
	
	
	
}
