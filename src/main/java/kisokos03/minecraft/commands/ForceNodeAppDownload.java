package kisokos03.minecraft.commands;

import kisokos03.minecraft.util.Setup;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;



public class ForceNodeAppDownload implements CommandExecutor {
    Setup Setup = new Setup();
    TextComponent component = Component.text("WARNING, this WILL cause brief lag");
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        Bukkit.getServer().broadcast(component);
        Setup.nodeAppSetup(true);
        return false;
    }

}
