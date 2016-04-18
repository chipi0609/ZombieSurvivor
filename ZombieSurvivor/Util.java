public class Util {

	public static Outcome calculateOutcome(double index, double biteChance,
			double hitChance, double destroyChance) {

		Outcome result = Outcome.DESTROYED;

		if (index < biteChance) {
			result = Outcome.BITTEN;
		}

		else if (index < biteChance + hitChance) {
			result = Outcome.HIT;
		}

		else if (index < biteChance + hitChance + destroyChance) {
			result = Outcome.DESTROYED;
		}

		return result;
	}

	public static int findIndexGreaterThanOrEqualTo(int[] numbers, int target) {
		for (int i = 0; i < numbers.length; i++) {
			if(numbers[i] == target) {
				return i;
			}
		}
		return -1;
	}

	public static void swap(Zombie[] zombies, int x, int y) {
		Zombie temp = zombies[x];
		zombies[x] = zombies[y];
		zombies[y] = temp;		
	}

}
