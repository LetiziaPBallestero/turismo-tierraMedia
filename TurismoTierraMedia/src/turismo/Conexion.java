package turismo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	private static Connection conexion;
	private static String url = "jdbc:sqlite:src/db/turismo_tierra_media.db";

	public static Connection obtenerConexion() throws SQLException {
		if (conexion == null || conexion.isClosed()) {
			conexion = DriverManager.getConnection(url);
		}
		return conexion;
	}

	public static void cerrarConexion() throws SQLException {
		if(!conexion.isClosed()) {
			conexion.close();
		}
	}
}