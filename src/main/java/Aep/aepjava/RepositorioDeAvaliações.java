package Aep.aepjava;

import java.util.ArrayList;

public class RepositorioDeAvaliações {
	private ArrayList<Avaliação> avaliações = new ArrayList<Avaliação>();

	public void adicionar(Avaliação avaliação) {
		this.avaliações.add(avaliação);
	}

	public Aluno[] obterAprovados(Disciplina disciplina) {
		ArrayList<Aluno> alunosAprovado = new ArrayList<Aluno>();
		
		Aluno[] alunosAprovados = new Aluno[1];
		
		
		
		for (Avaliação avaliação : avaliações) {
			Disciplina disciplinaNome = avaliação.getDisciplina();
			if (disciplinaNome == disciplina) {
				// Pega dados da avaliação atual e do aluno da mesma.
				Aluno aluno = avaliação.getAluno();
				int raAluno = aluno.getRA();
				float notaTotal = avaliação.getNota();

				// percorre as proximas avaliações comparando se a disciplina é a mesma;
				for (Avaliação avaliaçãoSeguinte : avaliações) {
					Disciplina disciplinaNomeSeguinte = avaliaçãoSeguinte.getDisciplina();
					if (disciplinaNomeSeguinte == disciplina) {
						if (avaliaçãoSeguinte.getAluno().getRA() == raAluno) { // se o aluno da avaliaçãoSeguinte for
																				// igual ao aluno da avaliação...
							notaTotal += avaliaçãoSeguinte.getNota(); // atribui a nota da avaliação seguinte no total
						}
					}
				}
				float mediaNota = notaTotal / 4;
				if (mediaNota > 60) {
					alunosAprovados[0] = aluno;
				}
			}
		}

		return alunosAprovados;
	}
}
