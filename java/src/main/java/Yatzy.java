import java.util.Arrays;

public class Yatzy {

	private static final int ZERO = 0;
	private static final int ONE = 1;
	private static final int TWO = 2;
	private static final int THREE = 3;
    private static final int FOUR = 4;
	private static final int FIVE = 5;
	private static final int SIX = 6;
	
	public static int chance(int d1, int d2, int d3, int d4, int d5)
	{
        return d1 + d2 +d3 +d4 +d5;
    }

    public static int yatzy(int... dice)
    {
        int[] counts = new int[SIX];
        for (int die : dice)
            counts[die-ONE]++;
        if(Arrays.stream(counts).anyMatch(i -> i == 5))
                return 50;
        return ZERO;
    }

    public static int ones(int d1, int d2, int d3, int d4, int d5) {
    	return Arrays.stream(new int[] {d1,d2,d3,d4,d5}).filter(i -> i == ONE).sum();
    }

    public static int twos(int d1, int d2, int d3, int d4, int d5) {
    	return Arrays.stream(new int[] {d1,d2,d3,d4,d5}).filter(i -> i == TWO).sum();
    }

    public static int threes(int d1, int d2, int d3, int d4, int d5) {
    	return Arrays.stream(new int[] {d1,d2,d3,d4,d5}).filter(i -> i == THREE).sum();
    }

    protected int[] dice;
    public Yatzy(int... args)
    {
		for (int die : args)
			dice[die-ONE] = die;
    }

    public int fours()
    {
    	return Arrays.stream(dice).filter(i -> i == FOUR).sum();
    }

    public int fives()
    {
    	return Arrays.stream(dice).filter(i -> i == FIVE).sum();
    }

    public int sixes()
    {
    	return Arrays.stream(dice).filter(i -> i == SIX).sum();
    }

    public static int score_pair(int d1, int d2, int d3, int d4, int d5)
    {
        int[] counts = new int[SIX];
        counts[d1-ONE]++;
        counts[d2-ONE]++;
        counts[d3-ONE]++;
        counts[d4-ONE]++;
        counts[d5-ONE]++;
        int at;
        for (at = ZERO; at != SIX; at++)
            if (counts[SIX-at-ONE] >= TWO)
                return (SIX-at)*TWO;
        return ZERO;
    }

    public static int two_pair(int d1, int d2, int d3, int d4, int d5)
    {
        int[] counts = new int[SIX];
        counts[d1-ONE]++;
        counts[d2-ONE]++;
        counts[d3-ONE]++;
        counts[d4-ONE]++;
        counts[d5-ONE]++;
        int n = ZERO;
        int score = ZERO;
        for (int i = ZERO; i < SIX; i += ONE)
            if (counts[SIX-i-ONE] >= TWO) {
                n++;
                score += (SIX-i);
            }        
        if (n == TWO)
            return score * TWO;
        else
            return ZERO;
    }

    public static int four_of_a_kind(int d1, int d2, int d3, int d4, int d5)
    {
        int[] tallies;
        tallies = new int[SIX];
        tallies[d1-ONE]++;
        tallies[d2-ONE]++;
        tallies[d3-ONE]++;
        tallies[d4-ONE]++;
        tallies[d5-ONE]++;
        for (int i = ZERO; i < SIX; i++)
            if (tallies[i] >= FOUR)
                return (i+ONE) * FOUR;
        return ZERO;
    }

    public static int three_of_a_kind(int d1, int d2, int d3, int d4, int d5)
    {
        int[] t;
        t = new int[SIX];
        t[d1-ONE]++;
        t[d2-ONE]++;
        t[d3-ONE]++;
        t[d4-ONE]++;
        t[d5-ONE]++;
        for (int i = ZERO; i < SIX; i++)
            if (t[i] >= THREE)
                return (i+ONE) * THREE;
        return ZERO;
    }

    public static int smallStraight(int d1, int d2, int d3, int d4, int d5)
    {
        int[] tallies;
        tallies = new int[SIX];
        tallies[d1-ONE] += ONE;
        tallies[d2-ONE] += ONE;
        tallies[d3-ONE] += ONE;
        tallies[d4-ONE] += ONE;
        tallies[d5-ONE] += ONE;
        if (tallies[ZERO] == ONE &&
            tallies[ONE] == ONE &&
            tallies[TWO] == ONE &&
            tallies[THREE] == ONE &&
            tallies[FOUR] == ONE)
            return 15;
        return ZERO;
    }

    public static int largeStraight(int d1, int d2, int d3, int d4, int d5)
    {
        int[] tallies;
        tallies = new int[SIX];
        tallies[d1-ONE] += ONE;
        tallies[d2-ONE] += ONE;
        tallies[d3-ONE] += ONE;
        tallies[d4-ONE] += ONE;
        tallies[d5-ONE] += ONE;
        if (tallies[ONE] == ONE &&
            tallies[TWO] == ONE &&
            tallies[THREE] == ONE &&
            tallies[FOUR] == ONE
            && tallies[FIVE] == ONE)
            return 20;
        return ZERO;
    }

    public static int fullHouse(int d1, int d2, int d3, int d4, int d5)
    {
        int[] tallies;
        boolean two = false;
        int i;
        int two_at = ZERO;
        boolean three = false;
        int three_at = ZERO;




        tallies = new int[SIX];
        tallies[d1-ONE] += ONE;
        tallies[d2-ONE] += ONE;
        tallies[d3-ONE] += ONE;
        tallies[d4-ONE] += ONE;
        tallies[d5-ONE] += ONE;

        for (i = ZERO; i != SIX; i += ONE)
            if (tallies[i] == TWO) {
                two = true;
                two_at = i+ONE;
            }

        for (i = ZERO; i != SIX; i += ONE)
            if (tallies[i] == THREE) {
                three = true;
                three_at = i+ONE;
            }

        if (two && three)
            return two_at * TWO + three_at * THREE;
        else
            return ZERO;
    }
}



