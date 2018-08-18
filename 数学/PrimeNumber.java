import java.util.BitSet;

class PrimeNumber {
    public static void main(String[] args) {
        prime();
    }

    // 找素数 , 0和1不是素数
    @Test
    public static void prime() {
        final int maxnum = 1000;
        final BitSet bs = new BitSet(maxnum);

        for (int i = 2; i <= maxnum; i++) {

            int j = 2;
            while (true) {
                final int x = i * j;
                if (x > maxnum)
                    break;
                bs.set(x);
                j++;
            }
        }

        for (int i = 2; i <= maxnum; i++) {
            if (!bs.get(i))
                System.out.println(i);
        }

    }

}