package br.com.projuris.interfaces;

import br.com.projuris.objects.CustoCargo;
import br.com.projuris.objects.CustoDepartamento;
import br.com.projuris.objects.Funcionario;

import java.util.List;

public interface Calculo {
    public List<CustoCargo> custoPorCargo(List<Funcionario> funcionarios);
    public List<CustoDepartamento> custoPorDepartamento(List<Funcionario> funcionarios);

}
