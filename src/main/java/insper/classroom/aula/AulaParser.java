package insper.classroom.aula;

// import org.hibernate.mapping.List;

public class AulaParser {

    public static Aula to(CreateAulaIn in) {
        return Aula.builder()
                .id_professor(in.id_professor())
                .nome(in.nome())
                .descricao(in.descricao())
                .data(in.data())
                .duracao(in.duracao())
                .departamento(in.departamento())
                .build();
    }
    
    public static CreateAulaOut to(Aula aula) {
        return CreateAulaOut.builder()
                .id(aula.id())
                .build();

    }

   



}