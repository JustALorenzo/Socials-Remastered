package me.justalorenzo.socials.commands;

import com.google.inject.Inject;
import me.justalorenzo.socials.Socials;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
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
                TextComponent message = new TextComponent(plugin.getConfig().get("prefix") + plugin.getConfig().get(cmd).toString() + plugin.getConfig().get("suffix"));
                message.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, (String) plugin.getConfig().get(cmd)));
                message.setHoverEvent( new HoverEvent( HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Check out our " + cmd).create()));

                Player p = (Player) commandSender;
                p.spigot().sendMessage(message);
                return true;
            }
        }
        return false;
    }

}
