package ejercicio5.dominio.model;

import ejercicio5.dominio.portsin.DominioException;

public class Viedma extends Tarjeta {

	public Viedma(String saldoMin, String saldo, String nroTarjeta) throws DominioException {
		super(saldoMin, saldo, nroTarjeta);
	}

	@Override
	public Double realizarDescuentos(Pedido unPedido) {

		return (unPedido.precioTotal());

	}

}
