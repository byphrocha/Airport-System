package Integrador;
public class Passageiro { // Atributos do passageiro
	private String nome;
    private String numDocumento;
    private String numTelefone;

    // Construtor para inicializar um objeto Passageiro com os dados fornecidos
    public Passageiro(String nome, String numDocumento, String numTelefone) {
        this.nome = nome;
        this.numDocumento = numDocumento;
        this.numTelefone = numTelefone;
    }
    // Métodos de acesso aos atributos do passageiro
    public String getNome() {
        return nome;
    }

    public String getNumDocumento() {
        return numDocumento;
    }

    public String getNumTelefone() {
        return numTelefone;
    }
}

