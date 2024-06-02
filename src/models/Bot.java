package models;

import factories.BotPlayingStrategyFactory;
import javafx.util.Pair;
import strategies.BotPlayingStrategy;

public class Bot extends Player{

    private BotLevel botLevel;
    private BotPlayingStrategy botPlayingStrategy;

    public Bot(String name, char symbol, BotLevel botLevel) {
        super(name, symbol);
        this.botLevel = botLevel;
        this.botPlayingStrategy = BotPlayingStrategyFactory.getStrategy(botLevel);
    }

    public Pair<Integer, Integer> getNextMove(Board board){
        System.out.println("Bot is making a move:");
        return botPlayingStrategy.getNextMove(board);
    }
}
