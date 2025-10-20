# CODIGO-MORSE

Este projeto implementa um sistema de tradução de Código Morse utilizando uma árvore binária.

O programa permite codificar e decodificar mensagens entre texto e código Morse, garantindo o funcionamento apenas com manipulação manual de nós e caracteres.

# Estrutura

O arquivo principal:

ArvoreMorse.java

Ele contém as seguintes classes:



# Nodo

Representa um nó da árvore binária do Código Morse.

### Atributos:

char caractere Armazena o caractere representado no nó.
Nodo esquerda Representa o ponto (.) no código Morse.
Nodo direita Representa o traço (-) no código Morse.

# Construtores:

Um construtor padrão que inicializa os valores como vazios.
Um construtor que recebe um caractere e o armazena no nó.

# ArvoreBinariaMorse

Responsável por construir e gerenciar a árvore binária que representa o alfabeto em código Morse.

# Principais métodos:

inserir(char c, String codigo)
  Insere um caractere na árvore de acordo com o código Morse correspondente, navegando pela esquerda (.) e direita (-) até posicioná-lo no nó correto.

decodificarLetra(String codigo)
  Percorre a árvore conforme o código Morse recebido e retorna o caractere correspondente.

codificarLetra(Nodo nodo, char letra, String caminho)
  Busca o caractere na árvore e retorna o caminho Morse (pontos e traços) até ele.

montarArvore()
  Constrói toda a árvore binária com o alfabeto completo (A–Z e 0–9) seguindo o padrão Morse internacional.

codificarPalavra(String texto)
  Transforma uma palavra ou frase em código Morse, separando letras com espaços e palavras com barras.

decodificarPalavra(String codigo)
  Converte uma sequência de pontos e traços em texto legível.

# Uso no sistema:

Controla toda a tradução entre texto e código Morse, servindo como núcleo da lógica do programa.

# Principal (Main)

Classe principal responsável pela interação com o usuário e execução das funções da árvore.

# Funcionalidades do Menu:

Codificar texto para Morse
   O usuário insere uma palavra ou frase, e o sistema converte para código Morse.

Decodificar Morse para texto
   O usuário insere um código Morse, e o sistema converte para texto comum.

Encerrar o programa
   Finaliza a execução do sistema.


# Lógica de Funcionamento

1. A árvore binária é construída no início do programa, armazenando cada letra e número em uma posição específica de acordo com o padrão Morse.
2. Para codificar, o programa percorre a árvore para cada caractere do texto e retorna seu equivalente em pontos e traços.
3. Para decodificar, o programa lê os sinais e percorre a árvore, retornando o caractere ao chegar no nó final.
4. O sistema aceita letras maiúsculas e minúsculas sem distinção.
5. O usuário pode alternar livremente entre codificação e decodificação durante a execução.
