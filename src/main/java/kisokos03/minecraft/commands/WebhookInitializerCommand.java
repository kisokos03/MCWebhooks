package kisokos03.minecraft.commands;

import kisokos03.minecraft.NodeCommands;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.Bukkit;

public class WebhookInitializerCommand implements CommandExecutor {
    NodeCommands Node = new NodeCommands();
    @Override
    public boolean onCommand(CommandSender sender, Command c, String s, String[] strings) {
        String[] command = new String[]{"init", Integer.toString(Bukkit.getOnlinePlayers().size())};
        Node.sendWebhook(command);
        Bukkit.getLogger().info(command[0] + " " + command[1]);
        return false;
    }
}
