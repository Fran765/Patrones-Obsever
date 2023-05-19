package ejercicio5.dominio.portsin;

public record PlatosRecord(String nombre, float precio) {

	@Override
	public String toString() {
		return nombre;
	}

}
