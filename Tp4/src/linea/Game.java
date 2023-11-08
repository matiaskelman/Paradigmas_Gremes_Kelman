package linea;

public class Game {

	public static void main(String[] args) throws Exception {

		System.out.println("Dimensiones?");

		Linea game = new Linea(prompt("Base? "), prompt("Altura? "), 'C');

		System.out.println(game.show());

		while (!game.finished()) {

			game.playRedAt(prompt("Red? "));

			System.out.println(game.show());

			if (!game.finished()) {

				game.playBlueAt(prompt("Blue? "));

				System.out.println(game.show());

			}

		}

	}

	private static int prompt(String message) {

		System.out.print(message);

		return Integer.parseInt(System.console().readLine());

	}

}
