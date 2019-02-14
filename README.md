# Projet3: Mastermind et PlusouMoins

## Introduction

Ce projet permettent de choisir différentes jeux (Mastermind, Plus ou Moins) ainsi que son mode.   
Mode de jeu: attaque, defense, versus.

Les configurations du jeu seront demandées lors du démarrage (ex: choix du jeu, mode de jeu, étendue, taille du code..).  


## Installation

1. Mon projet a été développé sur l'IDE: éclipse; le jdk utilisé est jdk 1.8.0-191  

2. Chercher le code source du projet3 sur mon dépot github : [github] (https://github.com/victorle876/projet3.git)  

3. Installer les packages api log4j suivants dans le dossier lib de l'IDE et le push-commit dans github . 
packages utilisées: log4j2-api.2.11.1.jar et log4j2-core.2.11.1.jar .   


## Mode d'emploi

1. Tout d'abord, il faut vérifier que vous avez une fenêtre console dans l'IDE Eclipse

2. Il faut compiler sur l'IDE et vérifier que vous avez ces messages suivants:

2019-02-14 15:30:41,378 main WARN Attempt to rename file MainClass.log to itself will be ignored
2019-02-14 15:30:41,381 main WARN Attempt to rename file Aide.log to itself will be ignored
Voulez vous changer la configuration du jeu ? Non (1) ou oui (2) ou (3) utiliser paramètres  

3. Pour démarrer le jeu, il faut faire le choix 2 pour initialiser les paramètres du jeu.  
* 1 signifie que vous utilisez les paramètres du jeu existants et 3 est réservé en mode débuggage  

4. Le jeu est démarré; vous avez une série de message permettant d'attester le fonctionnement du jeu  

Entrer l'étendue
9
Entrer la taille
3
Quel jeu voulez vous jouer?
1: Mastermind , 2: PlusouMoins
1
Ordinateur attaquant (1) ou défenseur (2) ou Mixte (3) ?
2
Entrer le nombre d'essais max
3
