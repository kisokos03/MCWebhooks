package kisokos03.minecraft.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CheckOnlinePlayersCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        int size = Bukkit.getOnlinePlayers().size();
        Bukkit.getLogger().info(Integer.toString(size));
        return false;
    }
}
