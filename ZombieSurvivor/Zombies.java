import java.util.Arrays;

public class Zombies {

  private final Zombie[] zombies;
  private int numberOfZombies;

  public Zombies(int maxZombies) {
	  zombies = new Zombie[maxZombies];
	  numberOfZombies = 0;
  }

  public int getNumberOfZombies() {
    return this.numberOfZombies;
  }

  public void addZombie(Zombie zombie) {
    // assume the array is big enough to store this zombie
	  zombies[numberOfZombies] = zombie;
	  numberOfZombies++;
  }

  public Zombie removeZombie(int zombieIndex) {
	  Zombie z = zombies[zombieIndex];
	  Util.swap(zombies, numberOfZombies-1, zombieIndex);
      numberOfZombies--;
      return z;
  }

  public void takeAllZombies(Zombies other) {
	  for(int i = 0; i < other.getNumberOfZombies(); i++) {
		  this.addZombie(other.removeZombie(i));
	  }
  }

  public String toString() {
    Zombie[] smaller = Arrays.copyOf(zombies, numberOfZombies);
    return Arrays.toString(smaller);
  }

}
