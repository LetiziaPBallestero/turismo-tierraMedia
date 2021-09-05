package turismo;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class TierraMedia {

	public static void main(String[] args) throws UsuarioException, AtraccionException, PromocionException, IOException {
		ScannerSugerencias sc = new ScannerSugerencias();
		sc.escanearUsuariosYProductos();
		sc.mostrarATodos();
	}

}
