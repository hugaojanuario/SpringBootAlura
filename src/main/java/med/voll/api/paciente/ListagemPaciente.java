package med.voll.api.paciente;

import med.voll.api.medico.ListagemMedico;

public record ListagemPaciente(String nome, String email, String cpf) {

    public ListagemPaciente(Paciente paciente){
        this(paciente.getNome(), paciente.getEmail(), paciente.getCpf());
    }
}
