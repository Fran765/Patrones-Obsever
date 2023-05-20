package ejercicio3.dominio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;

public class Almacenar extends DecoratorsLecturaClima {

	private String archivo;

	public Almacenar(LecturaClima miInterface, String file) {
		super(miInterface);
		this.archivo = file;
	}

	@Override
	public String leerTemperatura() throws DominioException {

		String temp = this.miInterface.leerTemperatura();

		File archivo = new File(this.archivo);

		try (PrintWriter escribir = new PrintWriter(archivo)) {

			escribir.println("Temperatura: " + temp + " Fecha: " + LocalDate.now());

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return temp;

	}

}
