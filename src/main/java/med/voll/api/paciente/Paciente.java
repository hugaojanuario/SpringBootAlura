package med.voll.api.paciente;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pacientes")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Paciente {

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

    @NotNull
    @Size(min = 11)
    private String cpf;

    public Paciente ( DadosPaciente paciente){
        this.id = paciente.id();
        this.nome = paciente.nome();
        this.email = paciente.email();
        this.telefone = paciente.telefone();
        this.cpf = paciente.cpf();
    }

    public void atualizarInformacoesPaciente( AtualizarPaciente atualizarPaciente){
        if(atualizarPaciente.nome() != null){
            this.nome = atualizarPaciente.nome();
        }

        if(atualizarPaciente.email() != null){
            this.email = atualizarPaciente.email();
        }

        if (atualizarPaciente.cpf() != null){
            this.cpf = atualizarPaciente.cpf();
        }

        if(atualizarPaciente.telefone() != null){
            this.telefone = atualizarPaciente.telefone();
        }
    }

}
