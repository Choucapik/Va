package be.mk.vakardia.Monde;

import be.mk.vakardia.Vakardia;
import net.minecraft.server.v1_12_R1.Blocks;
import net.minecraft.server.v1_12_R1.CriterionTriggerItemDurabilityChanged;
import net.minecraft.server.v1_12_R1.PortalTravelAgent;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.craftbukkit.v1_12_R1.block.CraftHopper;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerPortalEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BlockStateMeta;
import org.bukkit.inventory.meta.ItemMeta;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HUB implements Listener {

    private File data,chunk,serveur;
    private FileConfiguration datamodif,chunksav,serveursave;
    @EventHandler
    public void onfish(PlayerFishEvent e) {
        
    }
    @Deprecated
    @EventHandler
    public void onbreak(BlockBreakEvent e) {
        if(e.getPlayer().getWorld().getName().equals("Med")){
            if(!e.getPlayer().isOp()) {
                 int du = e.getPlayer().getItemInHand().getDurability();
                 int res = du--;
                Location loc = new Location(Bukkit.getWorld(e.getBlock().getWorld().getName()), e.getBlock().getLocation().getX(), e.getBlock().getLocation().getY() - 1, e.getBlock().getLocation().getZ(), 0f, 0f);
                String ck = e.getBlock().getWorld().getChunkAt(loc).toString();
                List<String> comp = new ArrayList<String>();
                comp.add("CraftChunk{x=-11z=23}");
                comp.add("CraftChunk{x=-11z=24}");
                comp.add("CraftChunk{x=-10z=24}");
                comp.add("CraftChunk{x=-12z=24}");
                comp.add("CraftChunk{x=-12z=25}");
                comp.add("CraftChunk{x=-13z=24}");
                comp.add("CraftChunk{x=-13z=23}");
                comp.add("CraftChunk{x=-14z=24}");
                comp.add("CraftChunk{x=-14z=23}");
                e.setCancelled(true);
                if (comp.contains(ck)) {
                    Material m = e.getBlock().getType();
                    Block b = e.getBlock();
                    if (m.equals(Material.IRON_ORE)) {
                        b.setType(Material.AIR);
                        e.getPlayer().getItemInHand().setDurability((short) res);
                        e.getPlayer().getInventory().addItem(new ItemStack(Material.IRON_ORE, 1));
                        Bukkit.getScheduler().runTaskLater(Vakardia.getPluginInstance(), new Runnable() {
                            @Override
                            public void run() {
                                b.setType(m);
                            }
                        }, 60 * 20L);
                    }

                }
                List<String> charbon = new ArrayList<String>();
                charbon.add("CraftChunk{x=-14z=11}");
                charbon.add("CraftChunk{x=-14z=10}");
                charbon.add("CraftChunk{x=-14z=9}");
                if (charbon.contains(ck)) {
                    Material m = e.getBlock().getType();
                    Block b = e.getBlock();
                    if (m.equals(Material.COAL_ORE)) {
                        b.setType(Material.AIR);
                        e.getPlayer().getItemInHand().setDurability((short) res);
                        e.getPlayer().getInventory().addItem(new ItemStack(Material.COAL, 1));
                        Bukkit.getScheduler().runTaskLater(Vakardia.getPluginInstance(), new Runnable() {
                            @Override
                            public void run() {
                                b.setType(m);
                            }
                        }, 30 * 20L);
                    }

                }
                List<String> ore = new ArrayList<String>();
                ore.add("CraftChunk{x=2z=7}");
                ore.add("CraftChunk{x=1z=7}");
                if (ore.contains(ck)) {
                    Material m = e.getBlock().getType();
                    Block b = e.getBlock();
                    if (m.equals(Material.GOLD_ORE)) {
                        b.setType(Material.AIR);
                        e.getPlayer().getItemInHand().setDurability((short) res);
                        e.getPlayer().getInventory().addItem(new ItemStack(Material.GOLD_ORE, 1));
                        Bukkit.getScheduler().runTaskLater(Vakardia.getPluginInstance(), new Runnable() {
                            @Override
                            public void run() {
                                b.setType(m);
                            }
                        }, 90 * 20L);
                    }
                }
                List<String> eme = new ArrayList<String>();
                eme.add("CraftChunk{x=19z=33}");
                if (eme.contains(ck)) {
                    Material m = e.getBlock().getType();
                    Block b = e.getBlock();
                    if (m.equals(Material.EMERALD_ORE)) {
                        b.setType(Material.AIR);
                        e.getPlayer().getItemInHand().setDurability((short) res);
                        e.getPlayer().getInventory().addItem(new ItemStack(Material.EMERALD, 1));
                        Bukkit.getScheduler().runTaskLater(Vakardia.getPluginInstance(), new Runnable() {
                            @Override
                            public void run() {
                                b.setType(m);
                            }
                        }, 120 * 20L);
                    }
                }
                List<String> bois = new ArrayList<String>();
                bois.add("CraftChunk{x=7z=25}");
                bois.add("CraftChunk{x=7z=24}");
                if (bois.contains(ck)) {
                    Material m = e.getBlock().getType();
                    Block b = e.getBlock();
                    if (m.getId() == 17) {
                        b.setType(Material.AIR);
                        e.getPlayer().getItemInHand().setDurability((short) res);
                        e.getPlayer().getInventory().addItem(new ItemStack(Material.LOG, 1));
                        Bukkit.getScheduler().runTaskLater(Vakardia.getPluginInstance(), new Runnable() {
                            @Override
                            public void run() {
                                b.setType(m);
                            }
                        }, 120 * 20L);
                    }
                }
                int t = e.getBlock().getTypeId();
                Block be = e.getBlock();

                List<String> pierr = new ArrayList<String>();
                pierr.add("CraftChunk{x=8z=13}");
                pierr.add("CraftChunk{x=8z=12}");
                if (pierr.contains(ck)) {
                    Material m = e.getBlock().getType();
                    Block b = e.getBlock();
                    if (m.equals(Material.COBBLESTONE)) {
                        b.setType(Material.AIR);
                        e.getPlayer().getItemInHand().setDurability((short) res);
                        e.getPlayer().getInventory().addItem(new ItemStack(Material.COBBLESTONE, 1));
                        Bukkit.getScheduler().runTaskLater(Vakardia.getPluginInstance(), new Runnable() {
                            @Override
                            public void run() {
                                b.setType(m);
                            }
                        }, 10 * 20L);
                    }
                }

            }
        }
    }
    @Deprecated
    @EventHandler
    public void onPlace(BlockPlaceEvent e) {
        if(e.getPlayer().getWorld().getName().equals("Med")){
            if(!e.getPlayer().isOp()){
                Location loc = new Location(Bukkit.getWorld(e.getBlock().getWorld().getName()), e.getBlock().getLocation().getX(), e.getBlock().getLocation().getY() - 1, e.getBlock().getLocation().getZ(), 0f, 0f);
                Location blo = new Location(Bukkit.getWorld(e.getBlock().getWorld().getName()), e.getBlock().getLocation().getX(), e.getBlock().getLocation().getY() , e.getBlock().getLocation().getZ(), 0f, 0f);

                Material m = Material.WOOD;

                if(loc.getBlock().getType().getId() == 60){
                    if(e.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.SEEDS)){
                        e.getPlayer().getInventory().removeItem(new ItemStack(Material.SEEDS,1));

                        Block co = blo.getBlock();
                        co.setType(Material.CROPS);
                        co.setData((byte) 0);

                    }else{
                        e.setCancelled(true);
                    }
                }else{
                    e.setCancelled(true);
                }
            }

        }
    }
    @EventHandler
    public void onPortal(PlayerPortalEvent e){
        e.setCancelled(true);
        Location Med2 = new Location(Bukkit.getWorld("Med2"),1121,101,1488);
        Location s = new Location(Bukkit.getWorld("Med"),-258.5,205,-110.5);
        if(e.getPlayer().getWorld().getName().equals("Med")){
            e.getPlayer().teleport(Med2);
        }else {
            e.getPlayer().teleport(s);
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
    public void onInventoryClick(InventoryClickEvent e) {
        this.data = new File("plugins/Vakardia/Data/Players/" + e.getWhoClicked().getUniqueId() + ".yml");
        this.datamodif = YamlConfiguration.loadConfiguration(data);
        Double ro = datamodif.getDouble("Joueur." + e.getWhoClicked().getUniqueId() + ".Argent");
        Player p = (Player) e.getWhoClicked();
        ItemStack item = e.getCurrentItem();
        String jobdefault = "null";
        if (e.getView().getTitle().equalsIgnoreCase("Chasse")){
            e.setCancelled(true);
        }
        if (e.getView().getTitle().equalsIgnoreCase("Potion")){
            e.setCancelled(true);
            if (item.getItemMeta().getDisplayName().equalsIgnoreCase("Encaisser ticket")) {
                if(e.getWhoClicked().getInventory().contains(Material.BEDROCK,1)) {

                        Double result = ro + 20;
                        try {
                            datamodif.set("Joueur." + p.getUniqueId() + ".Argent", result);
                            datamodif.save(data);
                            p.sendMessage("Tu as gagnier 20$");
                            e.getWhoClicked().getInventory().removeItem(new ItemStack(Material.BEDROCK,1));
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }


                }
            }
        }
        if (e.getView().getTitle().equalsIgnoreCase("Materiaux")){
            e.setCancelled(true);
            if (item.getItemMeta().getDisplayName().equalsIgnoreCase("Vendre 1 de Pierre")) {
                if(e.getWhoClicked().getInventory().contains(Material.COBBLESTONE,1)){
                    e.getWhoClicked().getInventory().removeItem(new ItemStack(Material.COBBLESTONE,1));
                    Double result = ro+1;
                    try {
                        datamodif.set("Joueur." + p.getUniqueId() + ".Argent", result);
                        datamodif.save(data);
                        p.sendMessage("Tu as vendu 1 de pierre");
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
            }
            if (item.getItemMeta().getDisplayName().equalsIgnoreCase("Acheter 1 Pain")) {

            }
            if (item.getItemMeta().getDisplayName().equalsIgnoreCase("Vendre 1 de bois")) {
                if(e.getWhoClicked().getInventory().contains(Material.LOG,1)){
                    e.getWhoClicked().getInventory().removeItem(new ItemStack(Material.LOG,1));
                    Double result = ro+1;
                    try {
                        datamodif.set("Joueur." + p.getUniqueId() + ".Argent", result);
                        datamodif.save(data);
                        p.sendMessage("Tu as vendu 1 de bois");
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
            }
            if (item.getItemMeta().getDisplayName().equalsIgnoreCase("Acheter 1 Pain")) {

            }
        }
        if (e.getView().getTitle().equalsIgnoreCase("Nourritures")){
            e.setCancelled(true);
            if (item.getItemMeta().getDisplayName().equalsIgnoreCase("Acheter 1 Pain")) {
                if(ro == 10 || ro >= 10){
                    e.getWhoClicked().getInventory().addItem(new ItemStack(Material.BREAD, 1));
                    Double result = ro-10;
                    try {
                        datamodif.set("Joueur." + p.getUniqueId() + ".Argent", result);
                        datamodif.save(data);
                        p.sendMessage("Tu as acheter 1 de pain !");
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
            }
            if (item.getItemMeta().getDisplayName().equalsIgnoreCase("Vendre 1 Pain")) {
                if(e.getWhoClicked().getInventory().contains(Material.BREAD,1)){
                    e.getWhoClicked().getInventory().removeItem(new ItemStack(Material.BREAD,1));
                    Double result = ro+8;
                    try {
                        datamodif.set("Joueur." + p.getUniqueId() + ".Argent", result);
                        datamodif.save(data);
                        p.sendMessage("Tu as vendu 1 pain !");
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
            }
        }
        if (e.getView().getTitle().equalsIgnoreCase("Ressource")){
            e.setCancelled(true);
            if (item.getItemMeta().getDisplayName().equalsIgnoreCase("Vendre 1 Coal")) {
                if(e.getWhoClicked().getInventory().contains(Material.COAL,1)){
                    e.getWhoClicked().getInventory().removeItem(new ItemStack(Material.COAL,1));
                    Double result = ro+1;
                    try {
                        datamodif.set("Joueur." + p.getUniqueId() + ".Argent", result);
                        datamodif.save(data);
                        p.sendMessage("Tu as vendu 1 charbon !");
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
            }
            if (item.getItemMeta().getDisplayName().equalsIgnoreCase("Acheter 1 Coal")) {

                if(ro == 10 || ro >= 10){
                    e.getWhoClicked().getInventory().addItem(new ItemStack(Material.COAL, 1));
                    Double result = ro-10;
                    try {
                        datamodif.set("Joueur." + p.getUniqueId() + ".Argent", result);
                        datamodif.save(data);
                        p.sendMessage("Tu as acheter 1 de µcharbon !");
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }

            }
            if (item.getItemMeta().getDisplayName().equalsIgnoreCase("Vendre 1 Minerai de fer")) {
                if(e.getWhoClicked().getInventory().contains(Material.IRON_ORE,1)){
                    e.getWhoClicked().getInventory().removeItem(new ItemStack(Material.IRON_ORE,1));
                    Double result = ro+4;
                    try {
                        datamodif.set("Joueur." + p.getUniqueId() + ".Argent", result);
                        datamodif.save(data);
                        p.sendMessage("Tu as vendu 1 minerai de fer !");
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
            }
            if (item.getItemMeta().getDisplayName().equalsIgnoreCase("Vakarans")) {

            }
            if (item.getItemMeta().getDisplayName().equalsIgnoreCase("Vendre 1 fer")) {
                if(e.getWhoClicked().getInventory().contains(Material.IRON_INGOT,1)){
                    e.getWhoClicked().getInventory().removeItem(new ItemStack(Material.IRON_INGOT,1));
                    Double result = ro+5;
                    try {
                        datamodif.set("Joueur." + p.getUniqueId() + ".Argent", result);
                        datamodif.save(data);
                        p.sendMessage("Tu as vendu 1 fer !");
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
            }
            if (item.getItemMeta().getDisplayName().equalsIgnoreCase("Vakarans")) {

            }
            if (item.getItemMeta().getDisplayName().equalsIgnoreCase("Vendre 1 Minerai d'or")) {
                if(e.getWhoClicked().getInventory().contains(Material.GOLD_ORE,1)){
                    e.getWhoClicked().getInventory().removeItem(new ItemStack(Material.GOLD_ORE,1));
                    Double result = ro+4;
                    try {
                        datamodif.set("Joueur." + p.getUniqueId() + ".Argent", result);
                        datamodif.save(data);
                        p.sendMessage("Tu as vendu 1 minerai d'or !");
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
            }
            if (item.getItemMeta().getDisplayName().equalsIgnoreCase("Vakarans")) {

            }
            if (item.getItemMeta().getDisplayName().equalsIgnoreCase("Vendre 1 Or")) {
                if(e.getWhoClicked().getInventory().contains(Material.GOLD_INGOT,1)){
                    e.getWhoClicked().getInventory().removeItem(new ItemStack(Material.GOLD_INGOT,1));
                    Double result = ro+7;
                    try {
                        datamodif.set("Joueur." + p.getUniqueId() + ".Argent", result);
                        datamodif.save(data);
                        p.sendMessage("Tu as vendu 1 lingot do'r !");
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
            }
            if (item.getItemMeta().getDisplayName().equalsIgnoreCase("Vakarans")) {

            }
            if (item.getItemMeta().getDisplayName().equalsIgnoreCase("Vendre 1 Emeraude")) {
                if(e.getWhoClicked().getInventory().contains(Material.EMERALD,1)){
                    e.getWhoClicked().getInventory().removeItem(new ItemStack(Material.EMERALD,1));
                    Double result = ro+40;
                    try {
                        datamodif.set("Joueur." + p.getUniqueId() + ".Argent", result);
                        datamodif.save(data);
                        p.sendMessage("Tu as vendu une emeraude !");
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
            }
            if (item.getItemMeta().getDisplayName().equalsIgnoreCase("Vakarans")) {

            }
        }
    }
    @EventHandler
    public void blockevent(PlayerInteractAtEntityEvent e) {
        Player p = e.getPlayer();
        this.data = new File("plugins/Vakardia/Data/Players/"+p.getUniqueId()+".yml");
        this.datamodif = YamlConfiguration.loadConfiguration(data);
        Double ro = datamodif.getDouble("Joueur." + p.getUniqueId() + ".Argent");
        String npc = e.getRightClicked().getName();
        if(npc.equalsIgnoreCase("Potion")){
            Inventory mat = Bukkit.createInventory(null, 1 * 9,  "Potion");
            ItemStack vendp = nameItem(Material.COBBLESTONE, "Encaisser ticket", "");
            mat.setItem(4 ,vendp);
            p.openInventory(mat);
        }
        if(npc.equalsIgnoreCase("Chasse")){
            Inventory mat = Bukkit.createInventory(null, 5 * 9,  "Chasse");
            ItemStack pierre = nameItem(Material.PORK, "Viande de cochon", "");
            ItemStack vendp = nameItem(Material.PORK, "Vendre", "");
            ItemStack achp = nameItem(Material.PORK, "Acheter", "");

            ItemStack bois = nameItem(Material.RAW_BEEF, "Viande de vache", "");
            ItemStack vendbois = nameItem(Material.RAW_BEEF, "Vendre", "");
            ItemStack achbois = nameItem(Material.RAW_BEEF, "Acheter", "");

            ItemStack pierretailler = nameItem(Material.RAW_CHICKEN, "Viande de poulet", "");
            ItemStack vendpt = nameItem(Material.RAW_CHICKEN, "Vendre", "");
            ItemStack achpt = nameItem(Material.RAW_CHICKEN, "Acheter", "");

            ItemStack planche = nameItem(Material.MUTTON, "Viande de mouton", "");
            ItemStack vendpl = nameItem(Material.MUTTON, "Vendre", "");
            ItemStack achpl = nameItem(Material.MUTTON, "Acheter", "");

            ItemStack fg = nameItem(Material.LEATHER, "Cuir", "");
            ItemStack gfgf = nameItem(Material.LEATHER, "Vendre", "");
            ItemStack gfgfgf = nameItem(Material.LEATHER, "Acheter", "");
            mat.setItem(4 ,pierre);
            mat.setItem(3,vendp);
            mat.setItem(5,achp);

            mat.setItem(12 ,vendbois);
            mat.setItem(13,bois);
            mat.setItem(14,achbois);

            mat.setItem(21 ,vendpt);
            mat.setItem(22,pierretailler);
            mat.setItem(23,achpt);

            mat.setItem(30 ,vendpl);
            mat.setItem(31,planche);
            mat.setItem(32,achpl);

            mat.setItem(39,gfgf);
            mat.setItem(40,fg);
            mat.setItem(41,gfgfgf);
            p.openInventory(mat);
        }
        if(npc.equalsIgnoreCase("Materiaux")){
            Inventory mat = Bukkit.createInventory(null, 4 * 9,  "Materiaux");
            ItemStack pierre = nameItem(Material.COBBLESTONE, "Pierre", "");
            ItemStack vendp = nameItem(Material.COBBLESTONE, "Vendre 1 de Pierre", "2$");
            ItemStack achp = nameItem(Material.COBBLESTONE, "Acheter 1 de Pierre", "");

            ItemStack bois = nameItem(Material.LOG, "Bois", "");
            ItemStack vendbois = nameItem(Material.LOG, "Vendre 1 de bois", "2$");
            ItemStack achbois = nameItem(Material.LOG, "Acheter 1 de bois", "");

            ItemStack pierretailler = nameItem(Material.STONE, "Pas dispo", "");
            ItemStack vendpt = nameItem(Material.STONE, "Pas dispo", "");
            ItemStack achpt = nameItem(Material.STONE, "Pas dispo", "");

            ItemStack planche = nameItem(Material.LOG_2, "Pas dispo", "");
            ItemStack vendpl = nameItem(Material.LOG_2, "Pas dispo", "");
            ItemStack achpl = nameItem(Material.LOG_2, "Pas dispo", "");
            mat.setItem(4 ,pierre);
            mat.setItem(3,vendp);
            mat.setItem(5,achp);

            mat.setItem(12 ,vendbois);
            mat.setItem(13,bois);
            mat.setItem(14,achbois);

            mat.setItem(21 ,vendpt);
            mat.setItem(22,pierretailler);
            mat.setItem(23,achpt);

            mat.setItem(30 ,vendpl);
            mat.setItem(31,planche);
            mat.setItem(32,achpl);

            p.openInventory(mat);
        }
        if(npc.equalsIgnoreCase("Ressource")){
            Inventory mat = Bukkit.createInventory(null, 6 * 9,  "Ressource");
            ItemStack coal = nameItem(Material.COAL, "Coal", "");
            ItemStack vendc = nameItem(Material.COAL, "Vendre 1 Coal", "2$");
            ItemStack achc = nameItem(Material.COAL, "Acheter 1 Coal", "10$");

            ItemStack mfer = nameItem(Material.IRON_ORE, "Minerai de fer", "");
            ItemStack vendmfer = nameItem(Material.IRON_ORE, "Vendre 1 Minerai de fer", "4$");
            ItemStack achcmfer = nameItem(Material.IRON_ORE, "Acheter 1 Minerai de fer", "15$");

            ItemStack fer = nameItem(Material.IRON_INGOT, "Fer", "");
            ItemStack vendfer = nameItem(Material.IRON_INGOT, "Vendre 1 fer", "10$");
            ItemStack achcfer = nameItem(Material.IRON_INGOT, "Acheter 1 fer", "25$");

            ItemStack mgold = nameItem(Material.GOLD_ORE, "Minerai d'or", "");
            ItemStack vendmgold = nameItem(Material.GOLD_ORE, "Vendre 1 Minerai d'or", "7$");
            ItemStack achcmgold = nameItem(Material.GOLD_ORE, "Acheter 1 Minerai d'or", "20$");

            ItemStack gold = nameItem(Material.GOLD_INGOT, "Or", "");
            ItemStack vendgold = nameItem(Material.GOLD_INGOT, "Vendre 1 Or", "14$");
            ItemStack achgold = nameItem(Material.GOLD_INGOT, "Acheter 1 Or", "30$");

            ItemStack eme = nameItem(Material.EMERALD, "Emeraude", "");
            ItemStack vendeme = nameItem(Material.EMERALD, "Vendre 1 Emeraude", "40$");
            ItemStack achceme = nameItem(Material.EMERALD, "Acheter 1 Emeraude", "100$");
            mat.setItem(4 ,coal);
            mat.setItem(3,achc);
            mat.setItem(5,vendc);

            mat.setItem(12 ,mfer);
            mat.setItem(13,achcmfer);
            mat.setItem(14,vendmfer);

            mat.setItem(21 ,fer);
            mat.setItem(22,vendfer);
            mat.setItem(23,achcfer);

            mat.setItem(30 ,mgold);
            mat.setItem(31,vendmgold);
            mat.setItem(32,achcmgold);

            mat.setItem(39 ,gold);
            mat.setItem(40,vendgold);
            mat.setItem(41,achgold);

            mat.setItem(48 ,eme);
            mat.setItem(49,vendeme);
            mat.setItem(50,achceme);
            p.openInventory(mat);
        }
        if(npc.equalsIgnoreCase("Nourritures")){
            Inventory mat = Bukkit.createInventory(null, 1 * 9,  "Nourritures");
            ItemStack bread = nameItem(Material.BREAD, "Pain", "");
            ItemStack vend = nameItem(Material.BREAD, "Vendre 1 Pain", "");
            ItemStack ach = nameItem(Material.BREAD, "Acheter 1 Pain", "");
            mat.setItem(4 ,bread);
            mat.setItem(3,ach);
            mat.setItem(5,vend);
            p.openInventory(mat);
        }
        if(npc.equalsIgnoreCase("Chasse")){

        }

    }
}
