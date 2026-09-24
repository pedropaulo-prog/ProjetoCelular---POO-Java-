public class Motorola extends Celular {

    private boolean botoesInterativos;

    public Motorola() {
        super("Moto G", new Bateria(0));
        this.botoesInterativos = true;
    }

    public boolean isBotoesInterativos() {
        return botoesInterativos;
    }

    public void setBotoesInterativos(boolean botoesInterativos) {
        this.botoesInterativos = botoesInterativos;
    }
}