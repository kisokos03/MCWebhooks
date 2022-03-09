package kisokos03.minecraft.listener;

import kisokos03.minecraft.util.NodeCommands;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuitListener implements Listener {

    NodeCommands Node = new NodeCommands();



    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e) {
        Bukkit.getLogger().info("playerQuitEvent");
        Bukkit.getScheduler().runTaskLater(Bukkit.getPluginManager().getPlugin("discordWebhooks"), new Runnable(){
            public void run(){
                Node.sendWebhook("members", Integer.toString((Bukkit.getServer().getOnlinePlayers().size())));
            }
        }, 40L);
        //checks players 40 ticks after quitEvent, as doing so immediately still returns value as if they were online


    }

}
