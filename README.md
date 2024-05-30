# Card Games Collection

Welcome to the Card Games Collection! This project includes implementations of two card games: Papaz Kimde? and Black Jack. These games were developed as a paired programming task with shared classes for player management, command execution, utilities, computer player logic, card handling, and deck management.

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

- Supports 2-4 players.
- Play with up to 3 computer players or 3 other human players.
- **Objective**: Avoid being the player left with the unpaired queen at the end.

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
- - **Developed by**: Byasar3 (Berna Yasar)

## How to Play

### Papaz Kimde?

1. Choose the number of players (2-4).
2. Decide if you want to play with human players or computer players.
3. The game will start, and players will take turns drawing cards to form pairs.
4. Avoid being left with the unpaired queen to win the game.

### Black Jack

1. Start the game to see the instructions.
2. Play by matching the middle card by suit or rank.
3. Use power cards strategically to gain an advantage. 
4. The first player to get rid of all their cards wins.
5. - **Developed by**: Nx-Makomva (Nic Makomva)

## Shared Classes

The project includes several shared classes that facilitate both games:

- **Player**: Manages player details and actions.
- **CommandRunner**: Executes game commands.
- **Utils**: Contains utility methods used across the games.
- **ComputerPlayer**: Logic for computer-controlled players.
- **Card**: Represents a single card.
- **Deck**: Manages the deck of cards, including shuffling and dealing.

## Replaying Games

At the end of each game, you will have the option to replay the game or switch to the other game. Follow the on-screen prompts to make your selection.





