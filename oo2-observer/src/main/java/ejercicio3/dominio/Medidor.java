package ejercicio3.dominio;

public class Medidor implements LecturaClima{

	private String temperatura;
	private ClimaOnline clima;

	public Medidor(ClimaOnline clima) {
		this.clima = clima;
	}

	public String leerTemperatura() throws DominioException {

		this.temperatura = this.clima.temperatura();
		return this.temperatura;
	}

}
