import java.util.Scanner;

enum Moeda{
    M10(0.10f, 1),
    M25(0.25f, 2),
    M50(0.50f, 3),
    M100(1f, 4);

    float valor;
    int volume;

    Moeda(float valor, int volume){
        this.valor = valor;
        this.volume = volume;
    }

    public String toString(){
        return "Valor: " + valor + " | Volume: " + volume + "\n";
    }
}

class Item{
    String descricao;
    int volume;

    Item(String descricao, int volume){
        this.descricao = descricao;
        this.volume = volume;
    }

    public String toString(){
        return "Descrição: " + descricao + " | Volume: " + volume + "\n";
    }
}

class Porco{
    String itens = "";
    float valor = 0.0f;
    int volume = 0;
    int volumeMax;
    boolean estaQuebrado = false;

    Porco(int volumeMax){
        this.volumeMax = volumeMax;
    }

    boolean addDinheiro(Moeda moeda){
        if(estaQuebrado == true){
            System.out.println("O porco esta quebrado");
            return false;
        }
        if(moeda.volume + this.volume > this.volumeMax){
            System.out.println("Porco esta lotado");
            return false;
        }
        this.valor += moeda.valor;
        this.volume += moeda.volume;
        return true;
    }

    boolean addItem(Item item){
        if(estaQuebrado == true){
            System.out.println("O porco esta quebrado");
            return false;
        }
        if(ths.volume + item.volume > this.volumeMax){
            System.out.println("O item não cabe no cofre");
            return false;
        }
        this.volume += item.volume;
        if(this.item.equals(""))
            this.item = item.descricao;            
        else
            this.item += ", " + item.descricao;
        return true;
    }

    boolean quebrar(){
        if(estaQuebrado)
            return false;
        estaQuebrado = true;
        return true;
    }

    float pegarDinheiro(){
        if(!estaQuebrado){
            System.out.println("Voce deve quebrar o cofre primeiro!");
            return 0.0f;
        }
        float aux = this.valor;
        this.valor = 0;
        return aux;
    }

    String pegarItens(){
        if(!estaQuebrado){
            System.out.println("Voce deve quebrar o cofre primeiro!");
            return "";
        }
        String aux = this.itens;
        this.itens = "";
        return aux;
    }

    public String toString() {
        return item + ":" + valor +":" + volume + "/" + volumeMax + ":" + estaQuebrado;
    }
}

public class Cofre1{
    public static void main(String[] args) {
        Porco porco = new Porco(25);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Cofre - Porco");

        while(true){
            String line = scanner.nextLine();
            String[] leitor = line.split(" ");

            if(line.equals("sair")){
                break;
            }else if(line.equals("show")){
                System.out.println(porco);
            }else if(leitor[0].equals("addmoeda")){
                if(leitor[1].equals("M10")){
                    porco.addDinheiro(Moeda.M10);
                }else if(leitor[1].equals("M25")){
                    porco.addDinheiro(Moeda.M25);
                }else if(leitor[1].equals("M50")){
                    porco.addDinheiro(Moeda.M50);
                }else if(leitor[1].equals("M100")){
                    porco.addDinheiro(Moeda.M100);
                }
            }else if(leitor[0].equals("additem")){
                porco.addItem(new Item(leitor[1], Integer.parseInt(leitor[2])));
            }else if(line.equals("quebrar")){
                porco.quebrar();
            }else if(line.equals("pegardinheiro")){
                porco.pegarDinheiro();
            }else if(line.equals("pegaritems")){
                porco.pegarItens();
            }
        }

        scanner.close();
    }
}