package turismo;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public class App {
public static void main(String[] args) throws SQLException, ParseException, PromocionException, AtraccionException {
	PromocionDAO promocionDAO = new PromocionDAO();
	AtraccionDAO atraccionDAO = new AtraccionDAO();
	List<Atraccion> atracciones = atraccionDAO.getAll();
	System.out.println(promocionDAO.getAll(atracciones));
}
}
