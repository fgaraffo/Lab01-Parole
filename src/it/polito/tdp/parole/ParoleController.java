package it.polito.tdp.parole;

/**
 * Sample Skeleton for 'Parole.fxml' Controller Class
 */


import it.polito.tdp.parole.model.Parole;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ParoleController {
	
	Parole elenco ;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtParola"
    private TextField txtParola; // Value injected by FXMLLoader

    @FXML // fx:id="txtResult"
    private TextArea txtResult; // Value injected by FXMLLoader
    
    @FXML // fx:id="txtTime"
    private TextArea txtTime; // Value injected by FXMLLoader
    
    @FXML
    private Button btnReset;

    @FXML // fx:id="btnInserisci"
    private Button btnInserisci; // Value injected by FXMLLoader

    @FXML
    private Button btnCancella;
    
    @FXML
    void doInsert(ActionEvent event) {
    	
    	
    	double startTime = System.nanoTime();
    	elenco.addParola(txtParola.getText());
    	double tot = System.nanoTime() - startTime;
    	String result = "";
    	for (String p : elenco.getElenco())
    		result+=p+"\n";
    	txtResult.setText(result);
    	txtTime.setText("INSERT: "+ tot/1000000000 + " seconds");
    	txtParola.clear();
    }
    
    @FXML
    void doReset(ActionEvent event) { //OK
    	elenco.reset();
    	txtResult.clear();
    	txtTime.clear();
    }

    @FXML
    void doCancel(ActionEvent event) {
    	
    	if (txtResult.getSelectedText().equals(""))
    	{
			txtTime.setText("Evidenzia la parola da eliminare!");
		}
    	else
    	{
//    	String selected = txtResult.getSelectedText();
    	double startTime = System.nanoTime();
    	elenco.cancella(txtResult.getSelectedText());
    	double tot = System.nanoTime() - startTime;
    	
    	String result = "";
    	for (String p : elenco.getElenco())
//    		{
//    			if (!p.equals(selected))
    				result+=p+"\n";
//    		}
    	txtResult.setText(result);
    	txtTime.setText("DELETE: "+ tot/1000000000 + " seconds");
    	}
   	}

    
    
    
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Parole.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Parole.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Parole.fxml'.";
        assert btnCancella != null : "fx:id=\"btnCancella\" was not injected: check your FXML file 'Parole.fxml'.";
        assert txtTime != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Parole.fxml'.";
        
        elenco = new Parole() ;
        
    }
}
