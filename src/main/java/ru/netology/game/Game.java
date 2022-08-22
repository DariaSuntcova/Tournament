package ru.netology.game;

import ru.netology.domain.Player;
import ru.netology.exception.AlreadyExistsException;
import ru.netology.exception.NotRegisteredException;

import java.util.HashMap;

public class Game {

    HashMap<String, Player> players = new HashMap<>();

    public void register(Player player) {
        if (!players.containsValue(player)) {
            players.put(player.getName(), player);
        } else {
            throw new AlreadyExistsException("Player already registered");
        }
    }


    public int round(String playerName1, String playerName2) {
        Player player1 = players.get(playerName1);
        Player player2 = players.get(playerName2);
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
