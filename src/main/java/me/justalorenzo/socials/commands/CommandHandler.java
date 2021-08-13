package me.justalorenzo.socials.commands;

import com.google.inject.Inject;
import me.justalorenzo.socials.Socials;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class CommandHandler implements CommandExecutor {
//doing this would lead in initializing the Main.Java class twice which is not a good thing.
// String[] commands  = Main().getCommandList();

    final private Socials plugin;

    @Inject
    public CommandHandler(Socials plugin) {
        this.plugin = plugin;
    }


    final String[] commandList = Socials.COMMAND_LINK_LIST;


    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {

        for (String cmd : commandList) {
            if (command.getName().equalsIgnoreCase(cmd)) {
                //get basic paths
                String prefixPath = plugin.getConfig().getString("prefix");
                String linkPath = plugin.getConfig().getString(cmd + ".link");
                String suffixPath = plugin.getConfig().getString("suffix");
                String msg = prefixPath + linkPath + suffixPath;
                boolean isAvailable = plugin.getConfig().getBoolean(cmd.toLowerCase() + ".available");
                if (isAvailable) {
                    TextComponent message = new TextComponent(msg);
                    message.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, plugin.getConfig().getString(cmd + ".link")));

                    String cmdCapitalized = cmd;
                    cmdCapitalized = cmdCapitalized.substring(0, 1).toUpperCase() + cmdCapitalized.substring(1);
                    message.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Check out our " + (ChatColor.UNDERLINE + cmdCapitalized) + ChatColor.stripColor("!")).create()));
                    if (!(commandSender instanceof Player)) {
                        commandSender.sendMessage(message.getText());
                    } else {
                        Player p = (Player) commandSender;

                        p.spigot().sendMessage(message);
                    }
                } else {
                    //unavailable
                    commandSender.sendMessage(prefixPath + (ChatColor.RED + "This is unavailable!") + ChatColor.RESET + suffixPath);
                }


                return true;
            }
        }
        return false;
    }

}
