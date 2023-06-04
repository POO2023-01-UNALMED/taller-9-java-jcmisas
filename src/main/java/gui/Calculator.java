package gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class Calculator extends VBox implements EventHandler<***>{
	
	String number1 = "";
	String number2 = "";
	String operator;
	Text displayText;
	
	public Calculator(){
		super(10);
		this.displayText = new Text();
		
		Rectangle rt = new Rectangle(250, 50, Color.TRANSPARENT);
		
		rt.setStroke(Color.GRAY);
		
		StackPane sp =  new StackPane(rt, this.displayText);
		
		sp.setPadding(new Insets(10, 10, 10, 10));
		
		*** gd = new GridPane();
		
		gd.setPadding(new Insets(10, 10, 10, 10));
		gd.setVgap(5);
		gd.setHgap(4);
		
		gd.setAlignment(Pos.***);
		
		Button b7 = new ***("7");
		gd.add(b7, 0, ***);
		b7.setPrefWidth(50);
		b7.setOnAction(this);
		
		*** b8 = new Button("8");
		gd.add(b8, ***, 0);
		b8.setPrefWidth(50);
		b8.setOnAction(this);
		
		Button b9 = new Button(***);
		gd.add(b9, 2, ***);
		b9.setPrefWidth(50);
		b9.setOnAction(this);
		
		Button div = new Button("/");
		gd.add(div, ***, ***);
		div.setPrefWidth(50);
		div.setOnAction(***);
		
		*** b4 = new Button("4");
		gd.add(b4, 0, 1);
		b4.setPrefWidth(50);
		b4.setOnAction(this);
		
		Button b5 = new ***("5");
		gd.***(b5, 1, 1);
		b5.setPrefWidth(50);
		b5.setOnAction(this);
		
		Button b6 = new Button("6");
		gd.add(b6, ***, ***);
		b6.setPrefWidth(50);
		***.setOnAction(this);
		
		*** mul = new Button("*");
		gd.add(mul, ***, 1);
		mul.setPrefWidth(50);
		mul.setOnAction(this);
		
		Button b1 = new Button(***);
		gd.add(b1, 0, ***);
		b1.setPrefWidth(50);
		b1.setOnAction(this);
		
		Button b2 = new ***("2");
		gd.add(b2, ***, 2);
		b2.setPrefWidth(50);
		b2.setOnAction(this);
		
		Button b3 = new ***("3");
		***.add(b3, 2, 2);
		b3.setPrefWidth(50);
		b3.setOnAction(***);
		
		*** minus = new Button("-");
		gd.add(minus, 3, ***);
		minus.setPrefWidth(50);
		minus.setOnAction(this);
		
		Button b0 = new ***("0");
		gd.add(b0, 0, 3, 2, 1);
		b0.setPrefWidth(105);
		***.setOnAction(this);
		
		Button plus = new Button("+");
		gd.***(plus, ***, 3);
		plus.setPrefWidth(50);
		plus.setOnAction(this);
		
		Button equals = new Button(***);
		***.add(equals, 3, 3);
		equals.setPrefWidth(50);
		equals.setOnAction(this);
		
		Button reset = new ***("C");
		gd.add(reset, 0, 4, ***, 1);
		reset.setPrefWidth(215);
		reset.setOnAction(***);
		
		this.getChildren().addAll(sp, gd);
	}

	@Override
	public void ***(ActionEvent event) {
		
		Button b = (Button) event.getSource();
		String value = b.getText();
		
		***
		***
		***
		
	}
	

}
