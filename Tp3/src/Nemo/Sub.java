package Nemo;

public class Sub {
	private Coordenadas coordenadas;
	private double direccion;
	private boolean exploto;

	public Sub(Coordenadas coordenadasIniciales, double direccionInicial) {
		// TODO Auto-generated constructor stub
		coordenadas = coordenadasIniciales;
		direccion = direccionInicial;
		setExploto(false);
	}

	public void accion(String comandos) {
		for (int i=0;i<comandos.length();i++ ) {
		if (comandos.charAt(i) == 'd') {
			this.coordenadas.descend();
		}
		if (comandos.charAt(i) == 'u') {
			this.coordenadas.ascend();
		}
		if (comandos.charAt(i) == 'm') {
			if (this.coordenadas.getZ() < -1) {
				setExploto(true);
			}
		}
		if (comandos.charAt(i) == 'r') {
			setDireccion(this.direccion -90);
		}
		if (comandos.charAt(i) == 'l') {
			setDireccion(this.direccion +90);
		}
		if (comandos.charAt(i) == 'f') {
			if (Math.cos(Math.toRadians(direccion)) == 1) {
				this.coordenadas.moverX(1);
			}
			else if (Math.cos(Math.toRadians(direccion)) == -1) {
				this.coordenadas.moverX(-1);
			}
			else if (Math.sin(Math.toRadians(direccion)) == 1) {
				this.coordenadas.moverY(1);
			}
			else {
				this.coordenadas.moverY(-1);
			}
			} }
		}
	

	public double getDireccion() {
		return this.direccion;
	}

	public void setDireccion(double d) {
		this.direccion = d;
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
