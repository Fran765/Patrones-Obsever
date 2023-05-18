package ejercicio4.dominio.model;

import java.util.Objects;

import ejercicio4.dominio.porstin.DominioException;


public class Telefono {
	
	private String telefono;
	
	public Telefono(String telefono) throws DominioException {
		
		Objects.requireNonNull(telefono);
		
		if(telefono.isEmpty())
			throw new DominioException("Debe cargar un telefono");
		
		if(!validarTelefono(telefono))
			throw new DominioException("El tel�fono debe ingresarse de la siguiente forma: NNNN-NNNNNN");
		
		this.telefono = telefono;
	}
	
	
	
	public String telefono() {
		return telefono;
	}



	private boolean validarTelefono(String telefono) {
		String regex = "\\d{4}-\\d{6}";
		return telefono.matches(regex);
	}

}
