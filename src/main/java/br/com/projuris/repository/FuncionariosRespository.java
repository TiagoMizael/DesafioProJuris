package br.com.projuris.repository;

import br.com.projuris.objects.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionariosRespository extends JpaRepository <Funcionario, Long> {

    Funcionario findById(long id);
}
