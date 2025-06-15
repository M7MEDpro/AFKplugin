package me.badawy.afkplugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public final class AFKplugin extends JavaPlugin {
    private final static Map<UUID, Long> lastActive = new HashMap<>();
    ArrayList<UUID> AFKplayers = new ArrayList<>();
    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new ListenersAFK(this), this);
        saveDefaultConfig();
        setAFKplayers();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
    public Map<UUID, Long> getLastActive() {
        return lastActive;
    }
    public void setLastActive(UUID uuid, long time) {
        lastActive.put(uuid,time);
    }
    public void setAFKplayers() {
        String[] temp = Getafktimer();
        double afktime = Double.parseDouble(temp[0]) * Double.parseDouble(temp[1])*1000;
        Bukkit.getScheduler().runTaskTimerAsynchronously(this, () -> {
            for (Player p : Bukkit.getOnlinePlayers()) {
                Long lasttime = getLastActive().get(p.getUniqueId());
                long timeWithoutActivity = System.currentTimeMillis() - lasttime;
                UUID uuid = p.getUniqueId();

                if (timeWithoutActivity > afktime) {
                    if (!AFKplayers.contains(uuid)) {
                        AFKplayers.add(uuid);
                        Bukkit.broadcastMessage(ChatColor.GREEN + p.getDisplayName() + ChatColor.GRAY + " is now AFK");
                        p.setPlayerListName(ChatColor.BLACK + p.getDisplayName());
                    }
                } else {
                    if (AFKplayers.contains(uuid)) {
                        AFKplayers.remove(uuid);
                        Bukkit.broadcastMessage(ChatColor.GREEN + p.getDisplayName() + ChatColor.YELLOW + " is no longer AFK");
                        p.setPlayerListName(p.getName());
                    }
                }
            }
        }, 0L, 20L * 3);
    }


    public String[] Getafktimer() {
        String timer = getConfig().getString("AFKtime");
        String[] arr = timer.split(",");
        switch (arr[1]) {
            case "m":
                arr[1] = "60";
                break;
            case "s":
                arr[1] = "1";
                break;
        }
        return arr;
    }
}
