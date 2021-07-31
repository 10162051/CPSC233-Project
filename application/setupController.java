package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import model.Factory;

public class setupController {

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
	private Button submitbutton;
	@FXML
	private Button resetbutton;
	
	@FXML
	public void submitButtonClicked(ActionEvent event) {
		int numberofseats=Integer.parseInt(numSeats.getText());
		Factory.getInstance().setNumOfSeats(numberofseats);
		int numberofpolls=Integer.parseInt(numPolls.getText());
		Factory.getInstance().setNumOfPolls(numberofpolls);
		System.out.println(Factory.getInstance().toString());
		firstScreen.setVisible(false);
		secondScreen.setVisible(true);
	}
	public void resetButtonClicked(ActionEvent event) {
		numSeats.clear();
		numPolls.clear();
		numofParties.clear();
	}
}
