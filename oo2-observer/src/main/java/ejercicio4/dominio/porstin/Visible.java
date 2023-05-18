package ejercicio4.dominio.porstin;

import java.util.ArrayList;
import java.util.List;

import ejercicio4.dominio.portsout.Espectador;
import ejercicio4.dominio.portsout.ParticipanteRecordOut;
import ejercicio4.dominio.portsout.RegistroException;

public abstract class Visible {

	private List<Espectador> misEspectadores;

	public Visible() {
		this.misEspectadores = new ArrayList<>();
	}

	public void agregarEspectador(Espectador nuevo) {
		this.misEspectadores.add(nuevo);
	}

	public void notificarNuevo(ParticipanteRecordOut nuevoParticipante) throws RegistroException {
		for (Espectador esp : misEspectadores) {
			esp.cambioEstado(nuevoParticipante);
		}
	}

}
