# Kyle's Playing Card Game(s)
A quick framework for playing (currently command-line only) card games from a jar.

### To build
`gradlew build`

This should create a JAR file playable by java -jar kp-engineering-challenge.jar
### To play the game
`jav -jar build/libs/kp-engineering-challenge-1.0.jar {game}` where game is either `52` or `pres`.

####President
A card game where everyone is dealt equally and the players go around placing cards in the middle until they run out. Players must play a card equal or higher than the card before it, and playing an equal card will skip the next player. My version has no support for "filling" or doubles or triples rounds. More information available [here](https://bicyclecards.com/how-to-play/presidents/). 

####52 Card Pickup
Pick up cards until they have all been picked up. 

####Others
Because of the easy to implement IGame framework, anyone can create a new implementation of a game. The only things necessary are implement IGame and add your game to the `GameFactory`.

### To test
`gradlew test`

Most tests have not been written yet. There should be more tests. 
 
# Design
My software architecture follows the MVC design pattern. My model is the interface `IGame`, my view is the interface `IView`, and my controller is the interface `IController`. I chose this pattern because of it's simple ability to scale in the future. If I ever decide to instead create a GUI for my game, I can easily create another implementation of my view accordingly.   
###Card
A Card is a data structure consisting of a value (integer), name (String), and suit (enum). My implementation included a standard set of playing cards and suits, but it can be extended to include any type of card.
###Deck
A deck is an interface for operating on groups of `Card`s. My implementation `StandardCardDeck` included 52 cards, 13 of each suit: 1-10, J, Q, K, A with Ace having a value higher than the rest. 
The operations available on a deck include shuffle, pop, peek, push, among others. Documentation available as a Javadoc. 
###IGame
The game consists of a queue of `IGameAction`s added to the controller. To create a new game, you must add Actions to the controller's queue, with each happening sequentially. Each action has instructions and a callback for the result of the action. It it's current implementation, the view provides user input and calls the callback. The controller handles queueing all the actions and enabling everything to work smoothly together.

FiftyTwoCardPickup uses one strategy of adding actions by adding all 52 at the beginning. This works well in a game where actions are known before the player starts. 

In a more complicated game, there are actions that are the result of other actions. In the example President, we use a recursive strategy to add actions to the game until we reach our basecase.  
# Choices
I chose Java as a language partly because of my strong background in it. A great advantage to Java is that it is strongly typed with support for interfaces, making it easy to create a simple MVC architecture while ensuring types are maintained. It has support for Javadocs to create easy documentation. JUnit and Mockito for testing are the most supported libraries so I chose those for that reason. I had worked with Gradle in the past so I decided to use it for my dependencies. Lombok is a great tool for making creating POJOs easier. 