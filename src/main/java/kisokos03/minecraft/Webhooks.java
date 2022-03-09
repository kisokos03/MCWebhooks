package kisokos03.minecraft;

import kisokos03.minecraft.commands.*;
import kisokos03.minecraft.listener.*;
import kisokos03.minecraft.util.*;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredListener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.server.ServerListPingEvent;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import com.destroystokyo.paper.event.server.PaperServerListPingEvent;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Webhooks extends JavaPlugin {

    NodeCommands Node = new NodeCommands();
    Setup Setup = new Setup();

    public static void downloadFile(URL url, String fileName) throws Exception {
        try (InputStream in = url.openStream()) {
            Files.copy(in, Paths.get(fileName));
        }
    }

    @Override
    public void onEnable() {
        Bukkit.getLogger().info("setup check: " + Boolean.toString(Setup.firstTimeSetupCheck()));
        try {
            downloadFile(new URL("https://github.com/kisokos03/MCWebhooks/blob/main/nodeapp/wh.js"), "WEBHOOKDOWNLOAD.js");
        } catch (Exception e) {

        }

        // Node.sendWebhook("enable");
        // this.getCommand("initializeWebhook").setExecutor(new
        // WebhookInitializerCommand());
        // this.getCommand("checkOnlinePlayers").setExecutor(new
        // CheckOnlinePlayersCommand());
        // getLogger().info("added initializer command");

        // getServer().getPluginManager().registerEvents(new PlayerQuitListener(),
        // this);
        // getServer().getPluginManager().registerEvents(new PlayerJoinListener(),
        // this);

    }

    @Override
    public void onDisable() {
        Node.sendWebhook("disable");

    }
}
