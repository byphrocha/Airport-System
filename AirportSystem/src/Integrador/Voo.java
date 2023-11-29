package Integrador;

import java.util.*;
public class Voo { // Atributos do voo
    private String numeroVoo;
    private String origem;
    private String destino;
    private String dataHoraPartida;
    private int numAssentosTotal;
    private List<Integer> assentosDisponiveis;
    private Map<Integer, Passageiro> assentosReservados; // Mapa para associar assentos aos passageiros

 // Construtor para inicializar um objeto Voo com os dados fornecidos
    public Voo(String numeroVoo, String origem, String destino, String dataHoraPartida, int numAssentosTotal) {
        this.numeroVoo = numeroVoo;
        this.origem = origem;
        this.destino = destino;
        this.dataHoraPartida = dataHoraPartida;
        this.numAssentosTotal = numAssentosTotal;
        this.assentosDisponiveis = new ArrayList<>();
        this.assentosReservados = new HashMap<>(); // Inicializa o mapa de assentos reservados
        for (int i = 1; i <= numAssentosTotal; i++) {
            assentosDisponiveis.add(i);
        }
    }

    public String getNumeroVoo() {
        return numeroVoo;
    }

    public String getOrigem() {
        return origem;
    }

    public String getDestino() {
        return destino;
    }

    public String getDataHoraPartida() {
        return dataHoraPartida;
    }

    public int getNumAssentosTotal() {
        return numAssentosTotal;
    }

    public int getNumAssentosDisponiveis() {
        return assentosDisponiveis.size();
    }

     public boolean reservarAssento(int assento, Passageiro passageiro) {
        if (assentosDisponiveis.contains(assento)) {
            assentosDisponiveis.remove(Integer.valueOf(assento));
            assentosReservados.put(assento, passageiro); // Associa o assento ao passageiro
            return true; // Assento reservado com sucesso
        } else {
            return false; // Assento não disponível
        }
    }

    public Map<Integer, Passageiro> getAssentosReservados() {
        return assentosReservados; // Método para obter os assentos reservados e os passageiros associados a eles
    } 
}
