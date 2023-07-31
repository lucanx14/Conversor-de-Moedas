package br.com.conversor.challenge.alura;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 * Responsible class for the creation of the buttons and yours events
 * 
 * @author Lucas Silva
 * @version 0.1
 */
public class MyButtons extends JButton{
	private static String answer;
	
	/**
	 * Method that creates the button "OK" and add your events
	 * 
	 * @param option
	 * @param frame
	 * @param i
	 * @return MyButtons
	 */
	public MyButtons ok(JComboBox option, MyFrame frame, int i) {
		this.setText("OK");
		this.setFocusable(false);
		this.addActionListener(e -> {

			if (i == 0) {
				tempOuMoeda(option, frame);
			} else if (i == 10) {
				moeda(option, frame);
			} else if (i == 6) {
				temperatura(option, frame);
			}

		});
		return this;
	}
	
	/**
	 * Method that creates a button "cancelar" and add your events.
	 * 
	 * @param frame
	 * @return MyButtons
	 */
	public MyButtons cancelar(MyFrame frame) {
		this.setText("Cancel");
		this.addActionListener(e -> {
			frame.dispose();
		});
		return this;
	}
	
	/**
	 * Responsible Method for the choice of the type of the converter(moedas ou temperatura), through theJComboBox.
	 * An input JOptionPane is invoked to takes the value that will be storage using the method setAnswer
	 * and will be, after, converted to the type that the user wants.
	 * 
	 * @param option
	 * @param frame
	 */
	public void tempOuMoeda(JComboBox<String> option, MyFrame frame) {
		frame.dispose();
		setAnswer(JOptionPane.showInputDialog("Insira um valor"));
		if (answer.matches("[0-9]+")) {
			if (option.getSelectedItem() == "Conversor de moedas") {
				new MyFrame(MyFrame.getConversores(1));
			} else {
				new MyFrame(MyFrame.getConversores(2));
			}
		} else {
			JOptionPane.showMessageDialog(null, "Digite um valor valido!");
			new MyFrame();
		}
	}
	/**
	 * Screen where the user will choose to which type of coin the value, given before, will be converted. After
	 * this, will be created an JOptionPane to show the results.
	 * 
	 * @param option
	 * @param frame
	 */
	public void moeda(JComboBox option, MyFrame frame) {
		Conversor conversor = new Conversor();
		String resultado;
		
		try {
			
			if (option.getSelectedIndex() == 0) {
				DatesJson.setMoedaApi("USD");
				resultado = conversor.valueRealParaEstrangeiro(answer, DatesJson.getValorMoeda());
				JOptionPane.showMessageDialog(null, new StringBuilder().append("Você tem $" + resultado + " Dolares"));
			} else if (option.getSelectedIndex() == 1) {
				DatesJson.setMoedaApi("EUR");
				resultado = conversor.valueRealParaEstrangeiro(answer, DatesJson.getValorMoeda());
				JOptionPane.showMessageDialog(null, new StringBuilder().append("Você tem $" + resultado + " Euros"));
			} else if (option.getSelectedIndex() == 2) {
				DatesJson.setMoedaApi("GBP");
				resultado = conversor.valueRealParaEstrangeiro(answer, DatesJson.getValorMoeda());
				JOptionPane.showMessageDialog(null, new StringBuilder().append("Você tem $" + resultado + " Libras Esterlinas"));
			} else if (option.getSelectedIndex() == 3) {
				resultado = conversor.valueRealParaARS(answer);
				JOptionPane.showMessageDialog(null, new StringBuilder().append("Você tem $" + resultado + " Peso Argentino"));
			} else if (option.getSelectedIndex() == 4) {
				resultado = conversor.getValueRealParaCLP(answer);
				JOptionPane.showMessageDialog(null, new StringBuilder().append("Você tem $" + resultado + " Peso Chileno"));
			} else if (option.getSelectedIndex() == 5) {
				DatesJson.setMoedaApi("USD");
				resultado = conversor.getValueEstrangeiroParaReal(answer, DatesJson.getValorMoeda());
				JOptionPane.showMessageDialog(null, new StringBuilder().append("Você tem $" + resultado + " Reais"));
			} else if (option.getSelectedIndex() == 6) {
				DatesJson.setMoedaApi("EUR");
				resultado = conversor.getValueEstrangeiroParaReal(answer, DatesJson.getValorMoeda());
				JOptionPane.showMessageDialog(null, new StringBuilder().append("Você tem $" + resultado + " Reais"));
			} else if (option.getSelectedIndex() == 7) {
				DatesJson.setMoedaApi("GBP");
				resultado = conversor.getValueEstrangeiroParaReal(answer, DatesJson.getValorMoeda());
				JOptionPane.showMessageDialog(null, new StringBuilder().append("Você tem $" + resultado + " Reais"));
			} else if (option.getSelectedIndex() == 8) {
				resultado = conversor.getValueARSParaReal(answer);
				JOptionPane.showMessageDialog(null, new StringBuilder().append("Você tem $" + resultado + " Reais"));
			} else if (option.getSelectedIndex() == 9) {
				resultado = conversor.getValueCLPParaReal(answer);
				JOptionPane.showMessageDialog(null, new StringBuilder().append("Você tem $" + resultado + " Reais"));
			}
		}catch(NullPointerException e) {
			JOptionPane.showMessageDialog(null, "Estamos com problemas tecnicos, tente novamente mais tarde!");
		}
		frame.dispose();
	}
	
	/**
	 * Screen where the user will choose to which temperature measurement unit the given value will be converted to.
	 * After this, will be created a JOptionPane to show the result.
	 * 
	 * @param option
	 * @param frame
	 */
	public void temperatura(JComboBox option, MyFrame frame) {
		Conversor conversor = new Conversor();
		String resultado;

		if (option.getSelectedIndex() == 0) {
			resultado = conversor.celsiusParaFahrenheit(answer);
			JOptionPane.showMessageDialog(null,
					new StringBuilder().append("A temperatura é de " + resultado + " Graus Fanrenheit"));
		} else if (option.getSelectedIndex() == 1) {
			resultado = conversor.celsiusParaKelvin(answer);
			JOptionPane.showMessageDialog(null,
					new StringBuilder().append("A temperatura é de " + resultado + " Graus Kelvin"));
		} else if (option.getSelectedIndex() == 2) {
			resultado = conversor.fahrenheitParaKelvin(answer);
			JOptionPane.showMessageDialog(null,
					new StringBuilder().append("A temperatura é de " + resultado + " Graus Kelvin"));
		} else if (option.getSelectedIndex() == 3) {
			resultado = conversor.fahrenheitParaCelsius(answer);
			JOptionPane.showMessageDialog(null,
					new StringBuilder().append("A temperatura é de " + resultado + " Graus Celsius"));
		} else if (option.getSelectedIndex() == 4) {
			resultado = conversor.kelvinParaFahrenheit(answer);
			JOptionPane.showMessageDialog(null,
					new StringBuilder().append("A temperatura é de " + resultado + " Graus Fahrenheit"));
		} else if (option.getSelectedIndex() == 5) {
			resultado = conversor.kelvinParaCelsius(answer);
			JOptionPane.showMessageDialog(null,
					new StringBuilder().append("A temperatura é de " + resultado + "Graus Celsius"));
		}
		frame.dispose();
	}
	
	/**
	 * getter of the String answer.
	 * @return answer
	 */
	public static String getAnswer() {
		return answer;
	}
	
	/**
	 * setter of the String answer.
	 * @param answer
	 */
	public static void setAnswer(String answer) {
		MyButtons.answer = answer;
	}
}
