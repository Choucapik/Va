package be.mk.vakardia.Profils;

import be.mk.vakardia.Vakardia;
import javafx.util.Pair;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.inventory.FurnaceExtractEvent;
import org.bukkit.event.inventory.FurnaceSmeltEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.event.player.*;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.Furnace;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Profils implements Listener {

    private File data,chunk,serveur,tg;
    private FileConfiguration datamodif,chunksav,serveursave,tgtg;
    public CBDD sql;
    private FurnaceRecipe e;

    public Profils(CBDD cb){
        sql = cb;
    }

    @EventHandler
    public void onchat(AsyncPlayerChatEvent e){
        Player p = e.getPlayer();
        e.setCancelled(true);
        this.data = new File("plugins/Vakardia/Data/Players/"+p.getUniqueId()+".yml");
        this.datamodif = YamlConfiguration.loadConfiguration(data);
        String team = datamodif.getString("Joueur." + p.getUniqueId() + ".Race");
        String job = datamodif.getString("Joueur." + p.getUniqueId() + ".Job");
        String ro = datamodif.getString("Joueur." + p.getUniqueId() + ".Roy");
        if(team.equals("Vakarans")) {
                String vak = "V";
                Bukkit.broadcastMessage(ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + vak + ChatColor.DARK_GRAY + "]"+"["+ChatColor.GREEN+job+ChatColor.DARK_GRAY+"]"+"["+ChatColor.BLUE+ro+ChatColor.DARK_GRAY+"]"+ChatColor.WHITE+ e.getPlayer().getName() +" "+ e.getMessage());
        }
        if(team.equals("Mirchantes")) {
            String mir = "M";
            Bukkit.broadcastMessage(ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + mir + ChatColor.DARK_GRAY + "]"+"["+ChatColor.GREEN+job+ChatColor.DARK_GRAY+"]"+"["+ChatColor.BLUE+ro+ChatColor.DARK_GRAY+"]"+ChatColor.WHITE+ e.getPlayer().getName()+" " + e.getMessage());
        }
        if(team.equals("Galmantes")) {
            String Gal = "G";
            Bukkit.broadcastMessage(ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + Gal + ChatColor.DARK_GRAY + "]"+"["+ChatColor.GREEN+job+ChatColor.DARK_GRAY+"]"+"["+ChatColor.BLUE+ro+ChatColor.DARK_GRAY+"]"+ChatColor.WHITE+ e.getPlayer().getName() +" "+ e.getMessage());
        }
        if(team.equals("Elfes")) {
            String EL = "E";
            Bukkit.broadcastMessage(ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + EL + ChatColor.DARK_GRAY + "]"+"["+ChatColor.GREEN+job+ChatColor.DARK_GRAY+"]"+"["+ChatColor.BLUE+ro+ChatColor.DARK_GRAY+"]"+ChatColor.WHITE+ e.getPlayer().getName() +" "+ e.getMessage());
        }
        if(team.equals("Humains")) {
            String hum = "H";
            Bukkit.broadcastMessage(ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + hum + ChatColor.DARK_GRAY + "]"+"["+ChatColor.GREEN+job+ChatColor.DARK_GRAY+"]"+"["+ChatColor.BLUE+ro+ChatColor.DARK_GRAY+"]"+ChatColor.WHITE+ e.getPlayer().getName() +" "+ e.getMessage());
        }

    }


    @EventHandler
    public void onfurnace(FurnaceExtractEvent e){

    }
    @EventHandler
    public void craftItem(PrepareItemCraftEvent e) {


        Material itemType = e.getRecipe().getResult().getType();
        List<String> forg = new ArrayList<String>();
        forg.add("IRON_CHESTPLATE");
        forg.add("IRON_LEGGINGS");
        forg.add("IRON_HELMET");
        forg.add("IRON_BOOTS");
        forg.add("IRON_SWORD");
        forg.add("IRON_AXE");
        forg.add("IRON_PICKAXE");
        forg.add("IRON_SHOVEL");
        forg.add("IRON_HOE");
        forg.add("BUCKET");
        forg.add("SHEARS");
        forg.add("GOLDEN_AXE");
        forg.add("GOLDEN_PICKAXE");
        forg.add("GOLDEN_SHOVEL");
        forg.add("GOLDEN_HOE");
        forg.add("GOLDEN_SWORD");
        forg.add("GOLDEN_CHESTPLATE");
        forg.add("GOLDEN_LEGGINGS");
        forg.add("GOLDEN_HELMET");
        forg.add("GOLDEN_BOOTS");
        forg.add("ANVIL");
        forg.add("DIAMOND_AXE");
        forg.add("DIAMOND_PICKAXE");
        forg.add("DIAMOND_SHOVEL");
        forg.add("DIAMOND_HOE");
        forg.add("DIAMOND_SWORD");
        forg.add("DIAMOND_CHESTPLATE");
        forg.add("DIAMOND_LEGGINGS");
        forg.add("DIAMOND_HELMET");
        forg.add("DIAMOND_BOOTS");
        if (forg.contains(itemType.toString())) {
            for (HumanEntity human : e.getViewers()){
                this.data = new File("plugins/Vakardia/Data/Players/"+human.getUniqueId()+".yml");
                this.datamodif = YamlConfiguration.loadConfiguration(data);
                if (!datamodif.getString("Joueur." + human.getUniqueId() + ".Job").equals("Forgeron")) {
                    human.sendMessage(ChatColor.RED + "[Vakardia]Tu n'est pas Forgeron !");
                    e.getInventory().setResult(new ItemStack(Material.AIR));
                }
            }
        }
        List<String> FER = new ArrayList<String>();
        FER.add("MUSHROOM_STEW");
        FER.add("BEETROOT_SOUP");
        FER.add("BREAD");
        if (FER.contains(itemType.toString())) {
            for (HumanEntity human : e.getViewers()){
                this.data = new File("plugins/Vakardia/Data/Players/"+human.getUniqueId()+".yml");
                this.datamodif = YamlConfiguration.loadConfiguration(data);
                if (!datamodif.getString("Joueur." + human.getUniqueId() + ".Job").equals("Fermier")) {
                    human.sendMessage(ChatColor.RED + "[Vakardia]Tu n'est pas Fermier !");
                    e.getInventory().setResult(new ItemStack(Material.AIR));
                }
            }
        }
        List<String> bli = new ArrayList<String>();
        bli.add("BOOK");
        bli.add("WRITABLE_BOOK");
        bli.add("MAP");
        bli.add("PAPER");
        if (bli.contains(itemType.toString())) {
            for (HumanEntity human : e.getViewers()){
                this.data = new File("plugins/Vakardia/Data/Players/"+human.getUniqueId()+".yml");
                this.datamodif = YamlConfiguration.loadConfiguration(data);
                if (!datamodif.getString("Joueur." + human.getUniqueId() + ".Job").equals("Blibliothécaire")) {
                    human.sendMessage(ChatColor.RED + "[Vakardia]Tu n'est pas Blibliothécaire !");
                    e.getInventory().setResult(new ItemStack(Material.AIR));
                }
            }
        }
        List<String> ta = new ArrayList<String>();
        ta.add("STONEBRICK");
        ta.add("WRITABLE_BOOK");
        ta.add("STONE_STAIRS");
        ta.add("STONE_SLAB");
        ta.add("COBBLESTONE_WALL");
        ta.add("STONE_SHOVEL");
        ta.add("STONE_PICKAXE");
        ta.add("STONE_AXE");
        ta.add("STONE_SWORD");
        if (ta.contains(itemType.toString())) {
            for (HumanEntity human : e.getViewers()){
                this.data = new File("plugins/Vakardia/Data/Players/"+human.getUniqueId()+".yml");
                this.datamodif = YamlConfiguration.loadConfiguration(data);
                if (!datamodif.getString("Joueur." + human.getUniqueId() + ".Job").equals("Tailleur")) {
                    human.sendMessage(ChatColor.RED + "[Vakardia]Tu n'est pas Tailleur de Pierre!");
                    e.getInventory().setResult(new ItemStack(Material.AIR));
                }
            }
        }
        List<String> menui = new ArrayList<String>();
        menui.add("CRAFTING_TABLE");
        menui.add("CHEST");
        menui.add("BED");
        menui.add("PLANKS");
        menui.add("WOOODEN_SLAB");
        menui.add("WOOODEN_DOOR");
        menui.add("SPRUCE_DOOR");
        menui.add("BIRCH_DOOR");
        menui.add("JUNGLE_DOOR");
        menui.add("ACACIA_DOOR");
        menui.add("DARK_OAK_DOOR");

        menui.add("WOOODEN_STAIRS");
        menui.add("SPRUCE_STAIRS");
        menui.add("BIRCH_STAIRS");
        menui.add("JUNGLE_STAIRS");
        menui.add("ACACIA_STAIRS");
        menui.add("DARK_OAK_STAIRS");

        menui.add("WOOODEN_FENCE_GATE");
        menui.add("SPRUCE_FENCE_GATE");
        menui.add("BIRCH_FENCE_GATE");
        menui.add("JUNGLE_FENCE_GATE");
        menui.add("ACACIA_FENCE_GATE");
        menui.add("DARK_OAK_FENCE_GATE");

        if (menui.contains(itemType.toString())) {
            for (HumanEntity human : e.getViewers()){
                this.data = new File("plugins/Vakardia/Data/Players/"+human.getUniqueId()+".yml");
                this.datamodif = YamlConfiguration.loadConfiguration(data);
                if (!datamodif.getString("Joueur." + human.getUniqueId() + ".Job").equals("Menuisier")) {
                    human.sendMessage(ChatColor.RED + "[Vakardia]Tu n'est pas Menuisier !");
                    e.getInventory().setResult(new ItemStack(Material.AIR));
                }
            }
        }
    }
    @EventHandler
    @Deprecated
    public void onConnect(PlayerJoinEvent e){
        this.tg = new File("plugins/Vakardia/Data/Players/"+e.getPlayer().getUniqueId()+".yml");
        this.tgtg = YamlConfiguration.loadConfiguration(tg);
        Player p = e.getPlayer();

        double m = tgtg.getDouble("Joueur." + p.getUniqueId() + ".Argent");
        String r = tgtg.getString("Joueur." + p.getUniqueId() + ".Race");
        String j = tgtg.getString("Joueur." + p.getUniqueId() + ".Job");
        String roy = tgtg.getString("Joueur." + p.getUniqueId() + ".Roy");
        if(!sql.hasprofil(p)){
            sql.addprofil(p,m,r,j,roy);
        }
        //double money = sql.getmoney(e.getPlayer());
        //p.sendMessage(String.valueOf(money));

        if(p.isOp()){
            e.setJoinMessage(ChatColor.DARK_GRAY+"["+ChatColor.RESET+ChatColor.GREEN+"+"+ChatColor.DARK_GRAY+"]"+ChatColor.RESET+ChatColor.GOLD+"[MJ]"+e.getPlayer().getName()+ChatColor.RESET+" viens de se réveiller");
            e.getPlayer().setPlayerListName(ChatColor.GOLD+"[MJ]"+p.getName());

        }else{
            e.getPlayer().setPlayerListName(ChatColor.DARK_GRAY+"[J]"+ChatColor.WHITE+p.getName());
            e.setJoinMessage(ChatColor.DARK_GRAY+"["+ChatColor.RESET+ChatColor.GREEN+"+"+ChatColor.DARK_GRAY+"]"+ChatColor.RESET+ChatColor.GRAY+e.getPlayer().getName()+" viens de se réveiller");
        }
        this.data = new File("plugins/Vakardia/Data/Players/"+p.getUniqueId()+".yml");
        this.datamodif = YamlConfiguration.loadConfiguration(data);

        //if(!sql.hasprofil(p)){
          // sql.addprofil(p,datamodif.getDouble("Joueur." + p.getUniqueId() + ".Argent"),datamodif.getString("Joueur." + p.getUniqueId() + ".Race"),datamodif.getString("Joueur." + p.getUniqueId() + ".Job"),datamodif.getString("Joueur." + p.getUniqueId() + ".Roy"));
        //}else{
          //  sql.udpate(p,datamodif.getDouble("Joueur." + p.getUniqueId() + ".Argent"),datamodif.getString("Joueur." + p.getUniqueId() + ".Race"),datamodif.getString("Joueur." + p.getUniqueId() + ".Job"),datamodif.getString("Joueur." + p.getUniqueId() + ".Roy"));
        //}
        this.data = new File("plugins/Vakardia/Data/Players/"+p.getUniqueId()+".yml");
        this.datamodif = YamlConfiguration.loadConfiguration(data);
        String jobdefault = "null";
        if(!data.exists()){
            Location s = new Location(Bukkit.getWorld("Med"),-258.5,205,-110.5,0,0);
            Inventory test = Bukkit.createInventory(null, 5 * 9, ChatColor.BLUE + "Races");
            ItemStack vak = nameItem(Material.WATCH, "Vakarans", "");
            ItemStack Mir = nameItem(Material.WATCH, "Mirchantes", "");
            ItemStack gal = nameItem(Material.WATCH, "Galmantes", "");
            ItemStack elf = nameItem(Material.WATCH, "Elfes", "");
            ItemStack hum = nameItem(Material.WATCH, "Humains", "");
            ItemStack air = nameItem(Material.STAINED_GLASS_PANE, " ", "");
            test.setItem(0, air);
            test.setItem(1, air);
            test.setItem(2, air);
            test.setItem(3, air);
            test.setItem(4, air);
            test.setItem(5, air);
            test.setItem(6, air);
            test.setItem(7, air);
            test.setItem(8, air);
            test.setItem(9, air);
            test.setItem(10, vak);
            test.setItem(11, air);
            test.setItem(12, air);
            test.setItem(13, Mir);
            test.setItem(14, air);
            test.setItem(15, air);
            test.setItem(16, gal);
            test.setItem(17, air);
            test.setItem(18, air);
            test.setItem(19, air);
            test.setItem(20, air);
            test.setItem(21, air);
            test.setItem(22, air);
            test.setItem(23, air);
            test.setItem(24, air);
            test.setItem(25, air);
            test.setItem(26, air);
            test.setItem(27, air);
            test.setItem(28, air);
            test.setItem(29, air);
            test.setItem(30, elf);
            test.setItem(31, air);
            test.setItem(32, hum);
            test.setItem(33, air);
            test.setItem(34, air);
            test.setItem(35, air);
            test.setItem(36, air);
            test.setItem(37, air);
            test.setItem(38, air);
            test.setItem(39, air);
            test.setItem(40, air);
            test.setItem(41, air);
            test.setItem(42, air);
            test.setItem(43, air);
            test.setItem(44, air);
            Bukkit.getScheduler().runTaskLater(Vakardia.getPluginInstance(), new Runnable() {
                @Override
                public void run() {
                    p.openInventory(test);
                    p.teleport(s);
                    p.setWalkSpeed(0.0f);
                    p.setFlySpeed(0.0f);
                    p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP,Integer.MAX_VALUE,250));
                }
            }, 3 * 20L);
        }
        if(data.exists()) {



            if (datamodif.getString("Joueur." + e.getPlayer().getUniqueId() + ".Race").equals("Vakarans")) {
                p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, Integer.MAX_VALUE, 1));
                p.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, Integer.MAX_VALUE, 1));
                p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, Integer.MAX_VALUE, 1));
                p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, Integer.MAX_VALUE, 0));
            }
            if (datamodif.getString("Joueur." + e.getPlayer().getUniqueId() + ".Race").equals("Mirchantes")) {
                p.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, Integer.MAX_VALUE, 1));
                p.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, Integer.MAX_VALUE, 5));
                p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 1));
            }
            if (datamodif.getString("Joueur." + e.getPlayer().getUniqueId() + ".Race").equals("Galmantes")) {
                p.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, Integer.MAX_VALUE, 4));
                p.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, Integer.MAX_VALUE, 5));
            }
            if (datamodif.getString("Joueur." + e.getPlayer().getUniqueId() + ".Race").equals("Elfes")) {
                p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, Integer.MAX_VALUE,2));
                p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 1));
                p.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, Integer.MAX_VALUE, 3));
            }
        }
    }
    @EventHandler
    public void onrespawn(PlayerRespawnEvent e){
        Player p = e.getPlayer();
        this.data = new File("plugins/Vakardia/Data/Players/"+p.getUniqueId()+".yml");
        this.datamodif = YamlConfiguration.loadConfiguration(data);
        if(data.exists()) {
            if (datamodif.getString("Joueur." + e.getPlayer().getUniqueId() + ".Race").equals("Vakarans")) {
                p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, Integer.MAX_VALUE, 2));
                p.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, Integer.MAX_VALUE, 1));
                p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, Integer.MAX_VALUE, 1));
                p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, Integer.MAX_VALUE, 2));
            }
            if (datamodif.getString("Joueur." + e.getPlayer().getUniqueId() + ".Race").equals("Mirchantes")) {
                p.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, Integer.MAX_VALUE, 3));
                p.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, Integer.MAX_VALUE, 5));
                p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 1));
            }
            if (datamodif.getString("Joueur." + e.getPlayer().getUniqueId() + ".Race").equals("Galmantes")) {
                p.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, Integer.MAX_VALUE, 4));
                p.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, Integer.MAX_VALUE, 5));
            }
            if (datamodif.getString("Joueur." + e.getPlayer().getUniqueId() + ".Race").equals("Elfes")) {
                p.addPotionEffect(new PotionEffect(PotionEffectType.HEAL, Integer.MAX_VALUE, 1));
                p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 1));
            }
        }
    }
    @EventHandler
    public void onDisable(PlayerQuitEvent e){
        this.tg = new File("plugins/Vakardia/Data/Players/"+e.getPlayer().getUniqueId()+".yml");
        this.tgtg = YamlConfiguration.loadConfiguration(tg);
        Player p = e.getPlayer();
        double m = tgtg.getDouble("Joueur." + p.getUniqueId() + ".Argent");
        String r = tgtg.getString("Joueur." + p.getUniqueId() + ".Race");
        String j = tgtg.getString("Joueur." + p.getUniqueId() + ".Job");
        String roy = tgtg.getString("Joueur." + p.getUniqueId() + ".Roy");
        //sql.udpate(p,m,r,j,roy);
        e.setQuitMessage(ChatColor.DARK_GRAY+"["+ChatColor.RESET+ChatColor.RED+"-"+ChatColor.DARK_GRAY+"]"+ChatColor.RESET+ChatColor.GRAY+e.getPlayer().getName()+" viens de s'endormir");
        //Pair<Statement, ResultSet> ds = sql.procedure("SELECT @@VERSION");
        /*try {
            ResultSet g = ds.getValue();
            if(g.next()) {

                Bukkit.broadcastMessage(String.valueOf(g.getObject(1)));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } */

    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        this.data = new File("plugins/Vakardia/Data/Players/"+e.getWhoClicked().getUniqueId()+".yml");
        this.datamodif = YamlConfiguration.loadConfiguration(data);
        Player p = (Player) e.getWhoClicked();
        ItemStack item = e.getCurrentItem();
        String jobdefault = "null";
        if (e.getView().getTitle().equalsIgnoreCase(ChatColor.BLUE + "Races")) {
            if (item.getItemMeta().getDisplayName().equalsIgnoreCase("Vakarans")) {
                e.setCancelled(true);
                p.removePotionEffect(PotionEffectType.JUMP);
                p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,Integer.MAX_VALUE,1));
                p.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST,Integer.MAX_VALUE,1));
                p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE,Integer.MAX_VALUE,1));
                p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING,Integer.MAX_VALUE,0));
                try {
                    data.createNewFile();
                    datamodif.set("Joueur." + p.getUniqueId() + ".Pseudo", p.getName());
                    datamodif.set("Joueur." + p.getUniqueId() + ".Argent", 50.0);
                    datamodif.set("Joueur." + p.getUniqueId() + ".Race", "Vakarans");
                    datamodif.set("Joueur." + p.getUniqueId() + ".Job", jobdefault);
                    datamodif.set("Joueur." + p.getUniqueId() + ".Roy", "Empire");
                    datamodif.set("Joueur." + p.getUniqueId() + ".Team-lvl", 0);
                    datamodif.set("Joueur." + p.getUniqueId() + ".Permission", 0);
                    datamodif.save(data);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }

                Inventory test = Bukkit.createInventory(null, 5 * 9, ChatColor.BLUE + "Métier");
                ItemStack guerrier = nameItem(Material.WATCH, "Guerrier", "");
                ItemStack forgeron = nameItem(Material.WATCH, "Forgeron", "");
                ItemStack menuisier = nameItem(Material.WATCH, "Menuisier", "");
                ItemStack tailleur = nameItem(Material.WATCH, "Tailleur", "");
                ItemStack min = nameItem(Material.WATCH, "Mineur", "");
                ItemStack chas = nameItem(Material.WATCH, "Chasseur", "");
                ItemStack air = nameItem(Material.STAINED_GLASS, " ", "");
                test.setItem(0, air);
                test.setItem(1, air);
                test.setItem(2, air);
                test.setItem(3, air);
                test.setItem(4, air);
                test.setItem(5, air);
                test.setItem(6, air);
                test.setItem(7, air);
                test.setItem(8, air);
                test.setItem(9, air);
                test.setItem(10, guerrier);
                test.setItem(11, air);
                test.setItem(12, air);
                test.setItem(13, forgeron);
                test.setItem(14, air);
                test.setItem(15, air);
                test.setItem(16, menuisier);
                test.setItem(17, air);
                test.setItem(18, air);
                test.setItem(19, air);
                test.setItem(20, air);
                test.setItem(21, air);
                test.setItem(22, air);
                test.setItem(23, air);
                test.setItem(24, air);
                test.setItem(25, air);
                test.setItem(26, air);
                test.setItem(27, air);
                test.setItem(28, tailleur);
                test.setItem(29, air);
                test.setItem(30, air);
                test.setItem(31, min);
                test.setItem(32, air);
                test.setItem(33, air);
                test.setItem(34, chas);
                test.setItem(35, air);
                test.setItem(36, air);
                test.setItem(37, air);
                test.setItem(38, air);
                test.setItem(39, air);
                test.setItem(40, air);
                test.setItem(41, air);
                test.setItem(42, air);
                test.setItem(43, air);
                test.setItem(44, air);
                p.openInventory(test);
            }
            if (item.getItemMeta().getDisplayName().equalsIgnoreCase("Mirchantes")) {
                e.setCancelled(true);
                p.removePotionEffect(PotionEffectType.JUMP);
                p.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS,Integer.MAX_VALUE,3));
                p.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING,Integer.MAX_VALUE,5));
                p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED,Integer.MAX_VALUE,1));
                try {
                    data.createNewFile();
                    datamodif.set("Joueur." + p.getUniqueId() + ".Pseudo", p.getName());
                    datamodif.set("Joueur." + p.getUniqueId() + ".Argent", 50.0);
                    datamodif.set("Joueur." + p.getUniqueId() + ".Race", "Mirchantes");
                    datamodif.set("Joueur." + p.getUniqueId() + ".Job", jobdefault);
                    datamodif.set("Joueur." + p.getUniqueId() + ".Roy", "Empire");
                    datamodif.set("Joueur." + p.getUniqueId() + ".Team-lvl", 0);
                    datamodif.set("Joueur." + p.getUniqueId() + ".Permission", 0);
                    datamodif.save(data);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                Inventory test = Bukkit.createInventory(null, 5 * 9, ChatColor.BLUE + "Métier");
                ItemStack fermier = nameItem(Material.WATCH, "Fermier", "");
                ItemStack Bûcheron = nameItem(Material.WATCH, "Bucheron", "");
                ItemStack Enchenteur = nameItem(Material.WATCH, "Enchenteur", "");
                ItemStack Druide = nameItem(Material.WATCH, "Druide", "");
                ItemStack Menuisier = nameItem(Material.WATCH, "Menuisier", "");
                ItemStack Eleveur = nameItem(Material.WATCH, "Eleveur", "");
                ItemStack air = nameItem(Material.STAINED_GLASS, " ", "");
                test.setItem(0, air);
                test.setItem(1, air);
                test.setItem(2, air);
                test.setItem(3, air);
                test.setItem(4, air);
                test.setItem(5, air);
                test.setItem(6, air);
                test.setItem(7, air);
                test.setItem(8, air);
                test.setItem(9, air);
                test.setItem(10, fermier);
                test.setItem(11, air);
                test.setItem(12, air);
                test.setItem(13, Bûcheron);
                test.setItem(14, air);
                test.setItem(15, air);
                test.setItem(16, Enchenteur);
                test.setItem(17, air);
                test.setItem(18, air);
                test.setItem(19, air);
                test.setItem(20, air);
                test.setItem(21, air);
                test.setItem(22, air);
                test.setItem(23, air);
                test.setItem(24, air);
                test.setItem(25, air);
                test.setItem(26, air);
                test.setItem(27, air);
                test.setItem(28, Druide);
                test.setItem(29, air);
                test.setItem(30, air);
                test.setItem(31, Menuisier);
                test.setItem(32, air);
                test.setItem(33, air);
                test.setItem(34, Eleveur);
                test.setItem(35, air);
                test.setItem(36, air);
                test.setItem(37, air);
                test.setItem(38, air);
                test.setItem(39, air);
                test.setItem(40, air);
                test.setItem(41, air);
                test.setItem(42, air);
                test.setItem(43, air);
                test.setItem(44, air);
                p.openInventory(test);
            }
            if (item.getItemMeta().getDisplayName().equalsIgnoreCase("Galmantes")) {
                e.setCancelled(true);
                p.removePotionEffect(PotionEffectType.JUMP);
                p.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST,Integer.MAX_VALUE,4));
                p.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE,Integer.MAX_VALUE,5));
                try {
                    data.createNewFile();
                    datamodif.set("Joueur." + p.getUniqueId() + ".Pseudo", p.getName());
                    datamodif.set("Joueur." + p.getUniqueId() + ".Argent", 50.0);
                    datamodif.set("Joueur." + p.getUniqueId() + ".Race", "Galmantes");
                    datamodif.set("Joueur." + p.getUniqueId() + ".Job", jobdefault);
                    datamodif.set("Joueur." + p.getUniqueId() + ".Roy", "Empire");
                    datamodif.set("Joueur." + p.getUniqueId() + ".Team-lvl", 0);
                    datamodif.set("Joueur." + p.getUniqueId() + ".Permission", 0);
                    datamodif.save(data);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                Inventory test = Bukkit.createInventory(null, 5 * 9, ChatColor.BLUE + "Métier");
                ItemStack vak = nameItem(Material.WATCH, "Druide", "");
                ItemStack Mir = nameItem(Material.WATCH, "Guerrier", "");
                ItemStack gal = nameItem(Material.WATCH, "Forgeron", "");
                ItemStack elf = nameItem(Material.WATCH, "Mineur", "");
                ItemStack hum = nameItem(Material.WATCH, "Tailleur", "");
                ItemStack air = nameItem(Material.STAINED_GLASS, " ", "");
                test.setItem(0, air);
                test.setItem(1, air);
                test.setItem(2, air);
                test.setItem(3, air);
                test.setItem(4, air);
                test.setItem(5, air);
                test.setItem(6, air);
                test.setItem(7, air);
                test.setItem(8, air);
                test.setItem(9, air);
                test.setItem(10, vak);
                test.setItem(11, air);
                test.setItem(12, air);
                test.setItem(13, Mir);
                test.setItem(14, air);
                test.setItem(15, air);
                test.setItem(16, gal);
                test.setItem(17, air);
                test.setItem(18, air);
                test.setItem(19, air);
                test.setItem(20, air);
                test.setItem(21, air);
                test.setItem(22, air);
                test.setItem(23, air);
                test.setItem(24, air);
                test.setItem(25, air);
                test.setItem(26, air);
                test.setItem(27, air);
                test.setItem(28, air);
                test.setItem(29, air);
                test.setItem(30, elf);
                test.setItem(31, air);
                test.setItem(32, hum);
                test.setItem(33, air);
                test.setItem(34, air);
                test.setItem(35, air);
                test.setItem(36, air);
                test.setItem(37, air);
                test.setItem(38, air);
                test.setItem(39, air);
                test.setItem(40, air);
                test.setItem(41, air);
                test.setItem(42, air);
                test.setItem(43, air);
                test.setItem(44, air);
                p.openInventory(test);
            }
            if (item.getItemMeta().getDisplayName().equalsIgnoreCase("Elfes")) {
                e.setCancelled(true);
                p.removePotionEffect(PotionEffectType.JUMP);
                p.addPotionEffect(new PotionEffect(PotionEffectType.HEAL,Integer.MAX_VALUE,1));
                p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED,Integer.MAX_VALUE,1));
                try {
                    data.createNewFile();
                    datamodif.set("Joueur." + p.getUniqueId() + ".Pseudo", p.getName());
                    datamodif.set("Joueur." + p.getUniqueId() + ".Argent", 50.0);
                    datamodif.set("Joueur." + p.getUniqueId() + ".Race", "Elfes");
                    datamodif.set("Joueur." + p.getUniqueId() + ".Job", jobdefault);
                    datamodif.set("Joueur." + p.getUniqueId() + ".Roy", "Empire");
                    datamodif.set("Joueur." + p.getUniqueId() + ".Team-lvl", 0);
                    datamodif.set("Joueur." + p.getUniqueId() + ".Permission", 0);
                    datamodif.save(data);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                Inventory test = Bukkit.createInventory(null, 5 * 9, ChatColor.BLUE + "Métier");
                ItemStack vak = nameItem(Material.WATCH, "Magicien", "");
                ItemStack gal = nameItem(Material.WATCH, "Blibliothécaire", "");
                ItemStack elf = nameItem(Material.WATCH, "Druide", "");
                ItemStack hum = nameItem(Material.WATCH, "Guerrier", "");
                ItemStack air = nameItem(Material.STAINED_GLASS, " ", "");
                test.setItem(0, air);
                test.setItem(1, air);
                test.setItem(2, air);
                test.setItem(3, air);
                test.setItem(4, air);
                test.setItem(5, air);
                test.setItem(6, air);
                test.setItem(7, air);
                test.setItem(8, air);
                test.setItem(9, air);
                test.setItem(10, vak);
                test.setItem(11, air);
                test.setItem(12, air);
                test.setItem(13, air);
                test.setItem(14, air);
                test.setItem(15, air);
                test.setItem(16, gal);
                test.setItem(17, air);
                test.setItem(18, air);
                test.setItem(19, air);
                test.setItem(20, air);
                test.setItem(21, air);
                test.setItem(22, air);
                test.setItem(23, air);
                test.setItem(24, air);
                test.setItem(25, air);
                test.setItem(26, air);
                test.setItem(27, air);
                test.setItem(28, elf);
                test.setItem(29, air);
                test.setItem(30, air);
                test.setItem(31, air);
                test.setItem(32, air);
                test.setItem(33, air);
                test.setItem(34, hum);
                test.setItem(35, air);
                test.setItem(36, air);
                test.setItem(37, air);
                test.setItem(38, air);
                test.setItem(39, air);
                test.setItem(40, air);
                test.setItem(41, air);
                test.setItem(42, air);
                test.setItem(43, air);
                test.setItem(44, air);
                p.openInventory(test);
            }
            if (item.getItemMeta().getDisplayName().equalsIgnoreCase("Humains")) {
                try {
                    data.createNewFile();
                    datamodif.set("Joueur." + p.getUniqueId() + ".Pseudo", p.getName());
                    datamodif.set("Joueur." + p.getUniqueId() + ".Argent", 50.0);
                    datamodif.set("Joueur." + p.getUniqueId() + ".Race", "Humains");
                    datamodif.set("Joueur." + p.getUniqueId() + ".Job", jobdefault);
                    datamodif.set("Joueur." + p.getUniqueId() + ".Roy", "Empire");
                    datamodif.set("Joueur." + p.getUniqueId() + ".Team-lvl", 0);
                    datamodif.set("Joueur." + p.getUniqueId() + ".Permission", 0);
                    datamodif.save(data);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                p.removePotionEffect(PotionEffectType.JUMP);
                e.setCancelled(true);
                Inventory test = Bukkit.createInventory(null, 6 * 9, ChatColor.BLUE + "Métier");
                ItemStack Fermier = nameItem(Material.WATCH, "Fermier", "");
                ItemStack Eleveur = nameItem(Material.WATCH, "Eleveur", "");
                ItemStack Bucheron = nameItem(Material.WATCH, "Bucheron", "");
                ItemStack Mineur = nameItem(Material.WATCH, "Mineur", "");
                ItemStack Chasseur = nameItem(Material.WATCH, "Chasseur", "");
                ItemStack Forgeron = nameItem(Material.WATCH, "Forgeron", "");
                ItemStack Tailleurdepierre = nameItem(Material.WATCH, "Tailleur de pierre", "");
                ItemStack Menuisier = nameItem(Material.WATCH, "Menuisier", "");
                ItemStack Druide = nameItem(Material.WATCH, "Druide", "");
                ItemStack Blibliothécaire = nameItem(Material.WATCH, "Blibliothécaire", "");
                ItemStack Magicien = nameItem(Material.WATCH, "Magicien", "");
                ItemStack Guerrier = nameItem(Material.WATCH, "Guerrier", "");
                ItemStack air = nameItem(Material.STAINED_GLASS, " ", "");
                test.setItem(0, air);
                test.setItem(1, air);
                test.setItem(2, air);
                test.setItem(3, air);
                test.setItem(4, air);
                test.setItem(5, air);
                test.setItem(6, air);
                test.setItem(7, air);
                test.setItem(8, air);
                test.setItem(9, air);
                test.setItem(10, Fermier);
                test.setItem(11, air);
                test.setItem(12, air);
                test.setItem(13, Eleveur);
                test.setItem(14, air);
                test.setItem(15, air);
                test.setItem(16, Bucheron);
                test.setItem(17, air);
                test.setItem(18, air);
                test.setItem(19, Mineur);
                test.setItem(20, air);
                test.setItem(21, air);
                test.setItem(22, Chasseur);
                test.setItem(23, air);
                test.setItem(24, air);
                test.setItem(25, Forgeron);
                test.setItem(26, air);
                test.setItem(27, air);
                test.setItem(28, Tailleurdepierre);
                test.setItem(29, air);
                test.setItem(30, air);
                test.setItem(31, Menuisier);
                test.setItem(32, air);
                test.setItem(33, air);
                test.setItem(34, Druide);
                test.setItem(35, air);
                test.setItem(36, air);
                test.setItem(37, Blibliothécaire);
                test.setItem(38, air);
                test.setItem(39, air);
                test.setItem(40, Magicien);
                test.setItem(41, air);
                test.setItem(42, air);
                test.setItem(43, Guerrier);
                test.setItem(44, air);
                test.setItem(45, air);
                test.setItem(46, air);
                test.setItem(47, air);
                test.setItem(48, air);
                test.setItem(49, air);
                test.setItem(50, air);
                test.setItem(51, air);
                test.setItem(52, air);
                test.setItem(53, air);
                p.openInventory(test);
            }
            e.setCancelled(true);
        }
        if (e.getView().getTitle().equalsIgnoreCase(ChatColor.BLUE + "Métier")) {
            e.setCancelled(true);
            if (item.getItemMeta().getDisplayName().equalsIgnoreCase("Guerrier")){
                try {
                    datamodif.set("Joueur." + p.getUniqueId() + ".Job", "Guerrier");
                    datamodif.save(data);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                p.setWalkSpeed(0.2f);
                p.setFlySpeed(0.2f);
            }
            if (item.getItemMeta().getDisplayName().equalsIgnoreCase("Magicien")){
                try {
                    datamodif.set("Joueur." + p.getUniqueId() + ".Job", "Magicien");
                    datamodif.save(data);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                p.setWalkSpeed(0.2f);
                p.setFlySpeed(0.2f);
            }
            if (item.getItemMeta().getDisplayName().equalsIgnoreCase("Blibliothécaire")){
                try {
                    datamodif.set("Joueur." + p.getUniqueId() + ".Job", "Blibliothécaire");
                    datamodif.save(data);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                p.setWalkSpeed(0.2f);
                p.setFlySpeed(0.2f);
            }
            if (item.getItemMeta().getDisplayName().equalsIgnoreCase("Druide")){
                try {
                    datamodif.set("Joueur." + p.getUniqueId() + ".Job", "Druide");
                    datamodif.save(data);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                p.setWalkSpeed(0.2f);
                p.setFlySpeed(0.2f);
            }
            if (item.getItemMeta().getDisplayName().equalsIgnoreCase("Menuisier")){
                try {
                    datamodif.set("Joueur." + p.getUniqueId() + ".Job", "Menuisier");
                    datamodif.save(data);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                p.setWalkSpeed(0.2f);
                p.setFlySpeed(0.2f);
            }
            if (item.getItemMeta().getDisplayName().equalsIgnoreCase("Tailleur de pierre")){
                try {
                    datamodif.set("Joueur." + p.getUniqueId() + ".Job", "Tailleurdepierre");
                    datamodif.save(data);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                p.setWalkSpeed(0.2f);
                p.setFlySpeed(0.2f);
            }
            if (item.getItemMeta().getDisplayName().equalsIgnoreCase("Forgeron")){
                try {
                    datamodif.set("Joueur." + p.getUniqueId() + ".Job", "Forgeron");
                    datamodif.save(data);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                p.setWalkSpeed(0.2f);
                p.setFlySpeed(0.2f);
            }
            if (item.getItemMeta().getDisplayName().equalsIgnoreCase("Chasseur")){
                try {
                    datamodif.set("Joueur." + p.getUniqueId() + ".Job", "Chasseur");
                    datamodif.save(data);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                p.setWalkSpeed(0.2f);
                p.setFlySpeed(0.2f);
            }
            if (item.getItemMeta().getDisplayName().equalsIgnoreCase("Mineur")){
                try {
                    datamodif.set("Joueur." + p.getUniqueId() + ".Job", "Mineur");
                    datamodif.save(data);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                p.setWalkSpeed(0.2f);
                p.setFlySpeed(0.2f);
            }
            if (item.getItemMeta().getDisplayName().equalsIgnoreCase("Bucheron")){
                try {
                    datamodif.set("Joueur." + p.getUniqueId() + ".Job", "Bucheron");
                    datamodif.save(data);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                p.setWalkSpeed(0.2f);
                p.setFlySpeed(0.2f);
            }
            if (item.getItemMeta().getDisplayName().equalsIgnoreCase("Eleveur")){
                try {
                    datamodif.set("Joueur." + p.getUniqueId() + ".Job", "Eleveur");
                    datamodif.save(data);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                p.setWalkSpeed(0.2f);
                p.setFlySpeed(0.2f);
            }
            if (item.getItemMeta().getDisplayName().equalsIgnoreCase("Fermier")){
                try {
                    datamodif.set("Joueur." + p.getUniqueId() + ".Job", "Fermier");
                    datamodif.save(data);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                p.setWalkSpeed(0.2f);
                p.setFlySpeed(0.2f);
            }
        }
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
    @EventHandler
    public void sign(SignChangeEvent e) {
        if(e.getPlayer().isOp()) {
            if (e.getLine(0).equalsIgnoreCase("[tg]")) {
                e.setLine(0, ChatColor.BLUE +""+ChatColor.BOLD +">--------<");
                e.setLine(1, ChatColor.BLUE +""+ChatColor.BOLD +"Choix pour");
                e.setLine(2, ChatColor.BLUE + ""+ChatColor.BOLD+"les nouveaux");
                e.setLine(3, ChatColor.BLUE +""+ChatColor.BOLD +">--------<");
            }
        }
    }
    @EventHandler
    public void interact(PlayerInteractEvent e) {
        this.data = new File("plugins/Vakardia/Data/Players/"+e.getPlayer().getUniqueId()+".yml");
        this.datamodif = YamlConfiguration.loadConfiguration(data);
        if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (e.getClickedBlock().getState() instanceof Sign) {
                Sign s = (Sign) e.getClickedBlock().getState();
                if (s.getLine(0).equalsIgnoreCase(ChatColor.BLUE +""+ChatColor.BOLD+ ">--------<")) {
                    if(!data.exists()) {
                        Inventory test = Bukkit.createInventory(null, 5 * 9, ChatColor.BLUE + "Races");
                        ItemStack vak = nameItem(Material.WATCH, "Vakarans", "");
                        ItemStack Mir = nameItem(Material.WATCH, "Mirchantes", "");
                        ItemStack gal = nameItem(Material.WATCH, "Galmantes", "");
                        ItemStack elf = nameItem(Material.WATCH, "Elfes", "");
                        ItemStack hum = nameItem(Material.WATCH, "Humains", "");
                        ItemStack air = nameItem(Material.STAINED_GLASS_PANE, " ", "");
                        test.setItem(0, air);
                        test.setItem(1, air);
                        test.setItem(2, air);
                        test.setItem(3, air);
                        test.setItem(4, air);
                        test.setItem(5, air);
                        test.setItem(6, air);
                        test.setItem(7, air);
                        test.setItem(8, air);
                        test.setItem(9, air);
                        test.setItem(10, vak);
                        test.setItem(11, air);
                        test.setItem(12, air);
                        test.setItem(13, Mir);
                        test.setItem(14, air);
                        test.setItem(15, air);
                        test.setItem(16, gal);
                        test.setItem(17, air);
                        test.setItem(18, air);
                        test.setItem(19, air);
                        test.setItem(20, air);
                        test.setItem(21, air);
                        test.setItem(22, air);
                        test.setItem(23, air);
                        test.setItem(24, air);
                        test.setItem(25, air);
                        test.setItem(26, air);
                        test.setItem(27, air);
                        test.setItem(28, air);
                        test.setItem(29, air);
                        test.setItem(30, elf);
                        test.setItem(31, air);
                        test.setItem(32, hum);
                        test.setItem(33, air);
                        test.setItem(34, air);
                        test.setItem(35, air);
                        test.setItem(36, air);
                        test.setItem(37, air);
                        test.setItem(38, air);
                        test.setItem(39, air);
                        test.setItem(40, air);
                        test.setItem(41, air);
                        test.setItem(42, air);
                        test.setItem(43, air);
                        test.setItem(44, air);
                        e.getPlayer().openInventory(test);
                    }
                }
            }
        }
    }
}
