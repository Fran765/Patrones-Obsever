package ejercicio4.dominio.model;

import java.util.List;

import ejercicio4.dominio.porstin.DominioException;
import ejercicio4.dominio.porstin.ParticipanteRecord;
import ejercicio4.dominio.porstin.RegistroDeParticipante;
import ejercicio4.dominio.porstin.Visible;
import ejercicio4.dominio.portsout.Espectador;
import ejercicio4.dominio.portsout.ParticipanteRecordOut;
import ejercicio4.dominio.portsout.RegistroException;

public class DefaultRegistroDeParticipante extends Visible implements RegistroDeParticipante {

	public DefaultRegistroDeParticipante(List<Espectador> nuevosEspectadores) {

		for (Espectador nuevoEspectador : nuevosEspectadores) {
			this.agregarEspectador(nuevoEspectador);
		}

	}

	@Override
	public void registrar(ParticipanteRecord participante) throws DominioException {

		Participante nuevo = new Participante(participante.nombre(), participante.telefono(), participante.region(),
				participante.mail());

		try {
			this.notificarNuevo(
					new ParticipanteRecordOut(nuevo.nombre(), nuevo.telefono(), nuevo.region(), nuevo.email()));
		} catch (RegistroException e) {
			throw new DominioException(e.getMessage());
		}

	}

}
