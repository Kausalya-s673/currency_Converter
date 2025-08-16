package currency_Converter;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.*;

public class CurrencyConverter {
public static void main(String[] args) {
	new ConverterFrame();
}
}
class ConverterFrame extends JFrame implements ActionListener{
	JComboBox<String> fromCurrency , toCurrency;
	JTextField amountField;
	JButton convertButton;
	JLabel resultLabel;
	HashMap<String , Double> exchangeRates;
	
	ConverterFrame(){
	setTitle("Currency Converter");
	setSize(400,250);
	setLayout(new GridLayout(5,2, 10 , 10));
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	String[] currencies= {"USD","EUR","INR","JPY","GBP"};
	fromCurrency=new JComboBox<>(currencies);
	toCurrency=new JComboBox<>(currencies);
	
	amountField=new JTextField();
	convertButton= new JButton("Convert");
	resultLabel= new JLabel("Converted Amount: ");
	
	convertButton.addActionListener(this);
	
	add(new JLabel("From : "));
	add(fromCurrency);
	add(new JLabel("To: "));
	add(toCurrency);
	add(new JLabel("Amount : "));
	add(amountField);
	add(convertButton);
	add(resultLabel);
	
	exchangeRates=new HashMap<>();
	exchangeRates.put("USD", 1.0);
	exchangeRates.put("EUR", 0.85);
	exchangeRates.put("INR", 83.0);
	exchangeRates.put("JPY", 110.0);
	exchangeRates.put("GBP", 0.75);
	
	  setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			double amount = Double.parseDouble(amountField.getText());
			String from=(String) fromCurrency.getSelectedItem();
			String to=(String) toCurrency.getSelectedItem();
			
			double converted= amount/exchangeRates.get(from)*exchangeRates.get(to);
			resultLabel.setText(String.format("Converted Amount: %.2f %s",converted,to));
			
		}catch(Exception ex){
			resultLabel.setText("Invalid Input , Try again.");
		}
	}
}

