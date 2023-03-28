package conta;

import conta.controller.ContaController;
import conta.model.ContaPoupanca;
import conta.model.ContaCorrente;
import conta.model.Conta;
import conta.util.Cores;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
		ContaController contas = new ContaController();
		Scanner input = new Scanner(System.in);
		int opcao, numero, agencia, tipo, aniversario;
		String titular;
		float saldo, limite;

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
				System.out.println("Informe o número da agência: ");
				agencia = input.nextInt();
				System.out.println("Informe o nome do titular da conta: ");
				input.skip("\\R?");
				titular = input.nextLine();

				do {
					System.out.println("Informe o tipo da conta([1] Conta Corrente // [2] Conta Poupança");
					tipo = input.nextInt();
				} while (tipo < 1 && tipo > 2);

				System.out.println("Informe o saldo da conta(R$): ");
				saldo = input.nextFloat();

				switch (tipo) {
				case 1 -> {
					System.out.println("Informe o limite de crédito da conta(R$): ");
					limite = input.nextFloat();
					contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
				}
				case 2 -> {
					System.out.println("Informe o dia do aniversário da conta: ");
					aniversario = input.nextInt();
					contas.cadastrar(
							new ContaPoupanca(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
				}
				default -> {
					System.out.println("Tipo de conta inválida!");
				}
				}

				keyPress();
				break;
			case 2:
				System.out.println(Cores.TEXT_WHITE + "Listar todas as contas\n\n");
				contas.listarTodas();
				keyPress();
				break;
			case 3:
				System.out.println(Cores.TEXT_WHITE + "Buscar conta por número\n\n");
				System.out.println("Informe o número da conta que deseja encontrar: ");
				numero = input.nextInt();

				contas.procurarPorNumero(numero);

				keyPress();
				break;
			case 4:
				System.out.println(Cores.TEXT_WHITE + "Atualizar dados da conta\n\n");
				numero = input.nextInt();
				if (contas.buscarNaCollection(numero) != null) {

					System.out.println("Informe o número da agência: ");
					agencia = input.nextInt();
					System.out.println("Informe o nome do titular da conta: ");
					input.skip("\\R?");
					titular = input.nextLine();

					tipo = contas.retornaTipo(numero);

					System.out.println("Informe o saldo da conta(R$): ");
					saldo = input.nextFloat();

					switch (tipo) {
					case 1 -> {
						System.out.println("Informe o limite de crédito da conta(R$): ");
						limite = input.nextFloat();
						contas.cadastrar(
								new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
						System.out.println("A conta número " + numero + " foi atualizada com sucesso");
					}
					case 2 -> {
						System.out.println("Informe o dia do aniversário da conta: ");
						aniversario = input.nextInt();
						contas.cadastrar(
								new ContaPoupanca(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
						System.out.println("A conta número " + numero + " foi atualizada com sucesso");
					}
					default -> {
						System.out.println("Tipo de conta inválida!");
					}

					}
				} else {
					System.out.println("A conta" + numero + " não foi encontrada!");
				}
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
				if (opcao < 1 || opcao > 9) {
					System.out.println(Cores.TEXT_RED_BOLD + "Opção inválida. Por favor, insira uma opção válida.\n"
							+ Cores.TEXT_RESET);
				}
				keyPress();
				break;
			}
		}
	}

	public static void keyPress() {

		try {

			System.out.println(Cores.TEXT_RESET + "\nAperte Enter para prosseguir! ");
			System.in.read();
		} catch (IOException e) {

			System.out.println("Você pressionou uma tecla diferente de Enter!");
		}
	}

}
