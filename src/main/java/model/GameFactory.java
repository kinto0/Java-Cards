package model;

/**
 * Factory to create game from string in command line arguments.
 */
public class GameFactory {

    /**
     * Calls the correct game constructor for a given argument.
     * @param game game command line argument
     * @return implementation of game
     */
    public static IGame factoryGame(String game) {
        IGame ret;
        switch(game) {
            case "pres":
                return new President();
            default:
                return new FiftyTwoCardPickup();
        }
    }
}
