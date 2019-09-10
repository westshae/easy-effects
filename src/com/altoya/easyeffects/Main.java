package com.altoya.easyeffects;

import com.altoya.easyeffects.commands.Milk;
import com.altoya.easyeffects.effects.*;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        this.getCommand("speed").setExecutor(new Speed());
        this.getCommand("slowness").setExecutor(new Slowness());
        this.getCommand("blindness").setExecutor(new Blindness());
        this.getCommand("badomen").setExecutor(new Badomen());
        this.getCommand("badluck").setExecutor(new Badluck());
        this.getCommand("absorption").setExecutor(new Absorption());
        this.getCommand("dolphinsgrace").setExecutor(new Dolphins());
        this.getCommand("fireresistance").setExecutor(new FireResistance());
        this.getCommand("glowing").setExecutor(new Glowing());
        this.getCommand("haste").setExecutor(new Haste());
        this.getCommand("healthboost").setExecutor(new HealthBoost());
        this.getCommand("heroofthevillage").setExecutor(new HeroOfTheVillage());
        this.getCommand("hunger").setExecutor(new Hunger());
        this.getCommand("invisibility").setExecutor(new Invisibility());
        this.getCommand("jumpboost").setExecutor(new JumpBoost());
        this.getCommand("levitation").setExecutor(new Levitation());
        this.getCommand("goodluck").setExecutor(new Goodluck());
        this.getCommand("miningfatigue").setExecutor(new MiningFatigue());
        this.getCommand("nausea").setExecutor(new Nausea());
        this.getCommand("nightvision").setExecutor(new NightVision());
        this.getCommand("poison").setExecutor(new Poison());
        this.getCommand("regeneration").setExecutor(new Regeneration());
        this.getCommand("resistance").setExecutor(new Resistance());
        this.getCommand("slowfalling").setExecutor(new SlowFalling());
        this.getCommand("strength").setExecutor(new Strength());
        this.getCommand("waterbreathing").setExecutor(new WaterBreathing());
        this.getCommand("weakness").setExecutor(new Weakness());
        this.getCommand("wither").setExecutor(new Wither());
        this.getCommand("conduitpower").setExecutor(new ConduitPower());

        this.getCommand("milk").setExecutor(new Milk());
    }

    @Override
    public void onDisable() {
    }
}