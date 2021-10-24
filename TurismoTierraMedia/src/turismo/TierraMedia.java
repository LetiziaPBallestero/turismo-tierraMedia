package turismo;

import java.io.IOException;
import java.sql.SQLException;

public class TierraMedia {

	public static void main(String[] args) throws UsuarioException, AtraccionException, PromocionException, IOException, SQLException {
		ScannerSugerencias sc = new ScannerSugerencias("src/archivosDeEntrada/usuarios.csv", "src/archivosDeEntrada/atracciones.csv", "src/archivosDeEntrada/promociones.csv");
		sc.escanearUsuariosYProductos();
		sc.mostrarATodos();
	}
}
