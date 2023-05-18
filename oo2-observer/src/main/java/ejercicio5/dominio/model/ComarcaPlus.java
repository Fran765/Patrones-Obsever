package ejercicio5.dominio.model;

import ejercicio5.dominio.portsin.DominioException;

public class ComarcaPlus extends Tarjeta {

	private static final Integer DESCUENTO_TOTAL = 2;

	public ComarcaPlus(String saldoMin, String saldo, String nroTarjeta) throws DominioException {
		super(saldoMin, saldo, nroTarjeta);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Double realizarDescuentos(Pedido unPedido) {

		return (descuento(unPedido.precioTotal(), DESCUENTO_TOTAL));

	}

}
