import java.util.ArrayList;
import java.util.Collections;

class Passageiro{
    String nome;
    static int idade;

    Passageiro(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public String toString() {
        return nome + " | idade: " + idade;
    }
}

class Dentro {
    ArrayList<Passageiro> poltronas;
    Passageiro passageiro = null;
    int qtdPreferencia;

    public Dentro(int lotacao, int qtdPreferencia){
        this.qtdPreferencia = qtdPreferencia;
        poltronas = new ArrayList<>();

        for(int i = 0; i < lotacao; i++){
            poltronas.add(null);
        }
    }

    public boolean subir(Passageiro teste) {
        for(int j = 0; j < poltronas.size(); j++){
            if(teste.idade >= 65){
                if(j < this.qtdPreferencia && poltronas.get(j) == null){
                    poltronas.set(j, teste);
                    System.out.println("Idoso sentado na poltrona preferencial.");
                    return true;
                }else if(j >= this.qtdPreferencia && poltronas.get(j) == null){
                    poltronas.set(j, teste);
                    System.out.println("Idoso sentado na poltrona convencional.");
                    return true;
                }
                System.out.println("Topic Lotada.");
                return false;
            }
            if(teste.idade < 65){
                j = this.qtdPreferencia;
                if(j >= this.qtdPreferencia && poltronas.get(j) == null){
                    poltronas.set(j, teste);
                    System.out.println("Passageiro sentado na poltrona convencional.");
                    return true;
                } 
                j = 0;
                if(j < this.qtdPreferencia && poltronas.get(j) == null){
                    poltronas.set(j, teste);
                    System.out.println("Passageiro sentado na poltrona preferencial.");
                    return true;
                }
                System.out.println("Topic Lotada.");
                return false;
            }

        }

        for(Passageiro poltrona : poltronas){
            if(poltrona != null && poltrona.nome.equals(teste.nome)){
                System.out.println("Esta pessoa já está situada em sua poltrona.");
                return false;
            }
        }
        
        return true;
    }

    public void descer(String name){
        for(k = 0; k < poltronas.size(); k++){
            if(poltrona.get(k).nome != null && name.equals(poltrona.get(k).nome)){
                poltronas.set(k, null);
                System.out.println("Passageiro desceu da Topic.");
            }
        }
    }

    public String toString(){
        int n = qtdPreferencia;
        String resultado = "[";

        for(int l = 0; l < poltronas.size(); l++){
            if(l < n && poltronas.get(l) != null){
                resultado += "@" + poltronas.get(l) + ", ";
            }else if(l < n && poltronas.get(l) == null){
                resultado += "@, ";
            }
            if(l >= n && poltronas.get(l) != null){
                resultado += "=" + poltronas.get(l) + ", ";
            } else if(l >= n && poltronas.get(l) == null){
                resultado += "=, ";
            }
        }

        return resultado += "]";
    }
}
public class Topic{
    public static void main(String [] args){
        Dentro dentro = new Dentro(10, 3);

        System.out.println(dentro);
        dentro.subir(new Passageiro("Isabela", 19));
        dentro.subir(new Passageiro("Giovana", 19));
        dentro.subir(new Passageiro("Odilon", 70));
        System.out.println(dentro);
    }
}

