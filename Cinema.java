import java.util.ArrayList;

class Cliente{
    int id;
    String fone;
    String name;

    Cliente(int id, String fone, String name){
        this.id = id;
        this.fone = fone;
        this.name = name;
    }

}

class Sala{
    int cadeiras;
    ArrayList<Cliente> cliente;
    int i;

    public Sala(int cadeiras){
        this.cadeiras = cadeiras;
        this.cliente = new ArrayList<>();

        for(i = 0; i < cadeiras; i++){
            this.cliente.add(new Cliente(i, "-", ""));
        }
    }

    public void reservar(Cliente pessoa){
        int i = pessoa.id;
        if(i >= 0 && i < cliente.size()){
            for(int k = 0; k < cliente.size(); k++){
                if(pessoa.name.equals(cliente.get(k).name)){
                    System.out.println("fail");
                    return;
                }
            }
            if(i == cliente.get(i).id && cliente.get(i).name != "-"){
                System.out.println("cadeira ocupada");
                return;
            } else {
                cliente.set(i, pessoa);
                System.out.println("Cadeira Reservada");
                return;
            }
        }
        System.out.println("Não Reservado");
        return;
    }

    public boolean cancelar(String id){
        for(int k = 0; k < cliente.size(); k++){
            if(id.equals(cliente.get(k).nome)){
                cliente.set(k, new Cliente(k,"-", ""));
                System.out.println("Reserva Cancelada");
                return true;
            }
            return false;
        }
    }
}
public class Cinema{
    public static void main(String[] args){
        Sala sala = new Sala(30);

        sala.reservar(new Cliente(1, "99887766", "Pedro")); 
        sala.reservar(new Cliente(2, "99778866", "Isabela"));
        sala.reservar(new Cliente(3, "99886677", "Yarlei"));
        sala.reservar(new Cliente(4, "99776688", "Rayane"));
        sala.reservar(new Cliente(5, "98887766", "Ricladio"));
        sala.reservar(new Cliente(6, "98778866", "Alex"));
        sala.cancelar("Alex");
        

    }
}