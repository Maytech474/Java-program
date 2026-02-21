package producao;

class Financeiro {

    public double calcularReceita(double precoUnitario, int quantidadeProduzida) {
        return precoUnitario * quantidadeProduzida;
    }

    public double calcularCustoTotal(double custoPorLote, int lotes) {
        return custoPorLote * lotes;
    }

    public double calcularLucro(double receita, double custo) {
        return receita - custo;
    }

    public double calcularMargem(double lucro, double receita) {
        if (receita == 0) return 0;
        return (lucro / receita) * 100;
    }
}