package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import model.Factory;
import model.Poll;
import model.PollList;
import model.Party;

public class EditPollController {
    private PollList polls;
    
    
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label ProjectedNumberOfSeat;

    @FXML
    private TextField ProjectedNumberOfSeatText;

    @FXML
    private Label ProjectedPercentageOfTheVote;

    @FXML
    private Button UpdatePollNameButton;

    @FXML
    private TextField UpdatePollNameText;

    @FXML
    private Button ClearButton;

    @FXML
    private HBox Hbox1;

    @FXML
    private HBox Hbox2;

    @FXML
    private BorderPane Pane;

    @FXML
    private Label PercentageMark;

    @FXML
    private Label per290;

    @FXML
    private ChoiceBox<String> EditChoiceBox;

    @FXML
    private HBox Hbox3;

    @FXML
    private HBox Hbox4;

    @FXML
    private ChoiceBox<String> PartyToUpdateChoiceBox;

    @FXML
    private HBox Hbox5;

    @FXML
    private HBox Hbox6;

    @FXML
    private Label PollToEdit;

    @FXML
    private TextField ProjectedPercentageOfTheVoteText;

    @FXML
    private Button UpdatePartyButton;

    @FXML
    private Label PartyToUpdate;

    @FXML
    void ReactToTypingPoll(KeyEvent event) {
    	
    }

    @FXML
    void ReactToButtonClickPoll(ActionEvent event) {
    	ChangePollData();			   		
              
    }
    
    @FXML
    void ReactToChoiceboxParty(ActionEvent event) {
    	
    }
    
    @FXML
    void ReactToChoiceboxEdit(ActionEvent event) {
    	SwitchParties();
    	
    }
    
    @FXML
    void ReactToTypingSeats(KeyEvent event) {
 
    }

    @FXML
    void ReactToTypingVote(KeyEvent event) {

    }

    @FXML
    void ReactToButtonClickClear(ActionEvent event) {
    	ProjectedNumberOfSeatText.clear();
    	ProjectedPercentageOfTheVoteText.clear();
    	UpdatePollNameText.clear();
    }

    @FXML
    void ReactToButtonClickParty(ActionEvent event) {
    	setPartyData();
    }

