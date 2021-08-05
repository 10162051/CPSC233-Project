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
        	        }
        	    }
        	);
    }
    
    private void setPieChartData(Poll aPoll) {
    	//create and declare PieChart Data arrays, and ultimately set those as the values 
    	//of the PieCharts that you have.
    	// It should take the data within the Poll instance and use the votes and seats to set that data.
    	ObservableList<Poll> pieChartPoll;
    	
    }
}


//List.  At start-up, get a random PollList from the Factory.  (Get the instance of Factory by calling Factory.getInstance().  
//Then call the method createRandomPollList()to get a random poll list that you can work with.

// Random rand = new Random(); RANDOM NUM GNERATOR
//myLabel.setText(myTextField.getText()); displays what you type in the textField as a label
//Do this under a button/selecty thing to make the pie chart work:
//PieChart.Data[] data = new PieChart.Data[5]; THE FIVE IS HOW MANY ITEMS IN THE ARRAY. CAN BE ANY NUM
// data[0] = new PieChart.Data("label here", rand.nextInt(101)); RAND.NEXTINT GENERATES RANDOM NUMBER FROM RANDOM RAND
//Need 5 data[num] if we do it this way.
//PieChart.setData(FXCollections.observableArrayList(data));
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
