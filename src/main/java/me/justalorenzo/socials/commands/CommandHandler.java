package me.justalorenzo.socials.commands;

import com.google.inject.Inject;
import me.justalorenzo.socials.Socials;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandHandler implements CommandExecutor {
//doing this would lead in initializing the Main.Java class twice which is not a good thing.
// String[] commands  = Main().getCommandList();

    private Socials plugin;

    @Inject
    public CommandHandler(Socials plugin) {
        this.plugin = plugin;
    }


    String[] commandList = Socials.COMMAND_LINK_LIST;


    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        for (String cmd : commandList) {
            if (command.getName().equalsIgnoreCase(cmd)) {
                commandSender.sendMessage(plugin.getConfig().get(cmd).toString());
                return true;
            }
        }
        return false;
    }
}
