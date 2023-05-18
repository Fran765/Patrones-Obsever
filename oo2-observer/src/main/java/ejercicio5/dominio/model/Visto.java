package ejercicio5.dominio.model;

import java.util.ArrayList;
import java.util.List;

import ejercicio5.dominio.portsin.Espectador;

public abstract class Visto {
	
	private List<Espectador> misEspectadores;
	
	public Visto() {
		this.misEspectadores = new ArrayList<>();
	}
	
	public void agregarEspectador(Espectador nuevo) {
		this.misEspectadores.add(nuevo);
	}
	
	public void notificarNuevaVenta(double importe) {
		for(Espectador unEspectador: misEspectadores) {
			unEspectador.notificacionVenta(importe);
		}
	}

}
