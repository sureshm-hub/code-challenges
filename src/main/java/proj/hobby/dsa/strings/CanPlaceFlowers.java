package proj.hobby.dsa.strings;

public class CanPlaceFlowers {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for(int i =0 ;i < flowerbed.length; i++) {
            if(flowerbed[i] == 0) {
                boolean beforeEmpty = i == 0  || flowerbed[i-1] == 0;
                boolean afterEmpty = i == flowerbed.length -1 || flowerbed[i+1] == 0;
                if(beforeEmpty && afterEmpty) {
                    n--;
                    flowerbed[i] = 1;
                }
            }
            if (n <= 0) {
                return true;
            }
        }
        return false;
    }

    public boolean canPlaceFlowersBasic(int[] flowerbed, int n) {
        int empty = 0;
        for(int i =0; i < flowerbed.length ; i++) {
            if(flowerbed[i] == 0) {
                if( i == 0 || i == flowerbed.length -1) {
                    empty++;
                }
                empty++;
            }
            if( n > 0 && flowerbed[i] == 1) {
                if(empty >= 3) {
                    n -= (empty-1)/2;
                }
                empty = 0;
            }
        }
        if(empty >= 3) {
            n -= (empty-1)/2;
        }
        return n <= 0;
    }

    public static void main(String[] args) {

        CanPlaceFlowers fp = new CanPlaceFlowers();
        System.out.println("Can Place Flowers: "+fp.canPlaceFlowers(new int[]{1,0,0,0,1},1));
        System.out.println("Can Place Flowers: "+fp.canPlaceFlowers(new int[]{1,0,0,0,1},2));
        System.out.println("Can Place Flowers: "+fp.canPlaceFlowers(new int[]{0,0,0,0,1},2));
        System.out.println("Can Place Flowers: "+fp.canPlaceFlowers(new int[]{1,0,0,0,0},2));
        System.out.println("Can Place Flowers: "+fp.canPlaceFlowers(new int[]{0,0,0,0,0},3));
        System.out.println("Can Place Flowers: "+fp.canPlaceFlowers(new int[]{0,0,0},2));
        System.out.println("Can Place Flowers: "+fp.canPlaceFlowers(new int[]{0},1));

        System.out.println(" >> Basic");
        System.out.println("Can Place Flowers: "+fp.canPlaceFlowersBasic(new int[]{1,0,0,0,1},1));
        System.out.println("Can Place Flowers: "+fp.canPlaceFlowersBasic(new int[]{1,0,0,0,1},2));
        System.out.println("Can Place Flowers: "+fp.canPlaceFlowersBasic(new int[]{0,0,0,0,1},2));
        System.out.println("Can Place Flowers: "+fp.canPlaceFlowersBasic(new int[]{0,0,0,0,0},3));
        System.out.println("Can Place Flowers: "+fp.canPlaceFlowersBasic(new int[]{0,0,0},2));
    }
}
