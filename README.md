# Card Games Collection

Welcome to the Card Games Collection! 
This project includes implementations of two card games: Papaz Kimde? and Black Jack. 
These games were developed as a paired programming task with shared authorship of classes for player management, command execution, utilities, computer player logic, card handling, and deck management.

## Table of Contents

- [Features](#features)
    - [Papaz Kimde?](#papaz-kimde)
    - [Black Jack](#black-jack)
- [How to Play](#how-to-play)
    - [Papaz Kimde?](#papaz-kimde)
    - [Black Jack](#black-jack)
- [Shared Classes](#shared-classes)
- [Replaying Games](#replaying-games)

## Features

### Papaz Kimde?

- Player 1 is always a human player, you.
- Supports 2-4 more players.
- Play with up to 3 other computer players or 3 other human players.
- 3 kings will be removed from deck, leaving only 1.
- Deck will be shuffled and dealt evenly among players.
- **Objective**: Goal is to get rid of all your cards and avoid being the player left with the unpaired king at the end.
- **Developed by**: [Berna Yasar](https://github.com/Byasar3)

### Black Jack

- Play against smart-mouthed computer players.
- Each player is dealt 7 cards, with one random card placed in the middle.
- Match the middle card by suit or rank to play your cards.
- Special power cards with unique effects:
    - **Aces**: Change the suit and can be played on anything.
    - **Twos**: Make the next player skip their turn and pick up two cards, unless they can also play a two.
    - **Black Jacks**: Make the next player pick up five cards, countered only by red jacks.
    - **Queens**: Must be covered with another card, any card can be used.
- **Objective**: Get rid of your cards as quickly as possible.
- **Developed by**: [Nic Makomva](https://github.com/Nx-Makomva)

## How to Play

Clone this repository to where you'd like to store the game:

``` https://github.com/Nx-Makomva/card-game.git ```

Open the file `card-game` in your chosen IDE and run from `Main`. The game should start running in the IDE's terminal.

### Papaz Kimde?

1. Choose the number of players (2-4).
2. Decide if you want to play with human players or computer players.
3. On your turn, you can pull a card from the next player. You'll be prompted to select a card from the next player's hand by entering its corresponding number.
(If it is a computer player's turn, a random card will be chosen after a short delay)
4. After pulling a card, if you have any pairs, these pairs will automatically be removed from your deck.
5. If you finish your cards with out the unpaired king, you win! 

### Black Jack

1. Start the game to see the instructions.
2. Play by matching the middle card by suit or rank.
3. Use power cards strategically to gain an advantage. 
4. The first player to get rid of all their cards wins.

## Shared Classes

The project includes several shared classes written by both authors that facilitate both games:

- **Player**: Manages player details and actions.
- **CommandRunner**: Executes game commands.
- **Utils**: Contains utility methods used across the games.
- **ComputerPlayer**: Logic for computer-controlled players.
- **Card**: Represents a single card.
- **Deck**: Manages the deck of cards, including shuffling and dealing.

## Replaying Games

At the end of each game, you will have the option to replay the game or switch to the other game. Follow the on-screen prompts to make your selection.

--------------

## Authors: 

[Berna Yasar](https://github.com/Byasar3) and [Nic Makomva](https://github.com/Nx-Makomva)
