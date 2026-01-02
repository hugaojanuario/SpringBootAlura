package med.voll.api.medico;

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

}
