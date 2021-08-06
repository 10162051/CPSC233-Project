package application;

//ALWAYS IMPORT FROM JAVAFX. CHECK WHEN YOU IMPORT
import java.util.Random;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import model.Poll;
import model.PollList;
import model.Factory;
import model.Party;

public class VisualizePollController {
	//Instance Variable
	private PollList polls;
	// Getter and Setter * We'll do something with these later
	PollList getPolls() {
		return polls;
	}
	void setPolls(PollList polls) {
		this.polls = polls;
	}

	@FXML
    private ChoiceBox<Poll> pollButton; 
	
    @FXML
    private Label selectPollLabel;

    @FXML
    private Label projectedSeatsLabel;

    @FXML
    private Label projectedPercentVotesLabel;

    @FXML
    private PieChart seatsPieChart;

    @FXML
    private PieChart precentVotesPieChart;
    
    @FXML
    private Button displayResultsButton;

	private PieChart percentVotesPieChart;

    @FXML
    void initialize() {
    	this.setPolls(Factory.getInstance().createRandomPollList());
    	assert pollButton != null : "fx:id=\"pollButton\" was not injected: check your FXML file 'Assignment2.fxml'.";
        assert selectPollLabel != null : "fx:id=\"selectPollLabel\" was not injected: check your FXML file 'Assignment2.fxml'.";
        assert projectedSeatsLabel != null : "fx:id=\"projectedSeatsLabel\" was not injected: check your FXML file 'Assignment2.fxml'.";
        assert projectedPercentVotesLabel != null : "fx:id=\"projectedPercentVotesLabel\" was not injected: check your FXML file 'Assignment2.fxml'.";
        assert seatsPieChart != null : "fx:id=\"seatsPieChart\" was not injected: check your FXML file 'Assignment2.fxml'.";
        assert precentVotesPieChart != null : "fx:id=\"precentVotesPieChart\" was not injected: check your FXML file 'Assignment2.fxml'.";
        //ChoiceBox
        ObservableList<Poll> selectPollList;
        pollButton.setItems(FXCollections.observableArrayList(this.polls.getPolls()));
        pollButton.getSelectionModel().selectedIndexProperty().addListener(
        	    new ChangeListener<Number>() {
        	        @Override
        	        public void changed(ObservableValue observable, Number oldValue, Number newValue) {
        	            int value = newValue.intValue();
        	            setPieChartData(polls.getPolls()[newValue.intValue()]);
        	        }
        	    }
        	);
    }
    
    private void setPieChartData(Poll aPoll) {
    	//create and declare PieChart Data arrays, and ultimately set those as the values 
    	//of the PieCharts that you have.
    	// It should take the data within the Poll instance and use the votes and seats to set that data.
    	ObservableList<Poll> pieChartPoll;
    	int numberofParties = Factory.getInstance().getPartyNames().length; //number of parties
    	PieChart.Data[] data = new PieChart.Data[numberofParties];
    	PieChart.Data[] dataVotes = new PieChart.Data[numberofParties];
    	Party[] sortedBySeats = aPoll.getPartiesSortedBySeats();
    	Party[] sortedByVotes = aPoll.getPartiesSortedByVotes();
    	// make this a loop instead. Based on the size of sortedSeats
    	int i = 0;
    	for (i = 0; i < data.length; i++) {
    		data[i] = new PieChart.Data(sortedBySeats[i].getName(), sortedBySeats[i].getProjectedNumberOfSeats());
    		dataVotes[i] = new PieChart.Data(sortedByVotes[i].getName(), sortedByVotes[i].getProjectedPercentageOfVotes());
    	}
    	seatsPieChart.setData(FXCollections.observableArrayList(data)); 
    	precentVotesPieChart.setData(FXCollections.observableArrayList(dataVotes));
    }
}
//ChoiceBox.setItems(FX.Collection.observableArrayList(values));
//ChoiceBox.getSelectModel().selectedIndexProperty().addListener(listener
//	 new ChangeListener<Number>(){
// 		@Override
//		public void changed(ObservableValue observable, Number oldValue, Number newValue){
//			int index = newValue.intValue();
//			if (index >=0)
//				myLabel.setText("Selected: " + values[index] + "at index: " + index);
//		}
//	}
//);
