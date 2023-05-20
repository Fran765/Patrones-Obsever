package ejercicio3.main;

import ejercicio3.dominio.Almacenar;
import ejercicio3.dominio.DominioException;
import ejercicio3.dominio.Imprimir;
import ejercicio3.dominio.LecturaClima;
import ejercicio3.dominio.Medidor;
import ejercicio3.dominio.WeatherChannelService;

public class Main {

	public static void main(String[] args) {

		LecturaClima miClass = new Almacenar(
				new Imprimir(new Medidor(new WeatherChannelService("7d5536c9de5773ac0574b17c23335dc7", "metric"))),
				"Datos_Clima_P3");

		try {
			System.out.println("Desde main: " + miClass.leerTemperatura());
		} catch (DominioException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
