package ejercicio4.dominio.model;

import java.util.ArrayList;
import java.util.List;

import ejercicio4.dominio.portsout.Espectador;
import ejercicio4.dominio.portsout.ParticipanteRecordOut;
import ejercicio4.dominio.portsout.RegistroException;


public abstract class Observable {
	

	List<Espectador> misEspectadores;

	public Observable() {
		this.misEspectadores = new ArrayList<>();
	}

	public void agregarObservador(Espectador nuevo) {
		this.misEspectadores.add(nuevo);
	}

	public void notificar(ParticipanteRecordOut participante) throws RegistroException {
		for (Espectador obs : misEspectadores) {
			obs.cambioEstado(participante);
		}
	}

}
