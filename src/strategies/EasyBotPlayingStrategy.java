package strategies;

import exceptions.InvalidGameStateException;
import javafx.util.Pair;
import models.Board;
import models.Cell;
import models.CellStatus;

import java.util.List;

public class EasyBotPlayingStrategy implements BotPlayingStrategy{

    @Override
    public Pair<Integer, Integer> getNextMove(Board board) {
        for (List<Cell> row : board.getCells()) {
            for (Cell cell : row) {
                if(cell.getCellStatus().equals(CellStatus.AVAILABLE))
                    return new Pair<>(cell.getRow(), cell.getCol());
            }
        }
        throw new InvalidGameStateException("No valid move left for bot");
    }
}
