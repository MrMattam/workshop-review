from tennis_game import TennisGame


def test_deuce():
    game = TennisGame("Player 1", "Player 2")
    assert game.get_score() == "Love - Love"


def test_player_one_score():
    game = TennisGame("Player 1", "Player 2")
    game.player1_scores()
    assert game.get_score() == "Fifteen - Love"
