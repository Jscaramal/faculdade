package Aep.aepjava;

public class Avaliação {
	private float nota;
	private Aluno aluno;
	private Disciplina disciplina;
	
	public Avaliação (Aluno aluno, Disciplina disciplina, float nota) {
		this.aluno = aluno;
		this.disciplina = disciplina;
		if(nota < 0 || nota > 10) {
			throw new Error("O valor da nota tem que estar entre 0 e 10");
		}else {
			this.nota = nota;
		}
	}
	
	public float getNota() {
		return nota;
	}
	public Disciplina getDisciplina() {
		return disciplina;
	}
	public Aluno getAluno() {
		return aluno;
	}
	
	
}
