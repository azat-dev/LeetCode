class Solution {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        
        // Преобразование массивов в множества
        Set<Integer> s1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> s2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());
        Set<Integer> s3 = Arrays.stream(nums3).boxed().collect(Collectors.toSet());

        // Создание копии множеств для нахождения пересечений
        Set<Integer> items12 = new HashSet<>(s1);
        
        // Нахождение пересечений s1 и s2
        items12.retainAll(s2);

        // Нахождение пересечений s1 и s3
        s1.retainAll(s3);

        // Нахождение пересечений s2 и s3
        s2.retainAll(s3);

        // Объединение всех найденных пересечений в одно множество
        items12.addAll(s1);
        items12.addAll(s2);

        // Преобразование результата в список и возврат
        return new ArrayList<>(items12);
    }
}