import java.util.Scanner;

public class MediaAlunos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int NUM_ALUNOS = 3;

        for (int i = 1; i <= NUM_ALUNOS; i++) {
            System.out.println("Aluno " + i);

            // Leitura das notas A1 e A2
            System.out.print("Digite a nota da prova A1: ");
            double notaA1 = scanner.nextDouble();

            System.out.print("Digite a nota da prova A2: ");
            double notaA2 = scanner.nextDouble();

            // Cálculo da média
            double media = (notaA1 + notaA2) / 2;

            // Verificação da situação do aluno
            if (media < 4) {
                System.out.println("Média: " + media + " - Situação: Reprovado");
            } else if (media >= 4 && media < 6) {
                System.out.println("Média: " + media + " - Situação: Exame final");
                System.out.print("Digite a nota do exame final: ");
                double notaExameFinal = scanner.nextDouble();

                // Recalcular média com a nota do exame final
                double mediaFinal = (media + notaExameFinal) / 2;

                if (mediaFinal >= 6) {
                    System.out.println("Média final: " + mediaFinal + " - Situação: Aprovado");
                } else {
                    System.out.println("Média final: " + mediaFinal + " - Situação: Reprovado");
                }
            } else {
                System.out.println("Média: " + media + " - Situação: Aprovado");
            }

            System.out.println(); // Linha em branco para separar alunos
        }

        scanner.close();
    }
}
