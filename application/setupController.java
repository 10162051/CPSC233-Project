package application;

import java.util.ArrayList;
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
	public HBox hbox;
	@FXML 
	private Button submitbutton;
	@FXML
	private Button resetbutton;
	
	private ArrayList<String> names = new ArrayList();
	private ArrayList<TextField> textfields = new ArrayList();
	@FXML
	public void submitButtonClicked(ActionEvent event) {
		int numberofseats=Integer.parseInt(numSeats.getText());
		Factory.getInstance().setNumOfSeats(numberofseats);
		int numberofpolls=Integer.parseInt(numPolls.getText());
		Factory.getInstance().setNumOfPolls(numberofpolls);
		/*System.out.println(Factory.getInstance().toString());*/
		firstScreen.setVisible(false);
		secondScreen.setVisible(true);
		int numberofparties=Integer.parseInt(numofParties.getText());
		ArrayList<HBox> hboxes = new ArrayList();
		for (int i = 0; i < numberofparties; i++){
			TextField partynames = new TextField();
			HBox hbox = new HBox(new Label("Name of Party"),partynames);
			hbox.setLayoutY(120 + (i*20));
			/*if ( i == 0) {
				hbox.setPadding(new Insets(15,12,15,12));
			}
			else {
				hbox.setPadding(new Insets(5,12,15,12));
			}*/
			hboxes.add(hbox);
			textfields.add(partynames);
			secondScreen.getChildren().add(hbox);
			
		}
		
	}
	/* code resets all the information entered in the textfield when rest button is clicked*/
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
		Factory.getInstance().setPartyNames(list.toArray(new String[0] ));
		System.out.println(Factory.getInstance().getPartyNames());
	}
}
	