package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class GameStatusView {

    private static final String END_GAME_COMMAND = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String ASK_OPINION_COMMAND = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    String opinion;

    public GameStatusView(){
        opinion = "";
    }

    public void askOpinion(){
        System.out.println(END_GAME_COMMAND);
        System.out.println(ASK_OPINION_COMMAND);
    }

    public void readOpinion(){
        opinion = Console.readLine();
    }

    public boolean isNotCorrectAnswer(){
        return false;
    }

    public void alertWrongAnswer(){

    }

    public String getOpinion(){
        return "";
    }
}
