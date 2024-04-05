package insper.classroom.aula;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import java.util.Date;

@Getter @Setter @Accessors(chain = true, fluent = true)
@NoArgsConstructor @AllArgsConstructor
@Builder
public class Aula {

    private String id;
    private String id_professor;
    private String nome;
    private String descricao;
    private Date data;
    private String duracao;
    
    
    
}
