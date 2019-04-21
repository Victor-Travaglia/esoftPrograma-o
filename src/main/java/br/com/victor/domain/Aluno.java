package br.com.victor.domain;

public class Aluno {

    private String nome;
    private Integer ra;

    public Aluno(String nome, int ra) {
        this.nome = nome;
        this.ra = ra;
    }

    public String getNome() {
        return nome;
    }

    public Integer getRa() {
        return ra;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Aluno)) return false;

        Aluno aluno = (Aluno) o;

        return getNome().equals(aluno.getNome()) &&
                getRa().equals(aluno.getRa());
    }
}
