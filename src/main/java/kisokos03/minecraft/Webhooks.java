package kisokos03.minecraft;

import kisokos03.minecraft.commands.*;
import kisokos03.minecraft.listener.*;
import kisokos03.minecraft.util.*;

import org.bukkit.plugin.java.JavaPlugin;

public class Webhooks extends JavaPlugin {

    NodeCommands Node = new NodeCommands();
    Setup Setup = new Setup();



    @Override
    public void onEnable() {
        Setup.nodeAppSetup(false);
        Node.sendWebhook("enable");
        this.getCommand("initializeWebhook").setExecutor(new WebhookInitializerCommand());
        this.getCommand("checkOnlinePlayers").setExecutor(new CheckOnlinePlayersCommand());
        this.getCommand("forceNodeAppDownload").setExecutor(new ForceNodeAppDownload());
        getLogger().info("added initializer command");
        getServer().getPluginManager().registerEvents(new PlayerQuitListener(),this);
        getServer().getPluginManager().registerEvents(new PlayerJoinListener(),this);

        
    
    }
    @Override
    public void onDisable() {
        Node.sendWebhook("disable");

    }
}
