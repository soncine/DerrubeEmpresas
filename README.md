# 🎯 Derrube Empresas — Jogo de Descoberta em Java

[![Java](https://img.shields.io/badge/Java-8%2B-ED8B00?logo=openjdk\&logoColor=white)](https://www.java.com/)
[![Status](https://img.shields.io/badge/Status-%20Concluído-green)]()

## 📋 Visão Geral

O **Derrube Empresas** é um jogo de linha de comando desenvolvido em Java, inspirado em um dos desafios propostos no livro **“Use a Cabeça! Java”**.

O objetivo do jogador é encontrar e eliminar três empresas escondidas em uma grade de **7 × 7**. Cada empresa ocupa três posições consecutivas, distribuídas horizontal ou verticalmente.

Para vencer, o jogador deve informar coordenadas como `a0`, `c4` ou `g6` até atingir todas as posições das empresas.

A dinâmica utiliza uma mecânica de descoberta de território semelhante à encontrada em jogos clássicos como **Campo Minado**: o tabuleiro permanece oculto, e cada tentativa revela se o jogador errou, acertou uma posição ou eliminou completamente uma empresa.

---

## ✨ Funcionalidades

* **Grade oculta de 7 × 7**: o jogo possui 49 posições identificadas pelas letras de `a` a `g` e pelos números de `0` a `6`.
* **Posicionamento aleatório**: as empresas são distribuídas automaticamente em posições diferentes a cada partida.
* **Três empresas para encontrar**: o jogador precisa eliminar `Pets.com`, `eToys.com` e `Go2.com`.
* **Três posições por empresa**: cada empresa ocupa três coordenadas consecutivas.
* **Validação das tentativas**: o programa informa se o palpite foi `errado`, se `acertou` uma posição ou se conseguiu `eliminar` uma empresa.
* **Controle de pontuação**: a quantidade total de palpites é contabilizada durante a partida.
* **Avaliação de desempenho**: ao final, o jogo informa se o jogador concluiu o desafio em até 18 tentativas.
* **Interação pelo terminal**: toda a partida acontece pela linha de comando.

---

## 🕹️ Como Jogar

1. Execute o programa pelo terminal.
2. O jogo esconderá três empresas na grade.
3. Digite uma coordenada formada por uma letra de `a` a `g` e um número de `0` a `6`.
4. Observe o resultado apresentado:

   * `errado`: nenhuma empresa ocupa aquela posição;
   * `acertou`: uma parte de uma empresa foi encontrada;
   * `eliminar`: todas as posições de uma empresa foram atingidas.
5. Continue jogando até eliminar as três empresas.
6. Tente concluir o jogo utilizando o menor número possível de palpites.

### Exemplos de coordenadas

```text
a0
b3
d5
g6
```

---

## 🛠️ Tecnologias e Conceitos Utilizados

| Recurso                             | Finalidade                                                          |
| :---------------------------------- | :------------------------------------------------------------------ |
| **Java**                            | Linguagem utilizada para desenvolver a lógica do jogo.              |
| **ArrayList**                       | Armazena as empresas e as coordenadas ocupadas por cada uma.        |
| **Programação Orientada a Objetos** | Organiza o programa em classes, objetos, atributos e métodos.       |
| **BufferedReader**                  | Realiza a leitura dos palpites informados no terminal.              |
| **Math.random()**                   | Gera posições aleatórias para as empresas.                          |
| **Laços e condicionais**            | Controlam as rodadas, verificam os resultados e encerram a partida. |
| **Encapsulamento**                  | Mantém dados e comportamentos organizados dentro das classes.       |

---

## 🧱 Estrutura do Programa

O projeto está concentrado no arquivo `DerrubeEmpresas.java`, que possui três componentes principais.

### `DerrubeEmpresas`

Classe responsável por controlar o fluxo geral da partida:

* configura as empresas;
* inicia o jogo;
* recebe e verifica os palpites;
* contabiliza as tentativas;
* remove as empresas eliminadas;
* encerra a partida.

### `empresa`

Representa cada empresa escondida no tabuleiro:

* armazena o nome da empresa;
* mantém a lista de coordenadas ocupadas;
* verifica se uma tentativa acertou uma posição;
* remove as posições atingidas;
* identifica quando a empresa foi completamente eliminada.

### `GameHelper`

Fornece os recursos auxiliares utilizados pelo jogo:

* lê os dados informados pelo usuário;
* cria uma grade de 49 posições;
* gera coordenadas aleatórias;
* evita a sobreposição entre empresas;
* alterna o posicionamento horizontal e vertical.

---

## 🚀 Como Executar

### Pré-requisitos

Certifique-se de ter o **JDK 8 ou superior** instalado em sua máquina.

Para verificar a instalação:

```bash
java -version
javac -version
```

### 1. Clonar o repositório

```bash
git clone https://github.com/seu-usuario/derrube-empresas.git
cd derrube-empresas
```

Substitua `seu-usuario` pelo seu nome de usuário no GitHub.

### 2. Compilar o programa

```bash
javac DerrubeEmpresas.java
```

### 3. Executar o jogo

```bash
java DerrubeEmpresas
```

---

## 💻 Exemplo de Execução

```text
Seu objetivo é eliminar três empresas
Pets.com, eToys.com e Go2.com
Tente eliminar todas com o menor numero de palpites

Insira um chute: a0
errado

Insira um chute: c3
acertou

Insira um chute: c4
acertou

Insira um chute: c5
Boa! você derrubou a Pets.com
eliminar
```

As posições das empresas são geradas aleatoriamente e mudam a cada execução.

---

## 📚 Origem do Projeto

Este projeto foi desenvolvido como uma adaptação prática de um dos desafios apresentados no livro **“Use a Cabeça! Java”**.

A proposta foi importante para praticar conceitos fundamentais da linguagem por meio de um projeto interativo, transformando o conteúdo estudado em uma aplicação funcional executada pelo terminal.

---

## 🧠 Aprendizados

Durante o desenvolvimento, foram praticados conceitos como:

* criação e manipulação de objetos;
* utilização de coleções com `ArrayList`;
* separação de responsabilidades entre classes;
* geração de valores aleatórios;
* leitura de dados pelo terminal;
* controle de fluxo com laços e condicionais;
* validação de coordenadas;
* manipulação de posições em uma grade;
* construção da lógica de um jogo;
* acompanhamento do desempenho do jogador.

---

## 🔮 Possíveis Melhorias

* Exibir visualmente a grade durante a partida.
* Validar coordenadas antes de contabilizar o palpite.
* Impedir que uma coordenada repetida conte como uma nova tentativa.
* Criar diferentes níveis de dificuldade.
* Permitir que o jogador escolha o tamanho da grade.
* Separar as classes em arquivos diferentes.
* Aplicar as convenções de nomenclatura do Java, como renomear `empresa` para `Empresa`.
* Adicionar testes automatizados.
* Desenvolver uma interface gráfica utilizando JavaFX ou Swing.

---

## 👨‍💻 Autor

Projeto desenvolvido por **Enzo Soncine**, estudante de programação, como parte dos estudos e da evolução prática em Java.

---

## 🤝 Contribuições

Sugestões, melhorias e feedbacks são bem-vindos.

Sinta-se à vontade para abrir uma *issue* ou enviar um *pull request*.
