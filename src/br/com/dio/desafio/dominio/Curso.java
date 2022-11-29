package br.com.dio.desafio.dominio;

public class Curso extends Conteudo{
    
    private int cargaHoraria;
    
    public Curso(String tituto, String descricao, int cargaHoraria) {
        super(tituto, descricao);
        this.cargaHoraria = cargaHoraria;
    }


    public int getCargaHoraria() {
        return cargaHoraria;
    }
    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }
    
    @Override
    public double calcularXp() {
        return XP_PADRAO * cargaHoraria;
    }

    @Override
    public String toString() {
        return "\n\t\tCurso - Título: " + super.getTitulo() + 
            "\n\t\tDescrição: " + super.getDescricao() + 
            "\n\t\tCarga horária: " + cargaHoraria + "horas\n";
    }
    
}
