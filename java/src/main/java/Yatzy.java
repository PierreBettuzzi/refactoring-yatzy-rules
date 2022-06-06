
public class Yatzy {

    private static final int FOUR = 4;
	private static final int THREE = 3;
	private static final int TWO = 2;
	private static final int ONE = 1;
	private static final int FIVE = 5;
	private static final int SIX = 6;
	private static final int ZERO = 0;
	public static int chance(int d1, int d2, int d3, int d4, int d5)
    {
        int total = ZERO;
        total += d1;
        total += d2;
        total += d3;
        total += d4;
        total += d5;
        return total;
    }

    public static int yatzy(int... dice)
    {
        int[] counts = new int[SIX];
        for (int die : dice)
            counts[die-ONE]++;
        for (int i = ZERO; i != SIX; i++)
            if (counts[i] == FIVE)
                return 50;
        return ZERO;
    }

    public static int ones(int d1, int d2, int d3, int d4, int d5) {
        int sum = ZERO;
        if (d1 == ONE) sum++;
        if (d2 == ONE) sum++;
        if (d3 == ONE) sum++;
        if (d4 == ONE) sum++;
        if (d5 == ONE) 
            sum++;

        return sum;
    }

    public static int twos(int d1, int d2, int d3, int d4, int d5) {
        int sum = ZERO;
        if (d1 == TWO) sum += TWO;
        if (d2 == TWO) sum += TWO;
        if (d3 == TWO) sum += TWO;
        if (d4 == TWO) sum += TWO;
        if (d5 == TWO) sum += TWO;
        return sum;
    }

    public static int threes(int d1, int d2, int d3, int d4, int d5) {
        int s;    
        s = ZERO;
        if (d1 == THREE) s += THREE;
        if (d2 == THREE) s += THREE;
        if (d3 == THREE) s += THREE;
        if (d4 == THREE) s += THREE;
        if (d5 == THREE) s += THREE;
        return s;
    }

    protected int[] dice;
    public Yatzy(int d1, int d2, int d3, int d4, int _5)
    {
        dice = new int[FIVE];
        dice[ZERO] = d1;
        dice[ONE] = d2;
        dice[TWO] = d3;
        dice[THREE] = d4;
        dice[FOUR] = _5;
    }

    public int fours()
    {
        int sum;    
        sum = ZERO;
        for (int at = ZERO; at != FIVE; at++) {
            if (dice[at] == FOUR) {
                sum += FOUR;
            }
        }
        return sum;
    }

    public int fives()
    {
        int s = ZERO;
        int i;
        for (i = ZERO; i < dice.length; i++) 
            if (dice[i] == FIVE)
                s = s + FIVE;
        return s;
    }

    public int sixes()
    {
        int sum = ZERO;
        for (int at = ZERO; at < dice.length; at++) 
            if (dice[at] == SIX)
                sum = sum + SIX;
        return sum;
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

    public static int four_of_a_kind(int _1, int _2, int d3, int d4, int d5)
    {
        int[] tallies;
        tallies = new int[SIX];
        tallies[_1-ONE]++;
        tallies[_2-ONE]++;
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
        boolean _2 = false;
        int i;
        int _2_at = ZERO;
        boolean _3 = false;
        int _3_at = ZERO;




        tallies = new int[SIX];
        tallies[d1-ONE] += ONE;
        tallies[d2-ONE] += ONE;
        tallies[d3-ONE] += ONE;
        tallies[d4-ONE] += ONE;
        tallies[d5-ONE] += ONE;

        for (i = ZERO; i != SIX; i += ONE)
            if (tallies[i] == TWO) {
                _2 = true;
                _2_at = i+ONE;
            }

        for (i = ZERO; i != SIX; i += ONE)
            if (tallies[i] == THREE) {
                _3 = true;
                _3_at = i+ONE;
            }

        if (_2 && _3)
            return _2_at * TWO + _3_at * THREE;
        else
            return ZERO;
    }
}



