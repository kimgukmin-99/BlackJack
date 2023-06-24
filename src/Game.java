import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.Scanner;
public class Game {
    Dealer dealer;
    Player player;
    Deck deck;
    Scanner scanner = new Scanner(System.in);
    boolean check = true;
    public final int BUSTED_NUM = 21;
    public final int DEALER_NUM = 17;
    public Game(){

        dealer = new Dealer();
        player = new Player();
        deck = new Deck();
        dealer.cards.add(deck.pop());
        dealer.cards.add(deck.pop());
        player.cards.add(deck.pop());
        player.cards.add(deck.pop());
        //딜러의 카드 하나 가려서 보여주기
        // check이 false이면 s입력이므로 반복문 탈출
        while (check){
            check = turn();
            player.sum = player.calculateSum();
            if(player.sum > BUSTED_NUM){
                printBoard();
                System.out.println("Dealer Wins...");
                break;

            }//플레이가 버스트될 경우
            //플레이어 스탠 할때
            if(!check){
                boolean check2 = true;
                dealer.sum = dealer.calculateSum();
                if(dealer.sum < DEALER_NUM){
                    while(dealer.sum < DEALER_NUM){
                        dealer.cards.add(deck.pop());
                        dealer.sum = dealer.calculateSum();
                    }
                }
                while(check2){
                    printBoard();
                    System.out.print("Hit or Stand?  (H/S): ");
                    String input = scanner.next();
                    check2 = isCheck(input, check2);
                    dealer.sum = dealer.calculateSum();
                    if(dealer.sum > BUSTED_NUM){
                        break;
                    }
                }
                int dealerScore = BUSTED_NUM - dealer.sum;
                int playerScore = BUSTED_NUM - player.sum;
                if(dealerScore > playerScore){
                    System.out.println("Player Win...");
                    break;
                }
                else if(playerScore > dealerScore){
                    System.out.println("Dealer Win...");
                    break;
                }
                else{
                    System.out.println("Draw...");
                    break;
                }
            }
        }

    }

    public boolean isH(String input) {
        return input.equalsIgnoreCase("H");
    }
    public boolean isS(String input) {
        return input.equalsIgnoreCase("S");
    }
    public boolean turn(){
        boolean check = true;
        printBoard();
        System.out.print("Hit or Stand?  (H/S): ");
        String input = scanner.next();
        return isCheck(input, check);
    }
    public void printBoard(){
        System.out.print("-------------");
        System.out.print("Jack's BlackJack Game");
        System.out.print("-------------");
        System.out.println();
        System.out.print("# Dealer: ");
        for(String card : dealer.cards){
            System.out.print(card + "  ");
        }
        System.out.println();
        System.out.print("# Player: ");
        for(String card : player.cards){
            System.out.print(card + "  ");
        }
        System.out.println();
        System.out.println("-----------------------------------------------");
    }
    public boolean isCheck(String input, boolean check){
        if(isH(input)){player.cards.add(deck.pop());
        }
        else if(isS(input)){check = false;
        }
        else{System.out.println("잘못입력하셨습니다. ");
        }

        return check;
    }

}
