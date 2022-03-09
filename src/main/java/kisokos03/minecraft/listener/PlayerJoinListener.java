package kisokos03.minecraft.listener;

import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import kisokos03.minecraft.util.NodeCommands;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;


public class PlayerJoinListener implements Listener{
    NodeCommands Node = new NodeCommands();

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        Node.sendWebhook("members", Integer.toString(Bukkit.getOnlinePlayers().size()));
    }
    
}
