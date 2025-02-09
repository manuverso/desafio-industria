# Desafio Técnico - Iniflex

## Descrição

Este é um projeto em Java que visa simular o gerenciamento de uma lista de funcionários de uma indústria. O objetivo é realizar diversas operações em uma lista de objetos da classe `Funcionário`, utilizando conceitos de herança, manipulação de dados e formatação.

## Requisitos

### 1. Classe Pessoa
- **Atributos**:
  - `nome`: Nome da pessoa (String)
  - `dataNascimento`: Data de nascimento da pessoa (LocalDate)

### 2. Classe Funcionário (Extende Pessoa)
- **Atributos**:
  - `salario`: Salário do funcionário (BigDecimal)
  - `funcao`: Função do funcionário (String)

### 3. Classe Principal
A classe principal deve realizar as seguintes ações:

#### 3.1 - Inserir todos os funcionários, mantendo a ordem e as informações da tabela fornecida.

#### 3.2 - Remover o funcionário "João" da lista.

#### 3.3 - Imprimir todos os funcionários com todas as informações:
- A data deve ser exibida no formato `dd/mm/aaaa`.
- Os valores numéricos (salário) devem ser formatados com separador de milhar como ponto e decimal como vírgula.

#### 3.4 - Atualizar os salários dos funcionários com um aumento de 10%.

#### 3.5 - Agrupar os funcionários por função em um mapa, onde a chave é a "função" e o valor é a "lista de funcionários".

#### 3.6 - Imprimir os funcionários agrupados por função.

#### 3.8 - Imprimir os funcionários que fazem aniversário no mês de Outubro (10) ou Dezembro (12).

#### 3.9 - Imprimir o funcionário com a maior idade, exibindo nome e idade.

#### 3.10 - Imprimir a lista de funcionários por ordem alfabética.

#### 3.11 - Imprimir o total dos salários de todos os funcionários.

#### 3.12 - Imprimir quantos salários mínimos cada funcionário ganha (considerando o salário mínimo como R$1212,00).

## Como Rodar o Projeto

1. Clone o repositório:
- Você pode clonar este repositório usando HTTPS:

[Clone este repositório](https://github.com/manuverso/desafio-industria.git)

- Ou, se preferir, usando SSH:

 SSH: git@github.com:manuverso/desafio-industria.git

2. Abra o projeto em sua IDE favorita (ex: Eclipse, IntelliJ, NetBeans).

3. Compile e execute a classe Principal.java para rodar o programa.

4. Certifique-se de que as dependências necessárias, como as bibliotecas Java para LocalDate, BigDecimal e formatação, estão corretamente configuradas.
