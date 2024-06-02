import controllers.GameController;
import exceptions.InvalidGameConstructionException;
import models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number of players:");
        int num = scanner.nextInt();
        List<Player> players = new ArrayList<>();
        for (int i=0; i<num; i++){
            System.out.println("Enter name of the player #" + (i+1));
            String name = scanner.next();
            System.out.println("Enter symbol for the player #" + (i+1));
            char symbol = scanner.next().charAt(0);
            Player player = new Player(name, symbol);
            players.add(player);
        }

        System.out.println("Should we add a bot? Y/N");
        String addBot = scanner.next();
        if(addBot.equalsIgnoreCase("y")){
            System.out.println("Select bot level? H/M/L");
            String botLevel = scanner.next();
            switch (botLevel){
                case "H":
                    players.add(new Bot("BOT-1", 'B', BotLevel.HIGH));
                    break;
                case "M":
                    players.add(new Bot("BOT-1", 'B', BotLevel.MEDIUM));
                    break;
                case "L":
                    players.add(new Bot("BOT-1", 'B', BotLevel.LOW));
                    break;
                default:
                    players.add(new Bot("BOT-1", 'B', BotLevel.LOW));

            }
        }

        GameController gameController = new GameController();
        Game game;
        try {
            game = gameController.createGame(players);
        } catch (InvalidGameConstructionException e) {
            System.out.println("Invalid game construction exception:" + e.getMessage());
            return;
        }

        while (gameController.getGameStatus(game).equals(GameStatus.IN_PROGRESS)){
            gameController.displayBoard(game);
            gameController.makeMove(game);
        }
    }
}
