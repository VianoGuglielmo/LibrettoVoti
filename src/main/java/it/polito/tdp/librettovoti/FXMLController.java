package it.polito.tdp.librettovoti;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.librettovoti_model.Libretto;
import it.polito.tdp.librettovoti_model.Voto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private Libretto model; //aggiungo model anche qua

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<Integer> ctmPunti;
    //comboBox contiene una lista di oggetti e devo dire cosa contiene dentro le <> in questo caso integer so deve
    //chiamare cmb e non ctm che ho sbagliato

    @FXML
    private TextField txtNome;

    @FXML
    private Label txtStato;
    
    @FXML
    private TextArea txtVoti;

    @FXML
    void handleNuovoVoto(ActionEvent event) {
    	// FASE 1. acquisizione e controllo dati
    	String nome = txtNome.getText(); //capire che dati metto in stringhe o int 
    	Integer punti = ctmPunti.getValue();
    	
    	// bisognerebbe fare serie di controlli validità
    	if(nome.equals("")||punti==null) {
    		//errore non posso eseguire l'opereazione
    		txtStato.setText("ERRORE occorre inserire nome o voto \n");
    		return;
    	}
    	
    	//FASE 2 esecuzione dell'opreazione(== chidere al Model di farla)
    	
    	boolean ok = model.add(new Voto(nome, punti));
    	
    	//FASE 3. visualizzazione/aggiornamento del risultato
    	if(ok) {
    	List<Voto> voti = model.getVoti();
    	txtVoti.clear();
    	txtVoti.appendText("Hai superato " + voti.size()+ " esami\n");
    	for(Voto v: voti) {
    		txtVoti.appendText(v.toString()+"\n");
    	}
    	txtNome.clear();
    	ctmPunti.setValue(null);// per pulire il ctmPunti stessa cosa di clear che non ha come metodo
    	txtStato.setText("");// stessa cosa di clear per una lable
    	}else {
    		txtStato.setText("ERRORE esame già presente");
    	}
    	
    	
    }
    
    public void setModel(Libretto model) { //ci ricorda su quale classe model lavorare
    	this.model = model;
    }

    @FXML
    void initialize() {
        assert ctmPunti != null : "fx:id=\"ctmPunti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtNome != null : "fx:id=\"txtNome\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtStato != null : "fx:id=\"txtStato\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtVoti != null : "fx:id=\"txtVoti\" was not injected: check your FXML file 'Scene.fxml'.";
        
        //aggiungere i vori nella tendina combobox
        ctmPunti.getItems().clear();
        for(int p=18; p<=30; p++) {
        	ctmPunti.getItems().add(p);//getItems aggiunge nella comboBox
        }
        
    }

}
