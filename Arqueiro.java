package Personagem;

import Personagem.Personagem;

public class Arqueiro extends Personagem {
    Arqueiro(String nome, String idade, String sexo){
        this.nome = nome;
        this.idade = Integer.parseInt(idade);
        this.sexo = sexo;
    }
}
