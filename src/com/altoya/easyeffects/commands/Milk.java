package com.altoya.easyeffects.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;

import static org.bukkit.Bukkit.getServer;

public class Milk implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("Milk")){
            if(sender instanceof Player){
                if(sender.hasPermission("effect.milk")){


                    if(args.length > 1){
                        sender.sendMessage(ChatColor.RED + "SyntaxError: /milk <PLAYER>");
                    }

                    if(args.length == 0){
                        Player player = (Player) sender;
                        for (PotionEffect effect :player.getActivePotionEffects ()){
                            player.removePotionEffect(effect.getType ());
                        }
                        player.sendMessage(ChatColor.LIGHT_PURPLE + "Your effects have been cleared");
                    }

                    if(args.length == 1){
                        Player player1 = getServer().getPlayer(args[0]);
                        for (PotionEffect effect :player1.getActivePotionEffects ()){
                            player1.removePotionEffect(effect.getType ());
                        }
                        player1.sendMessage(ChatColor.LIGHT_PURPLE + "Your effects have been cleared");
                    }                    }
                }else{
                    sender.sendMessage(ChatColor.RED + "You don't have permission to execute this command");
                    return true;
                }
            }else{
                sender.sendMessage(ChatColor.RED + "You must be a player to execute this command");
                return true;
            }
        return true;
    }
}