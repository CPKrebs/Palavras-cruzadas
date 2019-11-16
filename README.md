# Palavras-cruzadas

Projeto de jogo de palavras cruzadas utilizando o Android Studio.
Publico alvo: criançãs em fase de alfabetisação, até 9 anos. 


## Componentes

A seguir um resumo das Classes e Layout mais importantes para o projeto.

### Layout

* activity_main: Primeira layout visível para o usuário, permite o login.
* activity_tela__jogo: Exibe uma matrix 9x6 referente ao campo da fase, e as letas que podem ser usadas na fase. 
* activity_tela__menu: Exibe os níveis disponíveis, e a pontuação de todos os usuários cadastrados.
* activity_tela__cadastro: Responsável por realizar o cadastro de um novo usuário.

### Classes Java

* MainActivity: Responsável por realizar o login.
* Tela_Menu: Permite que o usúario escolha a fase, e exclua a sua conta. 
* Tela_Jogo: Gerencia quais palavras serão usadas na fase, calcula a pontuação obtida e atualiza o banco de dados.
* Tela_Cadastro: Permite que inclua um novo usuário no banco de dados, verificando se as informações estão certas e que não existam usuários repetidos.
* BD_Class: Descreve toda a extrutura do banco de dados existente, e oferece funções de suporte para outras classes, como: busca, inserção  e exclusão de dados.



