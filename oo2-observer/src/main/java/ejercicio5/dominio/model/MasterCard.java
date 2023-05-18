package ejercicio5.dominio.model;

import ejercicio5.dominio.portsin.DominioException;

public class MasterCard extends Tarjeta {

	private static final Integer DESCUENTO_TOTAL_PLATOS = 2;

	public MasterCard(String saldoMin, String saldo, String nroTarjeta) throws DominioException {
		super(saldoMin, saldo, nroTarjeta);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Double realizarDescuentos(Pedido unPedido) {

		return ((descuento(unPedido.precioTotalPlatos(), DESCUENTO_TOTAL_PLATOS)) + (unPedido.precioTotalBebidas()));

	}

}
