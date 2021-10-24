package turismo;

import java.sql.SQLException;
import java.text.ParseException;

public class App {
public static void main(String[] args) throws SQLException, ParseException, PromocionException, AtraccionException {
	PromocionDAO promocionDAO = new PromocionDAO();
	System.out.println(promocionDAO.getAll());
}
}
