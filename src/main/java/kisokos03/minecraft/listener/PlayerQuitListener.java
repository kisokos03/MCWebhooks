package kisokos03.minecraft.listener;

import kisokos03.minecraft.NodeCommands;
import kisokos03.minecraft.Webhooks;

import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.Plugin;

import org.jetbrains.annotations.NotNull;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;

public class PlayerQuitListener implements Listener {

    //private Webhooks mainPlugin;
    NodeCommands Node = new NodeCommands();



    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e) {
        Bukkit.getLogger().info("playerQuitEvent");
        // Bukkit.getScheduler().runTaskLater(mainPlugin, new Runnable() {
        //     public void run() {
        //         Node.sendWebhook("members", Integer.toString(Bukkit.getServer().getOnlinePlayers().size()));
        //         Bukkit.getServer().getLogger().info("removed?");
        //     }
        // }, 0L);
        Bukkit.getScheduler().runTaskLater(Bukkit.getPluginManager().getPlugin("discordWebhooks"), new Runnable(){
            public void run(){
                Node.sendWebhook("members", Integer.toString((Bukkit.getServer().getOnlinePlayers().size())));
            }
        }, 40L);


    }

}
