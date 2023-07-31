package br.com.conversor.challenge.alura;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty;
/**
 *  
 * Responsible class for the creation of the object JFrame and your layout
 *  
 * @author Lucas Silva
 * @version 0.1
 * 
 */
public class MyFrame extends JFrame {
//	{ "USD", "EUR", "GBP", "ARS", "CLP" }
	private static String[][] conversores = {
			{ "Conversor de moedas", "Conversor de temperatura" },
			{ "De Reais a dolares", "De Reais a Euro", "De Reais a Libras Esterlinas",
		"De Reais a Peso Argentino", "De Reais a Peso Chileno", "De Dolares a Reais", 
		"De Euro a Reais", "De Libras Esterlinas a Reais", "De Peso Argentino a Reais", 
		"De Peso Chileno a Reais"},			
			{ "De Celsius para Fahrenheit", "De Celsius para Kelvin",
				"De Fahrenheit para Kelvin", "De Fahrenheit para Celsius", "De Kelvin para Fahrenheit",
				" De Kelvin para Celsius" }
		};
	
	/**
	 * Constructor for initialize the object MyFrame using an Array of String as an argument.
	 * 
	 * @param conversor
	 */
	public MyFrame(String[] conversor) {
		this.telaInicial(new JComboBox(conversor), conversor.length);
	}
	
	/**
	 * Second constructor for initialize the object MyFrame, without the need of pass an argument.
	 */
	public MyFrame() {
		this.telaInicial(new JComboBox(conversores[0]), 0);
	}
	
	/**
	 * Responsible Method for the creation of the screens, in it are passed, as argument, an object JComboBox and an int as a index
	 * to identify the elements inside of the JComboBox.
	 * @param jcombo
	 * @param index
	 */
	public void telaInicial(JComboBox<String> jcombo, int index) {

		JPanel panelButtons = new JPanel();

		panelButtons.add(new MyButtons().ok(jcombo, this, index));
		panelButtons.add(new MyButtons().cancelar(this));
		
		ImageIcon icon = new ImageIcon("src/main/resources/currency-exchange.png");
		this.setIconImage(icon.getImage());
		this.setSize(300, 140);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.add(panel(jcombo), BorderLayout.NORTH);
		this.add(panelButtons, BorderLayout.SOUTH);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	}
	
	/**
	 * Method that return an formated JPanel object, and takes as argument a JComboBox
	 * 
	 * @param jcombo
	 * @return panelJCombo
	 */
	public JPanel panel(JComboBox jcombo) {
		JPanel panelJCombo = new JPanel();
		JLabel label = new JLabel("Escolha uma opção");
		panelJCombo.setBorder(new EmptyBorder(10, 15, 0, 15));
		panelJCombo.setLayout(new GridLayout(2, 1, 0, 0));
		panelJCombo.add(label);
		panelJCombo.add(jcombo);
		
		return panelJCombo;
	}
	
	/**
	 * Pass as argument an int to acess the elements inside of the array conversores and returns the acessed elements.	
	 * 
	 * @param i
	 * @return conversores[i]
	 */
	public static String[] getConversores(int i){
		return conversores[i];
	}
}
