import java.util.ArrayList;

public class Dealer {
    public int sum;
    ArrayList<String> cards; // 가지고 있는 카드 리스트
    String secretCard;

    public Dealer() {

        cards = new ArrayList<>();

    }

    // 가지고 있는 카드들의 전체 합을 계산하는 메소드
    public int calculateSum() {
        int cal_sum = 0;
        for (String card : cards) {
            int value = getValue(card);
            cal_sum += value;
        }
        return cal_sum;
    }

    // 카드의 값에 따라 숫자로 변환하여 반환하는 메소드
    private int getValue(String card) {
        String rank = card.substring(0, card.length() - 3); // 카드의 랭크 부분 추출
        if (rank.equals("A")) {
            return 11; // Ace는 11로 계산
        } else if (rank.equals("K") || rank.equals("Q") || rank.equals("J")) {
            return 10; // King, Queen, Jack은 10으로 계산
        } else {
            return Integer.parseInt(rank); // 숫자 카드는 해당 숫자로 계산
        }
    }
}
