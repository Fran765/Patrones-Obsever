package ejercicio5.infraestructura.data;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;

import ejercicio5.dominio.portsin.Espectador;
import ejercicio5.dominio.portsout.Almacenar;


public class EnDiscoAlmacenar implements Almacenar {

	private String direccion;

	public EnDiscoAlmacenar(String direccion) {
		this.direccion = direccion;
	}

	@Override
	public void registrar(double importeAbonar) {
		
		String datosAlmacenar =  "Fecha: " + LocalDateTime.now() + " Importe: " + importeAbonar + "\n";
		try {
			Files.write(Paths.get(direccion), datosAlmacenar.getBytes(), StandardOpenOption.APPEND);
		} catch (IOException e) {

			throw new RuntimeException("No se pudo persistir...", e);
		}

	}

}
