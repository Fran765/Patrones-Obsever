package ejercicio5.dominio.portsin;

import java.util.List;

import ejercicio5.dominio.model.Bebidas;
import ejercicio5.dominio.model.Platos;

public record PedidoRecordIn(List<PlatosRecord> platosIncluidos, List<BebidasRecord>bebidasIncluidas) {

}
