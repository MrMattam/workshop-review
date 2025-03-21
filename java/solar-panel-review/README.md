# Solar Panel Manager

Ce code est donné à titre pédagogique, pour servir de support de discussion autour des approches de code et de design logiciel.

## Contexte

Un fabricant de panneaux solaires nous a confié la mission suivante :

Implémenter un système permettant de modéliser le comportement d'un panneau solaire.  
Ce panneau solaire est équipé de capteurs qui permettent de :
* Connaître sa production en temps réel.
* Avoir une estimation de la production d'une journée en fonction d'une date.

## Règles métier

L'efficacité du panneau solaire dépend de plusieurs paramètres :
* Son exposition au soleil, qui correspond au pourcentage de surface du panneau exposée au soleil.
* La température extérieure.
* Le mode nuit.

Ainsi, on observe les règles suivantes :

* Il y a toujours une perte d'énergie de 2 % par rapport à la capacité du panneau.
* Au-dessus de 30 degrés, température optimale maximale, malheureusement, la performance du panneau est impactée de 20 %.
* L'efficacité est proportionnelle à la surface du panneau exposée au soleil.

La production instantanée est calculée à partir de l'efficacité courante.  
L'estimation de production dépend du nombre d'heures de soleil du mois (fourni par un système extérieur certifié par les plus grandes autorités et que l'on ne peut pas remettre en question).

## Ajout de fonctionnalités

### Ajout d’un historique de production

👉 Problème à résoudre : actuellement, la classe ne stocke que la production instantanée.  
👉 Changement demandé : ajouter une liste ou une structure de données permettant de suivre la production horaire du panneau.

### Prise en compte des conditions météorologiques

👉 Problème à résoudre : le panneau ne prend en compte que `sunExposure` et `temp`, mais pas la météo (pluie, neige, etc.).  
👉 Changement demandé : ajouter une classe `WeatherCondition` qui influence la production (`rain`, `snow`, `cloudCover`).