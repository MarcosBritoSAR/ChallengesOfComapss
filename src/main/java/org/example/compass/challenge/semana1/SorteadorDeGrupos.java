package org.example.compass.challenge.semana1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SorteadorDeGrupos {

    private List<String> nameList;
    private final Random random = new Random();
    private int numOfGroups;
    private int sizeOfList;


    public SorteadorDeGrupos(List<String> nameOfList, int numOfGroups) throws IllegalAccessException {

        if(nameOfList.isEmpty()) {throw new IllegalArgumentException("A lista não pode está vazia.");}
        if (numOfGroups <= 0){ throw new IllegalArgumentException("O numero de grupos deve ser maior que zero.");}

        this.nameList = new ArrayList<>(nameOfList); //Copiando o vetor original
        this.numOfGroups = numOfGroups;
        this.sizeOfList = nameList.size();
    }

    public List<List<String>> geraGrupos() {

        List<String> group;
        List<List<String>> groupList = new ArrayList<>();

        int[] containers = this.calculateContainerValues(this.sizeOfList, this.numOfGroups);

        for (int i = 0, randomLimit = this.sizeOfList; i < this.numOfGroups; i++) {
            group = new ArrayList<>();
            //Estou usando a lista de containers da seguinte forma:
            // 1. A quantidade de indices é a quantidade de grupos/containers
            // 2. Cada indice armazena a quantidade de pessoas que devem habitar o grupo/container
            System.out.println(containers[i]);
            for (int j = 0; j < containers[i]; j++) {
                //System.out.println("log : "+j);
                //System.out.println("log random : "+ randomLimit);
                group.add(this.nameList.remove(random.nextInt(randomLimit)));
                randomLimit--;
            }
            groupList.add(group);
        }

        return groupList;
    }

    /**
     * O objetivo é calcular a quantidade ideal de pessoas por cada grupo.
     * @param lengthOfList Quantidade de pessoas dentro da lista.
     * @param numOfGrups Quantidade de grupos definidos pelo usuário.
     * @return Devolve um vetor onde cada indice representa um grupo, e cada elemento do indice representa quantas pessoas devem está dentro dele!
     */
    public int[] calculateContainerValues(int lengthOfList, int numOfGrups) {//45 7

        //Nota do desafio: Os grupos devem ter a menor variação possível no número de integrantes (1 grupo pode ter 1 integrante a mais ou a menos).

        int personPerGroup = lengthOfList / numOfGrups;
        int rest = lengthOfList % numOfGrups;
        int[] container = new int[numOfGrups];

        //Adicina aos primeiros grupos, os restantes das pessoas obtidas na divisão.
        for(int i = 0 ; i < numOfGrups; i++) {

            container[i] = personPerGroup + ( i < rest? 1 : 0);

        }
        return container;
    }

}
