package program1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GUI extends Application {
private Group root = new Group();
private String filePath = "";
private Stack stack = new Stack();
private Scanner myScan;
private Text status = new Text("");

public static void main(String[] args) throws FileNotFoundException {
	launch(args);
}
	@Override
	public void start(Stage primaryStage) throws Exception {
	TextField file = new TextField();
	file.setText("default.txt");file.setLayoutX(200);file.setLayoutY(200);
	status.setLayoutX(100);status.setLayoutY(300);
	Text header = new Text("Please upload the file first, then read onto stack before performing any other operations.\n"
			+ "A default file is already provided for you.");
	header.setX(80);header.setY(100);
	
	//Upload Button
	Button upload = new Button("Upload File"); upload.setLayoutX(400);upload.setLayoutY(200);
	upload.setOnAction(new EventHandler<ActionEvent>() {
		@Override
		public void handle (ActionEvent event) {
			filePath = file.getText();
			File myFile = new File(filePath);
			try {
				myScan = new Scanner(new FileReader(myFile));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			file.clear();
		}});
	
	
	
	//Read Button
	Button readOnStack = new Button("Read Lines Onto Stack");
	readOnStack.setLayoutX(700);readOnStack.setLayoutY(100);
	readOnStack.setOnAction(new EventHandler<ActionEvent>() {
		@Override
		public void handle (ActionEvent event) {
			while(myScan.hasNextLine()) {
				stack.push(myScan.nextLine());
				status.setText("Lines Read Onto Stack!");
			}
		}});
	
	//Display top element of stack
	
	Button peekTop = new Button("See Top Element");
	peekTop.setLayoutX(700);peekTop.setLayoutY(150);
	peekTop.setOnAction(new EventHandler<ActionEvent>() {
		@Override
		public void handle (ActionEvent event) {
			status.setText(stack.peekTop());
		}});
	
	//Check syntax
	Button checkSyntax = new Button("Check Entire File Syntax");
	checkSyntax.setLayoutX(700);checkSyntax.setLayoutY(200);
	checkSyntax.setOnAction(new EventHandler<ActionEvent>() {
		@Override
		public void handle (ActionEvent event) {
			int i = stack.checkSyntax();
	
			if (i % 2 ==0) {
				status.setText("Your file looks syntactically correct!");
			}else {
				status.setText("One or more of the following characters has an uneven number:\n"
						+ "'{',  '}',  '(',  ')',  \"\n"
						+ "Possible syntax error!");
			}
		}});
	
	//Delete top stack item
	Button popStack = new Button("Delete Top Stack Item");
	popStack.setLayoutX(700);popStack.setLayoutY(250);
	popStack.setOnAction(new EventHandler<ActionEvent>() {
		@Override
		public void handle (ActionEvent event) {
			stack.pop();
			status.setText("Item deleted!");
		}});
	
	root.getChildren().addAll(header, file, upload,status, readOnStack, peekTop, checkSyntax, popStack);
	Scene myScene = new Scene(root, 1000, 700);
	primaryStage.setScene(myScene);
	primaryStage.show();
	
		
		
		
		
		
		
	}

}
