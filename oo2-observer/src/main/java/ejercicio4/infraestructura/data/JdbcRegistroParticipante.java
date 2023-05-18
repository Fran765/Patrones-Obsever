package ejercicio4.infraestructura.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ejercicio4.dominio.portsout.Espectador;
import ejercicio4.dominio.portsout.ParticipanteRecordOut;
import ejercicio4.dominio.portsout.RegistroException;


public class JdbcRegistroParticipante implements Espectador {

	private Conn connStr;

	public JdbcRegistroParticipante(String connStr) {
		this.connStr = new Conn(connStr);
	}

	@Override
	public void cambioEstado(ParticipanteRecordOut participante) throws RegistroException {
		try {
			Connection dbConn = this.connStr.open();

			PreparedStatement st = dbConn
					.prepareStatement("insert into participantes(nombre, telefono, region, mail) values(?,?,?,?)");

			st.setString(1, participante.nombre());
			st.setString(2, participante.telefono());
			st.setString(3, participante.region());
			st.setString(4, participante.mail());

			st.executeUpdate();
			st.close();

		} catch (SQLException e) {
			throw new RegistroException(e, "No ha podido registrarse el participante.");
		}
	}

}
