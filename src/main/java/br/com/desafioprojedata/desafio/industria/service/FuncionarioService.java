package br.com.desafioprojedata.desafio.industria.service;

import br.com.desafioprojedata.desafio.industria.model.Funcionario;
import br.com.desafioprojedata.desafio.industria.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    // 3.1 - Inicializar Funcionários
    public void inicializarFuncionarios() {
        if (funcionarioRepository.count() == 0) {
            List<Funcionario> funcionarios = List.of(
                    new Funcionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"), "Operador"),
                    new Funcionario("João", LocalDate.of(1990, 5, 12), new BigDecimal("2284.38"), "Operador"),
                    new Funcionario("Caio", LocalDate.of(1961, 5, 2), new BigDecimal("9836.14"), "Coordenador"),
                    new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"), "Diretor"),
                    new Funcionario("Alice", LocalDate.of(1995, 1, 5), new BigDecimal("2234.68"), "Recepcionista"),
                    new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"), "Operador"),
                    new Funcionario("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal("4071.84"), "Contador"),
                    new Funcionario("Laura", LocalDate.of(1994, 7, 8), new BigDecimal("3017.45"), "Gerente"),
                    new Funcionario("Heloísa", LocalDate.of(2003, 5, 24), new BigDecimal("1606.85"), "Eletricista"),
                    new Funcionario("Helena", LocalDate.of(1996, 9, 2), new BigDecimal("2799.93"), "Gerente")
            );
            funcionarioRepository.saveAll(funcionarios);
        }
    }

    // 3.2 - Remover funcionário João
    public void removerFuncionarioPorNome(String nome) {
        funcionarioRepository.findByNomeIgnoreCase(nome).ifPresent(funcionarioRepository::delete);
    }

    // 3.3 - Imprimir todos os funcionários com formato correto
    public void imprimirTodosFuncionarios() {
        funcionarioRepository.findAll().forEach(this::imprimirFuncionario);
    }

    // 3.4 - Aplicar 10% de aumento nos salários
    public void aplicarAumentoSalario(BigDecimal percentual) {
        funcionarioRepository.findAll().forEach(f -> {
            f.setSalario(f.getSalario().multiply(BigDecimal.ONE.add(percentual)));
            funcionarioRepository.save(f);
        });
    }

    // 3.5 - Agrupar os funcionários por função
    public Map<String, List<Funcionario>> agruparFuncionariosPorFuncao() {
        return funcionarioRepository.findAll().stream()
                .collect(Collectors.groupingBy(Funcionario::getFuncao));
    }

    // 3.6 - Imprimir funcionários agrupados por função
    public void imprimirFuncionariosAgrupadosPorFuncao() {
        agruparFuncionariosPorFuncao().forEach((funcao, lista) -> {
            System.out.println("\nFunção: " + funcao);
            lista.forEach(this::imprimirFuncionario);
        });
    }

    // 3.8 - Imprimir aniversariantes dos meses 10 e 12
    public void imprimirAniversariantes(int... meses) {
        System.out.println("\nAniversariantes:");
        funcionarioRepository.findAll().stream()
                .filter(f -> Arrays.stream(meses).anyMatch(m -> f.getDataNascimento().getMonthValue() == m))
                .forEach(this::imprimirFuncionario);
    }

    // 3.9 - Imprimir o funcionário mais velho
    public void imprimirFuncionarioMaisVelho() {
        funcionarioRepository.findAll().stream()
                .min(Comparator.comparing(Funcionario::getDataNascimento))
                .ifPresent(f -> System.out.println("\nFuncionário mais velho: " + f.getNome() + ", Idade: " +
                        Period.between(f.getDataNascimento(), LocalDate.now()).getYears() + " anos"));
    }

    // 3.10 - Imprimir funcionários por ordem alfabética
    public void imprimirFuncionariosOrdemAlfabetica() {
        funcionarioRepository.findAllByOrderByNomeAsc().forEach(this::imprimirFuncionario);
    }

    // 3.11 - Imprimir total dos salários
    public void imprimirTotalSalarios() {
        BigDecimal total = funcionarioRepository.findAll().stream()
                .map(Funcionario::getSalario)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("\nTotal dos salários: " + formatarMonetario(total));
    }

    // 3.12 - Imprimir quantos salários mínimos cada funcionário ganha
    public void imprimirSalariosMinimos(BigDecimal salarioMinimo) {
        funcionarioRepository.findAll().forEach(f -> System.out.println(f.getNome() + " - " +
                f.getSalario().divide(salarioMinimo, 2, BigDecimal.ROUND_HALF_UP) + " salários mínimos"));
    }

    private void imprimirFuncionario(Funcionario funcionario) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("Nome: " + funcionario.getNome() + ", Data de Nascimento: " + funcionario.getDataNascimento().format(formatter) +
                ", Salário: " + formatarMonetario(funcionario.getSalario()) + ", Função: " + funcionario.getFuncao());
    }

    private String formatarMonetario(BigDecimal valor) {
        NumberFormat nf = NumberFormat.getNumberInstance(new Locale("pt", "BR"));
        nf.setMinimumFractionDigits(2);
        return nf.format(valor);
    }
}

