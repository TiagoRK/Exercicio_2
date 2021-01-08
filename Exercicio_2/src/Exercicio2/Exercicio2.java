/*
Crie um algorítmo que leia o arquivo 'tarefa_2.txt' e realize a seguinte operação:
	Para cada linha, deve ser feito uma operação sobre o conteúdo posterior ao hífen '-'. A operação a ser feita deve corresponder ao token anterior ao hífen. (exemplo de linha: INVERTER-Estou em Sapiranga, volto logo. 2295935)
	As opções são: 
		NADA: Não realiza operação nenhuma sobre o texto.
		D - CAMEL_CASE: Deixa a primeira letra de cada palavra em caixa alta, e as demais letras em caixa baixa. DONE
		D - INVERTER: Inverte o texto colocando em primeiro lugar o caractére que antes estava em último. DONE
		D - UPPER_CASE: Deixa todo o texto em caixa alta. DONE
		D - LOWER_CASE: Deixa todo o texto em caixa baixa. DONE
		D - WEB_FORMAT: Substitui todos os espaços ' ' por '%20'.  DONE
		D - IS_NUMBER: Verifica se TODO o texto contém apenas números. DONE
		D - HAVE_SYMBOLS: Verifica se existe algum caractére não alfa-numérico no texto. DONE
		D - SUM: Se o texto for composto apenas de caractéres numéricos, deve ser somado o valor de cada número. DONE

	Resposta esperada:
		-Cada operação diferente sobre o texto deve ser feita em um método separado. 
		-No final da execução do código, deve ser impresso cada linha convertida, contendo as seguintes informações:
			[número da linha lida]: [código da operação] - [texto da operação] = [resposta processada]
			Exemplo: 
				Entrada: 'WEB_FORMAT-Aranhas tecelãs'
				Saída: '1: WEB_FORMAT - Aranhas tecelãs = Aranhas%20Tecelãs'
		-Linhas com códigos diferente dos apresentados devem ser ignoradas. Deve ser apresentado na impressão o número das linhas ignoradas e o código contido nela.
*/

