package gui;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.regex.Pattern;

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

public class Calculator extends VBox implements EventHandler<ActionEvent>{
	
	String number1 = "";
	String number2 = "";
	String operator;
	Text displayText;
	
	public Calculator(){
		super(10);
		this.displayText = new Text("0");
		
		Rectangle rt = new Rectangle(250, 50, Color.TRANSPARENT);
		
		rt.setStroke(Color.GRAY);
		
		StackPane sp =  new StackPane(rt, this.displayText);
		
		sp.setPadding(new Insets(10, 10, 10, 10));
		
		GridPane gd = new GridPane();
		
		gd.setPadding(new Insets(10, 10, 10, 10));
		gd.setVgap(5);
		gd.setHgap(4);
		
		gd.setAlignment(Pos.CENTER);
		
		Button b7 = new Button("7");
		gd.add(b7, 0, 0);
		b7.setPrefWidth(50);
		b7.setOnAction(this);
		
		Button b8 = new Button("8");
		gd.add(b8, 1, 0);
		b8.setPrefWidth(50);
		b8.setOnAction(this);
		
		Button b9 = new Button("9");
		gd.add(b9, 2, 0);
		b9.setPrefWidth(50);
		b9.setOnAction(this);
		
		Button div = new Button("/");
		gd.add(div, 3, 0);
		div.setPrefWidth(50);
		div.setOnAction(this);
		
		Button b4 = new Button("4");
		gd.add(b4, 0, 1);
		b4.setPrefWidth(50);
		b4.setOnAction(this);
		
		Button b5 = new Button("5");
		gd.add(b5, 1, 1);
		b5.setPrefWidth(50);
		b5.setOnAction(this);
		
		Button b6 = new Button("6");
		gd.add(b6, 2, 1);
		b6.setPrefWidth(50);
		b6.setOnAction(this);
		
		Button mul = new Button("*");
		gd.add(mul, 3, 1);
		mul.setPrefWidth(50);
		mul.setOnAction(this);
		
		Button b1 = new Button("1");
		gd.add(b1, 0, 2);
		b1.setPrefWidth(50);
		b1.setOnAction(this);
		
		Button b2 = new Button("2");
		gd.add(b2, 1, 2);
		b2.setPrefWidth(50);
		b2.setOnAction(this);
		
		Button b3 = new Button("3");
		gd.add(b3, 2, 2);
		b3.setPrefWidth(50);
		b3.setOnAction(this);
		
		Button minus = new Button("-");
		gd.add(minus, 3, 2);
		minus.setPrefWidth(50);
		minus.setOnAction(this);
		
		Button b0 = new Button("0");
		gd.add(b0, 0, 3, 2, 1);
		b0.setPrefWidth(105);
		b0.setOnAction(this);
		
		Button plus = new Button("+");
		gd.add(plus, 2, 3);
		plus.setPrefWidth(50);
		plus.setOnAction(this);
		
		Button equals = new Button("=");
		gd.add(equals, 3, 3);
		equals.setPrefWidth(50);
		equals.setOnAction(this);
		
		Button reset = new Button("C");
		gd.add(reset, 0, 4, 3, 1);
		reset.setPrefWidth(215);
		reset.setOnAction(event -> displayText.setText("0"));
		
		this.getChildren().addAll(sp, gd);
	}

	// @Override
	// public void start(ActionEvent event) {
		
	// 	Button b = (Button) event.getSource();
	// 	String value = b.getText();
		
	// 	***
	// 	***
	// 	***
		
	// }

	@Override
	public void handle(ActionEvent e) {
		Button bu= (Button) e.getSource();
		String value= bu.getText();
		String[] operadores= {"+", "-", "*", "/"};
		Integer[] numeros= {0,1,2,3,4,5,6,7,8,9};
		String[] display_values=displayText.getText().split("");
		String display=displayText.getText();
		System.out.println(display.length());

		if(displayText.getText().contains("No")){
			displayText.setText("No se puede dividir entre 0");
		}else if (isNumeric(value)){
			if(Integer.parseInt(value)==0 && displayText.getText().equals("0")){
				displayText.setText("0");
			}else if(Integer.parseInt(value)!=0 && displayText.getText().equals("0")){
				
				displayText.setText(value);

			}else{
				displayText.setText(displayText.getText() + value);
			}
		}else if(Arrays.asList(operadores).contains(value) && Arrays.stream(numeros).anyMatch(num -> Arrays.asList(display_values).contains(num.toString())) && !Arrays.stream(operadores).anyMatch(Arrays.asList(display_values)::contains)){

			displayText.setText(displayText.getText() + value);

		}else if(Arrays.asList(operadores).contains(value) && Arrays.stream(operadores).anyMatch(Arrays.asList(display_values)::contains) && !Arrays.asList(operadores).contains(display_values[0]) && !isNumeric(display_values[display.indexOf(Arrays.stream(operadores).filter(display::contains).findFirst().orElse(null))+1])){
			
			displayText.setText(display.substring(0,display.length()-1) + value);

		}else if(Arrays.asList(operadores).contains(value) && isNumeric(display_values[display.indexOf(Arrays.stream(operadores).filter(display::contains).findFirst().orElse(null))+1]) && !Arrays.asList(operadores).contains(display_values[0])){
			
			displayText.setText(displayText.getText());
		
		}else if(Arrays.asList(operadores).contains(value) && Arrays.asList(operadores).contains(display_values[0])){

			displayText.setText(displayText.getText() + value);
		}else if(value=="="){
			Map<String, BiFunction<Double,Double,Double>> operaciones = new HashMap<String, BiFunction<Double,Double,Double>>();
			operaciones.put("+", (a,b)->a+b);
			operaciones.put("-", (a,b)->a-b);
			operaciones.put("*", (a,b)->a*b);
			operaciones.put("/", (a,b)->a/b);
			operaciones.put("/", (a,b)->b!=0 ? a/b : null);

			Double resultado=0.0;
			String[] partes=null;
			

			for(Map.Entry<String, BiFunction<Double,Double,Double>> entry : operaciones.entrySet()){
				if(display.contains(entry.getKey())){
					partes=display.split(Pattern.quote(entry.getKey()));
					if(partes.length==2){
						resultado= entry.getValue().apply(Double.parseDouble(partes[0]), Double.parseDouble(partes[1]));
						break;
					}
			
				}
			
			}
				displayText.setText(resultado!=null ? String.valueOf(resultado) : "No se puede dividir entre 0");
				

		}
		
		
	}

	private boolean isNumeric(String value) {

		try {
			Integer.parseInt(value);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}
	

}
