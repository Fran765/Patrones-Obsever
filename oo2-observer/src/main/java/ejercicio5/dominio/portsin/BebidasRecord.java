package ejercicio5.dominio.portsin;

public record BebidasRecord(String nombre, float precio) {

	@Override
	public String toString() {
		return nombre;
	}
}
