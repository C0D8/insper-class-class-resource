package insper.classroom.aula;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Entity
@Table(name = "aula")
@EqualsAndHashCode(of = "id")
@Builder @Getter @Setter @Accessors(chain = true, fluent = true)
@NoArgsConstructor @AllArgsConstructor
public class AulaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_aula")
    private String id;

    @Column(name = "tx_name")
    private String nome;

    @Column(name = "tx_description")
    private String descricao;

    @Column(name = "dt_date")
    private String data;

    @Column(name = "duration")
    private Integer duracao;

    @Column(name = "id_professor")
    private String id_professor;




    public AulaModel(Aula o) {
        this.id = o.id();
        this.nome = o.nome();
        this.descricao = o.descricao();
        this.data = o.data();
        this.duracao = o.duracao();
        this.id_professor = o.id_professor();

    }

    public Aula to() {
        return Aula.builder()
                .id(id)
                .nome(nome)
                .descricao(descricao)
                .data(data)
                .duracao(duracao)
                .id_professor(id_professor)
                .build();
    }

}