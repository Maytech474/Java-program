package producao;

import java.util.Scanner;

public class SistemaEmpresarial {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        boolean sistemaAtivo = true;

        while (sistemaAtivo) {

            System.out.println("\n=== SISTEMA EMPRESARIAL INDUSTRIAL ===");
            System.out.println("1 - Simular Produção");
            System.out.println("2 - Sair");
            System.out.print("Escolha: ");
            int opcao = sc.nextInt();

            if (opcao == 1) {

                Lote lote = new Lote();
                Financeiro financeiro = new Financeiro();

                System.out.print("Nome do produto: ");
                lote.setNomeProduto(sc.next());

                System.out.print("Quantidade por lote: ");
                lote.setQuantidadePorLote(sc.nextInt());

                System.out.print("Tempo base (T): ");
                double T = sc.nextDouble();

                System.out.print("Quantidade produzida (q): ");
                int q = sc.nextInt();

                System.out.print("Quantidade total (Q): ");
                int Q = sc.nextInt();

                System.out.print("Horas por turno: ");
                double horasTurno = sc.nextDouble();

                System.out.print("Turnos por dia: ");
                int turnosDia = sc.nextInt();

                System.out.print("Dias no mês: ");
                int diasMes = sc.nextInt();

                System.out.print("Eficiência (%) : ");
                double eficiencia = sc.nextDouble() / 100;

                System.out.print("Perda (%) : ");
                double perda = sc.nextDouble() / 100;

                System.out.print("Custo por lote: ");
                double custoPorLote = sc.nextDouble();

                System.out.print("Preço de venda unitário: ");
                double precoUnitario = sc.nextDouble();

                // ===== CALCULOS DE PRODUÇÃO =====

                double tempoPorLote = lote.calcularTempoPorLote(T, q, Q);
                int lotesPorTurno = (int) (horasTurno / tempoPorLote);
                int producaoTurno = lotesPorTurno * lote.getQuantidadePorLote();
                int producaoDia = producaoTurno * turnosDia;
                int producaoMes = producaoDia * diasMes;

                producaoMes *= eficiencia;
                producaoMes *= (1 - perda);

                // ===== CALCULOS FINANCEIROS =====

                double receita = financeiro.calcularReceita(precoUnitario, producaoMes);
                double custoTotal = financeiro.calcularCustoTotal(custoPorLote, lotesPorTurno * turnosDia * diasMes);
                double lucro = financeiro.calcularLucro(receita, custoTotal);
                double margem = financeiro.calcularMargem(lucro, receita);

                // ===== RELATORIO =====

                System.out.println("\n====== RELATÓRIO EMPRESARIAL ======");
                System.out.println("Produto: " + lote.getNomeProduto());
                System.out.println("Produção mensal: " + producaoMes);
                System.out.println("Receita: R$ " + receita);
                System.out.println("Custo total: R$ " + custoTotal);
                System.out.println("Lucro: R$ " + lucro);
                System.out.println("Margem: " + margem + " %");
                System.out.println("===================================");

            } else {
                sistemaAtivo = false;
            }
        }

        sc.close();
        System.out.println("Sistema encerrado.");
    }
}