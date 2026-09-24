public class Main {

    public static void main(String[] args) {

        Apple apple = new Apple();

        System.out.println("APPLE");
        System.out.println("Modelo: " + apple.getModelo());
        System.out.println("Airdrop: " + apple.isAirdrop());

        apple.aumentarVolume(20);
        System.out.println("Volume: " + apple.getVolume());

        apple.carregarBateria(80);
        System.out.println("Bateria: " + apple.getBateria() + "%");

        Motorola motorola = new Motorola();

        System.out.println("\nMOTOROLA");
        System.out.println("Modelo: " + motorola.getModelo());
        System.out.println("Botoes interativos: " + motorola.isBotoesInterativos());

        motorola.aumentarVolume(30);
        System.out.println("Volume: " + motorola.getVolume());

        motorola.carregarBateria(70);
        System.out.println("Bateria: " + motorola.getBateria() + "%");
    }
}