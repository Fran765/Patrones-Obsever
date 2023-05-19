package ejercicio5.main.main;

import java.util.List;

import ejercicio5.dominio.model.ElectronicDispositivo;
import ejercicio5.dominio.model.RegistrarEspectador;
import ejercicio5.dominio.portsin.DominioException;
import ejercicio5.infraestructura.data.EnDiscoAlmacenar;
import ejercicio5.infraestructura.ui.PantallaCompra;
import ejercicio5.infraestructura.ui.PantallaGerenteEspectador;

public class Main {

	public static void main(String[] args) {

		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					new PantallaCompra(new ElectronicDispositivo(
							List.of((new RegistrarEspectador(new EnDiscoAlmacenar("DatosPunto5"))),
									new PantallaGerenteEspectador())));
				} catch (DominioException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

	}

}
