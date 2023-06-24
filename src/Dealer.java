public class Dealer {
    private int sum = 0; // 가지고 있는 카드의 합
    String[] cards = {}; // 가지고 있는 카드 리스트

    public Dealer() {
    }

    // 가지고 있는 카드들의 전체 합을 계산하는 메소드
    public int calculateSum() {
        sum = 0;
        for (String card : cards) {
            int value = getValue(card);
            sum += value;
        }
        return sum;
    }

    // 카드의 값에 따라 숫자로 변환하여 반환하는 메소드
    private int getValue(String card) {
        String rank = card.substring(0, card.length() - 1); // 카드의 랭크 부분 추출
        if (rank.equals("A")) {
            return 11; // Ace는 1로 계산
        } else if (rank.equals("K") || rank.equals("Q") || rank.equals("J")) {
            return 10; // King, Queen, Jack은 10으로 계산
        } else {
            return Integer.parseInt(rank); // 숫자 카드는 해당 숫자로 계산
        }
    }
}
