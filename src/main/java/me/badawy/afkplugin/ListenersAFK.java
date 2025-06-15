package me.badawy.afkplugin;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.UUID;

public class ListenersAFK implements Listener {
    private final AFKplugin plugin;
    public ListenersAFK(AFKplugin plugin) {
        this.plugin = plugin;

    }

    @EventHandler
    public void onmovement(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        UUID uuid = player.getUniqueId();
        long time = System.currentTimeMillis();
        plugin.setLastActive(uuid,time);

    }

    @EventHandler
    public void onplayerchat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        UUID uuid = player.getUniqueId();
        plugin.setLastActive(uuid,System.currentTimeMillis());
    }






   }

