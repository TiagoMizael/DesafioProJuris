package br.com.projuris.rest;

import br.com.projuris.objects.Funcionario;
import br.com.projuris.repository.FuncionariosRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/")
public class RestFuncionarios {

    @Autowired
    FuncionariosRespository funcionariosRespository;

    @GetMapping("/funcionarios")
    public List<Funcionario> listaFuncionario(){
        return funcionariosRespository.findAll();
    }

    @GetMapping("/funcionario/{id}")
    public Funcionario funcionarioId(@PathVariable(value = "id")long id){
        return funcionariosRespository.findById(id);
    }

    @PostMapping("/novoFuncionario")
    public Funcionario novoFuncionario(@RequestBody Funcionario funcionario){
        return funcionariosRespository.save(funcionario);
    }

    @DeleteMapping("/deletaFuncionario")
    public void deletaFuncionario (@RequestBody Funcionario funcionario){
        funcionariosRespository.delete(funcionario);
    }

    @PutMapping("/atualizaFuncionario")
    public Funcionario atualizaFuncionario(@RequestBody Funcionario funcionario){
        return funcionariosRespository.save(funcionario);
    }
}
