# Othello / Reversi

## Voici l’explication et les règles de ce jeu, d’après Wikipédia :
Il se joue sur un plateau unicolore de 64 cases, 8 sur 8. Les joueurs disposent de 64 pions bicolores, noirs d'un côté et blancs de l'autre. En début de partie, quatre pions sont déjà placés au centre du plateau dans la position suivante :

<code>

  1 2 3 4 5 6 7 8
1 · · · · · · · ·
2 · · · · · · · ·
3 · · · · · · · ·
4 · · · o ● · · ·
5 · · · ● o · · ·
6 · · · · · · · ·
7 · · · · · · · ·
8 · · · · · · · ·

</code>

-> http://www.ffothello.org/othello/regles-du-jeu/

Chaque joueur, noir et blanc, pose l'un après l'autre un pion de sa couleur sur le plateau de jeu selon des règles précises. Le jeu s'arrête quand les deux joueurs ne peuvent plus poser de pion. On compte alors le nombre de pions. Le joueur ayant le plus grand nombre de pions de sa couleur sur le plateau a gagné.

Noir commence toujours la partie. Puis  les joueurs jouent à  tour de rôle, chacun étant tenu de capturer des pions adverses lors de son mouvement. Si  un joueur ne peut pas capturer  de pion(s) adverse(s), il est forcé de passer son tour. Si aucun des deux joueurs ne peut jouer, ou si le plateau ne comporte plus de case vide, la partie s'arrête.

La capture de pions survient lorsqu'un joueur place un de ses pions à l'extrémité d'un alignement de pions adverses contigus et dont l'autre extrémité est déjà occupée par un de ses propres pions. Les alignements considérés peuvent être une colonne, une ligne, ou une diagonale. Si le pion nouvellement placé vient fermer plusieurs alignements, il capture tous les pions adverses des lignes ainsi fermées. La capture se traduit par le retournement des pions capturés. Ces retournements n'entraînent pas d'effet de capture en cascade : seul le pion nouvellement posé est pris en compte.

## Tester le jeu
http://reversi.fr/
