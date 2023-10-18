import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Produto> produtos = new ArrayList<>();        //lista de produtos não pereciveis
        ArrayList<Perecivel> pereciveis = new ArrayList<>();    //lista de produtos pereciveis

        int escolhaMenu;
        int simNao;

        do {

            System.out.print("\n\n" +
                    "================\n" +
                    "Cadastro de Produtos\n" +
                    "Digite o número da opção desejada: \n" +
                    "1 - Criar Produto\n" +
                    "2 - Criar Produto Perecível\n" +
                    "3 - Printar a lista de produtos\n" +
                    "4- Sair\n");


            Scanner input = new Scanner(System.in);

            escolhaMenu = input.nextInt();      //loop de validação da leitura da opção.
            input.nextLine();

            while (escolhaMenu < 1 || escolhaMenu > 4) {
                System.out.println("Erro. Digite 1,2,3 ou 4:");
                escolhaMenu = input.nextInt();      //loop de validação da leitura da opção.
                input.nextLine();
            }

            switch (escolhaMenu) {
                // criar produto
                case 1 -> {
                    // inserção de um novo produto
                    do {
                        System.out.print("\nInsira uma Descrição para o produto: ");
                        String descricao = input.nextLine();

                        System.out.print("Insira o Valor do produto: ");
                        double valor = input.nextDouble();
                        input.nextLine();

                        Produto produto = new Produto(descricao, valor);

                        produtos.add(produto);

                        System.out.printf("\n%s", produto);

                        System.out.print("\n\nDeseja criar mais um produto? 1 para sim, 2 para não:");
                        simNao = input.nextInt();
                        input.nextLine();
                    } while (simNao != 2);
                    break;
                }

                // criar produto perecível
                case 2 -> {
                    do {
                        System.out.print("\nInsira uma Descrição para o produto perecível: ");
                        String descricao = input.nextLine();

                        System.out.print("Insira o Valor do produto perecível: ");
                        double valor = input.nextDouble();
                        input.nextLine();

                        System.out.print("Insira o Dia de Validade (DD): ");
                        int dia = input.nextInt();
                        input.nextLine();

                        System.out.print("Insira o Mes de Validade (MM): ");
                        int mes = input.nextInt();
                        input.nextLine();

                        System.out.print("Insira o Ano de Validade (YYYY): ");
                        int ano = input.nextInt();
                        input.nextLine();

                        Perecivel perecivel = new Perecivel(descricao, valor, dia, mes, ano); // adicionar vetor validade

                        pereciveis.add(perecivel);

                        System.out.printf("\n%s", perecivel); //printa o objeto criado

                        if (perecivel.estaVencido()) {
                            System.out.println("\n\nATENCAO: ========= \nO produto está vencido!");
                        } else {
                            System.out.println("\n\nO produto está na data de validade!");
                        }

                        System.out.print("Defina quanto deseja aplicar de desconto: ");
                        double desconto = input.nextDouble();
                        input.nextLine();

                        perecivel.aplicaDesconto(desconto);

                        System.out.print("O novo valor atualizado é:");
                        System.out.printf("\n%s", perecivel.getValor()); //printa o objeto criado

                        System.out.print("\n\nDeseja criar mais um produto? 1 para sim, 2 para não");
                        simNao = input.nextInt();
                        input.nextLine();
                    } while (simNao != 2);
                    break;
                }
                case 3 -> {
                    for (Produto i : produtos) {
                        System.out.print("\n========\n");
                        System.out.printf(i.toString());
                    }
                    for (Perecivel i : pereciveis) {
                        System.out.print("\n========\n");
                        System.out.printf(i.toString());
                    }
                    break;
                }
                case 4 ->{
                    System.exit(0);
                }
            }
        }while(escolhaMenu != 4);

        } // fim do lançamento de exceções
    } // fim do método principal
