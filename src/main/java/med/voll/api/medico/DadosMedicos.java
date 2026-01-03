package med.voll.api.medico;

import med.voll.api.endereco.DadosEndereco;
import med.voll.api.endereco.Endereco;
import med.voll.api.enums.Especialidade;

public record DadosMedicos(String nome, String email, String crm, String telefone, boolean status, Especialidade especialidade, Endereco endereco) {

    public DadosMedicos (Medico medico){
        this(medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getTelefone(), medico.isStatus(),medico.getEspecialidade(), medico.getEndereco());
    }
}
