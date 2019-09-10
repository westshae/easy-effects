package com.altoya.easyeffects.effects;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import static org.bukkit.Bukkit.getServer;

public class Levitation implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("Levitation")) {
            if (sender instanceof Player) {
                String effect = "levitation";
                String effectType = "LEVITATION";
                giveEffect((Player) sender, effect, effectType, args);
            }else{
                sender.sendMessage(ChatColor.RED + "Only players can execute this command.");
                return true;
            }
        }
        return true;
    }

    public void giveEffect(Player sender, String effect, String effectType, String[] args)  {
        if(sender.hasPermission("effect." + effect)) {
            try {
                int argsInt = Integer.parseInt(args[0]);

            }catch(Exception e){
                sender.sendMessage(ChatColor.RED + "Syntax Error: /" + effect + " <LEVEL> <PLAYER>");
                return;
            }
            int argsInt = Integer.parseInt(args[0]);

            if (argsInt < 0) {
                sender.sendMessage(ChatColor.RED + "Potion level cannot be less then 1");
                return;
            }
            if (args[0] == null) {
                sender.sendMessage(ChatColor.RED + "Syntax Error: /" + effect + " <LEVEL> <PLAYER>");
                return;
            }
            if (args.length > 2) {
                sender.sendMessage(ChatColor.RED + "SyntaxError: Please use /" + effect + " <LEVEL> <PLAYER>");
            }
            if (args.length == 1) {
                try {
                    Player player = (Player) sender;

                    int levelZero = Integer.parseInt(args[0]);
                    if(levelZero == 0){
                        player.removePotionEffect(PotionEffectType.getByName(effectType));
                    }

                    player.removePotionEffect(PotionEffectType.getByName(effectType));
                    int level = Integer.parseInt(args[0]) - 1;
                    player.addPotionEffect(new PotionEffect(PotionEffectType.getByName(effectType), 100000, level));
                    player.sendMessage(ChatColor.LIGHT_PURPLE + "You now have " + effect + " level " + Integer.parseInt(args[0]));
                } catch (NumberFormatException e) {
                    sender.sendMessage(ChatColor.RED + "ValueError: Please use /" + effect + " <LEVEL> <PLAYER>");
                    return;
                }
            }
            if (args.length == 2) {
                try {
                    Float.parseFloat(args[0]);
                } catch (NumberFormatException e) {
                    sender.sendMessage(ChatColor.RED + "ValueError: Please use /" + effect + " <LEVEL> <PLAYER>");
                    return;
                }
                Player player = getServer().getPlayer(args[1]);

                player.removePotionEffect(PotionEffectType.getByName(effectType));
                int level = Integer.parseInt(args[0]) - 1;
                player.addPotionEffect(new PotionEffect(PotionEffectType.getByName(effectType), 100000, level));
                player.sendMessage(ChatColor.LIGHT_PURPLE + "You now have " + effect + " " + (level + 1));
            }
        }else{
            sender.sendMessage(ChatColor.RED + "You do not have permission to use this command");
            return;
        }
    }
}