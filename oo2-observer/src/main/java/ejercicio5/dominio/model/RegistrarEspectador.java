package ejercicio5.dominio.model;

import ejercicio5.dominio.portsin.Espectador;
import ejercicio5.dominio.portsout.Almacenar;

public class RegistrarEspectador implements Espectador {

	private Almacenar lugarDeRegistro;

	public RegistrarEspectador(Almacenar lugarDeRegistro) {
		this.lugarDeRegistro = lugarDeRegistro;
	}

	@Override
	public void notificacionVenta(double importeAbonar) {
		lugarDeRegistro.registrar(importeAbonar);
	}

}
