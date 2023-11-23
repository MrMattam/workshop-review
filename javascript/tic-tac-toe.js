//const prompt=require("prompt-sync")({sigint:true});
let tailleDuPlateau = 3;

function afficherPlateau(plateauDeJeu) {
    console.log("Plateau de jeu :");

    for (let i = 0; i < tailleDuPlateau; i++) {
        console.log(plateauDeJeu[i].join(" | "));
        if (i < 2) {
            console.log("---------");
        }
    }
}

function verifierGagnant(plateau, symbole) {

    for (let i = 0; i < tailleDuPlateau; i++) {
        if (
            verifierLigne(i) ||  verifierColonne(i)
        ) {
            return true;
        }
    }

    return (verifierDiagonaleGaucheDroite() || verifierDiagonalDroiteGauche());



    // Fonctions Utilitaires
    function verifierLigne(i) {
        return plateau[i][0] === symbole && plateau[i][1] === symbole && plateau[i][2] === symbole;
    }

    function verifierColonne(i) {
        return plateau[0][i] === symbole && plateau[1][i] === symbole && plateau[2][i] === symbole;
    }

    function verifierDiagonaleGaucheDroite() {
        return plateau[0][0] === symbole && plateau[1][1] === symbole && plateau[2][2] === symbole;
    }

    function verifierDiagonalDroiteGauche() {
        return plateau[0][2] === symbole && plateau[1][1] === symbole && plateau[2][0] === symbole;
    }
}


function jouerMorpion() {
    const plateau = [
        [" ", " ", " "],
        [" ", " ", " "],
        [" ", " ", " "],
    ];

    let tourCourant = 0;
    let symbole = "X";
    let nombreDeTourAJouer = 6;


    while (tourCourant < nombreDeTourAJouer) {
        afficherPlateau(plateau);

        // Demande au joueur actuel de saisir les coordonnées
        let ligne, colonne;
        do {
            ligne = parseInt(prompt(`Tour ${tourCourant + 1}: Joueur "${symbole}", Entrez le numéro de ligne (1, 2 ou 3):`)) - 1;
            colonne = parseInt(prompt(`Tour ${tourCourant + 1}: Joueur "${symbole}", Entrez le numéro de colonne (1, 2 ou 3):`)) - 1;
        } while (isNaN(ligne) || isNaN(colonne) || ligne < 0 || ligne >= 3 || colonne < 0 || colonne >= 3 || plateau[ligne][colonne] !== " ");

        plateau[ligne][colonne] = symbole;

        if (verifierGagnant(plateau, symbole)) {
            afficherPlateau(plateau);
            console.log(`Le joueur "${symbole}" a gagné !`);
            return;
        }

        tourCourant++;
        symbole = tourCourant % 2 === 0 ? "O" : "X";
    }

    afficherPlateau(plateau);
    console.log("Match nul !");
}

// Lancer le jeu
jouerMorpion();