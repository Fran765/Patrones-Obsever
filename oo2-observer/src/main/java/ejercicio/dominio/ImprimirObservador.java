package ejercicio.dominio;

public class ImprimirObservador implements Observador {

	private static final String MSJ_TEMPERATURA_BAJA = "“Hace frio, se encenderá la caldera”";
	private static final String MSJ_TEMPERATURA_ALTA = "“Hace calor, se encenderá el aire acondicionado”";

	private static final Double TEMPERATURA_MINIMA = 12.0;
	private static final Double TEMPERATURA_MAXIMA = 17.0;

	@Override
	public void refrescar(String nuevoEstado) {
		double temp = Double.parseDouble(nuevoEstado);
		if (temp < ImprimirObservador.TEMPERATURA_MINIMA) {
			System.out.println(ImprimirObservador.MSJ_TEMPERATURA_BAJA);
			
		} else if (temp > ImprimirObservador.TEMPERATURA_MAXIMA) {
			System.out.println(ImprimirObservador.MSJ_TEMPERATURA_ALTA);
			
		}

	}

}
