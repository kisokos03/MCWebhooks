package kisokos03.minecraft.util;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import org.bukkit.Bukkit;

public class Setup {
    public Boolean firstTimeSetupCheck() {
        boolean setup = false;
        try {
            String webhooksDir = ".\\plugins\\webhooks";
            List<File> files = Files.list(Paths.get(".\\plugins"))
                    .map(Path::toFile)
                    .collect(Collectors.toList());
            String[] filesString = new String[files.size()];
            for (int i = 0; i < files.size() - 1; i++) {
                filesString[i] = files.get(i).toString();
            }

            for (int i = 0; i < filesString.length - 1; i++) {
                // Bukkit.getLogger().info(filesString[i]);
                if (filesString[i].equals(webhooksDir)) {
                    // Bukkit.getLogger().info("match: " + filesString[i]);
                    setup = true;
                }
            }
            // files.forEach(f -> {if(f.toString() ==
            // ".\\plugins\\webhooks"){getLogger().info(f.toString());} else
            // {getLogger().info("actual name "+f.toString());}});
        } catch (IOException e) {
            Bukkit.getLogger().info(e.toString());
        }
        return setup;
        // if needs downlaoding:

    }

    // private void firstTimeSetup() {
    //     // download js files
    //     // test node, throw error if not present

    // }
}
