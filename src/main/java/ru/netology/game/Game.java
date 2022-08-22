package ru.netology.game;

import ru.netology.domain.Player;
import ru.netology.exception.AlreadyExistsException;
import ru.netology.exception.NotRegisteredException;

import java.util.ArrayList;

public class Game {

    ArrayList<Player> players = new ArrayList<>();

    public Player findByName(String name) {
        for (Player player : players) {
            if (player.getName().equals(name)) {
                return player;
            }
        }
        return null;
    }

    public void register(Player player) {
        if (!players.contains(player)) {
            players.add(player);
        } else {
            throw new AlreadyExistsException("Player already registered");
        }
    }


    public int round(String playerName1, String playerName2) {
        Player player1 = findByName(playerName1);
        Player player2 = findByName(playerName2);
        int result;
        if (player1 != null & player2 != null) {
            if (player1.getStrength() == player2.getStrength()) {
                result = 0;
            } else {
                result = player1.getStrength() > player2.getStrength() ? 1 : 2;
            }
        } else {
            throw new NotRegisteredException("Player not registered");
        }
        return result;
    }
}
