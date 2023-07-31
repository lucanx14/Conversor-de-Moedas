package br.com.conversor.challenge.alura;

import java.text.DecimalFormat;

/**
 * Responsible class for the conversion of the values.
 * 
 * the methods valueRealParaEstrangeiro and ValueEstrangeiroParaReal uses the values given by an API, through the class DatesJson.
 * The others method have a metric value predetermined.
 * 
 * @author Lucas Silva
 * @version 0.1
 */
public class Conversor {
	private DecimalFormat formatar = new DecimalFormat("0.00");

	public String valueRealParaEstrangeiro(String valorAConverter, String valorMoeda) {
		return this.formatar.format(Double.valueOf(valorAConverter)/Double.valueOf(valorMoeda));
	}
	public String valueRealParaARS(String valorAConverter) {
		return this.formatar.format(Double.valueOf(valorAConverter)/ 0.018);
	}
	public String getValueRealParaCLP(String valorAConverter) {
		return this.formatar.format(Double.valueOf(valorAConverter)/ 0.0058);
	}
	public String getValueEstrangeiroParaReal(String valorAConverter, String valorMoeda) {
		return this.formatar.format(Double.valueOf(valorMoeda) * Double.valueOf(valorAConverter));
	}
	public String getValueARSParaReal(String valorAConverter) {
		return this.formatar.format(Double.valueOf(valorAConverter)* 0.018);
	}
	public String getValueCLPParaReal(String valorAConverter) {
		return this.formatar.format(Double.valueOf(valorAConverter)* 0.0058);
	}
	
	
	
	public String celsiusParaFahrenheit(String valorAConverter) {
		return this.formatar.format(Double.valueOf(valorAConverter)*1.8+32);
	}
	public String celsiusParaKelvin(String valorAConverter) {
		return this.formatar.format(Double.valueOf(valorAConverter)+273);
	}
	public String fahrenheitParaCelsius(String valorAConverter) {
		return this.formatar.format((Double.valueOf(valorAConverter)-32)/1.8);
	}
	public String fahrenheitParaKelvin(String valorAConverter) {
		return this.formatar.format((Double.valueOf(valorAConverter)-32)*5/9+273);
	}
	public String kelvinParaCelsius(String valorAConverter) {
		return this.formatar.format(Double.valueOf(valorAConverter)-273);
	}
	public String kelvinParaFahrenheit(String valorAConverter) {
		return this.formatar.format((Double.valueOf(valorAConverter)-273)*1.8+32);
	}
	
}
