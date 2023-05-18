package ejercicio4.infraestructura.mail;

import java.util.Objects;
import java.util.Properties;

import ejercicio4.dominio.portsout.Espectador;
import ejercicio4.dominio.portsout.ParticipanteRecordOut;
import ejercicio4.dominio.portsout.RegistroException;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public class PorMailNotificarRegistro implements Espectador {

	private static final String ASUNTO = "Registro";

	private static final String MSJ = "Se ha registrado correctamente";

	@Override
	public void cambioEstado(ParticipanteRecordOut participante) throws RegistroException {

		Objects.requireNonNull(participante);

		String from = "jakartafrom@example.com";

		final String username = "0d27d2e44d1f90";
		final String password = "f222bac5da2b08";

		
		String host = "sandbox.smtp.mailtrap.io";

		
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "2525");

		
		Session session = Session.getInstance(props, new jakarta.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(participante.mail()));
			message.setSubject(PorMailNotificarRegistro.ASUNTO);
			message.setText(PorMailNotificarRegistro.MSJ);
			Transport.send(message);
			System.out.println("Email Message Sent Successfully");
		} catch (MessagingException e) {
			throw new RegistroException(e, "El mail no pudo ser enviado con exito.");
		}

	}

}
