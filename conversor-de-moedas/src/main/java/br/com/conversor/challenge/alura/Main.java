package br.com.conversor.challenge.alura;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Main Class.
 * 
 * @author Lucas Silva
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DatesJson.setTime(LocalDate.now().format(DateTimeFormatter.ofPattern("MM-dd-uuuu")));
		new MyFrame();
		

	}

}
