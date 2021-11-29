package nextstep.ladder.controller;

import nextstep.ladder.controller.view.InputView;
import nextstep.ladder.controller.view.OutputView;
import nextstep.ladder.domain.gift.Gift;
import nextstep.ladder.domain.gift.GiftBundle;
import nextstep.ladder.domain.ladder.LadderGame;
import nextstep.ladder.domain.ladder.Participant;
import nextstep.ladder.domain.ladder.Positive;
import nextstep.ladder.utils.Parser;

import java.util.List;
import java.util.Map;

public class LadderController {

    private static final String END_CONDITION = "EXIT";
    private static final String PLAY_ALL_CONDITION = "ALL";

    private LadderController() {
    }

    public static void main(String[] args) {
        try {
            start();
        } catch (IllegalArgumentException e) {
            System.out.println("\n잘못된 입력입니다: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("\n잠시후 다시 이용하세요");
        }
    }

    private static void start() {
        LadderGame ladderGame = createLadderGame();
        GiftBundle giftBundle = createGiftBundle();
        ladderGame.checkGiftBundleSize(giftBundle);

        OutputView.showRadderResult(ladderGame, giftBundle);

        keepPlayingUntilEndCondition(ladderGame, giftBundle);
    }

    private static LadderGame createLadderGame() {
        List<Participant> participants = createParticipants();
        Positive height = new Positive(InputView.getHeight());
        return LadderGame.of(participants, height);
    }

    private static List<Participant> createParticipants() {
        List<String> names = Parser.split(InputView.getNames());
        return Participant.listOf(names);
    }

    private static GiftBundle createGiftBundle() {
        List<String> gifts = Parser.split(InputView.getGifts());
        return new GiftBundle(Gift.listOf(gifts));
    }

    private static void keepPlayingUntilEndCondition(LadderGame ladderGame, GiftBundle giftBundle) {
        boolean continued;
        do {
            continued = play(ladderGame, giftBundle);
        } while (continued);
    }

    private static boolean play(LadderGame ladderGame, GiftBundle giftBundle) {
        String target = InputView.getTarget();

        if (END_CONDITION.equalsIgnoreCase(target)) {
            return false;
        }

        if (PLAY_ALL_CONDITION.equalsIgnoreCase(target)) {
            playAll(ladderGame, giftBundle);
            return true;
        }

        play(ladderGame, giftBundle, new Participant(target));
        return true;
    }

    private static void playAll(LadderGame ladderGame, GiftBundle giftBundle) {
        Map<Participant, Gift> playAllResults = ladderGame.playAllGame(giftBundle);
        OutputView.showWinningGiftsWithParticipant(playAllResults);
    }

    private static void play(LadderGame ladderGame, GiftBundle giftBundle, Participant participant) {
        Gift winningGift = ladderGame.playGame(participant, giftBundle);
        OutputView.showWinningGift(winningGift);
    }

}