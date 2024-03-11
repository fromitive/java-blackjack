package domain.constant;

import static domain.constant.BlackJackGameConfig.BUST_THRESHOLD;

public enum GamerResult {
    WIN("승"),
    DRAW("무"),
    LOSE("패");
    private final String result;

    GamerResult(String result) {
        this.result = result;
    }

    public static GamerResult judge(int dealerScore, int playerScore) {
        if (playerScore > BUST_THRESHOLD || (dealerScore <= BUST_THRESHOLD && dealerScore > playerScore)) {
            return GamerResult.WIN;
        }
        if (dealerScore > BUST_THRESHOLD || dealerScore < playerScore) {
            return GamerResult.LOSE;
        }
        return GamerResult.DRAW;
    }

    public GamerResult getOpponentGameResult() {
        if (this.equals(GamerResult.WIN)) {
            return GamerResult.LOSE;
        }
        if (this.equals(GamerResult.LOSE)) {
            return GamerResult.WIN;
        }
        return GamerResult.DRAW;
    }

    public String getResult() {
        return result;
    }
}
