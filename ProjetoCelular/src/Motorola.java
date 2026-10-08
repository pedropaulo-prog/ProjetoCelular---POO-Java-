public class Motorola extends Celular {

    private boolean botoesInterativos;

    public Motorola(String modelo, Bateria bateria, boolean botoesInterativos) {
        super(modelo, bateria);
        this.botoesInterativos = botoesInterativos;
    }

    public boolean isBotoesInterativos() {
        return botoesInterativos;
    }

    public void setBotoesInterativos(boolean botoesInterativos) {
        this.botoesInterativos = botoesInterativos;
    }

    @Override
    public void tocarSom() {
        System.out.println("Som do Motorola");
    }
}