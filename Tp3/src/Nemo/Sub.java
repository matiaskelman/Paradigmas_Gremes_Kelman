package Nemo;

import java.util.ArrayList;

import java.util.stream.Collectors;

public class Sub {
	private Coordenadas coordenadas;
	public DepthManager depth;
	private double direccion;

	public Sub(Coordenadas coordenadasIniciales, double direccionInicial) {
		coordenadas = coordenadasIniciales;
		direccion = direccionInicial;
		depth = new DepthManager();
	}

	public void accion(String comandos) {
		ArrayList<Character> comandoList = new ArrayList<Character>(
				comandos.chars().mapToObj(e -> (char) e).collect(Collectors.toList()));
		comandoList.forEach(comando -> accionForSingleCommand(comando));
	}

	public void accionForSingleCommand(char comando) {
		Command.accionFor(comando).move(this);
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

	public int getDepth() {
		return -depth.size();
	}
}
