package it.polito.tdp.indovinaNumero;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;

public class FXMLController {

	private int TMax; // tentativi
	private int NMax;
	//private final int NMax = 100; //final = costante
	private int NTentativiFatti;
	private int numeroSegreto;
	
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField TxtProva;

    @FXML
    private Button buttonNuovaPartita;

    @FXML
    private Button buttonProva;

    @FXML
    private ProgressBar barTentativi;
    
    @FXML
    private TextArea txtCom;

    @FXML
    private TextField txtNMax;

    @FXML
    private TextArea txtRisultato;

    @FXML
    private TextField txtTMax;

    @FXML
    private TextField txtTentativi;

    @FXML
    void doNuovaPartita(ActionEvent event) {
    	
    	// Inizializzare variabili del gioco
    	this.NTentativiFatti = 0;
    	this.numeroSegreto =  (int) (Math.random()*this.NMax) + 1;
    	try {
    		this.TMax = Integer.parseInt(this.txtTMax.getText());
    	} catch(NumberFormatException e) {
    		this.txtCom.setText("TMax deve essere un numero!");
    		return;
    	}
    	
    	try {
    		this.NMax = Integer.parseInt(this.txtNMax.getText());
    	} catch(NumberFormatException e) {
    		this.txtCom.setText("NMax deve essere un numero!");
    		return;
    	}
    	
    	// Scrivere informazioni utente
    	this.txtTentativi.setText(Integer.toString(this.TMax - this.NTentativiFatti));
    	this.txtNMax.setText(Integer.toString(this.NMax));
    	this.txtTMax.setText(Integer.toString(this.TMax));
    	
    	//this.txtRisultato.setText(Integer.toString(this.numeroSegreto));
    	
    	this.buttonProva.setDisable(false);
    	this.txtRisultato.clear();
    	this.TxtProva.clear();
    	this.txtCom.clear();
    	this.barTentativi.setProgress(0.0);
    	
    }

    @FXML
    void doProva(ActionEvent event) {
    	
    	txtCom.clear();
    	
    	int guess = 0;
    	// Leggere numero scelto
    	try {
    		
    		guess = Integer.parseInt(this.TxtProva.getText());
    	} catch(NumberFormatException e) {
    		this.txtCom.setText("Inserire un numero!");
    		return;
    	}
    	
    	
    	// Fare controlli sul numero
    	
    	
    	// Incrementare numero tentativi fatti
    	
    	this.NTentativiFatti++;
    	
    	this.txtTentativi.setText(Integer.toString((this.TMax-this.NTentativiFatti)));
    	
    	this.barTentativi.setProgress((double)this.NTentativiFatti/this.TMax);
    	
    	// Gioco
    	if(guess == this.numeroSegreto) {
    		this.txtRisultato.appendText("Hai vinto. Il numero segreto era " + this.numeroSegreto);
    		this.buttonProva.setDisable(true);
    		return;
    	}
    	
    	if(this.NTentativiFatti == this.TMax) {
    		this.txtRisultato.appendText("Hai perso. Il numero segreto era " + this.numeroSegreto);
    		this.buttonProva.setDisable(true);
    		return;
    	}
    	
    	
    	if(guess > this.numeroSegreto) {
    		this.txtRisultato.appendText("Numero troppo alto \n");
    	} else {
    		this.txtRisultato.appendText("Numero troppo basso \n");
    	}
    	
    	
    }

    @FXML
    void initialize() {
        assert TxtProva != null : "fx:id=\"TxtProva\" was not injected: check your FXML file 'Scene.fxml'.";
        assert buttonNuovaPartita != null : "fx:id=\"buttonNuovaPartita\" was not injected: check your FXML file 'Scene.fxml'.";
        assert buttonProva != null : "fx:id=\"buttonProva\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCom != null : "fx:id=\"txtCom\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtNMax != null : "fx:id=\"txtNMax\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtRisultato != null : "fx:id=\"txtRisultato\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtTMax != null : "fx:id=\"txtTMax\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtTentativi != null : "fx:id=\"txtTentativi\" was not injected: check your FXML file 'Scene.fxml'.";

    }

    
}
