package br.com.victor.domain;

import br.com.victor.checker.Verificador;

public class Avaliacao {

    private Double nota;
    private Aluno aluno;
    private Disciplina disciplina;

    public Avaliacao(Aluno aluno, Disciplina disciplina, Double nota) {
        Verificador.obrigatorio(aluno, "aluno");
        Verificador.obrigatorio(disciplina, "disciplina");
        Verificador.obrigatorio(nota, "nota");
        Verificador.notaValida(nota, "nota");

        this.aluno = aluno;
        this.disciplina = disciplina;
        this.nota = nota;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public Double getNota() {
        return nota;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Avaliacao)) return false;

        Avaliacao avaliacao = (Avaliacao) o;

        return getNota().equals(avaliacao.getNota()) &&
                getAluno().equals(avaliacao.getAluno()) &&
                getDisciplina().equals(avaliacao.getDisciplina());
    }
}