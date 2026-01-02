package med.voll.api.endereco;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {


    @NotBlank
    private String logradouro;

    @NotBlank
    private String bairro;

    @NotBlank
    @Pattern(regexp = "\\d{8}")
    private String cep;

    private String numero;
    private String complemento;

    @NotBlank
    private String cidade;

    @NotBlank
    private String uf;

    public void atualizarInformacoesEndereco(Endereco enderecoDados) {
        if (enderecoDados.getUf() != null){
            this.uf = enderecoDados.getUf();
        }

        if(enderecoDados.getCep() != null){
            this.cep = enderecoDados.getCep();
        }

        if (enderecoDados.bairro != null) {
            this.bairro = enderecoDados.getBairro();
        }

        if (enderecoDados.getCidade() != null){
            this.cidade = enderecoDados.getCidade();
        }

        if (enderecoDados.getNumero() != null){
            this.numero = enderecoDados.getNumero();
        }

        if(enderecoDados.getLogradouro() != null){
            this.logradouro = enderecoDados.getLogradouro();
        }

        if (enderecoDados.getComplemento() != null){
            this.complemento = enderecoDados.getComplemento();
        }
    }
}
