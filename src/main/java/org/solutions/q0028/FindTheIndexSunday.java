package org.solutions.q0028;

/*
        28. Find the Index of the First Occurrence in a String

Given two strings needle and haystack, return the index of the first occurrence of needle in haystack,
or -1 if needle is not part of haystack.

Example 1:

Input: haystack = "sadbutsad", needle = "sad"
Output: 0
Explanation: "sad" occurs at index 0 and 6.
The first occurrence is at index 0, so we return 0.

Example 2:
Input: haystack = "leetcode", needle = "leeto"
Output: -1
Explanation: "leeto" did not occur in "leetcode", so we return -1.

Constraints:

1 <= haystack.length, needle.length <= 104
haystack and needle consist of only lowercase English characters.

 */

public class FindTheIndexSunday {

    // Sunday solution approach

    public int strStr(String haystack, String needle) {
        // Se a needle for vazia, por convenção retorna 0.
        // Isso é padrão em muitas implementações de strStr.
        if (needle.isEmpty()) {
            return 0;
        }

        // Se a haystack for menor que a needle, é impossível haver match.
        // Retorna -1 indicando que não encontrou.
        if (haystack.length() < needle.length()) {
            return -1;
        }

        // ---------- PASSO 1: CRIAR A TABELA DE DESLOCAMENTO ----------
        // A tabela de deslocamento nos diz, para cada caractere possível,
        // quantas posições podemos pular quando esse caractere aparece
        // logo após a janela atual.

        // Vamos criar um array de tamanho 256 para cobrir todos os caracteres ASCII.
        // Inicializamos todos com (comprimento da needle + 1).
        // Isso significa: se o caractere não estiver na needle, pulamos (n+1) posições.
        int n = needle.length();
        int[] auxTable = new int[256];

        // Preenchemos todos os valores com (n + 1) - o pulo máximo.
        for (int i = 0; i < 256; i++) {
            auxTable[i] = n + 1;
        }

        // Agora, para cada caractere que está na needle, atualizamos seu valor na tabela.
        // O valor é: n - posição_do_caractere_na_needle.
        // Isso significa que se o caractere aparecer após a janela, alinhamos sua última
        // ocorrência na needle com a posição dele no texto.
        for (int i = 0; i < n; i++) {
            char c = needle.charAt(i);
            // n - i é o deslocamento necessário para alinhar essa ocorrência do caractere.
            // Como percorremos da esquerda para a direita, a última ocorrência que
            // encontrarmos será a que prevalece (o que é bom, queremos o menor deslocamento).
            auxTable[c] = n - i;
        }

        // ---------- PASSO 2: BUSCA COM SALTOS INTELIGENTES ----------
        // Agora vamos percorrer a haystack, mas não de um em um.
        // Vamos usar a tabela de deslocamento para pular de forma inteligente.

        int h = haystack.length();

        // i é a posição inicial da janela atual na haystack.
        // A janela vai de i até i+n-1.
        // Enquanto houver espaço para a needle caber (i <= h - n), continuamos.
        for (int i = 0; i <= h - n;) {
            // Vamos tentar comparar a janela atual com a needle.
            int j;

            // Compara caractere por caractere da janela com a needle.
            for (j = 0; j < n; j++) {
                // Se em qualquer ponto os caracteres forem diferentes, paramos a comparação.
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }

            // Se j chegou a n, significa que todos os caracteres foram iguais.
            // Encontramos a needle! Retornamos a posição i.
            if (j == n) {
                return i;
            }

            // Se não encontramos, precisamos mover a janela.
            // Aqui está a mágica do Sunday: olhamos o caractere logo após a janela.
            // Se a janela atual vai de i até i+n-1, o caractere após a janela é i+n.

            // Primeiro, verificamos se existe esse caractere (se não estamos no final).
            if (i + n >= h) {
                // Se não há caractere após a janela, não há mais para onde ir.
                break;
            }

            // O caractere após a janela é:
            char nextChar = haystack.charAt(i + n);

            // Consultamos a tabela de deslocamento para esse caractere.
            int shift = auxTable[nextChar];

            // Movemos a janela pelo valor do deslocamento.
            i += shift;

            // Note: se o deslocamento for 0, isso criaria um loop infinito.
            // Mas em nossa tabela, o menor valor é 1 (para o último caractere da needle).
            // Portanto, sempre avançamos pelo menos 1 posição.
        }

        // Se chegamos aqui, percorremos toda a haystack e não encontramos a needle.
        return -1;
    }
}
