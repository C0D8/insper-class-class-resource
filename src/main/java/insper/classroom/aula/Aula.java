package insper.classroom.aula;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter @Accessors(chain = true, fluent = true)
@NoArgsConstructor @AllArgsConstructor
@Builder
public class Aula {
    private Integer id;
    private Date data;
    private Integer duracao;
    private String descricao;
    private String materia;
    private Integer idProfessor;
    
}
