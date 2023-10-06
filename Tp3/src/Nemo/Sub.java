package Nemo;

public class Sub {
	private Coordenadas coordenadas;
	private float direccion;
	private boolean exploto;

	public Sub(Coordenadas coordenadasIniciales, float direccionInicial) {
		// TODO Auto-generated constructor stub
		coordenadas = coordenadasIniciales;
		direccion = direccionInicial;
		setExploto(false);
	}

	public void accion(String comando) {
		if (comando == "d") {
			this.coordenadas.descend();
		}
		if (comando == "u") {
			this.coordenadas.ascend();
		}
		if (comando == "m") {
			if (this.coordenadas.getZ() < -1) {
				setExploto(true);
			}
		}
		if (comando == "r") {
			setDireccion(this.direccion + 90);
		}
		if (comando == "l") {
			setDireccion(this.direccion - 90);
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

	public boolean isExploto() {
		return exploto;
	}

	public void setExploto(boolean exploto) {
		this.exploto = exploto;
	}
}
