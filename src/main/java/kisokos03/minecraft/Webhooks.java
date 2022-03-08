package kisokos03.minecraft;

import kisokos03.minecraft.NodeCommands;
import kisokos03.minecraft.commands.*;
import kisokos03.minecraft.listener.*;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredListener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.server.ServerListPingEvent;
import org.bukkit.command.CommandExecutor;
import com.destroystokyo.paper.event.server.PaperServerListPingEvent;

import java.io.File;
import java.io.IOException;


public class Webhooks extends JavaPlugin{

    NodeCommands Node = new NodeCommands();
  

    @Override
    public void onEnable(){
        Node.sendWebhook("enable");

        this.getCommand("initializeWebhook").setExecutor(new WebhookInitializerCommand());
        this.getCommand("checkOnlinePlayers").setExecutor(new CheckOnlinePlayersCommand());
        getLogger().info("added initializer command");

        getServer().getPluginManager().registerEvents(new PlayerQuitListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerJoinListener(), this);
        
    }
    
    @Override
    public void onDisable(){
        Node.sendWebhook("disable");

    }
}
    