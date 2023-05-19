package ejercicio5.infraestructura.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ejercicio5.dominio.portsin.Dispositivo;
import ejercicio5.dominio.portsin.DominioException;
import ejercicio5.dominio.portsin.TarjetaRecord;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class PantallaPago extends JFrame {

	private JPanel contentPane;
	private JTextField txtNroTarjeta;
	private JComboBox comboBoxPropina;

	public PantallaPago(Dispositivo miDispositivo) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(700, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);

		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel("Ingrese su Nro. Tarjeta:");
		lblNewLabel.setBounds(10, 38, 160, 25);
		contentPane.add(lblNewLabel);

		txtNroTarjeta = new JTextField();
		txtNroTarjeta.setBounds(248, 41, 154, 19);
		contentPane.add(txtNroTarjeta);
		txtNroTarjeta.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Seleccione un monto de propina:");
		lblNewLabel_1.setBounds(10, 112, 228, 25);
		contentPane.add(lblNewLabel_1);

		comboBoxPropina = new JComboBox<Integer>();
		comboBoxPropina.setBounds(324, 114, 78, 21);
		contentPane.add(comboBoxPropina);
		cargarComboBox();

		JButton btnNewButton = new JButton("Confirmar Pago");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					miDispositivo.pagarPedido(new TarjetaRecord("0", "500000", txtNroTarjeta.getText()),
							(Integer) comboBoxPropina.getSelectedItem());
					btnNewButton.setEnabled(false);
				} catch (DominioException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		btnNewButton.setBounds(161, 221, 122, 32);
		contentPane.add(btnNewButton);
		setVisible(false);
	}

	private void cargarComboBox() {
		this.comboBoxPropina.addItem(2);
		this.comboBoxPropina.addItem(3);
		this.comboBoxPropina.addItem(5);
	}
}
