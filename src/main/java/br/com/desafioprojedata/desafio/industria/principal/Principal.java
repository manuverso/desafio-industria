package br.com.desafioprojedata.desafio.industria.principal;

import br.com.desafioprojedata.desafio.industria.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class Principal {
    @Autowired
    private FuncionarioService funcionarioService;

    public void rodarOperacoes() {
        funcionarioService.inicializarFuncionarios();


        funcionarioService.removerFuncionarioPorNome("João");


        System.out.println("Todos os funcionários:");
        funcionarioService.imprimirTodosFuncionarios();


        funcionarioService.aplicarAumentoSalario(new BigDecimal("0.10"));


        System.out.println("\nFuncionários agrupados por função:");
        funcionarioService.imprimirFuncionariosAgrupadosPorFuncao();


        funcionarioService.imprimirAniversariantes(10, 12);


        funcionarioService.imprimirFuncionarioMaisVelho();


        System.out.println("\nFuncionários em ordem alfabética:");
        funcionarioService.imprimirFuncionariosOrdemAlfabetica();


        funcionarioService.imprimirTotalSalarios();


        funcionarioService.imprimirSalariosMinimos(new BigDecimal("1212.00"));
    }
}
