package Aep.aepjava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");

		RepositorioDeAvaliações repositorioAvaliacao = new RepositorioDeAvaliações();
		// Criar 10 alunos
		List<Aluno> listAlunos = new ArrayList<Aluno>();

		for (int contador = 0; contador < 10; contador++) {
			listAlunos.add(new Aluno(contador, "aluno" + contador));
		}
		// Cria 5 disciplinas
		List<Disciplina> listDisciplina = new ArrayList<Disciplina>();
		for (int contador = 0; contador <= 4; contador++) {
			listDisciplina.add(new Disciplina("disciplina" + contador));
		}

		List<Avaliação> listAvaliacao = new ArrayList<Avaliação>();
		float[] notas = { 4, 5, 6, 7 };

		for (Aluno aluno : listAlunos) {
			for (Disciplina disciplina : listDisciplina) {
				Arrays.parallelSort(notas);
				for (int contNota = 0; contNota <= 3; contNota++) {
					float nota = notas[contNota];
					listAvaliacao.add(new Avaliação(aluno, disciplina, nota));
				}
			}
		}
		
		for(Avaliação listAvaliacaoRepo : listAvaliacao) {
			repositorioAvaliacao.adicionar(listAvaliacaoRepo);
		}
		List<Aluno> listAlunosAprovados = new ArrayList<Aluno>();
		for(Disciplina list : listDisciplina) {
			Aluno aluAprov = repositorioAvaliacao.obterAprovados(list);
			listAlunosAprovados.add(aluAprov);
			
		}
		for(Aluno lsApro : listAlunosAprovados) {
			System.out.println(lsApro.getNome());
		}
		
	}
}
