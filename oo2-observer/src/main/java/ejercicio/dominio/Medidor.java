package ejercicio.dominio;

import java.util.List;

public class Medidor extends Observable {

	private String temperatura;
	private ClimaOnline clima;

	public Medidor(ClimaOnline clima, List<Observador> observadores) {

		this.clima = clima;
		for (Observador obs : observadores) {
			this.agregarObservador(obs);
		}

	}

	public String leerTemperatura() throws DominioException {

		this.temperatura = this.clima.temperatura();

		this.notificar(temperatura);

		return this.temperatura;
	}

}
