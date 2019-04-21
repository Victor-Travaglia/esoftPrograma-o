package br.com.victor.repository;

import br.com.victor.checker.Verificador;
import br.com.victor.domain.Aluno;
import br.com.victor.domain.Avaliacao;
import br.com.victor.domain.Disciplina;

import java.util.ArrayList;
import java.util.List;

public class RepositorioDeAvaliacoes {

    private List<Avaliacao> avaliacoes = new ArrayList<Avaliacao>();

    public void adicionar(Avaliacao avaliacao){
        avaliacoes.add(avaliacao);
    }

    public Aluno [] obterAprovados(Disciplina disciplina) {
        Aluno [] aluno = null;
        for (int i = 0; i < avaliacoes.size(); i ++) {
            if (avaliacoes.get(i).getDisciplina().equals(disciplina)) {
                Double media = 0.0;
                for (int j = 0; j < Verificador.QUANTIDADE_DE_NOTAS; j++) {
                    media += avaliacoes.get(j).getNota();
                }
                if (media / 4 >= Verificador.MEDIA_APROVADO) {
                    aluno [i] = avaliacoes.get(i).getAluno();
                }
            }
        }
        return aluno;
    }
}