package turismo;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public interface GenericDAO <T> {
	public List<T> getAll() throws SQLException, ParseException;
}