package Nemo;

import java.util.ArrayList;

import java.util.stream.Collectors;

public class Sub {
	private Coordenadas coordenadas;
	private double direccion;
	private boolean exploto;

	public Sub(Coordenadas coordenadasIniciales, double direccionInicial) {
		coordenadas = coordenadasIniciales;
		direccion = direccionInicial;
		setExploto(false);
	}

	public void accion(String comandos) {
		ArrayList<Character> comandoList = new ArrayList<Character>(comandos.chars().mapToObj(e -> (char) e).collect(Collectors.toList()));
		System.out.print(comandoList);
		comandoList.forEach(comando -> accionForSingleCommand(comando));}

		

	public void accionForSingleCommand(char comando) {
		System.out.print(comando);
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

	public boolean isExploto() {
		return exploto;
	}

	public void setExploto(boolean exploto) {
		this.exploto = exploto;
	}
}
