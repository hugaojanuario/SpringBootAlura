package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;

    @PostMapping
    @Transactional
    public void cadastrarMedico(@RequestBody @Valid Medico medico ){
        medicoRepository.save(medico);

    }

    @GetMapping
    public Page<ListagemMedico> listarMedicos(@PageableDefault(size = 10, sort = {"id"}) Pageable paginacao){
        return medicoRepository.findAll(paginacao).map(ListagemMedico::new);
    }

    @PutMapping
    @Transactional
    public void atualizarMedico(@RequestBody @Valid AtualizarMedico medicoDados ){
        var medico = medicoRepository.getReferenceById(medicoDados.getId());
        medico.ataulizarInformacoes(medicoDados);
    }

}
