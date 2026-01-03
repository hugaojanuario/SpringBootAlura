package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.medico.*;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.transaction.Transactional;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrarMedico(@RequestBody @Valid DadosMedicos dados, UriComponentsBuilder uriBuilder){
        var medico = new Medico(dados);
        medicoRepository.save(medico);

        var uri = uriBuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();

        return ResponseEntity.created(uri).body(new DetalhamentoDadosAtualizadosMedico(medico));
    }

    @GetMapping
    public ResponseEntity<Page<ListagemMedico>>listarMedicos(@PageableDefault(size = 10, sort = {"id"}) Pageable paginacao){
        var page = medicoRepository.findAllByStatusTrue(paginacao).map(ListagemMedico::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizarMedico(@RequestBody @Valid AtualizarMedico medicoDados ){
        var medico = medicoRepository.getReferenceById(medicoDados.getId());
        medico.ataulizarInformacoes(medicoDados);

        return ResponseEntity.ok(new DetalhamentoDadosAtualizadosMedico(medico));
    }

//    @DeleteMapping("/{id}")
//    public void deletarMedico(@PathVariable Long id){
//        medicoRepository.deleteById(id);
//    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity inativarMedico(@PathVariable Long id){
        var medico = medicoRepository.getReferenceById(id);
        medico.excluir();
        return ResponseEntity.noContent().build();
    }

}
