package ejercicio5.dominio.model;

import java.util.List;

import ejercicio5.dominio.portsin.BebidasRecord;
import ejercicio5.dominio.portsin.Dispositivo;
import ejercicio5.dominio.portsin.DominioException;
import ejercicio5.dominio.portsin.Espectador;
import ejercicio5.dominio.portsin.PedidoRecordIn;
import ejercicio5.dominio.portsin.PlatosRecord;
import ejercicio5.dominio.portsin.TarjetaRecord;

public class ElectronicDispositivo extends Visto implements Dispositivo {

	private Pedido miPedido;
	private double importeAbonar;

	public ElectronicDispositivo(List<Espectador> nuevosEspectadores) {
		this.importeAbonar = 0;
		for (Espectador nuevo : nuevosEspectadores) {
			this.agregarEspectador(nuevo);
		}
	}

	@Override
	public void cargarPedido(PedidoRecordIn pedidoRealizado) {

		Pedido nuevo = new Pedido();

		for (PlatosRecord plato : pedidoRealizado.platosIncluidos()) {
			nuevo.agregarPlato(new Platos(plato.nombre(), plato.precio()));
		}
		for (BebidasRecord bebida : pedidoRealizado.bebidasIncluidas()) {
			nuevo.agregarBebida(new Bebidas(bebida.nombre(), bebida.precio()));
		}

		this.miPedido = nuevo;

	}

	@Override
	public void pagarPedido(TarjetaRecord tarjetaDada, int propina) throws DominioException {

		Tarjeta nueva = this.determinarTipoTarjeta(tarjetaDada);

		this.importeAbonar = sumarPropina(nueva.realizarDescuentos(miPedido), propina);

		nueva.efectuarPago(importeAbonar);

		this.notificarNuevaVenta(importeAbonar);

	}

	private Double sumarPropina(Double totalPedido, int propina) {
		return (((propina * totalPedido) / 100) + (totalPedido));
	}

	private Tarjeta determinarTipoTarjeta(TarjetaRecord tarjetaDada) throws DominioException {
		if (tarjetaDada.nroTarjeta().matches("^1[0-9]{12}(?:[0-9]{3})?$"))
			return new Visa(tarjetaDada.saldoMin(), tarjetaDada.saldo(), tarjetaDada.nroTarjeta());

		if (tarjetaDada.nroTarjeta().matches("^2[0-9]{12}(?:[0-9]{3})?$"))
			return new Viedma(tarjetaDada.saldoMin(), tarjetaDada.saldo(), tarjetaDada.nroTarjeta());

		if (tarjetaDada.nroTarjeta().matches("^3[0-9]{12}(?:[0-9]{3})?$"))
			return new MasterCard(tarjetaDada.saldoMin(), tarjetaDada.saldo(), tarjetaDada.nroTarjeta());

		if (tarjetaDada.nroTarjeta().matches("^4[0-9]{12}(?:[0-9]{3})?$"))
			return new ComarcaPlus(tarjetaDada.saldoMin(), tarjetaDada.saldo(), tarjetaDada.nroTarjeta());

		throw new DominioException("Tipo de tarjeta no reconocido");

	}

}
