package br.com.projuris.rest;

import br.com.projuris.MyCalculo;
import br.com.projuris.objects.CustoCargo;
import br.com.projuris.objects.CustoDepartamento;
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
public class RestCalculo {
    public static final Logger logger = LoggerFactory.getLogger(RestCalculo.class);

    @Autowired
    FuncionariosRespository funcionariosRespository;

    @RequestMapping(value = "/calculaCargos", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CustoCargo>> calculaCargos() {

        List<Funcionario> funcionarios = funcionariosRespository.findAll();
        MyCalculo myCalculo = new MyCalculo();

        List<CustoCargo> custoCargo = myCalculo.custoPorCargo(funcionarios);
        if (custoCargo == null) {
            logger.error("Não foram encontradas Despesas por Cargo");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(custoCargo, HttpStatus.OK);
        }
    }

    @GetMapping("/calculaCargos/{cargo}")
    public CustoCargo filterCalcularCargo(@PathVariable(value = "cargo") String cargo) {
        try {
            List<Funcionario> funcionarios = funcionariosRespository.findAll();
            MyCalculo myCalculo = new MyCalculo();
            List<CustoCargo> custoCargos = myCalculo.custoPorCargo(funcionarios);
            CustoCargo custo = myCalculo.filterCustoCargo(custoCargos, cargo);
            if (custo != null) {
                return custo;
            }
            throw new Exception("Não foi possível concluir a consulta");
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

    @RequestMapping(value = "/calculaDepartamentos", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CustoDepartamento>> calculaDepartamentos() {

        List<Funcionario> funcionarios = funcionariosRespository.findAll();
        MyCalculo myCalculo = new MyCalculo();

        List<CustoDepartamento> custoDepartamento = myCalculo.custoPorDepartamento(funcionarios);
        if (custoDepartamento == null) {
            logger.error("Não foram encontradas Despesas por Departamento");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<>(custoDepartamento, HttpStatus.OK);
        }
    }

    @GetMapping("/calculaDepartamento/{departamento}")
    public CustoDepartamento filterCalculaDepartamento(@PathVariable(value = "departamento") String departamento) {
        try {
            List<Funcionario> funcionarios = funcionariosRespository.findAll();
            MyCalculo myCalculo = new MyCalculo();
            List<CustoDepartamento> custoDepartamentos = myCalculo.custoPorDepartamento(funcionarios);
            CustoDepartamento custo = myCalculo.filterCustoDepartamento(custoDepartamentos, departamento);
            if (custo != null) {
                return custo;
            }
            throw new Exception("Não foi possível concluir a consulta");
        } catch (Exception e) {
            e.getMessage();

            return null;
        }
    }
}
