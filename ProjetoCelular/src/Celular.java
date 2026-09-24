public class Celular {

    private String modelo;
    private Bateria bateria;
    private int volume;

    public Celular(String modelo, Bateria bateria) {
        this.modelo = modelo;
        this.bateria = bateria;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void aumentarVolume(int quantidade) {

        if (quantidade > 0 && volume + quantidade <= 100) {
            volume = volume + quantidade;
        }

    }

    public void carregarBateria(int quantidade) {
        bateria.carregar(quantidade);
    }

    public int getVolume() {
        return volume;
    }

    public int getBateria() {
        return bateria.getPorcentagem();
    }
}