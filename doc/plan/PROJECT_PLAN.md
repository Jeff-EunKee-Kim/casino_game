# Project Plan
- Write your plan for how to manage and prioritize the project in a single file, PROJECT_PLAN.md, that describes the APIs each team member plans to take primary and secondary responsibility for and a rough timeline of how the team will order the work to complete the program. Specifically, each person should take responsibility for specific features and use cases they intend to work on during each Sprint. This requires the team to agree on the feature priorities and set goals for what to complete at the end of each Sprint (i.e., each week).
- Jeff
    - Primary: Player module (betting, buying)
    - Secondary: Integration 
    - Sprint 1: 
        - Player should have an account to keep track of their money balance
        - Player should be able to buy chips with money
        - Player should be able to place bets and keep track of their bets
    - Sprint 2: 
        - Create an AI player to play against each other 
        - Fix bugs and refine code

- Vincent
    - Primary Responsibility: Casino module
    - Secondary: Flexible - wherever needs help
    - Sprint 1: 
        - Implement enumerated values for different games
        - Random values can be drawn
    - Sprint 2: 
        - Finish implementing game logic
- Aparimeya
    - Primary Responsibility: Front End
    - Secondary: Integrating 
    - Sprint 1: 
        - Main event loop
        - Start selection menu
        - UI and functionality for one game
    - Sprint 2: 
        - UI and functionality for another game
        
- Celine
    - Primary Responsibility: game module
    - Secondary: Help whenever needed
    - Sprint 1: 
       - Implement abstract game to be extended by other games
       - Start roulette winnings
       - Determine if the player has won or lost
       - Update both player and casino modules
       - Start roulette winnings
    - Sprint 2:
       - Complete roulette, black jack, and slot machine winnings
       - Complete interaction between game and front end


# APIs
- selectGame
    - Select the game chosen by the player 
- startGame
    - Initialize the selected game
- stopGame
    - Stop all running animation
- saveGame
    - Will save the player balance
    - Will save the game status
- loadGame
    - Load the saved status of the game 
- makePlayer
    - Make new players who can play the game 
- buyChips
    - Exchange money with chips that could be used in placing bets
- placeBet
    - Place bets in current games 
- runRound
    - Go on to the next stage for each respective game
    - Blackjack: Draw next card
    - Roulette: Run the roulette
    - Slot: Run the slot 
    
# API Examples

- Exchange money for tokens at the exchange booth
```java
buyChips(int amount)
```

- Quit current game for new game
```java
stopGame()
selectGame()
startGame()
```

- There should be 3 types of chips, $1, $5, and $10 which user can use to bet
```java
placeBet(int one, int five, int ten)
```

- The user can win money if all images are the same in the slot machine game
```java
runRound()
// victory conditions and earning tokens should be built-in
```
