package ejercicio5.infraestructura.ui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;

import ejercicio5.dominio.portsin.Espectador;

public class PantallaGerenteEspectador extends JFrame implements Espectador {

	private JLabel label;

	public PantallaGerenteEspectador() {

		JFrame frame = new JFrame("Pantalla Gerente");
		frame.getRootPane().setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		label = new JLabel("...");
		label.setFont(new Font("Dialog", Font.PLAIN, 20));
		frame.add(label);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 150);
		frame.setLocation(200, 200);
		frame.setVisible(true);
	}

	@Override
	public void notificacionVenta(double importeAbonar) {
		
		if (importeAbonar > 300000)

			label.setForeground(Color.RED);

		label.setText("$ "+importeAbonar);

	}

}