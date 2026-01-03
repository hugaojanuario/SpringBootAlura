package med.voll.api.medico;

import med.voll.api.enums.Especialidade;

public class ListagemMedico{

    private Long id ;
    private String nome ;
    private String email ;
    private String crm ;
    private Especialidade especialidade ;


    public ListagemMedico(Medico medico) {
        this.id = medico.getId();
        this.nome = medico.getNome();
        this.email = medico.getEmail();
        this.crm = medico.getCrm();
        this.especialidade = medico.getEspecialidade();
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

    public String getCrm() {
        return crm;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }
}
