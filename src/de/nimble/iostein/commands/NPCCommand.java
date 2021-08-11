package de.nimble.iostein.commands;

import de.nimble.iostein.PerksPlugin;
import de.nimble.iostein.perks.npc.PerkNPC;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class NPCCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        if(!(commandSender instanceof Player)) {
            return false;
        }
        Player player = (Player) commandSender;

        PerkNPC npc = new PerkNPC(player);
        npc.spawn();

        player.sendMessage(PerksPlugin.generalConfig.getPerkVillagerSpawnedMessage());

        return true;
    }

}
