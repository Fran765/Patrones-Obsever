package ejercicio3.dominio;

public abstract class DecoratorsLecturaClima implements LecturaClima {

	protected LecturaClima miInterface;

	public DecoratorsLecturaClima(LecturaClima miInterface) {
		this.miInterface = miInterface;
	}

	public abstract String leerTemperatura() throws DominioException;

}
