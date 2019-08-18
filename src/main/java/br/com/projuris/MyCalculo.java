package br.com.projuris;

import br.com.projuris.interfaces.Calculo;
import br.com.projuris.objects.CustoCargo;
import br.com.projuris.objects.CustoDepartamento;
import br.com.projuris.objects.Funcionario;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyCalculo implements Calculo {
    @Override
    public List<CustoCargo> custoPorCargo(List<Funcionario> funcionarios) {
        try {
            List<CustoCargo> custoCargos = new ArrayList<>();
            boolean first = true;
            for (Funcionario funcionario : funcionarios) {
                boolean achou = false;

                //Primeiro Funcionário da lista, cria um CustoCargo
                if (first) {
                    CustoCargo custo = new CustoCargo();
                    custo.setCargo(funcionario.getCargo());
                    custo.setCusto(funcionario.getSalario());
                    custoCargos.add(custo);
                } else {
                    //Verifica se o cargo do funcionário já está registrado no CustoCargo
                    //Se tiver, adiciona o custo ao custo total do cargo
                    if (funcionario.getCargo() != null) {
                        for (ListIterator<CustoCargo> it = custoCargos.listIterator(); it.hasNext(); ) {
                            CustoCargo cargo = it.next();
                            if (funcionario.getCargo().equalsIgnoreCase(cargo.getCargo())) {

                                BigDecimal custoTot = cargo.getCusto().add(funcionario.getSalario());
                                cargo.setCusto(custoTot);
                                achou = true;
                            }
                        }
                    }
                    if (funcionario.getCargo() != null && !achou) {
                        //Se não, cria um CustoCargo e seta os valores
                        CustoCargo custo = new CustoCargo();
                        custo.setCargo(funcionario.getCargo());
                        custo.setCusto(funcionario.getSalario());
                        custoCargos.add(custo);
                    } else if(funcionario.getCargo() == null){
                        throw new Exception("Funcionário do ID: " + funcionario.getId() + " não possui cargo");
                    }

                }
                first = false;
            }
            return custoCargos;
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

    public CustoCargo filterCustoCargo(List<CustoCargo> custoCargos, String filter) {
        try {
            for (CustoCargo custo : custoCargos) {
                if (filter.equalsIgnoreCase(custo.getCargo())) {
                    return custo;
                }
            }
            throw new Exception("Não foi possível encontrar os custos de Cargos com o filtro" + filter);
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

    @Override
    public List<CustoDepartamento> custoPorDepartamento(List<Funcionario> funcionarios) {
        try {
            List<CustoDepartamento> custoDepartamentos = new ArrayList<>();
            boolean first = true;
            for (Funcionario funcionario : funcionarios) {
                boolean achou = false;

                //Primeiro Funcionário da lista, cria um CustoDepartamento
                if (first) {
                    CustoDepartamento custo = new CustoDepartamento();
                    custo.setDepartamento(funcionario.getDepartamento());
                    custo.setCusto(funcionario.getSalario());
                    custoDepartamentos.add(custo);
                } else {
                    if (funcionario.getDepartamento() != null) {
                        for (ListIterator<CustoDepartamento> it = custoDepartamentos.listIterator(); it.hasNext(); ) {
                            //Verifica se o departamento do funcionário já está registrado no CustoDepartamento
                            //Se tiver, adiciona o custo ao custo total do departamento

                            CustoDepartamento departamento = it.next();
                            if (funcionario.getDepartamento() != null &&
                                    funcionario.getDepartamento().equalsIgnoreCase(departamento.getDepartamento())) {

                                BigDecimal custoTot = departamento.getCusto().add(funcionario.getSalario());
                                departamento.setCusto(custoTot);
                                achou = true;
                            }
                        }
                    }
                    if (funcionario.getDepartamento() != null && !achou) {
                        //Se não, cria um CustoDepartamento e seta os valores
                        CustoDepartamento custo = new CustoDepartamento();
                        custo.setDepartamento(funcionario.getDepartamento());
                        custo.setCusto(funcionario.getSalario());
                        custoDepartamentos.add(custo);
                    }else if(funcionario.getDepartamento() == null){
                        throw new Exception("Funcionario com ID: "+ funcionario.getId()+" não possui departamento");
                    }
                }
                first = false;
            }
            return custoDepartamentos;
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

    public CustoDepartamento filterCustoDepartamento(List<CustoDepartamento> custoDepartamentos, String filter) {
        try {
            for (CustoDepartamento custo : custoDepartamentos) {
                if (filter.equalsIgnoreCase(custo.getDepartamento())) {
                    return custo;
                }
            }
            throw new Exception("Não foi possível encontrar os custos de dapartamento com o filtro" + filter);
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }
}
