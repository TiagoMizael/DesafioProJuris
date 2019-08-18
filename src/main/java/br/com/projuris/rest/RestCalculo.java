package br.com.projuris.rest;

import br.com.projuris.MyCalculo;
import br.com.projuris.objects.CustoCargo;
import br.com.projuris.objects.CustoDepartamento;
import br.com.projuris.objects.Funcionario;
import br.com.projuris.repository.FuncionariosRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/")
public class RestCalculo {

    @Autowired
    FuncionariosRespository funcionariosRespository;

    @GetMapping("/calculaCargos")
    public List<CustoCargo> calculaCargos(){
       try{
        List<Funcionario> funcionarios = funcionariosRespository.findAll();
        MyCalculo myCalculo = new MyCalculo();

        List<CustoCargo> custoCargo = myCalculo.custoPorCargo(funcionarios);
        if(custoCargo != null) {
            return custoCargo;
        }
        throw new Exception("Não foi possível buscar as despesas");
        }catch (Exception e){
           e.getMessage();
           return  null;
       }
    }

    @GetMapping("/calculaCargos/{cargo}")
    public CustoCargo filterCalcularCargo(@PathVariable(value = "cargo")String cargo){
        try {
            List<Funcionario> funcionarios = funcionariosRespository.findAll();
            MyCalculo myCalculo = new MyCalculo();
            List<CustoCargo> custoCargos = myCalculo.custoPorCargo(funcionarios);
            CustoCargo custo = myCalculo.filterCustoCargo(custoCargos, cargo);
            if(custo != null) {
                return custo;
            }
            throw new Exception("Não foi possível concluir a consulta");
        }catch (Exception e){
            e.getMessage();
            return null;
        }
    }

    @GetMapping("/calculaDepartamentos")
    public List<CustoDepartamento> calculaDepartamentos(){
        try{
            List<Funcionario> funcionarios = funcionariosRespository.findAll();
            MyCalculo myCalculo = new MyCalculo();

            List<CustoDepartamento> custoDepartamento = myCalculo.custoPorDepartamento(funcionarios);
            if(custoDepartamento != null) {
                return custoDepartamento;
            }
            throw new Exception("Não foi possível buscar as despesas");
        }catch (Exception e){
            e.getMessage();
            return  null;
        }
    }

    @GetMapping("/calculaDepartamento/{departamento}")
    public CustoDepartamento filterCalculaDepartamento(@PathVariable(value = "departamento")String departamento){
        try {
            List<Funcionario> funcionarios = funcionariosRespository.findAll();
            MyCalculo myCalculo = new MyCalculo();
            List<CustoDepartamento> custoDepartamentos = myCalculo.custoPorDepartamento(funcionarios);
            CustoDepartamento custo = myCalculo.filterCustoDepartamento(custoDepartamentos, departamento);
            if(custo != null) {
                return custo;
            }
            throw new Exception("Não foi possível concluir a consulta");
        }catch (Exception e){
            e.getMessage();

            return null;
        }
    }
}
