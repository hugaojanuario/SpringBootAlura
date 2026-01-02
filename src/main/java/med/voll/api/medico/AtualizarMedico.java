package med.voll.api.medico;

import jakarta.validation.constraints.NotNull;
import lombok.NoArgsConstructor;
import med.voll.api.endereco.Endereco;

public class AtualizarMedico {

    @NotNull
    private Long id;

    private String nome;
    private String email;
    private String telefone;
    private Endereco endereco;

    public AtualizarMedico() {
    }

    public AtualizarMedico(Medico medico) {
        this.id = medico.getId();
        this.nome = medico.getNome();
        this.email = medico.getEmail();
        this.telefone = medico.getTelefone();
        this.endereco = medico.getEndereco();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}

