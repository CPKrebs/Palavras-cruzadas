# Palavras-cruzadas

Projeto de jogo de palavras cruzadas utilizando o Android Studio.

Resolva a cruzadinha o mais rápido possivel, utilizando as letras em destaque para ganhar a pontuação máxima (1000 pontos). Temas variados, contendo 12 fases.

Público alvo: crianças em fase de alfabetização, até 9 anos. 



## Componentes

A seguir um resumo das Classes e Layout mais importantes para o projeto.

### Layout

* activity_main: Primeira layout visível para o usuário, permite o login.
* activity_tela__jogo: Exibe uma matriz 9x6 referente ao campo da fase, e as 12 letras que podem ser usadas na fase. Alem de um cronometro. 
* activity_tela__menu: Exibe os níveis disponíveis, o menu de opções, e a pontuação de todos os usuários cadastrados.
* activity_tela__cadastro: Responsável por realizar o cadastro de um novo usuário.

### Classes Java

* MainActivity: Responsável por realizar o login.
* Tela_Menu: Permite que o usuário escolha a fase, verifica através da cor do level qual pontuação  atingiu, e exclua a sua conta. Também é responsável por iniciar a música.
* Tela_Jogo: Gerencia quais palavras serão usadas na fase, calcula a pontuação obtida e atualiza o banco de dados.
* Tela_Cadastro: Permite que inclua um novo usuário no banco de dados, verificando se as informações estão certas e que não existam usuários repetidos.
* BD_Class: Descreve toda a extrutura do banco de dados existente, e oferece funções de suporte para outras classes, como: busca, inserção  e exclusão de dados.
