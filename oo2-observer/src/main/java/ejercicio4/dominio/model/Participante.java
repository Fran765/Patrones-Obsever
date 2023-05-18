package ejercicio4.dominio.model;

import java.util.Objects;

import ejercicio4.dominio.porstin.DominioException;

public class Participante {

	private String nombre;
	private Telefono telefono;
	private Region region;
	private Email mail;

	public Participante(String nombre, String telefono, String region, String mail) throws DominioException {

		Objects.requireNonNull(nombre);

		if (nombre.isEmpty())
			throw new DominioException("Debe cargar un nombre");

		this.nombre = nombre;
		this.telefono = new Telefono(telefono);
		this.region = new Region(region);
		this.mail = new Email(mail);
	}

	public String nombre() {
		return nombre;
	}

	public String telefono() {
		return telefono.telefono();
	}

	public String region() {
		return region.region();
	}
	
	public String email() {
		return mail.getMail();
	}

}
