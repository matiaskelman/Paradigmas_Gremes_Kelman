package Nemo;

import java.util.ArrayList;

import java.util.stream.Collectors;

public class Sub {
	private Coordenadas coordenadas;
	public DepthManager depth;
	private String direccion;

	public Sub(Coordenadas coordenadasIniciales, String direccionInicial) {
		coordenadas = coordenadasIniciales;
		direccion = direccionInicial;
		depth = new DepthManager();
	}

	public void accion(String comandos) {
		comandos.chars().forEachOrdered(comando -> accionForSingleCommand((char) comando));
		}
	public void accionForSingleCommand(char comando) {
			Command.commandFor(comando).move(this);
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String d) {
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
