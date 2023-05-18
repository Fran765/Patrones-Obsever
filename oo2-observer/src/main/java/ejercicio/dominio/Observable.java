package ejercicio.dominio;

import java.util.ArrayList;
import java.util.List;

public abstract class Observable {

	List<Observador> misObservadores;

	public Observable() {
		this.misObservadores = new ArrayList<>();
	}

	void agregarObservador(Observador nuevo) {
		this.misObservadores.add(nuevo);
	}

	void notificar(String estado) {
		for (Observador obs : misObservadores) {
			obs.refrescar(estado);
		}
	}

}
