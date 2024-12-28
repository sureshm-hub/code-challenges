package proj.hobby.dsa;

public class MinFlipsforOr {
    public int minFlips(int a, int b, int c) {
        int count = 0;
        while(a > 0 || b > 0 || c > 0) {
            int abit = a & 1;
            int bbit = b & 1;
            int cbit = c & 1;

            if( (abit |  bbit) != cbit) {
                if(cbit == 0) {
                    if(abit == 1){
                        count++;
                    }
                    if(bbit == 1){
                        count++;
                    }
                }
                if(cbit == 1){
                    count++;
                }
            }
            a >>= 1;
            b >>= 1;
            c >>= 1;
        }
        return count;
    }

    public static void main(String[] args) {
        MinFlipsforOr orFlips = new MinFlipsforOr();
        System.out.println("Min Flips for Or: "+orFlips.minFlips(2,6,5));

        System.out.println("Min Flips for Or: "+ orFlips.minFlips(4,2,7));

        System.out.println("Min Flips for Or: "+orFlips.minFlips(1,2,3));

        //   1000
        //   0011
        //   0101
        System.out.println("Min Flips for Or: "+orFlips.minFlips(8,3,5));
    }
}