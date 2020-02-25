package br.com.schumaker.http2client;

import br.com.schumaker.http2client.modelo.Turma;
import br.com.schumaker.http2client.servico.AlunoServico;
import br.com.schumaker.http2client.servico.LivroServico;
import br.com.schumaker.http2client.servico.TurmaServico;
import java.time.LocalDate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Principal {

    public static void main(String... strings) {

        var alunoServico = new AlunoServico();
        var turmaServico = new TurmaServico();
        var livroServico = new LivroServico();

        livroServico.listar();

        var alunos = alunoServico.listar().stream()
                .flatMap(a -> Stream.ofNullable(a.getNome()))
                .map(s -> s.toUpperCase())
                .collect(Collectors.toList());

        System.out.println("Lista de alunos matriculados na escola: " + alunos);

        var turmasPorCurso = turmaServico.listar().stream()
                .collect(Collectors.groupingBy(Turma::getCurso,
                        Collectors.filtering(a -> a.getInicio().equals(LocalDate.of(2019, 4, 3)), Collectors.toList())));

        System.out.println("Rela��o de turmas por curso: " + turmasPorCurso);

        var aluno = alunoServico.listarPorCpf(4915774030L);
        aluno.ifPresentOrElse(System.out::println,
                () -> System.out.println("N�o h� aluno cadastrado para este cpf"));

        var alunoRecuperado = alunoServico.listarPorCpf(43647814016L)
                .or(() -> alunoServico.listarPorCpf(49157745030L))
                .or(() -> alunoServico.listarPorCpf(82757618083L))
                .or(() -> alunoServico.listarPorCpf(41189989042L));

        alunoRecuperado.ifPresentOrElse(System.out::println,
                () -> System.out.println("N�o h� aluno cadastrado para este cpf"));
    }
}
