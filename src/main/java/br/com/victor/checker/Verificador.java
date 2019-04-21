package br.com.victor.checker;

import br.com.victor.domain.Aluno;
import br.com.victor.domain.Disciplina;

import java.util.List;

public class Verificador {

    private static final Double LIMITE_SUPERIOR_NOTA = 10.0;
    private static final Double LIMITE_INFERIOR_NOTA = 0.0;
    public static final Double MEDIA_APROVADO = 6.0;
    public static final Integer QUANTIDADE_DE_NOTAS = 4;

    public static void obrigatorio(Object value, String campo) {
        if (value.equals(null)) {
            throw new RuntimeException("\n Campo " + campo + " é obrigatório");
        }
    }

    public static void notaValida(Double value, String campo) {
        if (value > LIMITE_SUPERIOR_NOTA && value < LIMITE_INFERIOR_NOTA) {
            throw new RuntimeException("\n Campo " + campo + " deve estar no intervalo de " + LIMITE_INFERIOR_NOTA + " e" + LIMITE_SUPERIOR_NOTA);
        }
    }

    public static void estaNaLista(List<Aluno> alunos, Aluno aluno) {
        for (int i = 0; i < alunos.size(); i++) {
            if (alunos.get(i).getNome().equalsIgnoreCase(aluno.getNome()) && alunos.get(i).getRa().equals(aluno.getRa())) {
                break;
            }
            else {
                throw new RuntimeException("\n O nome: " + aluno.getNome() + " não está na lista");
            }
        }
    }

    public static void estaNaLista(List<Disciplina> disciplinas, Disciplina disciplina) {
        for (int i = 0; i < disciplinas.size(); i++) {
            if (disciplinas.get(i).getNome().equalsIgnoreCase(disciplina.getNome())) {
                break;
            }
            else {
                throw new RuntimeException("\n A Disciplina: " + disciplina.getNome() + " não está na lista");
            }
        }
    }
}
