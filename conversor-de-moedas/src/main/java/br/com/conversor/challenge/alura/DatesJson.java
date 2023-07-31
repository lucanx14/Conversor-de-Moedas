package br.com.conversor.challenge.alura;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Class responsible for fetching the updated values of some currencies through an API.
 * 
 * @author Lucas Silva
 * @version 0.1
 */

public class DatesJson {
	private static String apiCotacao = "https://olinda.bcb.gov.br/olinda/servico/PTAX/versao/v1/odata/CotacaoMoedaPeriodoFechamento("
			+ "codigoMoeda=@codigoMoeda,dataInicialCotacao=@dataInicialCotacao,dataFinalCotacao=@dataFinalCotacao)"
			+ "?@codigoMoeda='USD'&@dataInicialCotacao='07-17-2023'&@dataFinalCotacao='07-24-2023'"
			+ "&$orderby=dataHoraCotacao%20desc&$format=json&$select=cotacaoCompra,dataHoraCotacao";

	/**
	 * Setter responsible for defining the date to be used in the API. Receives a String argument representing a date in the format MM-dd-yyyy.
	 *
	 * @param time The date in the format MM-dd-yyyy.
	 */

	public static void setTime(String time) {
		String regex = "@dataInicialCotacao='(\\d{2}-d{2}-d{4})'";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(apiCotacao);

		if (matcher.find()) {
			apiCotacao = apiCotacao.replace(matcher.group(1), time);
		}
	}

	/**
	 *  
	 * Receives, as a parameter, the abbreviation of the currency desired by the user for conversion.
	 * @param moeda The abbreviation of the desired currency.
	*/
	public static void setMoedaApi(String moeda) {
		String regex = "@codigoMoeda='(\\w+)'";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(apiCotacao);

		if (matcher.find()) {
			apiCotacao = apiCotacao.replace(matcher.group(1), moeda);
		}
	}

	/**
	 * 
	 * Responsible for obtaining the purchase value of a currency through an
	 * external API.
	 * 
	 * @return The purchase value or null if it is not possible to obtain the value.
	 * @throws IOException          If an I/O error occurs during the HTTP call.
	 * @throws InterruptedException If the thread is interrupted while waiting for
	 *                              the HTTP response.
	 */
	public static String getValorMoeda() {
		HttpClient httpClient = HttpClient.newHttpClient();
		HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(apiCotacao)).GET().build();
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
			String responseBody = response.body();
			JsonNode rootNode = objectMapper.readTree(responseBody);
			JsonNode jsonNOde = rootNode.get("value");
			for (JsonNode valores : jsonNOde) {
				String valorCotacao = valores.get("cotacaoCompra").asText();
				return valorCotacao;
			}
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	}

}
