package turismo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ItinerarioDAO {
	public void update(Usuario usuario, Producto producto) throws SQLException {
		if (producto.esPromo()) {
			for (Atraccion a : ((Promocion) producto).getAtracciones()) {
				String sql = "INSERT INTO itinerarios(usuario, promocion_id, atraccion)" + "VALUES(?, ?, ?)";
				Connection conexion = Conexion.obtenerConexion();
				PreparedStatement statement = conexion.prepareStatement(sql);
				statement.setString(1, usuario.getNombre());
				statement.setInt(2, ((Promocion) producto).getIdPromo());
				statement.setString(3, a.getNombre());
				statement.executeUpdate();
			}
		} else {
			String sql = "INSERT INTO itinerarios(usuario, atraccion)" + "VALUES(?, ?)";
			Connection conexion = Conexion.obtenerConexion();
			PreparedStatement statement = conexion.prepareStatement(sql);
			statement.setString(1, usuario.getNombre());
			statement.setString(2, producto.getNombre());
			statement.executeUpdate();
		}
	}
}
