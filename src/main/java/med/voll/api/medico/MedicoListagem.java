package med.voll.api.medico;

import med.voll.api.enums.Especialidade;

public record MedicoListagem(Long id, String nome, String email, String crm, Especialidade especialidade) {

    public MedicoListagem(Medico medico){
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());

    }
}
