public class Turn {

	private static final int NUM_EASY_ZOMBIES = 20;
	private static final int NUM_MEDIUM_ZOMBIES = 20;
	private static final int NUM_HARD_ZOMBIES = 10;

	private static final int MAX_NUM_ZOMBIES = NUM_EASY_ZOMBIES
			+ NUM_MEDIUM_ZOMBIES + NUM_HARD_ZOMBIES;

	private static final int BITE_LIMIT = 6;
	private static final int HAND_SIZE = 5;

	private final int player;

	private final Zombies zombiePopulation = new Zombies(MAX_NUM_ZOMBIES);
	private final Zombies destroyed = new Zombies(MAX_NUM_ZOMBIES);
	private final Zombies hit = new Zombies(HAND_SIZE);
	private final Zombies bitten = new Zombies(MAX_NUM_ZOMBIES);

	public Turn(int player) {
		this.player = player;
		for (int i = 0; i < NUM_EASY_ZOMBIES; i++) {
			zombiePopulation.addZombie(Zombie.EASY);
		}

		for (int i = 0; i < NUM_MEDIUM_ZOMBIES; i++) {
			zombiePopulation.addZombie(Zombie.MEDIUM);
		}

		for (int i = 0; i < NUM_HARD_ZOMBIES; i++) {
			zombiePopulation.addZombie(Zombie.HARD);
		}

	}

	public int getCurrentPlayer() {
		return player;
	}

	public boolean hasBeenBittenTooManyTimes() {
		return bitten.getNumberOfZombies() >= 6;
	}

	public int getCurrentScore() {
		return hasBeenBittenTooManyTimes() ? 0 : destroyed.getNumberOfZombies();
	}

	private void addZombies(Zombies hand, int extraZombiesNeeded) {
		for (int i = 0; i < extraZombiesNeeded; i++) {
			if (i < zombiePopulation.getNumberOfZombies()) {
				int j = (int) (Math.random() * extraZombiesNeeded);
				hand.addZombie(zombiePopulation.removeZombie(j));
			}
		}
	}

	private Outcome[] getOutcomesForHand(Zombies hand) {
		int handLength = hand.getNumberOfZombies();
		Outcome[] outcome = new Outcome[handLength];
		for (int i = 0; i < handLength; i++) {
			Zombie zombie = hand.removeZombie(i);
			outcome[i] = zombie.randomOutcome();

			switch (outcome[i]) {
			case HIT:
				hit.addZombie(zombie);
				break;
			case BITTEN:
				bitten.addZombie(zombie);
				break;
			case DESTROYED:
				destroyed.addZombie(zombie);
				break;
			}
		}
		return outcome;
	}

	public Outcome[] drawAndGetOutcomes() {
		Zombies hand = new Zombies(HAND_SIZE);
		hand.takeAllZombies(hit);

		int numOfZombies = hand.getNumberOfZombies();
		if (numOfZombies < HAND_SIZE) {
			addZombies(hand, HAND_SIZE - numOfZombies);
		}
		
		return getOutcomesForHand(hand);
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Destroyed: ");
		sb.append(destroyed);
		sb.append("\n");
		sb.append("Hits: ");
		sb.append(hit);
		sb.append("\n");
		sb.append("Bites: ");
		sb.append(bitten);
		return sb.toString();
	}

}
