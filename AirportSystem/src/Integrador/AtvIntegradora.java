package Integrador;

import java.util.*;
public class AtvIntegradora {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Inicialização de variáveis
        List<Voo> voos = new ArrayList<>();

        int opcao;
        do { // Loop do menu principal
            exibirMenu();
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha pendente

            switch (opcao) {
                case 1:
                    cadastrarVoo(scanner, voos);
                    break;
                case 2:
                    reservarAssento(scanner, voos);
                    break;
                case 3:
                    consultarInformacoesVoo(scanner, voos);
                    break;
                case 0:
                    System.out.println("Saindo do programa. Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }

    private static void exibirMenu() { // Método para exibir o menu de opções
        System.out.println("\nEscolha uma opção:");
        System.out.println("1 - Cadastrar Voo");
        System.out.println("2 - Reservar Assento");
        System.out.println("3 - Consultar Informações de Voo");
        System.out.println("0 - Sair");
    }

    private static void cadastrarVoo(Scanner scanner, List<Voo> voos) { // Método para cadastrar um novo voo
        System.out.println("Digite o número do voo:");
        String numeroVoo = scanner.next();

        System.out.println("Digite a origem do voo:");
        String origem = scanner.next();

        System.out.println("Digite o destino do voo:");
        scanner.nextLine(); // Consumir a quebra de linha pendente
        String destino = scanner.nextLine();

        System.out.println("Digite a data e hora de partida do voo (formato: yyyy-MM-dd HH:mm):");
        String dataHoraPartida = scanner.next() + " " + scanner.next();

        System.out.println("Digite o número total de assentos do voo:");
        int numAssentosTotal = scanner.nextInt();

        Voo novoVoo = new Voo(numeroVoo, origem, destino, dataHoraPartida, numAssentosTotal);
        voos.add(novoVoo);

        System.out.println("Voo cadastrado com sucesso!");
    }   // Solicita e obtém os dados para criar um novo Voo
       // Adiciona o novo Voo à lista de voos
      // Imprime mensagem de sucesso

    private static void reservarAssento(Scanner scanner, List<Voo> voos) { // Método para reservar um assento em um voo
        System.out.println("Digite o número do voo para reserva:");
        String numeroVoo = scanner.next();

        Voo vooSelecionado = buscarVooPorNumero(numeroVoo, voos);

        if (vooSelecionado != null) {
            System.out.println("Digite o número do assento desejado:");
            int assento = scanner.nextInt();

            System.out.println("Digite o nome do passageiro:");
            scanner.nextLine(); // Consumir a quebra de linha pendente
            String nomePassageiro = scanner.nextLine();

            System.out.println("Digite o número do documento do passageiro:");
            String numDocumento = scanner.next();

            System.out.println("Digite o número do telefone do passageiro:");
            String numTelefone = scanner.next();

            Passageiro novoPassageiro = new Passageiro(nomePassageiro, numDocumento, numTelefone);
            if (vooSelecionado.reservarAssento(assento, novoPassageiro)) {
                System.out.println("Assento reservado com sucesso para " + nomePassageiro);
            } else {
                System.out.println("Assento não disponível.");
            }
            } 
    } 		   // Solicita e obtém os dados para reservar um assento em um voo
    		  // Verifica se o voo existe e se o assento está disponível
    		 // Realiza a reserva do assento para o passageiro
    		// Imprime mensagem de sucesso ou de assento não disponível

    private static void consultarInformacoesVoo(Scanner scanner, List<Voo> voos) { // Método para consultar informações de um voo
        System.out.println("Digite o número do voo para consulta:");
        String numeroVoo = scanner.next();

        Voo vooSelecionado = buscarVooPorNumero(numeroVoo, voos);

        if (vooSelecionado != null) {
            System.out.println("Informações do Voo:");
            System.out.println("Origem: " + vooSelecionado.getOrigem());
            System.out.println("Destino: " + vooSelecionado.getDestino());
            System.out.println("Data e Hora de Partida: " + vooSelecionado.getDataHoraPartida());
            System.out.println("Número Total de Assentos: " + vooSelecionado.getNumAssentosTotal());
            System.out.println("Número de Assentos Disponíveis: " + vooSelecionado.getNumAssentosDisponiveis());

            // Mostrar assentos reservados e os passageiros associados
            Map<Integer, Passageiro> assentosReservados = vooSelecionado.getAssentosReservados();
            if (!assentosReservados.isEmpty()) {
                System.out.println("Assentos Reservados:");
                for (Map.Entry<Integer, Passageiro> entry : assentosReservados.entrySet()) {
                    System.out.println("Assento " + entry.getKey() + ": " + entry.getValue().getNome());
                }
            } else {
                System.out.println("Não há assentos reservados neste voo.");
            }
        } else {
            System.out.println("Voo não encontrado.");
        }
    }    // Solicita e obtém o número do voo para consultar suas informações
        // Busca o voo na lista e imprime suas informações (origem, destino, etc.)
       // Imprime os assentos reservados e os passageiros associados

    private static Voo buscarVooPorNumero(String numeroVoo, List<Voo> voos) { // Método para buscar um voo na lista por número de voo
        for (Voo voo : voos) {
            if (voo.getNumeroVoo().equals(numeroVoo)) {
                return voo;
            }
        }
        return null;
    }
}
	 //Percorre a lista de voos para encontrar o voo pelo número
	// Retorna o voo se encontrado, senão retorna null
