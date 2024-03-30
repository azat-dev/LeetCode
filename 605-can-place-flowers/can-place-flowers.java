class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        if (n == 0) {
            return true;
        }

        for (int i = 0; i < flowerbed.length; i++) {

            final var value = flowerbed[i];

            if (value == 1) {
                i++;
                continue;
            }

            final var isNextEmpty = i + 1 < flowerbed.length ? flowerbed[i + 1] == 0 : true;
            final var isPrevEmpty = i - 1 >= 0 ? flowerbed[i - 1] == 0 : true;

            if (isPrevEmpty && isNextEmpty) {
                flowerbed[i] = 1;
                n--;
                i++;

                if (n == 0) {
                    return true;
                }
            }
        }

        return false;
    }
}