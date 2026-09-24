public class Apple extends Celular {

    private boolean airdrop;

    public Apple() {
        super("iPhone 17 Pro Max", new Bateria(0));
        this.airdrop = true;
    }

    public boolean isAirdrop() {
        return airdrop;
    }

    public void setAirdrop(boolean airdrop) {
        this.airdrop = airdrop;
    }
}