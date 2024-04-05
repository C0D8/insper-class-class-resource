package insper.classroom.aula;

import insper.classroom.aula.CreateAulaIn;

public class AulaParser {

    public static Aula to(CreateAulaIn in) {
        return Aula.builder()
                .id_professor(in.id_professor())
                .nome(in.nome())
                .descricao(in.descricao())
                .data(in.data())
                .duracao(in.duracao())
                .build();
    }
    
    public static CreateAulaOut to(Aula aula) {
        return CreateAulaOut.builder()
                .id(aula.id())
                .id_professor(aula.id_professor())
                .nome(aula.nome())
                .descricao(aula.descricao())
                .data(aula.data())
                .duracao(aula.duracao())
                .build();

    }

}