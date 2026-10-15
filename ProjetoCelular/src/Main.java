
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Apple apple = new Apple("iPhone 17 Pro Max", new Bateria(0), true);

        System.out.println("APPLE");
        System.out.println("Modelo: " + apple.getModelo());
        System.out.println("Airdrop: " + apple.isAirdrop());
        System.out.println("Conector: " + apple.tipoDeConector());

        apple.aumentarVolume(20);
        System.out.println("Volume: " + apple.getVolume());

        apple.carregarBateria(80);
        System.out.println("Bateria: " + apple.getBateria() + "%");

        apple.tocarSom();

        Motorola motorola = new Motorola("Moto G", new Bateria(0), true);

        System.out.println("\nMOTOROLA");
        System.out.println("Modelo: " + motorola.getModelo());
        System.out.println("Botoes interativos: " + motorola.isBotoesInterativos());
        System.out.println("Conector: " + motorola.tipoDeConector());

        motorola.aumentarVolume(30);
        System.out.println("Volume: " + motorola.getVolume());

        motorola.carregarBateria(70);
        System.out.println("Bateria: " + motorola.getBateria() + "%");

        motorola.tocarSom();

        List<Celular> celulares = new ArrayList<>();

        celulares.add(apple);
        celulares.add(motorola);

        System.out.println("\nLISTA POLIMORFICA");

        for (Celular celular : celulares) {
            System.out.println("Modelo: " + celular.getModelo());
            System.out.println("Conector: " + celular.tipoDeConector());
            celular.tocarSom();
            System.out.println("-------------------------");
        }
    }
}

