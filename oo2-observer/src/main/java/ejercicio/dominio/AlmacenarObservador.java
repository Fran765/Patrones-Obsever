package ejercicio.dominio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Objects;

public class AlmacenarObservador implements Observador {

	private String file;

	public AlmacenarObservador(String file) {
		Objects.requireNonNull(file);
		this.file = file;
	}

	@Override
	public void refrescar(String nuevoEstado) {

		File archivo = new File(this.file);

		PrintWriter escribir;
		try {
			escribir = new PrintWriter(archivo);

			escribir.println("Temperatura: " + nuevoEstado + " Fecha: " + LocalDate.now());

			escribir.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
