package application;

import java.util.Random;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.input.MouseEvent;
import model.Poll;


// ALWAYS IMPORT FROM JAVAFX. CHECK WHEN YOU IMPORT
public class VisualizePollController {

    @FXML
    private ChoiceBox<String> pollButton; //String can be polls, parties, etc. 
    
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
    void openSelectPoll(MouseEvent event) {
    	// THIS SHOULD BE WHEN A CHOICE IS SELECTED FROM THE DROP DOWN MENU.
    	PieChart.Data[] data = new PieChart.Data[6]; //6 is a place setting
    	Random rand = new Random();
    	data [0] = new PieChart. Data("Poll 1", rand.nextInt(100));
    	data [1] = new PieChart. Data("Poll 2", rand.nextInt(100));
    	data [2] = new PieChart. Data("Poll 3", rand.nextInt(100));
    	data [3] = new PieChart. Data("Poll 4", rand.nextInt(100));
    	data [4] = new PieChart. Data("Poll 5", rand.nextInt(100));
    	data [5] = new PieChart. Data("Poll 6", rand.nextInt(100));
    	
    	seatsPieChart.setData(FXCollections.observableArrayList(data));
    }
    @FXML
    void initialize() {
        assert pollButton != null : "fx:id=\"pollButton\" was not injected: check your FXML file 'Assignment2.fxml'.";
        assert selectPollLabel != null : "fx:id=\"selectPollLabel\" was not injected: check your FXML file 'Assignment2.fxml'.";
        assert projectedSeatsLabel != null : "fx:id=\"projectedSeatsLabel\" was not injected: check your FXML file 'Assignment2.fxml'.";
        assert projectedPercentVotesLabel != null : "fx:id=\"projectedPercentVotesLabel\" was not injected: check your FXML file 'Assignment2.fxml'.";
        assert seatsPieChart != null : "fx:id=\"seatsPieChart\" was not injected: check your FXML file 'Assignment2.fxml'.";
        assert precentVotesPieChart != null : "fx:id=\"precentVotesPieChart\" was not injected: check your FXML file 'Assignment2.fxml'.";
        
        //For the drop down box
        //String[] values = {"Aggregate Poll", "All Polls"};
        //seatsPieChart.setItems(FXCollections.observableArrayList(values));
        //seatsPieChart.getSelectModel().selectedIndexProperty().addListener(listener
        		//new ChangeListener<Number>(){
        		//@Override
        			//public void changed(ObservableValue observable, Number oldValue, Number newValue){
        			//int index = newValue.intValue();
        		//}
        //	}
     //   );
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

//For the drop down box
//String[] values = {"Aggregate Poll", "All Polls"};
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
