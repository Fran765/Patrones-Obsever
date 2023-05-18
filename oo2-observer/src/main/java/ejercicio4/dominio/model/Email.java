package ejercicio4.dominio.model;

import java.util.Objects;

import ejercicio4.dominio.porstin.DominioException;


public class Email {
	
	private String mail;

	public Email(String direccionMail) throws DominioException {

		Objects.requireNonNull(direccionMail);

		if (direccionMail.isEmpty())
			throw new DominioException("Debe ingresar un mail");

		if (!validarMail(direccionMail))
			throw new DominioException("Email debe ser v�lido");

		this.mail = direccionMail;
	}

	public String getMail() {
		return mail;
	}

	private boolean validarMail(String mail) {
		String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
		return mail.matches(regex);
	}

}
