import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<PessoaFisica> listaPf = new ArrayList<>();

        System.out.println("Bem vindo ao sistema de cadastro de Pessoas Fisicas e Juridicas");

        Scanner leitor = new Scanner(System.in);

        String opcao;

        do{

            System.out.println("Escolha uma opção: 1 - Pessoa Fisica / 2 - Pessoa Juridica / 0 - Sair");
            opcao = leitor.nextLine();

            switch(opcao){
                case "1":
                    String opcaoPf;

                    do{

                        System.out.println("Digite uma opcao: 1 - Cadastrar PF / 2 - Listar PF / 0 - Voltar");
                        opcaoPf = leitor.nextLine();

                        switch(opcaoPf){
                            case "1":
                                PessoaFisica novaPf = new PessoaFisica();
                                Endereco novoEndPf = new Endereco();

                                System.out.println("Digite o nome: ");
                                novaPf.nome = leitor.nextLine();

                                System.out.println("Digite o cpf: ");
                                novaPf.cpf = leitor.nextLine();

                                System.out.println("Digite o rendimento: ");
                                novaPf.rendimento = leitor.nextFloat();

                                System.out.println("Digite a data de nascimento: (dd/mm/aaaa)");
                                novaPf.dataNasc = LocalDate.parse(leitor.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

                                Period idade = Period.between(novaPf.dataNasc, LocalDate.now());

                                if(idade.getYears() >= 18){
                                    System.out.println("Idade Valida!");
                                }else{
                                    System.out.println("Idade Invalida!");
                                    break;
                                }

                                leitor.nextLine();

                                System.out.println("Digite o logradouro: ");
                                novoEndPf.logradouro = leitor.nextLine();

                                System.out.println("Digite o numero: ");
                                novoEndPf.numero = leitor.nextInt();

                                leitor.nextLine();

                                System.out.println("Este endereco e comercial? S/N: ");
                                String endCom = leitor.nextLine();
                                if(endCom.equals("S") || endCom.equals("s")){
                                    novoEndPf.endComercial = true;
                                }else{
                                    novoEndPf.endComercial = false;
                                }

                                novaPf.endereco = novoEndPf;

                                listaPf.add(novaPf);

                                System.out.println("Cadastrro realizado com sucesso!");

                                break;

                            case "2":
                                if(listaPf.size() > 0){
                                    for (PessoaFisica cadaPf : listaPf) {
                                        System.out.println("Nome: " + cadaPf.nome);
                                        System.out.println("CPF: " + cadaPf.cpf);
                                        System.out.println("Data de Nascimento: " + cadaPf.dataNasc.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                                        System.out.println("Endereco: " + cadaPf.endereco.logradouro + "-" + cadaPf.endereco.numero);
                                        System.out.println();
                                        System.out.println("Aperte ENTER para continuar");
                                        leitor.nextLine();
                                    }
                                }else{
                                    System.out.println("Lista vazia!");
                                }
                                break;

                            case "0":
                                System.out.println("Voltar");
                                break;

                            default:
                                System.out.println("Opcao invalida!");
                                break;

                        }

                    }while(!opcaoPf.equals("0"));

                    break;

                case "2":
                    System.out.println("case 2");
                    break;

                case "0":
                    System.out.println("case 0");
                    break;

                default:
                    System.out.println("default");
                    break;

            }

        }while(!opcao.equals("0"));
    }
}