package br.com.desafioprojedata.desafio.industria.repository;


import br.com.desafioprojedata.desafio.industria.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    // Buscar funcionário pelo nome (case-insensitive)
    Optional<Funcionario> findByNomeIgnoreCase(String nome);

    // Listar todos os funcionários em ordem alfabética (por nome)
    List<Funcionario> findAllByOrderByNomeAsc();

    // Buscar funcionários por função
    List<Funcionario> findByFuncao(String funcao);

    // Buscar funcionários com aniversário no mês especificado
    @Query("SELECT f FROM Funcionario f WHERE MONTH(f.dataNascimento) = :mes")
    List<Funcionario> findByAniversarioNoMes(int mes);

    // Buscar o funcionário mais velho
    @Query("SELECT f FROM Funcionario f ORDER BY f.dataNascimento ASC")
    Optional<Funcionario> findFuncionarioMaisVelho();

    // Obter a soma total dos salários
    @Query("SELECT SUM(f.salario) FROM Funcionario f")
    Optional<BigDecimal> findTotalSalarios();
}
