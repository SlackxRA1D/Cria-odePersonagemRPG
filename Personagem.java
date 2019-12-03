package Personagem;

public class Personagem {

    String nome;
    int idade;
    String sexo;
    String classe;
    String arma;
    int hp;
    int mp;
    int level;
    int xp;
    int forca;
    int intel;
    int agilidade;
    int danoarma;

    public Personagem() {
        this.nome = "João";
        this.classe = "Guerreiro";
        this.xp = 0;
        this.level = 1;
        this.hp = 20;
        this.mp = 10;
        this.agilidade = 5;
        this.forca = 5;
        this.intel = 5;
    }
    
    public void setSexo(String sexo){
        this.sexo = sexo;
    }
    
    public String getSexo(){
        return sexo;
    }
    
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp += hp;
    }

    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        this.mp += mp;
    }

    public int getForca() {
        return forca;
    }

    public void setForca(int forca) {
        this.forca += forca;
    }

    public int getIntel() {
        return intel;
    }

    public void setIntel(int intel) {
        this.intel += intel;
    }

    public int getAgilidade() {
        return agilidade;
    }

    public void setAgilidade(int agilidade) {
        this.agilidade += agilidade;
    }

    public void Informacao() {
        System.out.println("Nome: " + this.nome.toUpperCase());
        System.out.println("Classe: " + this.getClasse());
        System.out.println("Level: " + this.getLevel() + "   EXP: " + this.getXp() + "/100");
        System.out.println("Agilidade: " + this.getAgilidade());
        System.out.println("Inteligencia: " + this.getIntel());
        System.out.println("Força: " + this.getForca());
        System.out.println("Vida: " + this.getHp());
        System.out.println("Mana: " + this.getMp());

    }

    public static void main(String[] args) {
        Personagem p = new Personagem();

        p.Informacao();

    }
}
