import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Renda anual com salário: ");
        Double salarioAnual = scanner.nextDouble();
        System.out.print("Renda anual com prestação de serviço: ");
        Double prestacaoAnual = scanner.nextDouble();
        System.out.print("Renda anual com ganho de capital: ");
        Double ganhoCapitalAnual = scanner.nextDouble();

        System.out.print("Gastos Médicos: ");
        Double gastosMedicos = scanner.nextDouble();
        System.out.print("Gastos Educacionais: ");
        Double gastosEducacionais = scanner.nextDouble();


        // Calculo Impostos
        Double impostoSalario;
        if (salarioAnual / 12 > 5000.00) {
            impostoSalario = salarioAnual * 0.2;
        } else if (salarioAnual / 12 >= 3000.00 && salarioAnual / 12 <= 5000.00) {
            impostoSalario = salarioAnual * 0.1;
        } else {
            impostoSalario = 0.00;
        }

        Double impostoPrestacao = prestacaoAnual * 0.15;
        Double impostoGanhoCapital = ganhoCapitalAnual * 0.2;

        // Relatorio de Impostos
        System.out.println("\n");
        System.out.println("RELATORIO IMPOSTO DE RENDA");
        System.out.println("\n");
        System.out.println("CONSOLIDADO DE RENDA:");
        System.out.printf("Imposto sobre salario: %.2f%n", impostoSalario);
        System.out.printf("Imposto sobre servicos: %.2f%n", impostoPrestacao);
        System.out.printf("Imposto sobre ganho de capital: %.2f%n", impostoGanhoCapital);

        // Relatorio Deducoes
        Double maximoDedutivel = (impostoSalario + impostoPrestacao + impostoGanhoCapital) * 0.3;
        Double gastosDedutiveis = gastosMedicos + gastosEducacionais;
        System.out.println("\n");
        System.out.println("DEDUCOES:");
        System.out.printf("Maximo dedutivel %.2f%n", maximoDedutivel);
        System.out.printf("Gastos dedutiveis: %.2f%n", gastosDedutiveis);
        System.out.println("\n");

        // Resumo do Total
        Double impostoTotal = impostoSalario + impostoPrestacao + impostoGanhoCapital;

        Double abatimento = gastosDedutiveis > maximoDedutivel ? maximoDedutivel : gastosDedutiveis;

        Double impostoDevido = impostoTotal - abatimento;

        System.out.println("RESUMO:");
        System.out.printf("Imposto bruto total: %.2f%n", impostoTotal);
        System.out.printf("Abatimento: %.2f%n", abatimento);
        System.out.printf("Imposto devido: %.2f%n", impostoDevido);

        scanner.close();
    }
}
