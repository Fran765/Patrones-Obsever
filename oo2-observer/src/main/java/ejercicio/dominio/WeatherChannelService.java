package ejercicio.dominio;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Objects;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

public class WeatherChannelService implements ClimaOnline {

	private String url = "https://api.openweathermap.org/data/2.5/weather?q=viedma,032&lang=sp&appid=";
	private String unidad = "&units=";

	public WeatherChannelService(String apiKey, String unidadMedida) {
		Objects.requireNonNull(apiKey);
		Objects.requireNonNull(unidadMedida);

		this.url = this.url + apiKey + unidad + unidadMedida;
	}

	@Override
	public String temperatura() throws DominioException {

		HttpClient httpClient = HttpClient.newHttpClient();

		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(this.url)).build();

		HttpResponse<String> response = null;
		try {
			response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
		} catch (IOException | InterruptedException e) {

			throw new DominioException("Error al consultar el clima", e);
		}

		String jsonString = response.body();

		Gson gson = new GsonBuilder().create();
		var jsonObject = gson.fromJson(jsonString, JsonObject.class);

		var main = jsonObject.getAsJsonObject("main");

		return main.get("temp").toString();

	}

}
