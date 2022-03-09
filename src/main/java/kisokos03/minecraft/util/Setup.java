package kisokos03.minecraft.util;

import java.util.List;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.stream.Collectors;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.InvalidRemoteException;
import org.eclipse.jgit.api.errors.TransportException;
import org.bukkit.Bukkit;

public class Setup {
    private Boolean firstTimeSetupCheck() {
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

    public void nodeAppSetup(Boolean forced) {

        // download js files
        // test node, throw error if not present
        Setup Setup = new Setup();

        if ((!Setup.firstTimeSetupCheck()) || forced) {
            
            try {
                Files.walk(Path.of("./plugins/webhooks"));
            } catch (IOException e) {
                Bukkit.getLogger().info(e.toString());
            }

            try {
                Git.cloneRepository()
                        .setURI("https://github.com/kisokos03/MCWebhooksNode")
                        .setDirectory(new File("./plugins/webhooks"))
                        .call();
            } catch (InvalidRemoteException e) {
                Bukkit.getLogger().info(e.toString());
            } catch (TransportException e) {
                Bukkit.getLogger().info(e.toString());
            } catch (GitAPIException e) {
                Bukkit.getLogger().info(e.toString());
            }

        }
    }
}
