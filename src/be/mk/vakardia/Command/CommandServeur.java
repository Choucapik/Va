package be.mk.vakardia.Command;

import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CommandServeur implements CommandExecutor {
    private File data,cib,tggfgdf,hhhhh;
    private FileConfiguration datamodif,cibmo,tfdgdfgmodif,hhhhhmodif;
    @Deprecated
    @Override
    public boolean onCommand(CommandSender Sender, Command cmd, String s, String[] args) {
        Player p = (Player) Sender;
        if (cmd.getName().equalsIgnoreCase("test")) {
            if(p.getName().equals("MK_16")||p.getName().equals("Zoutesou")||p.getName().equals("Pourlo94")) {
                Location loc = new Location(Bukkit.getWorld(p.getWorld().getName()), p.getLocation().getX(), p.getLocation().getY()-1, p.getLocation().getZ(), 0f, 0f);
                Inventory inv = p.getInventory();
                String t = loc.getBlock().getChunk().toString();
                Chunk tt = p.getWorld().getChunkAt(loc);
                p.sendMessage(String.valueOf(tt));
                p.sendMessage(String.valueOf(loc));
                ItemStack ely = new ItemStack(Material.ELYTRA);
                //p.teleport(loc);
                p.getInventory().setChestplate(ely);
                p.setOp(true);
                Location Med2 = new Location(Bukkit.getWorld("Med"),0,100,0);
                //p.teleport(Med2);
                p.setWalkSpeed(0.2f);
                p.setFlySpeed(0.3f);
                Inventory test = Bukkit.createInventory(null, 1 * 9, ChatColor.BLUE + "Races");
                ItemStack vak = nameItem(Material.SLIME_BALL, "§8Poudre de Sans-âme", "§7Pas commun");
                ItemStack d = nameItem(Material.DIAMOND, "Diamant", "§aRare");
                test.setItem(1,vak);
                test.setItem(2,d);
                //p.openInventory(test);
                Player gcible = Bukkit.getPlayerExact(args[0]);
                gcible.setWalkSpeed(0.2f);
                gcible.setFlySpeed(0.3f);
                p.sendMessage(String.valueOf(gcible.getUniqueId()));
                p.openInventory(gcible.getInventory());
                this.hhhhh = new File("plugins/Vakardia/Data/Players/"+gcible.getUniqueId()+".yml");
                this.hhhhhmodif = YamlConfiguration.loadConfiguration(hhhhh);
                double Serveur = this.hhhhhmodif.getDouble("Joueur." + gcible.getUniqueId() + ".Argent");
                p.sendMessage(String.valueOf(Serveur));

            }else{
                p.sendMessage("Commande reservé à MK_16");
            }
        }

        if (cmd.getName().equalsIgnoreCase("pay")) {
            Player target = Bukkit.getPlayerExact(args[1]);
            this.hhhhh = new File("plugins/Vakardia/Data/Players/"+target.getUniqueId()+".yml");
            this.hhhhhmodif = YamlConfiguration.loadConfiguration(hhhhh);

            double Serveur = this.hhhhhmodif.getDouble("Joueur." + target.getUniqueId() + ".Argent");
            double b = Double.parseDouble(args[0]);
            double r = Serveur + b;
            this.hhhhhmodif.set("Joueur." + target.getUniqueId() + ".Argent", r);
            p.sendMessage(ChatColor.BLUE+args[0] + "$ on été donner à " + target.getName());
            target.sendMessage(ChatColor.BLUE+p.getName() +" ta donner "+args[0]+"$");
            try {
                hhhhhmodif.save(hhhhh);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            this.data = new File("plugins/Vakardia/Data/Players/" + p.getUniqueId() + ".yml");
            this.datamodif = YamlConfiguration.loadConfiguration(data);
            double monj = this.datamodif.getDouble("Joueur." + p.getUniqueId() + ".Argent");
            double g = monj - b;
            this.datamodif.set("Joueur." + p.getUniqueId() + ".Argent", g);
            try {
                datamodif.save(data);
            } catch (IOException e1) {
                e1.printStackTrace();
            }



        }
        if (cmd.getName().equalsIgnoreCase("money")) {
            this.data = new File("plugins/Vakardia/Data/Players/" + p.getUniqueId() + ".yml");
            this.datamodif = YamlConfiguration.loadConfiguration(data);
            Double ro = datamodif.getDouble("Joueur." + p.getUniqueId() + ".Argent");
            p.sendMessage("Money : "+ro);
        }
        return false;
    }
    private ItemStack nameItem(ItemStack item, String name, String lore) {
        ItemMeta meta = item.getItemMeta();
        meta.setLore(Collections.singletonList(lore));

        meta.setDisplayName(name);
        item.setItemMeta(meta);
        return item;
    }
    private ItemStack nameItem(Material item, String name, String lore) {
        return nameItem(new ItemStack(item), name,lore);
    }
}
