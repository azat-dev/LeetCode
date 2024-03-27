class Solution {
    public String customSortString(String order, String s) {
        
        final var items = new HashMap<Character, StringBuilder>();

        for (int i = 0; i < s.length(); i++) {

            final var ch = s.charAt(i);
            var sb = items.get(ch);

            if (sb == null) {
                sb = new StringBuilder();
            }

            sb.append(ch);
            items.put(ch, sb);
        }

        final var sb = new StringBuilder(items.size());

        for (int i = 0; i < order.length(); i++) {

            final var ch = order.charAt(i);
            final var item = items.get(ch);

            if (item == null) {
                continue;
            }

            sb.append(item);
            items.remove(ch);
        }

        for (Character ch : items.keySet()) {

            final var item = items.get(ch);

            if (item == null) {
                continue;
            }

            sb.append(item);
        }

        return sb.toString();
    }
}