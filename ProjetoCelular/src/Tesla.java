public class Tesla extends Carro implements Recarregavel {

    private Bateria bateria;

    public Tesla() {
        super("Tesla Model 3");
        this.bateria = new Bateria(0);
    }

    public Bateria getBateria() {
        return bateria;
    }

    public String exibirTipo() {
        return "Carro elétrico";
    }

    public String buzinar() {
        return "Tesla: buzina elétrica!";
    }

    @Override
    public void recarregar(int quantidade) {
        bateria.carregar(quantidade);
    }
}
