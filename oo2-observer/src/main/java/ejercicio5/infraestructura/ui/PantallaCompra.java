package ejercicio5.infraestructura.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ejercicio5.dominio.portsin.BebidasRecord;
import ejercicio5.dominio.portsin.PedidoRecordIn;
import ejercicio5.dominio.portsin.PlatosRecord;

public class PantallaCompra extends JFrame {

	private JPanel contentPane;
	private JComboBox cbPlatos;
	private JComboBox cbBebidas;
	
	public PantallaCompra() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		cbPlatos = new JComboBox<PlatosRecord>();
		cbPlatos.setBounds(58, 48, 108, 21);
		contentPane.add(cbPlatos);
		this.cargarComboBoxPlato();

		cbBebidas = new JComboBox<BebidasRecord>();
		cbBebidas.setBounds(261, 48, 108, 21);
		contentPane.add(cbBebidas);
		this.cargarComboBoxBebida();
		
		JButton btnPagar = new JButton("Pagar");
		btnPagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PedidoRecordIn pedido = new PedidoRecordIn(List.of(cbPlatos.getSelectedItem()),List.of(cbBebidas.getSelectedItem()));
			}
		});
		btnPagar.setBounds(160, 191, 108, 28);
		contentPane.add(btnPagar);

	}
	
	private void cargarComboBoxPlato() {
		PlatosRecord plato1 = new PlatosRecord("fideos", 200);
		PlatosRecord plato2 = new PlatosRecord("Asado", 1500);
		PlatosRecord plato3 = new PlatosRecord("Caviar", 300000);
		
		this.cbPlatos.addItem(plato1);
		this.cbPlatos.addItem(plato2);
		this.cbPlatos.addItem(plato3);
		
	}
	
	private void cargarComboBoxBebida() {
		BebidasRecord bebida1 = new BebidasRecord("Coca-cola", 350);
		BebidasRecord bebida2 = new BebidasRecord("Cerveza", 800);
		BebidasRecord bebida3 = new BebidasRecord("Vino", 16000);
		
		this.cbBebidas.addItem(bebida1);
		this.cbBebidas.addItem(bebida2);
		this.cbBebidas.addItem(bebida3);
	}
}
