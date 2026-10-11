package ru.netology;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Player> players = new ArrayList<>();

    public void register(Player player) {
        players.add(player);
    }

    private Player findByName(String name) {
        for (Player player : players) {
            if (player.getName().equals(name)) {
                return player;
            }
        }
        return null;
    }

    public int round(String name1, String name2) {
        Player p1 = findByName(name1);
        if (p1 == null) {
            throw new NotRegisteredException("Игрок " + name1 + " не зарегистрирован");
        }

        Player p2 = findByName(name2);
        if (p2 == null) {
            throw new NotRegisteredException("Игрок " + name2 + " не зарегистрирован");
        }

        if (p1.getStrength() > p2.getStrength()) {
            return 1;
        }
        if (p1.getStrength() < p2.getStrength()) {
            return 2;
        }
        return 0;
    }
}