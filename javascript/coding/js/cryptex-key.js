function encryptWithKey(text, key) {
    var encryptedText = '';
    for (var i = 0; i < text.length; i++) {
        var currentChar = text[i];
        var keyChar = key[i % key.length];
        var encryptedChar = String.fromCharCode(currentChar.charCodeAt(0) + keyChar.charCodeAt(0));
        encryptedText += encryptedChar;
    }
    return encryptedText;
}

function chiffrer() {
    var texteOriginal = document.getElementById("texteOriginal").value;
    var cle = document.getElementById("cle").value;
    var texteChiffre = encryptWithKey(texteOriginal, cle);
    document.getElementById("texteChiffre").value = texteChiffre;
}


function decryptWithKey(encryptedText, key) {
    // TODO
}

function dechiffrer() {
    // TODO
}

function effacer() {
    document.getElementById("texteOriginal").value = ""
    document.getElementById("texteChiffre").value = ""
    document.getElementById("cle").value = ""
}
