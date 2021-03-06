package org.projectrails.commands;

import java.util.Arrays;

import org.projectrails.Rails;

import PluginReference.ChatColor;
import PluginReference.MC_Entity;
import PluginReference.MC_EntityType;
import PluginReference.MC_Player;
import PluginReference.MC_World;
import PluginReference.RainbowUtils;

public class CmdClearlag extends RailCommand {

    @Override
    public void handleCommand(MC_Player sender, String[] args) {
        int i = 0;
        for (MC_World w : RainbowUtils.getServer().getWorlds()) {
            for (MC_Entity e : w.getEntities()) {
                if ((e.getType() == MC_EntityType.ITEM || e.getType() == MC_EntityType.PRIMED_TNT 
                        || e.getType() == MC_EntityType.THROWN_EGG || e.getType() == MC_EntityType.WITHER_SKULL ||
                        e.getType() == MC_EntityType.ARROW) && !e.hasCustomName() && !e.isInvisible()) {
                    e.removeEntity();
                    i++;
                }
            }
        }
        if (Rails.broadcastclearlag) {
            sender.getServer().broadcastMessage(ChatColor.GOLD + "Removed " + ChatColor.GREEN + i + ChatColor.GOLD + " ground items.");
        } else {
            sendMessage(sender, ChatColor.GOLD + "Removed " + ChatColor.GREEN + i + ChatColor.GOLD +" ground items.");
        }
    }

    @Override
    public CommandInfo getInfo() {
        return new CommandInfo("clearlag", "Remove ground items.", Arrays.asList("removelag", "clearitems", "clearlagg"));
    }

}
