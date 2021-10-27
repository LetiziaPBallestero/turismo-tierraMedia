package turismo;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public interface ProductoDAO <T> {
	//public List<T> getAll() throws SQLException, ParseException, PromocionException, AtraccionException;
	public void update(Producto producto) throws SQLException;
}