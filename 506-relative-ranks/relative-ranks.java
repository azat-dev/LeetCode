class Solution {

    private record Item(int athleteIndex, int score) {}

    private String getMedalForPlace(int place) {

        switch (place) {
            case 1:
                return "Gold Medal";
            case 2:
                return "Silver Medal";
            case 3:
                return "Bronze Medal";
            default:
                return String.valueOf(place);
        }
    }

    public String[] findRelativeRanks(int[] score) {
        
        final var maxHeap = new PriorityQueue<Item>(
            score.length,
            (a, b) -> {
                return -(a.score() - b.score());
            } 
        );

        for (int i = 0; i < score.length; i++) {
            final var item = new Item(i, score[i]);
            maxHeap.add(item);
        }

        final var result = new String[score.length];
        int place = 1;

        while (!maxHeap.isEmpty()) {

            final var item = maxHeap.poll();
            result[item.athleteIndex()] = getMedalForPlace(place);
            place++;
        }

        return result;
    }
}