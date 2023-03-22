package conta;

import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int opcao;
		while (true) {
			System.out.println(" ========================================================================");
			System.out.println(" ||====================================================================||");
			System.out.println(" ||                                                                    ||");
			System.out.println(" ||                         Banco Rouffos                              ||");
			System.out.println(" ||                                                                    ||");
			System.out.println(" ||====================================================================||");
			System.out.println(" || (1) Criar conta             || (2) Listar todas as contas          ||");
			System.out.println(" ||=============================||=====================================||");
			System.out.println(" || (3) Buscar conta por número || (4) Atualizar dados da conta        ||");
			System.out.println(" ||=============================||=====================================||");
			System.out.println(" || (5) Apagar conta            || (6) Sacar                           ||");
			System.out.println(" ||=============================||=====================================||");
			System.out.println(" || (7) Depositar               || (8) Transferir valores entre contas ||");
			System.out.println(" ||====================================================================||");
			System.out.println(" ||                          (9) Sair                                  ||");
			System.out.println(" ||====================================================================||");
			System.out.println(" ||                    Entre com a opção desejada                      ||");
			System.out.println(" ||====================================================================||");
			System.out.println(" ========================================================================");
			opcao = input.nextInt();

			if (opcao == 9) {
				System.out.println("Banco Rouffos -- Seu FUTURO é aqui!");
				input.close();
				System.exit(0);

			}
			switch (opcao) {
			case 1:
				System.out.println("Criar conta\n\n");

				break;
			case 2:
				System.out.println("Listar todas as contas\n\n");

				break;
			case 3:
				System.out.println("Buscar conta por número\n\n");

				break;
			case 4:
				System.out.println("Atualizar dados da conta\n\n");

				break;
			case 5:
				System.out.println("Apagar conta\n\n");

				break;
			case 6:
				System.out.println("Sacar\n\n");

				break;
			case 7:
				System.out.println("Depositar\n\n");

				break;
			case 8:
				System.out.println("Transferir valores entre contas\n\n");

				break;
			default:
				System.out.println("Opção inválida. Por favor, insira uma opção válida.\n");
			}
		}
	}

}
