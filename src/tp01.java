import java.util.Scanner;

public class tp01 {

    private static String[] nomes;
    private static float[] notaAV1;
    private static float[] notaAV2;

    private static final int TAMANHO = 100;

    private static void imprimir() {
        for (int i = 0; i < TAMANHO; i++) {
            if(nomes[i] != null) {
                imprimir(i);
            }
        }
    }

    private static void imprimir(int indice) {
        float mediaFinal = calcularSituacao(indice);
       
        System.out.println("Nome do aluno: " + nomes[indice]);
        System.out.println("Nota da AV1: "   + notaAV1[indice]);
        System.out.println("Nota da AV1: "   + notaAV2[indice]);
        System.out.println("Média final: "   + mediaFinal);
        System.out.println("Situação: "      + obterSituacao(mediaFinal));
    }

    private static float calcularSituacao(int indice) {
        return (notaAV1[indice] + notaAV2[indice]) / 2;
    }

    private static String obterSituacao(float media) {
        if(media >= 7) {
            return "Aprovado";
        } else if(media >= 4 && media < 7) {
            return "Prova final";
        } else {
            return "Reprovado";
        }
    }

    public static void main(String[] args) {
        nomes = new String[TAMANHO];
        notaAV1 = new float[TAMANHO];
        notaAV2 = new float[TAMANHO];

        Scanner in = new Scanner(System.in);

        String opcao;
        int pos = 0;

        do {
            System.out.println("[1] Registrar as notas de um novo aluno.");
            System.out.println("[2] Consultar boletim de um aluno");
            System.out.println("[3] Consultar notas da turma.");
            System.out.println("[4] Sair.");

            System.out.print("Opção: ");
            opcao = in.next();

            switch (opcao) {
                case "1":
                    if(pos < TAMANHO) {
                        System.out.print("Nome: ");
                        nomes[pos] = in.next();

                        System.out.print("Nota AV1: ");
                        notaAV1[pos] = in.nextFloat();

                        System.out.print("Nota AV2: ");
                        notaAV2[pos] = in.nextFloat();

                        System.out.println("Registro realizado com codigo " + pos);

                        pos++;
                    } else {
                        System.out.println("Não há mais espaço para novos alunos.");
                    }
                    break;
                case "2":
                  System.out.print("Informe o codigo do aluno: ");
                  int id = in.nextInt();

                  if(id >= 0 && id < pos) {
                        imprimir(id);
                    } else {
                        System.out.println("Aluno não encontrado.");
                  }
                  break;
                case "3":
                    imprimir();
                    break;
                case "4":
                System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (!"4".equalsIgnoreCase(opcao));
        
        System.out.println("Fim do programa.");

        in.close();
    }
}