//const prompt=require("prompt-sync")({sigint:true});

function afficherPlateau(jeu) {
    console.log("Plateau de jeu :");
    for (let i = 0; i < 3; i++) {
        console.log(jeu[i].join(" | "));
        if (i < 2) {
            console.log("---------");
        }
    }
}

// Fonction pour vérifier s'il y a un perdant
function verifierGagnant(plateau, symbole) {
    // Vérification des lignes, colonnes et diagonales
    for (let i = 0; i < 3; i++) {
        if (
            (plateau[i][0] === symbole && plateau[i][1] === symbole && plateau[i][2] === symbole) ||
            (plateau[0][i] === symbole && plateau[1][i] === symbole && plateau[2][i] === symbole)
        ) {
            return true;
        }
    }

    if (
        (plateau[0][0] === symbole && plateau[1][1] === symbole && plateau[2][2] === symbole) ||
        (plateau[0][2] === symbole && plateau[1][1] === symbole && plateau[2][0] === symbole)
    ) {
        return true;
    }

    return false;
}


function jouerMorpion() {
    const plateau = [
        [" ", " ", " "],
        [" ", " ", " "],
        [" ", " ", " "],
    ];

    let tour = 0;
    let symbole = "X";

    while (tour < 6) {
        afficherPlateau(plateau);

        // Demande au joueur actuel de saisir les coordonnées
        let ligne, colonne;
        do {
            ligne = parseInt(prompt(`Tour ${tour + 1}: Joueur "${symbole}", Entrez le numéro de ligne (1, 2 ou 3):`)) - 1;
            colonne = parseInt(prompt(`Tour ${tour + 1}: Joueur "${symbole}", Entrez le numéro de colonne (1, 2 ou 3):`)) - 1;
        } while (isNaN(ligne) || isNaN(colonne) || ligne < 0 || ligne >= 3 || colonne < 0 || colonne >= 3 || plateau[ligne][colonne] !== " ");

        plateau[ligne][colonne] = symbole;

        if (verifierGagnant(plateau, symbole)) {
            afficherPlateau(plateau);
            console.log(`Le joueur "${symbole}" a gagné !`);
            return;
        }

        tour++;
        symbole = tour % 2 === 0 ? "O" : "X";
    }

    afficherPlateau(plateau);
    console.log("Match nul !");
}

// Lancer le jeu
jouerMorpion();