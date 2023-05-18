package ejercicio5.dominio.portsin;

public interface RecibirUnPedido {

	void cargarPedido(PedidoRecordIn pedidoRealizado);

	void pagarPedido(TarjetaRecord tarjetaDada, int propina) throws DominioException;
}
