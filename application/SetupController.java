package application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import model.Factory;

public class SetupController {
    private PollTrackerApp App;
	@FXML
	public TextField numSeats;
	@FXML
	public TextField numPolls;
	@FXML
	public TextField numofParties;
	@FXML
	public AnchorPane firstScreen;
	@FXML
	public AnchorPane secondScreen;
	@FXML
	public HBox hbox;
	@FXML 
	private Button submitbutton;
	@FXML
	private Button resetbutton;
	
	private ArrayList<TextField> textfields = new ArrayList();
	@FXML
	public void submitButtonClicked(ActionEvent event) {
		/**
		 * converts textfield values to integer and calls setNumofSeats method to update value
		 * Factory
		 */
		int numberofseats=Integer.parseInt(numSeats.getText());
		Factory.getInstance().setNumOfSeats(numberofseats);
		/**
		 * converts textfield values to integer and calls setNumofPolls method to update value
		 * Factory
		 */
		int numberofpolls=Integer.parseInt(numPolls.getText());
		Factory.getInstance().setNumOfPolls(numberofpolls);
		/**
		 * once values are updated in Factory, First screen vanish and displays second screen to enter 
		 * party names. 
		 */
		firstScreen.setVisible(false);
		secondScreen.setVisible(true);
		int numberofparties=Integer.parseInt(numofParties.getText());
		ArrayList<HBox> hboxes = new ArrayList();
		/**
		 * loops through and adds Hbox with the label "Name of Party" and partynames. 
		 */
		for (int i = 0; i < numberofparties; i++){
			TextField partynames = new TextField();
			HBox hbox = new HBox(new Label("Name of Party"),partynames);
			hbox.setLayoutY(120 + (i*20));
			hboxes.add(hbox);
			textfields.add(partynames);
			secondScreen.getChildren().add(hbox);
			
		}
		
	}
	/**
	 * 
	 * code resets all the information entered in the textfield when rest button is clicked
	 */
	
	public void resetButtonClicked(ActionEvent event) {
		numSeats.clear();
		numPolls.clear();
		numofParties.clear();
	}
	public void submitPartyNames(ActionEvent event) {
		ArrayList<String> list = new ArrayList();
		for (TextField textfield: textfields) {
			list.add(textfield.getText());
		}
		/**
		 * updates the Party names in Factory.
		 */
		Factory.getInstance().setPartyNames(list.toArray(new String[0] ));
		App.pollView();
	}
	
	public PollTrackerApp linkWithApplication(PollTrackerApp App) {
		this.App = App;
		return App;
	}
}
	