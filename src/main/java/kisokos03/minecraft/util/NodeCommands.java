package kisokos03.minecraft.util;

import java.io.IOException;

public class NodeCommands {
    // private String Stringify(String... strings){
    // String result = "";
    // for(int i = 0; i < strings.length; i++){
    // result = result + strings[i] + " ";
    // }
    // return result.strip();
    // }
    private String[] commandBuilder(String command, String path, String... args) {
        int totalSize = args.length + 2;

        String[] result = new String[totalSize];
        result[0] = command;
        result[1] = path;

        for (int i = 0; i < args.length; i++) {
            result[i + 2] = args[i];
        }

        return result;

    }

    public String sendWebhook(String... args) {
        ProcessBuilder pb = new ProcessBuilder(commandBuilder("node", "./plugins/webhooks", args));
        pb.redirectOutput(ProcessBuilder.Redirect.INHERIT);
        pb.redirectError(ProcessBuilder.Redirect.INHERIT);
        try {
            pb.start();
        } catch (IOException e) {
            return e.toString();
        }
        return "success";
    }
}
