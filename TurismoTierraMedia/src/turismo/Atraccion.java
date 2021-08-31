package turismo;

public class Atraccion extends Producto
{
	private int costoAtraccion;
	private double tiempo;
	private int cupoMaximo;
	private int cuposOcupados;
	private TipoDeAtraccion tipoDeAtraccion;

	public int getCosto()
	{
		return costoAtraccion;
	}

	public double getTiempo()
	{
		return tiempo;
	}

	public TipoDeAtraccion getTipoDeAtraccion()
	{
		return tipoDeAtraccion;
	}

	public boolean hayCupo(int cuposOcupados)
	{
		return cuposOcupados < cupoMaximo;
	}

}
