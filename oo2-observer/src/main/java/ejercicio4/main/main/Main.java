package ejercicio4.main.main;

import java.util.List;

import ejercicio4.dominio.model.DefaultRegistroDeParticipante;
import ejercicio4.infraestructura.data.JdbcRegistroParticipante;
import ejercicio4.infraestructura.mail.PorMailNotificarRegistro;
import ejercicio4.infraestructura.ui.AgregarParticianteView;

public class Main {

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					new AgregarParticianteView(new DefaultRegistroDeParticipante(
							List.of(new JdbcRegistroParticipante("jdbc:mysql://localhost:3306/oop2-e1"),
									new PorMailNotificarRegistro())));
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			}
		});
	}

}
