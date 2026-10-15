
public class Apple extends Celular {

    private boolean airdrop;

    public Apple(String modelo, Bateria bateria, boolean airdrop) {
        super(modelo, bateria);
        this.airdrop = airdrop;
    }

    public boolean isAirdrop() {
        return airdrop;
    }

    public void setAirdrop(boolean airdrop) {
        this.airdrop = airdrop;
    }

    @Override
    public void tocarSom() {
        System.out.println("Som do iPhone");
    }

    @Override
    public String tipoDeConector() {
        return "Lightning";
    }
}
