package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.paciente.AtualizarPaciente;
import med.voll.api.paciente.DadosPaciente;
import med.voll.api.paciente.ListagemPaciente;
import med.voll.api.paciente.Paciente;
import med.voll.api.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository pacienteRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrarPacientes(@RequestBody @Valid DadosPaciente dadosPaciente, UriComponentsBuilder uriBuilder){
        var paciente = new Paciente(dadosPaciente);
        pacienteRepository.save(paciente);
        var uri = uriBuilder.path("/pacientes/{id}").buildAndExpand(paciente.getId()).toUri();
        return  ResponseEntity.created(uri).body(new DadosPaciente(paciente));

    }

    @GetMapping
    public ResponseEntity <Page<ListagemPaciente>> listarPacientes(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
        var pagina = pacienteRepository.findAll(paginacao).map(ListagemPaciente::new);

        return ResponseEntity.ok(pagina);
    }

    @GetMapping("/{id}")
    public ResponseEntity listarPAcientePorId(@PathVariable Long id){
        var paciente = pacienteRepository.findById(id);
        return ResponseEntity.ok(paciente);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizarDadosPaciente(@RequestBody @Valid AtualizarPaciente atualizarPaciente){
        var paciente = pacienteRepository.getReferenceById(atualizarPaciente.id());

        return ResponseEntity.ok(new DadosPaciente(paciente));
    }


}
