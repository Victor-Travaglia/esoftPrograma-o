import br.com.victor.checker.Verificador;
import br.com.victor.domain.Aluno;
import br.com.victor.domain.Avaliacao;
import br.com.victor.domain.Disciplina;
import br.com.victor.repository.RepositorioDeAvaliacoes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Integer opcao = null;

        List<Aluno> alunos = new ArrayList<Aluno>();
        List<Disciplina> disciplinas = new ArrayList<Disciplina>();
        RepositorioDeAvaliacoes academicos = new RepositorioDeAvaliacoes();

        do {
            System.out.println("                       ");
            System.out.println("######### MENU ########");
            System.out.println("1 - Inserir Aluno      ");
            System.out.println("2 - Inserir Disciplinas");
            System.out.println("3 - Inserir Avaliações ");
            System.out.println("4 - Mostrar Alunos     ");
            System.out.println("5 - Mostrar Aprovados  ");
            System.out.println("0 - Sair               ");
            System.out.println("                       ");
            System.out.print(" Informe sua opção: ");
            opcao = sc.nextInt();
            System.out.println();

            if (opcao == 1) {
                System.out.print("\n Informe o Nome do aluno: ");
                String nome = sc.next();

                System.out.print("\n Informe o RA do aluno: ");
                int ra = sc.nextInt();

                Aluno aluno = new Aluno(nome, ra);
                alunos.add(aluno);
                System.out.println();
            }

            if (opcao == 2) {
                System.out.print("\n Informe o Nome da disciplina: ");
                String nome = sc.next();

                Disciplina disciplina = new Disciplina(nome);
                disciplinas.add(disciplina);
                System.out.println();
            }

            if (opcao == 3) {
                System.out.print("\n Informe o Nome do aluno: ");
                String nomeAluno = sc.next();

                System.out.print("\n Informe o RA do aluno: ");
                int ra = sc.nextInt();

                Aluno aluno = new Aluno(nomeAluno, ra);
                Verificador.estaNaLista(alunos, aluno);

                System.out.print("\n Informe o Nome da disciplina: ");
                String nomeDisciplina = sc.next();

                Disciplina disciplina = new Disciplina(nomeDisciplina);
                Verificador.estaNaLista(disciplinas, disciplina);

                for(int i = 0; i < Verificador.QUANTIDADE_DE_NOTAS; i++) {
                    System.out.print("\n Informe a nota da avaliação: ");
                    Double nota = sc.nextDouble();

                    Avaliacao avaliacao = new Avaliacao(aluno, disciplina, nota);
                    academicos.adicionar(avaliacao);
                }
            }

            if (opcao == 4) {
                for(int i = 0; i < alunos.size(); i++){
                    System.out.println("Aluno: " + alunos.get(i).getNome());
                }
            }

            if (opcao == 5) {
                System.out.print("\n Informe o Nome da disciplina: ");
                String nome = sc.next();

                Disciplina disciplina = new Disciplina(nome);
                Verificador.estaNaLista(disciplinas, disciplina);

                System.out.println(academicos.obterAprovados(disciplina));
            }
        }
        while(opcao != 0);

        sc.close();
    }
}
