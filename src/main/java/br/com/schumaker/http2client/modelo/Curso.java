package br.com.schumaker.http2client.modelo;

/**
 *
 * @author hudson schumaker
 */
public class Curso {

    public String nome;
    public String ementa;
    public String cargaHoraria;
    public Livro livro;

    public Curso(String nome, String ementa, String cargaHoraria, Livro livro) {
        this.nome = nome;
        this.ementa = ementa;
        this.cargaHoraria = cargaHoraria;
        this.livro = livro;
    }

    @Override
    public String toString() {
        return nome + " ";
    }
}
