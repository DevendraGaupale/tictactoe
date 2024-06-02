package strategies;

import javafx.util.Pair;
import models.Board;

public interface BotPlayingStrategy {
    public Pair<Integer, Integer> getNextMove(Board board);
}
