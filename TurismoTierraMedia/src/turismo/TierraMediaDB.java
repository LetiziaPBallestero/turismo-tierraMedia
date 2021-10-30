package turismo;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

public class TierraMediaDB {
	public static void main(String[] args) throws IOException, SQLException, UsuarioException, PromocionException, AtraccionException, ParseException {
		ScannerDB scannerDB = new ScannerDB();
		scannerDB.escanearUsuariosYProductos();
		scannerDB.mostrarATodos();
	}
}
