package turismo;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

public class App {
public static void main(String[] args) throws SQLException, ParseException, PromocionException, AtraccionException, UsuarioException, IOException {
	ScannerDB scannerDB = new ScannerDB();
	scannerDB.escanearUsuariosYProductos();
	scannerDB.mostrarATodos();
}
}
