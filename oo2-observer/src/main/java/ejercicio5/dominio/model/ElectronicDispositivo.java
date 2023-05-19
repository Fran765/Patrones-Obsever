package ejercicio5.dominio.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

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

	private Map<Integer, Tarjeta> mapaTarjetas;

	public ElectronicDispositivo(List<Espectador> nuevosEspectadores) throws DominioException {
		this.importeAbonar = 0;
		for (Espectador nuevo : nuevosEspectadores) {
			this.agregarEspectador(nuevo);
		}

		this.mapaTarjetas = new HashMap<>();
		this.cargarTarjetas();
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
		
		if(tarjetaDada.nroTarjeta().isBlank())
			throw new DominioException("Debe ingresar un numero de tarjeta.");

		Tarjeta nueva = this.determinarTipoTarjeta(tarjetaDada);

		this.importeAbonar = sumarPropina(nueva.realizarDescuentos(miPedido), propina);

		nueva.efectuarPago(importeAbonar);

		this.notificarNuevaVenta(importeAbonar);

	}

	private Double sumarPropina(Double totalPedido, int propina) {
		return (((propina * totalPedido) / 100) + (totalPedido));
	}

	
	private Tarjeta determinarTipoTarjeta(TarjetaRecord tarjetaDada) throws DominioException {

		if (!this.mapaTarjetas.containsKey(Integer.parseInt(tarjetaDada.nroTarjeta())))
			throw new DominioException("Tipo de tarjeta no reconocido");

		return this.mapaTarjetas.get(Integer.parseInt(tarjetaDada.nroTarjeta()));

	}

	private void cargarTarjetas() throws DominioException {

		this.mapaTarjetas.put(1, new Visa("0", "500000", "1"));
		this.mapaTarjetas.put(2, new Viedma("0", "500000", "2"));
		this.mapaTarjetas.put(3, new MasterCard("0", "500000", "3"));
		this.mapaTarjetas.put(4, new ComarcaPlus("0", "500000", "4"));

	}

}
