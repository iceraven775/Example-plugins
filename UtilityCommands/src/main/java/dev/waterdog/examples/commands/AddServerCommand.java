package dev.waterdog.examples.commands;

import dev.waterdog.ProxyServer;
import dev.waterdog.command.Command;
import dev.waterdog.command.CommandSender;
import dev.waterdog.command.CommandSettings;
import dev.waterdog.network.ServerInfo;

import java.net.InetSocketAddress;

public class AddServerCommand extends Command {

    public AddServerCommand() {
        super("addserver", CommandSettings.builder()
                .setDescription("Add a Server to the server list")
                .setUsageMessage("/addserver <Name> <IP> <Port>")
                .setPermission("waterdog.example.addserver").build());
    }

    @Override
    public boolean onExecute(CommandSender commandSender, String s, String[] strings) {
        if (strings.length < 3) {
            commandSender.sendMessage(this.getUsageMessage());
            return false;
        }
        ServerInfo i = new ServerInfo(strings[0], new InetSocketAddress(strings[1], Integer.parseInt(strings[2])), null);
        ProxyServer.getInstance().registerServerInfo(i);
        commandSender.sendMessage("Server added successfully!");

        return true;
    }
}
