package Nemo;

public class Sub {
	private Coordenadas coordenadas;
	private float direccion;

	public Sub(Coordenadas coordenadasIniciales, float direccionInicial) {
		// TODO Auto-generated constructor stub
		coordenadas = coordenadasIniciales;
		direccion = direccionInicial;
	}

	public void moverse(String comando) {
		if (comando == "d") {
			this.coordenadas.descend();
		}
		if (comando == "u") {
			this.coordenadas.ascend();
		}
	}

	public float getDireccion() {
		return this.direccion;
	}

	public void setDireccion(float direccion) {
		this.direccion = direccion;
	}

	public Coordenadas getCoordenadas() {
		return this.coordenadas;
	}

	public void setCoordenadas(Coordenadas coordenadas) {
		this.coordenadas = coordenadas;
	}
}
