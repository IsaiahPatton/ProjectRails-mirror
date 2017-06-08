package org.projectrails.warps;

import java.util.List;

import org.projectrails.RailCommand;

import PluginReference.ChatColor;
import PluginReference.MC_Player;

public class CmdSetwarp extends RailCommand {
    @Override
    public String getCommandName() {
        return "setwarp";
    }

    @Override
    public String getHelpLine(MC_Player arg0) {
        return ChatColor.AQUA + "/setwarp" + ChatColor.WHITE + " --- set a warp";
    }

    @Override
    public void handleCommand(MC_Player p, String[] args) {
        if (args.length <= 0) {
            p.sendMessage(ChatColor.RED + "Usage: /setwarp <warpname>");
        } else {
            WarpConfiguration.createWarp(p.getLocation(), args[0].toLowerCase());
            String loc = "X:" + p.getLocation().x + ",Y:" + (p.getLocation().y + 1) + ",Z:" + p.getLocation().z;
            p.sendMessage(ChatColor.GREEN + "Set warp " + args[0].toLowerCase() + " at " + loc);
        }
    }

    @Override
    public boolean hasPermissionToUse(MC_Player p) {
        return super.hasPermissionToUse(p) || p.hasPermission("rainbow.setwarp") || p.hasPermission("rails.setwarp");
    }

    @Override
    public List<String> getAliases() {
        return null;
    }
}