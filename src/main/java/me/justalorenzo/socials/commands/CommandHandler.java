package me.justalorenzo.socials.commands;

import com.google.inject.Inject;
import me.justalorenzo.socials.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandHandler implements CommandExecutor {


String[] commands = {"Discord"};

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        for(String cmd : commands) {
            if(command.getName().equalsIgnoreCase(cmd)) {
                commandSender.sendMessage("wow you did a " + command.getName());
                return true;
            }
        }
        return false;
    }
}
