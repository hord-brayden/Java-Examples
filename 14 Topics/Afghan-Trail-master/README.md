# Afghan Trail      
## Description
Afghani Trail is a text based role-playing game based on the popular Oregon Trail game. The game is about escaping from the taliban, and trying to maneuver through modern day Afghanistan unnoticed by the oppressive AL-Qaeda based operatives. The player assumes the role of a pilgrim, or rural farmer guiding a party of settlers from Kandahar, Afghanistan, into Afghanistan's northern province called Herat, in attempts to relocate away from NATO and coalition fighting for control of the region, and ultimately escape and seek asylum within Iran. The player will try to start a new life by settling in Herat, or potentially seeking asylum in Iran. Along the way the player can make decisions, shop for supplies or rest. In starting town, Kandahar, players can shop for their supplies.

After player buys their supply and equipment, player will start their journey to the south eastern steppes of Afghanistan, off to Iran. Players are required to carry food for their entire journey, in addition to medicine, ammunition to hunt local wildlife, and defend themselves from extremists. An important aspect of the game is the ability to hunt. Using guns and bullets bought over the course of play, players will be able hunt wild animals to add to their food reserves, in addition to killing muslim extremists.

Along the way characters will be experiencing illnesses and even death. The party could die from various causes, such as measles, malaria, exhaustion, typhoid, cholera, and, dysentery. The wagon could break down in the journey and player is required to fix it. Players must also plan carefully and stock their supplies as needed. The players task is simple, to take their party to Herat with adequate supplies to survive the journey. The game is over when the party reaches the destination, or they succumb to terrorists or an otherwise grim end.
List of end user stories -
Here is the list of end user stories or scenes that are needed for the game:

·         Start the program
·         Main menu
·         Guide
·         Start a new game
·         Load a game
·         Check your party health
·         Check your inventory
·         Set your travel pace
·         Hunt
·         Trade with in game characters
·         Save the game
·         View wagon status
·         Buy supplies
·         Dump supply or inventory

## Description of end user stories
### Start program 
The player opens the program to initiate the game. The computer displays main menu. Players could choose between starting a new game, loading their previous saved game, exiting the game, or viewing the game guide.
Main menu
Displays the following menu:

W - Start game
A - Load game
S - Exit
D - Guide

The player then clicks one of the options. The computer will display the selected option. The program terminates when Exit is selected.

### Game guide
The following menu is displayed:

·         The goal of the game
·         How to move
·         How to hunt
·         How to check party’s health
·         How to trade
·         How to set travel’s pace

### Start game
The computer will display a welcome screen and ask the player to fill out information such as:           
- Name of the party leader (username)
- Their profession, for example: banker, carpenter, blacksmith, farmer.

After players have finished filling out the information required to start the game the computer will display the prologue screen and a little bit of background story. At this point, it will start the game.

### Event Specific Menus
**Master Key** 
Ignore - Ignore current event, and proceed to the next part of the trail towards the end of the game.
Rest - Wait to make the decision, however the game will potentially have a 50% chance of creating a new event, positive or negative, during the time in which you will be waiting that can occur to your party.


**Death Event Menu** 
Occurs when your party all perishes, and forces you to the main menu to start a game, or load a game.
W - Back to Main Game Menu

**Disease Contraction Event Menu** 
W - Leave afflicted member to die - The afflicted party member gets left behind, and is deleted from your party list. It also continues you towards the completion of the game.
A - Administer First Aid - Checks if you have any medicine, and if so, administers medicine on the afflicted party member,  It also continues you towards the completion of the game. If you do not have medicine, it gives you the invalid command, and pushes you back to the Disease Contraction Event Menu.
S - Ignore
D - Rest

**Broken Wagon Event Menu** 
W - Fix Wagon - Uses Spare parts located in the inventory of the party to attempt and fix the wagon. If party does not have adequate spare parts, proceed to death event screen. 

**Obstacle Choice Event Menu**
W - Navigate Obstacle - Proceed through the obstacle, and there is a 50% chance to break your wagon. If wagon breaks, proceed to the Broken Wagon Event Menu. After completion, proceeds to the next phase of the map.
A - Go Around - Time delay, but a safer option as opposed to Navigate obstacle. To compensate for the time delay, there is a 25% chance that you will encounter another random event while circumnavigating the river. After completion, proceeds to the next phase of the map.
S - Ignore
D - Rest

