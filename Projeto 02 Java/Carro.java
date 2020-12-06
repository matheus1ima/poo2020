import java.util.Scanner;

public class Carro {
    int gas;
    int gasMax;
    int pass;
    int passMax;
    int km;

    Carro(){;
        this.gasMax = 100;
        this.gas = 0;
        this.passMax = 2;
        this.pass = 0;
        this.km = 0;
    }

    void embarcar(){
        if(pass < 2){
            pass += 1;
        } else {
            System.out.println("O carro está lotado!");
        }
    }

    void desembarcar(){
        if(pass > 1){
            pass -= 1;
        } else {
            System.out.println("O carro está vazio!");
        }
    }

    void abastecer(int qtd){
        if(gas < gasMax){
            if(qtd > gasMax){
                gas = gasMax;
            } else if(qtd < gasMax && gas + qtd > gasMax){
                gas = gasMax;
            } else {
                gas += qtd;
            }

        }
    }

    void dirigir(int dist){
        if(pass == 0 && gas == 0){
            System.out.println("Estou impossibilitado de tal tarefa");
        } else if(pass > 0 && gas > 0){
            if(gas < dist){
                System.out.println("Andei só " + gas);
                km = gas;
                gas = 0;
                return;
            } else {
                gas -= dist;
                km += dist;
                System.out.println("Que passeio agradavel");
            }       
        }
    }

    public String toString() {
        return "Gasolina: " + gas + "/" + gasMax + " | Passageiros: " + pass  + "/" + passMax  +" | Km: " + km;
    }

    public static void main(String[] args){
        Carro carro = new Carro();

        Scanner scanner = new Scanner(System.in);

        while(true){
            String line = scanner.nextLine();
            String[] ui = line.split(" ");
            if(line.equals("end")){
                break;
            }else if(line.equals("show")){
                System.out.println(carro);
            }else if(ui[0].equals("embarcar")){
                carro.embarcar();
            }else if(ui[0].equals("desembarcar")){
                carro.desembarcar();
            }else if(line.equals("abastecer")){
                carro.abastecer(Integer.parseInt(ui[1]));
            }else if(ui[0].equals("dirigir")){
                carro.dirigir(Integer.parseInt(ui[1]));
            }else{
                System.out.println("fail: comando invalido");
            }
        }
        scanner.close();
    }
}