    @FXML
    void initialize() {
        assert ProjectedNumberOfSeat != null : "fx:id=\"ProjectedNumberOfSeat\" was not injected: check your FXML file 'EditPollView.fxml'.";
        assert ProjectedNumberOfSeatText != null : "fx:id=\"ProjectedNumberOfSeatText\" was not injected: check your FXML file 'EditPollView.fxml'.";
        assert ProjectedPercentageOfTheVote != null : "fx:id=\"ProjectedPercentageOfTheVote\" was not injected: check your FXML file 'EditPollView.fxml'.";
        assert UpdatePollNameButton != null : "fx:id=\"UpdatePollNameButton\" was not injected: check your FXML file 'EditPollView.fxml'.";
        assert UpdatePollNameText != null : "fx:id=\"UpdatePollNameText\" was not injected: check your FXML file 'EditPollView.fxml'.";
        assert ClearButton != null : "fx:id=\"ClearButton\" was not injected: check your FXML file 'EditPollView.fxml'.";
        assert Hbox1 != null : "fx:id=\"Hbox1\" was not injected: check your FXML file 'EditPollView.fxml'.";
        assert Hbox2 != null : "fx:id=\"Hbox2\" was not injected: check your FXML file 'EditPollView.fxml'.";
        assert Pane != null : "fx:id=\"Pane\" was not injected: check your FXML file 'EditPollView.fxml'.";
        assert PercentageMark != null : "fx:id=\"PercentageMark\" was not injected: check your FXML file 'EditPollView.fxml'.";
        assert per290 != null : "fx:id=\"per290\" was not injected: check your FXML file 'EditPollView.fxml'.";
        assert EditChoiceBox != null : "fx:id=\"EditChoiceBox\" was not injected: check your FXML file 'EditPollView.fxml'.";
        assert Hbox3 != null : "fx:id=\"Hbox3\" was not injected: check your FXML file 'EditPollView.fxml'.";
        assert Hbox4 != null : "fx:id=\"Hbox4\" was not injected: check your FXML file 'EditPollView.fxml'.";
        assert PartyToUpdateChoiceBox != null : "fx:id=\"PartyToUpdateChoiceBox\" was not injected: check your FXML file 'EditPollView.fxml'.";
        assert Hbox5 != null : "fx:id=\"Hbox5\" was not injected: check your FXML file 'EditPollView.fxml'.";
        assert Hbox6 != null : "fx:id=\"Hbox6\" was not injected: check your FXML file 'EditPollView.fxml'.";
        assert PollToEdit != null : "fx:id=\"PollToEdit\" was not injected: check your FXML file 'EditPollView.fxml'.";
        assert ProjectedPercentageOfTheVoteText != null : "fx:id=\"ProjectedPercentageOfTheVoteText\" was not injected: check your FXML file 'EditPollView.fxml'.";
        assert UpdatePartyButton != null : "fx:id=\"UpdatePartyButton\" was not injected: check your FXML file 'EditPollView.fxml'.";
        assert PartyToUpdate != null : "fx:id=\"PartyToUpdate\" was not injected: check your FXML file 'EditPollView.fxml'.";
        Factory f = null;
        f = Factory.getInstance();
        polls = f.createEmptyPolls();
        int index = 0;
        String[] pollsname = new String[polls.getPolls().length];
        for(; index < polls.getPolls().length; index++) {
        	pollsname[index] = polls.getPolls()[index].getPollName();
        }
        
        EditChoiceBox.setItems(FXCollections.observableArrayList(pollsname));

        
        String[] partiesname = new String[polls.getPolls()[0].getPartiesSortedBySeats().length];
		int index2 = 0;
        for(; index2 < polls.getPolls()[0].getPartiesSortedBySeats().length; index2++) {
        	partiesname[index2] = polls.getPolls()[0].getPartiesSortedBySeats()[index2].getName() + "  " + polls.getPolls()[0].getPartiesSortedBySeats()[index2].getProjectedNumberOfSeats() + " Projected Number Of Seats  " + polls.getPolls()[0].getPartiesSortedBySeats()[index2].getProjectedPercentageOfVotes() + "% of votes";
        }
        
        PartyToUpdateChoiceBox.setItems(FXCollections.observableArrayList(partiesname));
    }
    
    
    private void ChangePollData() {
    	String pollname = UpdatePollNameText.getText();
    	EditChoiceBox.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
    		
    		public void changed(ObservableValue va, Number oldvalue, Number newvalue) {
    		    int index = oldvalue.intValue();
    		    if(index >= 0) {
    		    	polls.getPolls()[index].setPollName(pollname);
    		    	int index2 = 0;
    		        String[] pollsname = new String[polls.getPolls().length];
    		        for(; index2 < polls.getPolls().length; index2++) {
    		        	pollsname[index2] = polls.getPolls()[index2].getPollName();
    		        }
    		        EditChoiceBox.setItems(FXCollections.observableArrayList(pollsname));
    		        index2 = 0;
    		    }
    		    
    		}
    		    
    	}
    	);
    }
    
    
    
    private void SwitchParties() {
        EditChoiceBox.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
    		
    		public void changed(ObservableValue va, Number oldvalue, Number newvalue) {
    			if(newvalue.intValue() >= 0) {
    				int index = newvalue.intValue();
    				int index2 = 0;
    				String[] partiesname = new String[polls.getPolls()[index].getPartiesSortedBySeats().length];
        	        for(; index2 < polls.getPolls()[index].getPartiesSortedBySeats().length; index2++) {
        	        	partiesname[index2] = polls.getPolls()[index].getPartiesSortedBySeats()[index2].getName() + "  " + polls.getPolls()[index].getPartiesSortedBySeats()[index2].getProjectedNumberOfSeats() + " Projected Number Of Seats  " + polls.getPolls()[index].getPartiesSortedBySeats()[index2].getProjectedPercentageOfVotes() + "% of votes";
        	        }
        	        
        	        PartyToUpdateChoiceBox.setItems(FXCollections.observableArrayList(partiesname));
        	        index2 = 0;
    			}
    			else {
    				String[] partiesname = new String[polls.getPolls()[0].getPartiesSortedBySeats().length];
    				int index = 0;
        	        for(; index < polls.getPolls()[0].getPartiesSortedBySeats().length; index++) {
        	        	partiesname[index] = polls.getPolls()[0].getPartiesSortedBySeats()[index].getName() + "  " + polls.getPolls()[0].getPartiesSortedBySeats()[index].getProjectedNumberOfSeats() + " Projected Number Of Seats  " + polls.getPolls()[0].getPartiesSortedBySeats()[index].getProjectedPercentageOfVotes() + "% of votes";
        	        }
        	        
        	        PartyToUpdateChoiceBox.setItems(FXCollections.observableArrayList(partiesname));

    			}
    		    
    		}
    		    
    		
    		    
    	}
    	);
    }
    
    
    private void setPartyData() {
    	PartyToUpdateChoiceBox.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
    		
    		public void changed(ObservableValue va, Number oldvalue, Number newvalue) {
    			if(newvalue.intValue() >= 0) {
    				int index = newvalue.intValue();
    				int index2 = 0;
    				String[] partiesname = new String[polls.getPolls()[index].getPartiesSortedBySeats().length];
    				float ProjectedNumberOfSeat = Float.parseFloat(ProjectedNumberOfSeatText.getText());
    				float ProjectedPercentageOfTheVote = Float.parseFloat(ProjectedPercentageOfTheVoteText.getText());
    				for(; index2 < polls.getPolls()[index].getPartiesSortedBySeats().length; index2++) {
    					polls.getPolls()[index].getPartiesSortedBySeats()[index2].setProjectedNumberOfSeats(ProjectedNumberOfSeat);
    					polls.getPolls()[index].getPartiesSortedByVotes()[index2].setProjectedPercentageOfVotes(ProjectedPercentageOfTheVote);
    				}
        	        for(; index2 < polls.getPolls()[index].getPartiesSortedBySeats().length; index2++) {
        	        	partiesname[index2] = polls.getPolls()[index].getPartiesSortedBySeats()[index2].getName() + "  " + polls.getPolls()[index].getPartiesSortedBySeats()[index2].getProjectedNumberOfSeats() + " Projected Number Of Seats  " + polls.getPolls()[index].getPartiesSortedBySeats()[index2].getProjectedPercentageOfVotes() + "% of votes";
        	        }
        	        
        	        PartyToUpdateChoiceBox.setItems(FXCollections.observableArrayList(partiesname));
        	        index2 = 0;
    			}
    		    
    		}
    		    
    		
    		    
    	}
    	);
    }
}



