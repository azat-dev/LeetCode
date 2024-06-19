class Solution {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        
        final var s1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        final var s2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());
        final var s3 = Arrays.stream(nums3).boxed().collect(Collectors.toSet());

        final var items12 = new HashSet(s1);
        items12.retainAll(s2);

        s1.retainAll(s3);
        s2.retainAll(s3);

        items12.addAll(s1);
        items12.addAll(s2);

        return new ArrayList<>(items12);
    }
}