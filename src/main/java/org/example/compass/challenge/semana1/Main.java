package org.example.compass.challenge.semana1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    static public int QUANTITYPERGOUP = 3;
    static public List<String> NAME_LIST = new ArrayList<>(Arrays.asList(
            "Sofia Mendes",
            "Lucas Silva",
            "Maria Oliveira",
            "Pedro Santos",
            "Ana Martins",
            "João Costa",
            "Carolina Pereira",
            "André Almeida",
            "Mariana Fernandes",
            "Tiago Rodrigues"));


    public static void main(String[] args) throws IllegalAccessException {

        SorteadorDeGrupos sorteador = new SorteadorDeGrupos(NAME_LIST, QUANTITYPERGOUP);

        List<List<String>> gruposSeparados = sorteador.geraGrupos();

        showGroup(gruposSeparados);
    }

    public static void showGroup(List<List<String>> grupos) {

        int i = 0;
        for (List<String> group: grupos){
            System.out.println((i + 1) + " Group:");
            group.forEach(name -> System.out.println(name));
            System.out.println("________________");
            i ++;
        }
    }
}

