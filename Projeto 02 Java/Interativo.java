import java.util.Scanner;
//Codigo do Calango modificado
class Calango {
    int bucho; //atributos
    int maxBucho;
    int nPatas;
    int vida;
    boolean alive;
    int asas;

    //mesmo nome da classe = sombreamento de variavel
    Calango(int maxBucho){ //parametros
        this.bucho = maxBucho;
        this.maxBucho = maxBucho;
        this.nPatas = 4;
        this.vida = 4;
        this.alive = true;
        this.asas = 4;
    }

    void comer(int qtd){
        bucho += qtd;
        if(bucho > maxBucho){
            bucho = maxBucho;
            System.out.println("Comi até ficar saciado");
        }else{
            System.out.println("Tô cheio");
        }
    }

    void andar(int dist){
        if(nPatas < 2){
            System.out.println("Estou impossibilitado de tal tarefa");
            return;
        }
        if(bucho > 0){
            if(bucho < dist){
                System.out.println("Andei só " + bucho);
                bucho = 0;
                return;
            }
            bucho -= dist;
            System.out.println("Que passeio agradavel");
            return;
        }
        System.out.println("Estou muito cansado");
        
    }

    void voar(int km){
        if(asas < 2){
            System.out.println("Estou impossibilitado de tal tarefa");
            return;
        }
        if(bucho > 0){
            if(bucho < km){
                System.out.println("Voei só " + bucho);
                bucho = 0;
                return;
            }
            bucho -= km;
            System.out.println("Que passeio agradavel, o céu estava top!");
            return;
        }
        System.out.println("Estou muito cansado");
        
    }

    void acidentar(){
        if(nPatas > 0 && asas > 0){
            nPatas -= 1;
            asas -= 1;
            System.out.println("Ouch! Perdi uma pata e uma asa");
        }else{
            System.out.println("Já virei cobra!!");
        }
    }

    void regenerar(){
        if(nPatas == 4 && asas == 4){
            System.out.println("Estou perfeito");
        }else if (bucho > 0){
            nPatas += 1;
            asas += 1;
            bucho -= 1;
            System.out.println("Opa! Recuperei uma pata e uma asa!");
        }else{
            System.out.println("Nao tenho energia suficiente para me recuperar");
        }
    }

    public String toString() {
        return "Bucho: " + bucho + "/" + maxBucho + " | Patas: " + nPatas  + " | Asas: " + asas  +" | Alive: " + alive;
    }
}

public class Interativo {
    public static void main(String[] args) {
        Calango calango = new Calango(10);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Calango Mutante - Nova Atualização(COM ASAS)");
        System.out.println("'end' - Para finalizar a jogada\n'show' - Para visualizar a situação\n'andar' - Para andar\n'voar' - Para voar\n'regenerar' - para recuperar patas e asas\n'comer' - Para se alimentar\n'brigar' - Para acidentar");
        while(true){
            String line = scanner.nextLine();
            String[] ui = line.split(" ");
            if(line.equals("end")){
                break;
            }else if(line.equals("show")){
                System.out.println(calango);
            }else if(ui[0].equals("andar")){//andar _dist
                calango.andar(Integer.parseInt(ui[1]));
            }else if(ui[0].equals("voar")){//voar _km
                calango.voar(Integer.parseInt(ui[1]));
            }else if(line.equals("regenerar")){
                calango.regenerar();
            }else if(ui[0].equals("comer")){//comer _qtd
                calango.comer(Integer.parseInt(ui[1]));
            }else if(line.equals("brigar")){
                calango.acidentar();
            }else{
                System.out.println("fail: comando invalido");
            }
        }
        scanner.close();
    }
}