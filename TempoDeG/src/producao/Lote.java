package producao;

class Lote {

    private String nomeProduto;
    private int quantidadePorLote;

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setQuantidadePorLote(int quantidadePorLote) {
        this.quantidadePorLote = quantidadePorLote;
    }

    public int getQuantidadePorLote() {
        return quantidadePorLote;
    }

    public double calcularTempoPorLote(double T, int q, int Q) {
        return T * ((double) q / Q);
    }
}