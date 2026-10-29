public abstract class Celular implements Recarregavel {

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

    @Override
    public void recarregar(int percentual) {

        if (percentual < Recarregavel.CARGA_MINIMA ||
                percentual > Recarregavel.CARGA_MAXIMA) {

            System.out.println("Erro: Percentual inválido!");
            return;
        }

        bateria.setPorcentagem(percentual);

        System.out.println("Celular " + modelo +
                " recarregado para " + percentual + "%");
    }

    public int getVolume() {
        return volume;
    }

    public int getBateria() {
        return bateria.getPorcentagem();
    }

    public void tocarSom() {
        System.out.println("Som do celular");
    }

    public abstract String tipoDeConector();
}