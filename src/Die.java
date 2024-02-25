import java.util.Random;

public class Die {
    private int rolledDie;
    Random random = new Random();

    public Die() {
        this.rolledDie = random.nextInt(1,6+1);
    }

    public int rollDie() {
         return this.rolledDie = random.nextInt(1,6+1);
    }

    public int getRolledDie() {
        return rolledDie;
    }

    public void setRolledDie(int rolledDie) {
        this.rolledDie = rolledDie;
    }

}
