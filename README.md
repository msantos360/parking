Project: Parking
Programador do sistema: Michael Santos

-----------
**Project description**
O projeto Parking é um sistema que, controla a entrada e saída de veículos e calcula a permanência pelo valor da hora do estacionamento.
A API se comunica através do protocolo http transmitindo e recebendo JSON, se tornando desacoplada do Front End, permitindo utilizar qualquer outra tecnologia no Front para se comunicar, seja ela React, Angular ou Vue por exemplo.

**Infraestrutura do projeto**
Spring Boot - Seguindo o modelo Rest;
Spring Data;
Spring Security com autenticação via token JWT;
Monitoramento da API com Spring Boot Actuator;
Documentação da API com Swagger;
Controle de dependências - Maven
Banco de dados - MySql e Framework Hibernate;

**Funcionalidades do sistema**
Autenticação de logins de usuários;
Cadastro, consulta, atualização e exclusão de:
Clientes, veículos, tabela de preços e estacionamentos
Permite o controle da entrada e saída dos veículos, calculando a permanência e total a pagar*

*Total a pagar é calculado pela permanência, tipo de veículo (Moto, Carro, SUV...) e pela tabela de preços de cada estacionamento (valor da primeira hora, das demais, diárias...).
