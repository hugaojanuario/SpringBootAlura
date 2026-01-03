package med.voll.api.medico;


import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.endereco.Endereco;
import med.voll.api.enums.Especialidade;

@Entity
@Table(name = "medicos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of= "id")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String telefone;

    @NotBlank
    @Pattern(regexp = "\\d{4,6}")
    private String crm;

    @Enumerated(EnumType.STRING)
    @NotNull
    private Especialidade especialidade;

    @Embedded
    @NotNull
    @Valid
    private Endereco endereco;

    private boolean status;

    public Medico(DadosMedicos dadosMedicos) {
        this.nome = dadosMedicos.nome();
        this.email = dadosMedicos.email();
        this.telefone = dadosMedicos.telefone();
        this.crm = dadosMedicos.crm();
        this.especialidade = dadosMedicos.especialidade();
        this.endereco = dadosMedicos.endereco();
        this.status = dadosMedicos.status();
    }

    public void ataulizarInformacoes(AtualizarMedico medicoDados) {
        if(medicoDados.getNome() != null){
            this.nome = medicoDados.getNome();
        }

        if(medicoDados.getEmail() != null){
            this.email = medicoDados.getEmail();
        }

        if(medicoDados.getTelefone() != null){
            this.telefone = medicoDados.getTelefone();
        }

        if (medicoDados.getEndereco() != null){
            this.endereco.atualizarInformacoesEndereco(medicoDados.getEndereco());
        }
    }

    public void excluir() {
        this.status = false;
    }
}
