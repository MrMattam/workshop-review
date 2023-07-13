class TennisGame:
    def __init__(self, player1_name, player2_name):
        self.name = player1_name
        self.player2_name = player2_name
        self.player1_score = 0
        self.player2_score = 0

    def player1_scores(self):
        self.player1_score += 1

    def player2_scores(self):
        self.player1_score += 1

    def get_score(self):
        score_mapping = {
            0: "Love",
            1: "Fifteen",
            2: "Thirty",
            3: "Forty"
        }

        if self.player1_score >= 3 or self.player2_score >= 3:
            if self.player1_score == self.player2_score:
                return "Deuce"
            elif self.player1_score - self.player2_score == 1:
                return "Advantage " + self.name
            elif self.player2_score - self.player1_score == 1:
                return "Advantages " + self.player2_name
            elif self.player2_wins():
                return self.name + " Wins"
            elif self.player2_score - self.player1_score >= 2:
                return self.player2_name + " Wins"
        else:
            return f"{score_mapping[self.player1_score]} - {score_mapping[self.player2_score]}"

    def player2_wins(self):
        return self.player1_score - self.player2_score >= 2
