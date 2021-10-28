package turismo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;

public class UsuarioDAO {
	public List<Usuario> getAll() throws SQLException, ParseException {
		List<Usuario> usuarios = new LinkedList<Usuario>();
		String sql = "SELECT * FROM usuarios";
		Connection conexion = Conexion.obtenerConexion();
		PreparedStatement statement = conexion.prepareStatement(sql);
		ResultSet resultados = statement.executeQuery();

		while (resultados.next()) {
			Usuario usuario = new Usuario(TipoDeAtraccion.valueOf((resultados.getString("tipo_de_atraccion"))), resultados.getString("nombre"), resultados.getDouble("presupuesto"),  resultados.getDouble("tiempo_disponible"));
			usuarios.add(usuario);
		}
		return usuarios;
		}
	
	public void update(Usuario usuario) throws SQLException{
		String sql = "UPDATE usuarios SET presupuesto = ?, tiempo_disponible = ? WHERE nombre = ?";
		Connection conexion = Conexion.obtenerConexion();
		PreparedStatement statement = conexion.prepareStatement(sql);
		statement.setDouble(1, usuario.getPresupuesto());
		statement.setDouble(2, usuario.getTiempoDisponible());
		statement.setString(3, usuario.getNombre());
		statement.executeUpdate();
	}

}
