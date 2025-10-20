import java.util.Scanner;

class Nodo {
    public char caractere;
    public Nodo esquerda;
    public Nodo direita;

    public Nodo() {
        this.caractere = ' ';
        this.esquerda = null;
        this.direita = null;
    }

    public Nodo(char c) {
        this.caractere = c;
        this.esquerda = null;
        this.direita = null;
    }
}

class ArvoreBinariaMorse {
    private Nodo raiz;

    public ArvoreBinariaMorse() {
        this.raiz = null;
    }

    public void inicializar() {
        this.raiz = new Nodo();
    }

    public void inserir(String codigo, char c) {
        if (this.raiz == null) {
            inicializar();
        }

        Nodo atual = this.raiz;
        int len = codigo.length();
        for (int i = 0; i < len; i = i + 1) {
            char simb = codigo.charAt(i);
            if (simb == '.') {
                if (atual.esquerda == null) {
                    atual.esquerda = new Nodo();
                }
                atual = atual.esquerda;
            } else if (simb == '-') {
                if (atual.direita == null) {
                    atual.direita = new Nodo();
                }
                atual = atual.direita;
            }
        }
        atual.caractere = c;
    }

    public char buscar(String codigo) {
        if (this.raiz == null) {
            return ' ';
        }

        Nodo atual = this.raiz;
        int len = codigo.length();
        for (int i = 0; i < len; i = i + 1) {
            char simb = codigo.charAt(i);
            if (simb == '.') {
                if (atual.esquerda == null) {
                    return ' ';
                }
                atual = atual.esquerda;
            } else if (simb == '-') {
                if (atual.direita == null) {
                    return ' ';
                }
                atual = atual.direita;
            } else {
                return ' ';
            }
        }
        return atual.caractere;
    }

    public void remover(String codigo) {
        if (this.raiz == null) {
            return;
        }

        Nodo atual = this.raiz;
        int len = codigo.length();
        for (int i = 0; i < len; i = i + 1) {
            char simb = codigo.charAt(i);
            if (simb == '.') {
                if (atual.esquerda == null) {
                    return;
                }
                atual = atual.esquerda;
            } else if (simb == '-') {
                if (atual.direita == null) {
                    return;
                }
                atual = atual.direita;
            } else {
                return;
            }
        }
        atual.caractere = ' ';
    }

    public void mostrar() {
        mostrarRec(this.raiz, 0, "");
    }

    private void mostrarRec(Nodo nodo, int nivel, String caminho) {
        if (nodo == null) {
            return;
        }

        for (int i = 0; i < nivel; i = i + 1) {
            System.out.print("   ");
        }
        char c = nodo.caractere;
        if (c == ' ') {
            System.out.println("- (" + caminho + ")");
        } else {
            System.out.println(c + " (" + caminho + ")");
        }

        mostrarRec(nodo.esquerda, nivel + 1, caminho + ".");
        mostrarRec(nodo.direita, nivel + 1, caminho + "-");
    }

    public String decodificarMensagem(String mensagem) {
        String resultado = "";
        int len = mensagem.length();
        String token = "";
        for (int i = 0; i < len; i = i + 1) {
            char ch = mensagem.charAt(i);
            if (ch == ' ') {
                if (token.length() > 0) {
                    char dec = buscar(token);
                    if (dec == ' ') {
                        resultado = resultado + '?';
                    } else {
                        resultado = resultado + dec;
                    }
                    token = "";
                } else {
                    if (i + 1 < len) {
                        char prox = mensagem.charAt(i + 1);
                        if (prox == ' ') {
                            resultado = resultado + ' ';
                            while (i + 1 < len && mensagem.charAt(i + 1) == ' ') {
                                i = i + 1;
                            }
                        }
                    }
                }
            } else {
                token = token + ch;
            }
        }
        if (token.length() > 0) {
            char dec = buscar(token);
            if (dec == ' ') {
                resultado = resultado + '?';
            } else {
                resultado = resultado + dec;
            }
        }

        return resultado;
    }
}

public class ArvoreMorse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArvoreBinariaMorse arv = new ArvoreBinariaMorse();
        arv.inicializar();

        arv.inserir(".-", 'A');
        arv.inserir("-...", 'B');
        arv.inserir("-.-.", 'C');
        arv.inserir("-..", 'D');
        arv.inserir(".", 'E');
        arv.inserir("..-.", 'F');
        arv.inserir("--.", 'G');
        arv.inserir("....", 'H');
        arv.inserir("..", 'I');
        arv.inserir(".---", 'J');
        arv.inserir("-.-", 'K');
        arv.inserir(".-..", 'L');
        arv.inserir("--", 'M');
        arv.inserir("-.", 'N');
        arv.inserir("---", 'O');
        arv.inserir(".--.", 'P');
        arv.inserir("--.-", 'Q');
        arv.inserir(".-.", 'R');
        arv.inserir("...", 'S');
        arv.inserir("-", 'T');
        arv.inserir("..-", 'U');
        arv.inserir("...-", 'V');
        arv.inserir(".--", 'W');
        arv.inserir("-..-", 'X');
        arv.inserir("-.--", 'Y');
        arv.inserir("--..", 'Z');

        arv.inserir(".----", '1');
        arv.inserir("..---", '2');
        arv.inserir("...--", '3');
        arv.inserir("....-", '4');
        arv.inserir(".....", '5');
        arv.inserir("-....", '6');
        arv.inserir("--...", '7');
        arv.inserir("---..", '8');
        arv.inserir("----.", '9');
        arv.inserir("-----", '0');

        while (true) {
            System.out.println("\n Código Morse");
            System.out.println("1 Mostrar árvore");
            System.out.println("2 Buscar código Morse (ex: ... )");
            System.out.println("3 Remover código Morse (apaga caractere no nó)");
            System.out.println("4 Decodificar mensagem Morse (tokens separados por espaço)");
            System.out.println("5 Exemplo rápido (SOS)");
            System.out.println("0 Sair");
            System.out.print("Escolha: ");
            String opc = sc.nextLine();

            if (opc.length() == 0) {
                continue;
            }

            char escolha = opc.charAt(0);
            if (escolha == '0') {
                break;
            } else if (escolha == '1') {
                System.out.println("Exibindo árvore (nó: caminho):");
                arv.mostrar();
            } else if (escolha == '2') {
                System.out.print("Digite código Morse (pontos '.' e traços '-'): ");
                String codigo = sc.nextLine();
                char res = arv.buscar(codigo);
                if (res == ' ') {
                    System.out.println("Não encontrado para o código: " + codigo);
                } else {
                    System.out.println("Código " + codigo + " - " + res);
                }
            } else if (escolha == '3') {
                System.out.print("Digite código Morse a remover (apenas limpar caractere): ");
                String codigo = sc.nextLine();
                arv.remover(codigo);
                System.out.println("Removido (se existia) o caractere no código: " + codigo);
            } else if (escolha == '4') {
                System.out.println("Digite a mensagem em Morse. Separe letras por 1 espaço e palavras por 2 espaços.");
                System.out.println("Exemplo: ... --- ...  .-  -> SOS A");
                System.out.print("Mensagem Morse: ");
                String msg = sc.nextLine();
                String dec = arv.decodificarMensagem(msg);
                System.out.println("Decodificado: " + dec);
            } else if (escolha == '5') {
                System.out.println("Exemplo: ... --- ...");
                System.out.println("Resultado: " + arv.decodificarMensagem("... --- ..."));
            } else {
                System.out.println("Opção inválida.");
            }
        }

        sc.close();
    }
}
