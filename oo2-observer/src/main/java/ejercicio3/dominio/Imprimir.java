package ejercicio3.dominio;

public class Imprimir extends DecoratorsLecturaClima {

	public Imprimir(LecturaClima miInterface) {
		super(miInterface);
	}

	@Override
	public String leerTemperatura() throws DominioException {

		String temp = this.miInterface.leerTemperatura();
		System.out.println("Decorador Imprimir: "+temp);
		return temp;
	}

}
