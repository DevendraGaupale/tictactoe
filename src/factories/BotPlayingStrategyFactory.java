package factories;

import models.BotLevel;
import strategies.BotPlayingStrategy;
import strategies.EasyBotPlayingStrategy;
import strategies.HighBotPlayingStrategy;
import strategies.MediumBotPlayingStrategy;

public class BotPlayingStrategyFactory {

    public  static BotPlayingStrategy getStrategy(BotLevel botLevel){
        switch (botLevel){
            case LOW:
                return new EasyBotPlayingStrategy();
            case HIGH:
                return new HighBotPlayingStrategy();
            case MEDIUM:
                return new MediumBotPlayingStrategy();
        }
        throw new UnsupportedOperationException("Bot type" + botLevel + "is not supported");
    }
}
