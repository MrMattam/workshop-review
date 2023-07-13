from tennis_game import TennisGame

if __name__ == '__main__':
    game = TennisGame("Player 1", "Player 2")
    game.player1_scores()
    game.player2_scores()
    print(game.get_score())
    game.player2_scores()
    game.player2_scores()
    print(game.get_score())

