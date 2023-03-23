package conta;

import conta.model.ContaPoupanca;
import conta.model.ContaCorrente;
import conta.model.Conta;
import conta.util.Cores;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int opcao;
		// Teste da Classe Conta Corrente
				ContaCorrente cc1 = new ContaCorrente(1, 123, 1, "José da Silva", 0.0f, 1000.0f);
				cc1.visualizar();
				cc1.sacar(12000.0f);
				cc1.visualizar();
				cc1.depositar(5000.0f);
				cc1.visualizar();
				
		        // Teste da Classe Conta Poupança
				ContaPoupanca cp1 = new ContaPoupanca(2, 123, 2, "Maria dos Santos", 100000.0f, 15);
				cp1.visualizar();
		        cp1.sacar(1000.0f);
				cp1.visualizar();
				cp1.depositar(5000.0f);
				cp1.visualizar();

		while (true) {
			System.out.println(Cores.TEXT_CYAN + Cores.ANSI_BLACK_BACKGROUND
					+ " ========================================================================");

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
			System.out.println(
					" ========================================================================" + Cores.TEXT_RESET);
			try {
				opcao = input.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Por favor, digite números inteiros! ");
				input.nextLine();
				opcao = 0;
			}

			if (opcao == 9) {
				System.out.println(Cores.TEXT_WHITE_BOLD + "Banco Rouffos -- Seu FUTURO é aqui!");
				input.close();
				System.exit(0);

			}
			switch (opcao) {
			case 1:
				System.out.println(Cores.TEXT_WHITE + "Criar conta\n\n");

				keyPress();
				break;
			case 2:
				System.out.println(Cores.TEXT_WHITE + "Listar todas as contas\n\n");

				keyPress();
				break;
			case 3:
				System.out.println(Cores.TEXT_WHITE + "Buscar conta por número\n\n");

				keyPress();
				break;
			case 4:
				System.out.println(Cores.TEXT_WHITE + "Atualizar dados da conta\n\n");

				keyPress();
				break;
			case 5:
				System.out.println(Cores.TEXT_WHITE + "Apagar conta\n\n");

				keyPress();
				break;
			case 6:
				System.out.println(Cores.TEXT_WHITE + "Sacar\n\n");

				keyPress();
				break;
			case 7:
				System.out.println(Cores.TEXT_WHITE + "Depositar\n\n");

				keyPress();
				break;
			case 8:
				System.out.println(Cores.TEXT_WHITE + "Transferir valores entre contas\n\n");

				keyPress();
				break;
			default:
				System.out.println(Cores.TEXT_RED_BOLD + "Opção inválida. Por favor, insira uma opção válida.\n"+ Cores.TEXT_RESET);
				keyPress();
			}
		}
	}

	public static void keyPress() {

		try {

			System.out.println(Cores.TEXT_RESET + "\nPressione Enter para continuar... ");
			System.in.read();
		} catch (IOException e) {

			System.out.println("Você pressionou uma tecla diferente de Enter!");
		}
	}

}
