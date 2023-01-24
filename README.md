# OOP-Adventure-Game

# Aim
Using an adventure game to demonstrate OOP principles

Principles demonstrated: Inheritance, Polymporhism, Liskovs Substitution Principle, Objects etc

Preferably, run in intelliJ IDE to preserve terminal colour coding else, run _"Initialise.java"_ to start the game

# Gameplay

## Town Info
```
NAME:John
ATTACK:10[DMG]
HP:100%

What Town Would You Like To Travel To?
---------------------------
Town ---> |Bind|
There is a Monster Jonsa with 100HP [ALIVE]
There is a Magician Landrover present... He could be good or bad. You'll have to risk it for a biscuit! [2 (TRIES/TRY) LEFT]
There's a weapon present. Pick it up to find out more... [1 (EQUIP/EQUIPS) LEFT]
A potion with a health boost of up to 35 health is present. [2 (POTION/POTIONS) LEFT]
---------------------------
Town ---> |Trope|
There is a Monster Kulum with 100HP [ALIVE]
There is a Magician Tyron present... He could be good or bad. You'll have to risk it for a biscuit! [2 (TRIES/TRY) LEFT]
There's a weapon present. Pick it up to find out more... [1 (EQUIP/EQUIPS) LEFT]
A potion with a health boost of up to 35 health is present. [2 (POTION/POTIONS) LEFT]
---------------------------
Town ---> |Azaar|
There is a Warrior Desdrick with 138HP [ALIVE]
There is a Magician Falqway present... He could be good or bad. You'll have to risk it for a biscuit! [2 (TRIES/TRY) LEFT]
There's a weapon present. Pick it up to find out more... [1 (EQUIP/EQUIPS) LEFT]
A potion with a health boost of up to 35 health is present. [2 (POTION/POTIONS) LEFT]
---------------------------
Town ---> |Fracture|
There is a Warrior Erq with 148HP [ALIVE]
There is a Magician Falqway present... He could be good or bad. You'll have to risk it for a biscuit! [2 (TRIES/TRY) LEFT]
There's a weapon present. Pick it up to find out more... [1 (EQUIP/EQUIPS) LEFT]
A potion with a health boost of up to 35 health is present. [2 (POTION/POTIONS) LEFT]
---------------------------
Town ---> |Haven|
There is a Monster Erq with 100HP [ALIVE]
There is a Magician Landin present... He could be good or bad. You'll have to risk it for a biscuit! [2 (TRIES/TRY) LEFT]
There's a weapon present. Pick it up to find out more... [1 (EQUIP/EQUIPS) LEFT]
A potion with a health boost of up to 35 health is present. [2 (POTION/POTIONS) LEFT]
---------------------------
```
## Town Interactions
```
[A] Fight Enemy 
[B] Try Magician 
[C] Equip Weapon 
[D] Drink Potion 
[E] Leave Town 
[F] View Inventory 
[Q] Quit
```
## Synopsis
```
- 🔥The aim of the game is to kill all enemies.
- Towns are randomly generated. There is a chance a Monster or Warrior could spawn.
- 🔥You have an attack stat which can be increased by picking weapons up.(Maximum Interaction is 1 per town)
- NOTE that the weapon present in a town is probability based (Higher chance of lower DMG weapons spawning)
- Magicians are present in each town but are randomised. So interact wisely...
* There are bad Magicians which possess bad charm attributes which will decrease your HP.
* Good Magicians do the opposite.
* Maximum Interaction is 2 per magician in each town.
- ⚔ Warriors are stronger than Monsters (Higher HP and Higher DMG). Tread Carefully!
- ⚗️Potions are present too. But beware... Toxic potions can suppress your attack stat. Normal potions will increase your health.
* Maximum Interaction is 2 per town.
```
