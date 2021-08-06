/**@author Shaohuan Xia
 * @author Carlene Kalin
 * @author Hima Rajesh
 */

package application;
	
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

import model.Factory;
import model.PollList;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.StackPane;

/**This class is used to integrate the individual portions
 * and allow user to switch the views.
 * The data is shared among each component.
 */
public class PollTrackerApp extends Application {
	Stage primaryStage;
	PollList polls;
	
	//to set up the primary view
	private void setupView() {
		FXMLLoader loader = new FXMLLoader();
		Scene scene;
		//use exception to make the code clear
		try {
			Parent setupView = (Parent) loader.load(new FileInputStream("view/SetupView.fxml"));
			SetupController setupController = loader.getController();
			setupController.linkWithApplication(this);
			scene = new Scene(setupView,300,300);
			primaryStage.setScene(scene);
			primaryStage.show();		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**This is used to switch the views
	 * allow 2 tabs being shown in a view
	 */
	void pollView() {
		FXMLLoader loader = new FXMLLoader();
		Scene scene;
		polls = Factory.getInstance().createEmptyPolls();

		try {
			loader = new FXMLLoader();
			//load the first tab
			Tab editView = new Tab("Edit", loader.load(new FileInputStream("view/EditPollView.fxml")));
			EditPollController editPollController = loader.getController();
			editPollController.setPolls(polls);
			editPollController.refresh();
			loader = new FXMLLoader();
			//load the second tab
			Tab visualizeView = new Tab("Visualize", loader.load(new FileInputStream("view/VisualizePollView.fxml")));
			VisualizePollController visualizePollController = loader.getController();
			visualizePollController.setPolls(polls);
			TabPane root = new TabPane(editView, visualizeView);
			scene = new Scene(root, 800,500);
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
	}
	/**
	 * Set up the first scene
	 */
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		setupView();
		
	}
	/**
	 * launch
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
