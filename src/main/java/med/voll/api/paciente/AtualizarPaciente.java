package med.voll.api.paciente;

import lombok.Getter;


public record AtualizarPaciente(Long id, String nome, String email, String telefone, String cpf) {

    public AtualizarPaciente(Paciente paciente){
        this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getTelefone(), paciente.getCpf());
    }
}
