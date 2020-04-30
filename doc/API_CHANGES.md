# API Document

## Roulette
1. playRouletteRound
    - Input: HashMap of the betting
        - // 0~36 numbers, 37: red, 38: black, 39: odd, 40: even
    - Output: ResultRoulette
        - winStatus, amountWon, ballPosition, playerBalance

## Blackjack
ResultBlackjack
    - int winStatus
    - int amountWon
    - int playerBalance
//    0: lose, 1: win, 2: tie, 3: not finished

1. startBlackjack
    - Input: Null
    - Output: Dealer's hand, player's hand
        - in list of integers
2. hitBlackjack
    - Input: Dealer's hand, player's hand
    - Output: ResultBlackjack
        - in list of integers
3. stopBlackjack
    - Input: Dealer's hand, player's hand
    - Output: ResultBlackjack
        - winStatus, amountWon, playerBalance, Updated Dealer's hand, player's hand

## Slots
1. playSlots
    - Input: betting lines
        - HashMap<Integer, Integer>
        - 0: top, 1: middle, 2: bottom, 3: tlbr diagonal, 4: bltr diagonal
    - Output: ResultSlot
        - winStatus, amountWon, playerBalance, slotGrid
    
    - Winning price
        - {50, 50, 100, 100, 150, 150, 10000};
        - Can be modified in SlotModel class
    - frequency
        -  {40, 40, 20, 20, 10, 7, 3};
        -  can be modified in Column Class