**Hunting Choice Event Menu**
W - Attempt Hunt - Start out with a base chance of 20%, then take into account the Party’s total stamina which contributes to the chance of a successful hunt, also uses 10% of party’s ammunition, and creates a equivalent amount of Meat compared to the ammunition expenditure. After hunt, it expends 5% of party’s stamina, no matter the outcome. After completion, proceeds to the next phase of the map.
S - Ignore
D - Rest

**Party Attacked by Terrorists Event Menu**
W - Fight - Start out with a base chance of a 15% chance of succeeding in the encounter. Tehn take into account the party’s total stamina, which will contribute to the chance of a successful fight. 20% of the party’s ammunition will be expended, in addition to 20% of the party’s stamina after a fight, if it ends in success. If the party fails after the equation is ran by the system, the game is over. 
A - Flee - Start with a base chance of 20%, then take into account whether the wagon is broken or not (wagon broken = divide chances in half) multiplied by the party’s stamina. If flee is unsuccessful, game over, otherwise, there is a 50% chance of dropping items, After completion, proceeds to the next phase of the map.
S - Surrender- Game Over

**Character Death Event Menu**
S - Ignore 
D - Rest

**Trading W/Shopkeeper Event Menu** (Once a player enters a town, it immediately goes to the shopkeeper prompt)
W - Buy: shows shopkeeper inventory and value
	W - Choose item to buy (W = item first distinguishing letter)
A  - Exit (goes back a menu)
D- Rob: Attempt to kill the shopkeeper
	-Always die, proceed to game over screen.
E - Guess the volume of the box to win its contents: Shopkeeper presents a box with a specified length width and height and asks you to input the correct volume (random value between 1-5 = length, random value between 1-5 = width, random value between 1-5 = height).
S - Sell: shows user inventory and values
A - Leave - After completion, proceeds to the next phase of the map.
Q - Save - Save Game, then kicks user back to the same menu.


**Invalid Commands**
Whenever an end user enters an invalid command, or uses a command that is not available to be used during that phase of the game, it will return a message, prompting the user to try another command that is applicable during that game phase. 

·         Return - “INVALID COMMAND, TRY AGAIN”

## In-game menu

**O - Guide**
The computer will display complete game guide that the player needed throughout the game just like the guide displayed in main menu such as:
·         The goal of the game
·         How to move
·         How to hunt
·         How to check party’s health
·         How to set travel’s pace


**P - Party health**
The computer will display the list of the members name and their overall health. It will also show their health status such as illness and stamina (or tiredness level).
	Party Member
Health
Stamina
I - Inventory
The computer will display the inventory of the characters in the party. You can then choose to:
D - Drop Item(s)
A - Exit Inventory Screen

**TYPES OF INVENTORY**
- Food 
- Ammunition
- Medicine
- Spare Parts



**U - Map**
Displays the current map progress 

                   ,-.^._                 _
       Iran  __            .'      `-.            ,' ;
               \/`-.  ,----' ________ `-.   _  ,-.,'  `
             _.'\  `--'     /   ^^   \  `-' '-'      ;
            :    \  _______/ ^ ^^^^    o             ;    __,-.
            ,'    o          ^   Mazar-i-Sharif       ;_,-',.__'--.
           :    Herat       ^^          \            ,--```    `--'
           :                ^^           \         ;
           :             ^^^^^       ^^   |        :
           ;         ^  ^ ^ ^        ^^^  |       :
          (       ^ ^ ^ ^             __  |       ;
           `-.    ^ ^ ^ ^       _____/   *      ,'
             ;    ^ ^ ^        /       Kabul   :
           .'    ^  ^         /  ^^^      .-._,'
         .'                  /    ^       `.
      _.'                   /            .__;
      `._                  o            ;
         `.             Kandahar       :    
           `.               ,..__,---._;    
             `-.__         :                
                  `.--.____;   
 
                                           
                                           




 
