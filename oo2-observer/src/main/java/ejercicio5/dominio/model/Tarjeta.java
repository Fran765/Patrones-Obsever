package ejercicio5.dominio.model;

import ejercicio5.dominio.portsin.DominioException;

public abstract class Tarjeta {

	private static final String MSJ_ERROR = "Tarjeta ingresada no valida.";
	
	protected Double saldo;
	protected int saldoMin;
	protected int nroTarjeta;

	public Tarjeta(String saldoMin, String saldo, String nroTarjeta) throws DominioException {

		this.validarTarjeta(nroTarjeta);
		this.saldoMin = Integer.parseInt(saldoMin);
		this.saldo = Double.parseDouble(saldo);
		this.nroTarjeta = Integer.parseInt(nroTarjeta);
	}

	public abstract Double realizarDescuentos(Pedido unPedido);

	protected void efectuarPago(Double precioFinal) throws DominioException {

		if (this.saldo - precioFinal < this.saldoMin) {
			this.saldo = this.saldo - precioFinal;

		} else {

			throw new DominioException("Fondos negativos alcanzados.");
		}
	}

	protected Double descuento(Double precio, int descuento) {
		return (precio - ((descuento * precio) / 100));
	}

	private void validarTarjeta(String nroTarjeta) throws DominioException {

		if (!nroTarjeta.matches("^1[0-9]{12}(?:[0-9]{3})?$"))
			throw new DominioException(Tarjeta.MSJ_ERROR);
		if (!nroTarjeta.matches("^2[0-9]{12}(?:[0-9]{3})?$"))
			throw new DominioException(Tarjeta.MSJ_ERROR);
		if (!nroTarjeta.matches("^3[0-9]{12}(?:[0-9]{3})?$")) 
			throw new DominioException(Tarjeta.MSJ_ERROR);
		if (!nroTarjeta.matches("^4[0-9]{12}(?:[0-9]{3})?$")) 
			throw new DominioException(Tarjeta.MSJ_ERROR);
	}

}
