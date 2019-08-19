package br.com.projuris.rest;

import br.com.projuris.objects.Funcionario;
import br.com.projuris.repository.FuncionariosRespository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/")
public class RestFuncionarios {

    public static final Logger logger = LoggerFactory.getLogger(RestFuncionarios.class);

    @Autowired
    FuncionariosRespository funcionariosRespository;

    @RequestMapping(value = "/funcionarios", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Funcionario>> listaFuncionario() {
        List<Funcionario> funcionarios = funcionariosRespository.findAll();
        return new ResponseEntity<>(funcionarios, HttpStatus.OK);
    }

    @RequestMapping(value = "/novoFuncionario", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Funcionario> novoFuncionario(@RequestBody Funcionario funcionario) {
        Funcionario cadastrado = funcionariosRespository.save(funcionario);
        return new ResponseEntity<>(cadastrado, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/deletaFuncionario/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deletaFuncionario(@PathVariable("id") long id) {
        Funcionario funcionario = funcionariosRespository.findById(id);
        if (funcionario == null) {
            logger.error("Não foi encontrado usuário com ID: ", id);
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        funcionariosRespository.delete(funcionario);
        return new ResponseEntity<Funcionario>(HttpStatus.NO_CONTENT);

    }

    @RequestMapping(value = "/atualizaFuncionario/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> atualizaFuncionario(@PathVariable("id") long id, @RequestBody Funcionario atualiza) {
        Funcionario funcionario = funcionariosRespository.findById(id);

        if (funcionario == null) {
            logger.error("Funcionário com o ID: " + id + "não encontrado");
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        funcionario.setCargo(atualiza.getCargo());
        funcionario.setDepartamento(atualiza.getDepartamento());
        funcionario.setSalario(atualiza.getSalario());

        funcionariosRespository.save(funcionario);
        return new ResponseEntity<Funcionario>(HttpStatus.OK);
    }
}
