package ejercicio5.dominio.model;

import ejercicio5.dominio.portsin.DominioException;

public class Visa extends Tarjeta {

	private static final Integer DESCUENTO_TOTAL_BEBIDAS = 3;

	public Visa(String saldoMin, String saldo, String nroTarjeta) throws DominioException {
		super(saldoMin, saldo, nroTarjeta);
	}

	@Override
	public Double realizarDescuentos(Pedido unPedido) {

		return (descuento(unPedido.precioTotalBebidas(), DESCUENTO_TOTAL_BEBIDAS) + unPedido.precioTotalPlatos());

	}

}
