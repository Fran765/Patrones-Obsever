package ejercicio5.main.main;

import java.util.List;

import ejercicio5.dominio.model.ElectronicDispositivo;
import ejercicio5.infraestructura.data.EnDiscoAlmacenar;
import ejercicio5.infraestructura.ui.PantallaCompra;
import ejercicio5.infraestructura.ui.PantallaGerenteEspectador;

public class Main {

	public static void main(String[] args) {

		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new PantallaCompra(new ElectronicDispositivo(
						List.of(new EnDiscoAlmacenar("DatosPunto5"), new PantallaGerenteEspectador())));
			}
		});

	}

}
