package linea;

public class Game {

	public static void main(String[] args) throws Exception {

		System.out.println("Dimensiones?");

		Linea game = new Linea(promptInt("Base? "), promptInt("Altura? "), (char) promptChar("Modo?"));

		System.out.println(game.show());

		while (!game.finished()) {

			game.agregarRojoEnColumna(promptInt("Red? "));

			System.out.println(game.show());

			if (!game.finished()) {

				game.agregarAzulEnColumna(promptInt("Blue? "));

				System.out.println(game.show());

			}

		}

	}

	private static int promptInt(String message) {

		System.out.print(message);

		return Integer.parseInt(System.console().readLine());

	}
	private static char promptChar(String message) {

		System.out.print(message);

		return System.console().readLine().charAt(0);

	}

}
