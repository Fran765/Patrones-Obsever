package ejercicio.main;

import java.util.List;

import ejercicio.dominio.AlmacenarObservador;
import ejercicio.dominio.DominioException;
import ejercicio.dominio.ImprimirObservador;
import ejercicio.dominio.Medidor;
import ejercicio.dominio.WeatherChannelService;

public class Main {

	public static void main(String[] args) {

		Medidor miMedidor = new Medidor(new WeatherChannelService("7d5536c9de5773ac0574b17c23335dc7", "metric"),
				List.of(new AlmacenarObservador("Datos_Clima"), new ImprimirObservador()));

		try {
			System.out.println(miMedidor.leerTemperatura());
		} catch (DominioException e) {
			e.printStackTrace();
		}

	}

}
