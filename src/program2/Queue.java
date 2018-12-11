package program2;

import java.io.FileNotFoundException;
import java.util.Date;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
//Create by Adrian ashwah
//Queue implementation that uses a Linked List implementation
public class Queue extends Application{
private SLinkedList line = new SLinkedList();
private Node node;
private Group root = new Group();
private Date date = new Date();
private Text status = new Text("");
	public static void main(String[] args)  {
		
		launch(args);
	}
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		//TextFields
		status.setX(100);status.setY(250);
		TextField name = new TextField();
		TextField occupation = new TextField();
		name.setLayoutX(100);name.setLayoutY(100);
		occupation.setLayoutX(350);occupation.setLayoutY(100);
		name.setPromptText("Enter Name");occupation.setPromptText("Enter Occupation");
		
		//Add to Queue button
		
		Button addQueue = new Button("Add to Queue");
		addQueue.setLayoutX(600);addQueue.setLayoutY(100);
		addQueue.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle (ActionEvent event) {
				Person newPerson = new Person(name.getText(), occupation.getText(), date);
				node = new Node(newPerson.toString(), null);
				line.addLast(node);
				name.clear();occupation.clear();
			}});
		
		
		
		//Display 1st in Queue
		
		Button display = new Button("Show 1st in Queue");
		
		display.setLayoutX(600);display.setLayoutY(150);
		display.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle (ActionEvent event) {
				status.setText(line.getFirstNode().getElement());
			}});
		
		
		
		//Remove 1st from Queue
		
		Button removeFirst = new Button("Remove 1st in Queue");
		
		removeFirst.setLayoutX(600);removeFirst.setLayoutY(200);
		removeFirst.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle (ActionEvent event) {
				line.removeFirst();
				status.setText("Removed first person in line!");;
			}});
		
		
		
		
		
		root.getChildren().addAll(name, occupation, addQueue, display, status, removeFirst);
		Scene myScene = new Scene(root, 1000, 700);
		primaryStage.setScene(myScene);
		primaryStage.show();
		
	}
	
}
