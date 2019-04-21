package br.com.victor.domain;

public class Disciplina {

    private String nome;

    public Disciplina(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Disciplina)) return false;

        Disciplina that = (Disciplina) o;

        return getNome().equals(that.getNome());
    }
}