package br.com.schumaker.http2client.servico;

import br.com.schumaker.http2client.modelo.Aluno;
import br.com.schumaker.http2client.modelo.Curso;
import br.com.schumaker.http2client.modelo.Turma;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author hudson schumaker
 */
public class TurmaServico {

    AlunoServico alunoServico = new AlunoServico();
    CursoServico cursoServico = new CursoServico();

    public List<Turma> listar() {
        List<Curso> cursos = cursoServico.listar();
        List<Aluno> alunos = alunoServico.listar();
        return List.of(
                new Turma(LocalDate.of(2019, 4, 3), LocalDate.of(2019, 4, 5), cursos.get(0), alunos.get(0), alunos.get(1)),
                new Turma(LocalDate.of(2019, 4, 3), LocalDate.of(2019, 4, 13), cursos.get(1), alunos.get(0)),
                new Turma(LocalDate.of(2019, 4, 17), LocalDate.of(2019, 4, 19), cursos.get(2), alunos.get(1)));
    }
}
