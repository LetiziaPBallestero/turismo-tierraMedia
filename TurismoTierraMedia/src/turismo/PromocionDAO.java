package turismo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;

public class PromocionDAO implements ProductoDAO<Promocion> {
    AtraccionDAO atraccionDAO = new AtraccionDAO();
	/*public List<Promocion> getAll() throws SQLException, ParseException, PromocionException, AtraccionException {
		List<Promocion> promociones = new LinkedList<Promocion>();
		AtraccionDAO atraccionDAO = new AtraccionDAO();
		List<Atraccion> atracciones = atraccionDAO.getAll();
		String sql = "SELECT promociones.id, promociones.tipo_de_promocion, promociones.tipo_de_atracciones, promociones.numero_asociado, atracciones.nombre, atracciones.costo, atracciones.tiempo, atracciones.cupo\r\n"
				+ "FROM promociones\r\n"
				+ "JOIN atracciones_de_promociones ON atracciones_de_promociones.id_promocion = promociones.id\r\n"
				+ "JOIN atracciones ON atracciones_de_promociones.id_atraccion = atracciones.id";
		Connection conexion = Conexion.obtenerConexion();
		PreparedStatement statement = conexion.prepareStatement(sql);
		ResultSet resultados = statement.executeQuery();
		int idAnterior = 0;
		//Map<ResultSet, List<Atraccion>> resultadosAtracciones = new TreeMap<ResultSet, List<Atraccion>>();
		while (resultados.next()) {
			List<Atraccion> atraccionesPromo = new LinkedList<Atraccion>();
			while (resultados.next() && idAnterior + 1 == (resultados.getInt("id"))) {
				agregarAtraccionAPromo(resultados.getString("nombre"), atraccionesPromo, atracciones);
			}
			idAnterior++;
			//resultadosAtracciones.put(resultados, atraccionesPromo);
			Promocion promocion = crearPromocion(resultados.getString("tipo_de_promocion"),
					resultados.getString("tipo_de_atracciones"), resultados.getInt("numero_asociado"),
					atraccionesPromo);
			promociones.add(promocion);
		}
		return promociones;
	}*/
	
	public List<Promocion> getAll() throws SQLException, ParseException, PromocionException, AtraccionException
    {
        List<Promocion> promociones = new LinkedList<Promocion>();
        List<Atraccion> atracciones = atraccionDAO.getAll();
        String sql = "SELECT promociones.id, promociones.tipo_de_promocion, promociones.tipo_de_atracciones, promociones.numero_asociado, atracciones.nombre, atracciones.costo, atracciones.tiempo, atracciones.cupo\r\n"
                + "FROM promociones\r\n"
                + "JOIN atracciones_de_promociones ON atracciones_de_promociones.id_promocion = promociones.id\r\n"
                + "JOIN atracciones ON atracciones_de_promociones.id_atraccion = atracciones.id";
        Connection conexion = Conexion.obtenerConexion();
        PreparedStatement statement = conexion.prepareStatement(sql);
        ResultSet resultados = statement.executeQuery();
        int idAnterior = 1;
        resultados.next();
        int contador = 1;

        while (contador <= 10)
        {
            List<Atraccion> atraccionesPromo = new LinkedList<Atraccion>();
            while (contador <= 9 && idAnterior == resultados.getInt("id"))
            {
                agregarAtraccionAPromo(resultados.getString("nombre"), atraccionesPromo, atracciones);
                resultados.next();

            }

            if (contador == 10)
            {
                for (int i = 0; i < 2; i++)
                {
                    agregarAtraccionAPromo(resultados.getString("nombre"), atraccionesPromo, atracciones);
                    resultados.next();
                }

                agregarAtraccionAPromo(resultados.getString("nombre"), atraccionesPromo, atracciones);
            }

            contador++;
            idAnterior++;

            Promocion promocion = crearPromocion(resultados.getString("tipo_de_promocion"),
                    resultados.getString("tipo_de_atracciones"), resultados.getInt("numero_asociado"),
                    atraccionesPromo);

            promociones.add(promocion);
        }
        return promociones;
    }

	private void agregarAtraccionAPromo(String nombre, List<Atraccion> atraccionesPromo, List<Atraccion> atracciones) {
		for (Atraccion a : atracciones) {
			if (nombre.equals(a.getNombre())) {
				atraccionesPromo.add(a);
			}
		}
	}

	private Promocion crearPromocion(String tipoPromo, String tipoAtraccion, int numeroAsociado,
			List<Atraccion> atraccionesPromo) throws PromocionException, AtraccionException {
		Promocion promo = null;

		if (tipoPromo.toLowerCase().equals("axb")) {
			promo = new PromocionAxB(TipoDePromocion.valueOf(tipoPromo), TipoDeAtraccion.valueOf(tipoAtraccion),
					atraccionesPromo);
		}

		if (tipoPromo.toLowerCase().equals("absoluta")) {
			promo = new PromocionAbsoluta(TipoDePromocion.valueOf(tipoPromo), TipoDeAtraccion.valueOf(tipoAtraccion),
					numeroAsociado, atraccionesPromo);
		}
		if (tipoPromo.toLowerCase().equals("porcentual")) {
			promo = new PromocionPorcentual(TipoDePromocion.valueOf(tipoPromo), TipoDeAtraccion.valueOf(tipoAtraccion),
					numeroAsociado, atraccionesPromo);
		}
		return promo;
	}
	
	public void update(Producto promocion) throws SQLException{
		List<Atraccion> atracciones = ((Promocion) promocion).getAtracciones();
		for(Atraccion a : atracciones) {
			atraccionDAO.update(a);
		}
	}

}