package Exercicio2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Exercicio2 {

    public static void main(String[] args) {
        int numeroLinha = 0;
        try {
            FileReader fr = new FileReader("G:/tarefa_2.txt");
            BufferedReader br = new BufferedReader(fr);
            String temp;
            while ((temp = br.readLine()) != null) {
                int um = temp.indexOf("-");
                String verificar = "";
                if(temp.contains("-")){
                    verificar = temp.substring(0, um);
                }
                
                if (verificar.contains("CAMEL_CASE")) {
                    numeroLinha = numeroLinha + 1;
                    ativarCamelCase(temp, numeroLinha, verificar);
                } else if (verificar.contains("INVERTER")) {
                    numeroLinha = numeroLinha + 1;
                    ativarInverter(temp, numeroLinha, verificar);
                } else if (verificar.contains("UPPER_CASE")) {
                    numeroLinha = numeroLinha + 1;
                    ativarUpperCase(temp, numeroLinha, verificar);
                } else if (verificar.contains("LOWER_CASE")) {
                    numeroLinha = numeroLinha + 1;
                    ativarLowerCase(temp, numeroLinha, verificar);
                } else if (verificar.contains("WEB_FORMAT")) {
                    numeroLinha = numeroLinha + 1;
                    ativarWebFormat(temp, numeroLinha, verificar);
                } else if (verificar.contains("IS_NUMBER")) {
                    numeroLinha = numeroLinha + 1;
                    ativarIsNumber(temp, numeroLinha, verificar);
                } else if (verificar.contains("HAVE_SYMBOLS")) {
                    numeroLinha = numeroLinha + 1;
                    ativarVerificaEspeciais(temp, numeroLinha, verificar);
                } else if (verificar.contains("SUM")) {
                    numeroLinha = numeroLinha + 1;
                    ativarSomaNumeros(temp, numeroLinha, verificar);
                } else if (verificar.contains("NADA")) {
                    numeroLinha = numeroLinha + 1;
                    nada(temp, numeroLinha, verificar);
                } else if (verificar.contains("NADA") || verificar.contains("CAMEL_CASE") || verificar.contains("INVERTER") || verificar.contains("UPPER_CASE") || verificar.contains("LOWER_CASE") || verificar.contains("WEB_FORMAT") || verificar.contains("IS_NUMBER") || verificar.contains("HAVE_SYMBOLS") || verificar.contains("SUM") == false) {
                    numeroLinha = numeroLinha + 1;
                    linhaIgnorada(temp, numeroLinha);
                }
            }

        } catch (FileNotFoundException el) {
            System.out.println("Arquivo não Encontrado!");
        } catch (IOException e) {
        }

    }

    public static void linhaIgnorada(String temp, int numeroLinha) {
        System.out.println(numeroLinha + ": " + "LINHA IGNORADA - " + temp);
    }

    public static void nada(String temp, int numeroLinha, String verificar) {
        String[] restoDaString = temp.split("NADA-", 2);
        StringBuilder builder = new StringBuilder();
        for (String value : restoDaString) {
            builder.append(value);
        }
        String text = builder.toString();
        System.out.println(numeroLinha + ": " + verificar + " - " + text);
    }

    public static void ativarSomaNumeros(String temp, int numeroLinha, String verificar) {
        String[] restoDaString = temp.split("SUM-", 2);
        StringBuilder builder = new StringBuilder();
        for (String value : restoDaString) {
            builder.append(value);
        }
        String text = builder.toString();
        if (somaNumeros(text) == 0) {
            System.out.println(numeroLinha + ": " + verificar + " - " + text + " = ERRO! NÃO CONTÉM SOMENTE NÚMEROS!");
        } else {
            System.out.println(numeroLinha + ": " + verificar + " - " + text + " = " + somaNumeros(text));
        }
    }

    public static void ativarVerificaEspeciais(String temp, int numeroLinha, String verificar) {
        String[] restoDaString = temp.split("HAVE_SYMBOLS-", 2);
        StringBuilder builder = new StringBuilder();
        for (String value : restoDaString) {
            builder.append(value);
        }
        String text = builder.toString();
        System.out.println(numeroLinha + ": " + verificar + " - " + text + " = " + verificaEspeciais(text));
    }

    public static void ativarIsNumber(String temp, int numeroLinha, String verificar) {
        String[] restoDaString = temp.split("IS_NUMBER-", 2);
        StringBuilder builder = new StringBuilder();
        for (String value : restoDaString) {
            builder.append(value);
        }
        String text = builder.toString();
        System.out.println(numeroLinha + ": " + verificar + " - " + text + " = " + verificaNumeros(text));
    }

    public static void ativarWebFormat(String temp, int numeroLinha, String verificar) {
        String[] restoDaString = temp.split("WEB_FORMAT-", 2);
        StringBuilder builder = new StringBuilder();
        for (String value : restoDaString) {
            builder.append(value);
        }
        String text = builder.toString();
        System.out.println(numeroLinha + ": " + verificar + " - " + text + " = " + formataWebFormat(text));
    }

    public static void ativarLowerCase(String temp, int numeroLinha, String verificar) {
        String[] restoDaString = temp.split("LOWER_CASE-", 2);
        StringBuilder builder = new StringBuilder();
        for (String value : restoDaString) {
            builder.append(value);
        }
        String text = builder.toString();
        System.out.println(numeroLinha + ": " + verificar + " - " + text + " = " + transformaLowerCase(text));
    }

    public static void ativarUpperCase(String temp, int numeroLinha, String verificar) {
        String[] restoDaString = temp.split("UPPER_CASE-", 2);
        StringBuilder builder = new StringBuilder();
        for (String value : restoDaString) {
            builder.append(value);
        }
        String text = builder.toString();
        System.out.println(numeroLinha + ": " + verificar + " - " + text + " = " + transformaUpperCase(text));
    }

    public static void ativarCamelCase(String temp, int numeroLinha, String verificar) {
        String[] restoDaString = temp.split("CAMEL_CASE-", 2);
        StringBuilder builder = new StringBuilder();
        for (String value : restoDaString) {
            builder.append(value);
        }
        String text = builder.toString();
        System.out.println(numeroLinha + ": " + verificar + " - " + text + " = " + formatarCamelCase(text));
    }

    public static void ativarInverter(String temp, int numeroLinha, String verificar) {
        String[] restoDaString = temp.split("INVERTER-", 2);
        StringBuilder builder = new StringBuilder();
        for (String value : restoDaString) {
            builder.append(value);
        }
        String text = builder.toString();
        System.out.println(numeroLinha + ": " + verificar + " - " + text + " = " + inverter((text)));
    }

    public static int somaNumeros(String entrada) {
        String resultado = entrada;
        int resultadoSoma = 0;
        if (resultado.matches("^\\d+$")) {
            for (int i = 0; i < resultado.length(); i++) {
                char atual = resultado.charAt(i);
                String atual2 = "" + atual;
                resultadoSoma = resultadoSoma + Integer.parseInt(atual2);
            }
        }
        return resultadoSoma;
    }

    public static String verificaEspeciais(String entrada) {
        String resultado = entrada;
        String verificacao;
        if (resultado.matches("[A-Za-z0-9]+")) {
            verificacao = "Não contém caractéres especiais";
        } else {
            verificacao = "Contém caractéres especiais!";
        }
        return verificacao;
    }

    public static String verificaNumeros(String entrada) {
        String resultado = entrada;
        String verificacao;
        if (resultado.matches("^\\d+$")) {
            verificacao = "O texto contém somente números!";
        } else {
            verificacao = "O texto não contém somente números!";
        }
        return verificacao;
    }

    public static String formataWebFormat(String entrada) {
        String resultado = entrada;
        String resultadoFormatado = resultado.replace(" ", "%20");
        return resultadoFormatado;
    }

    public static String transformaUpperCase(String entrada) {
        String resultado = entrada.toUpperCase();
        return resultado;
    }

    public static String transformaLowerCase(String entrada) {
        String resultado = entrada.toLowerCase();
        return resultado;
    }

    public static String inverter(String entrada) {
        String resultado = "";
        for(int i=entrada.length()-1;i>0;i--){
            char atual = entrada.charAt(i);
            resultado = resultado+atual;
        }
        return resultado;
    }

    public static String formatarCamelCase(String entrada) {
        String resultado = "";
        char primeiraLetra = entrada.charAt(0);
        char primeiraLetraMenor = Character.toUpperCase(primeiraLetra);
        resultado = resultado + primeiraLetraMenor;
        for (int i = 1; i < entrada.length(); i++) {
            char atual = entrada.charAt(i);
            char anterior = entrada.charAt(i - 1);
            if (anterior == ' ' || anterior == '_') {
                char atualLetraMaior = Character.toUpperCase(atual);
                resultado = resultado + atualLetraMaior;
            } else if (atual == ' ' || atual == '_') {
                char removeEspaço = '\0';
                resultado = resultado + removeEspaço;
            } else {
                char atualLetraMenor = Character.toLowerCase(atual);
                resultado = resultado + atualLetraMenor;
            }

        }
        return resultado;
    }

}
