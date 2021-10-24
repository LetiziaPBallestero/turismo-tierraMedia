package turismo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;

public class AtraccionDAO implements ProductoDAO<Atraccion> {

	public List<Atraccion> getAll() throws SQLException, ParseException {
		List<Atraccion> atracciones = new LinkedList<Atraccion>();
		String sql = "SELECT * FROM atracciones";
		Connection conexion = Conexion.obtenerConexion();
		PreparedStatement statement = conexion.prepareStatement(sql);
		ResultSet resultados = statement.executeQuery();

		while (resultados.next()) {
			Atraccion atraccion = new Atraccion(resultados.getString("nombre"),
					TipoDeAtraccion.valueOf((resultados.getString("tipo"))), resultados.getDouble("costo"),
					resultados.getDouble("tiempo"), resultados.getInt("cupo"));
			atracciones.add(atraccion);
		}
		return atracciones;
	}
	
	public void update(Producto atraccion) throws SQLException{
		String sql = "UPDATE atracciones SET cupo = ? WHERE nombre = '?'";
		Connection conexion = Conexion.obtenerConexion();
		PreparedStatement statement = conexion.prepareStatement(sql);
		statement.setInt(1, ((Atraccion) atraccion).getCuposOcupados());
		statement.setString(2, atraccion.getNombre());
		statement.executeUpdate();
	}

}