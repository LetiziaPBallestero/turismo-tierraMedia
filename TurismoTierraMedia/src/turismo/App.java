package turismo;

import java.sql.SQLException;
import java.text.ParseException;

public class App {
public static void main(String[] args) throws SQLException, ParseException {
	UsuarioDAO usuarioDAO = new UsuarioDAO();
	System.out.println(usuarioDAO.getAll());
	
	AtraccionDAO atraccionDAO = new AtraccionDAO();
	System.out.println(atraccionDAO.getAll());
}
}
