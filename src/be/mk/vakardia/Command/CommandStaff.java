package be.mk.vakardia.Command;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class CommandStaff implements CommandExecutor {
    private File tt;
    private File data;
    private FileConfiguration datamodif;
    private FileConfiguration ttmodif;
    @Override
    public boolean onCommand(CommandSender Sender, Command cmd, String s, String[] args) {

        if (cmd.getName().equalsIgnoreCase("gmc")) {
            Player p = (Player) Sender;
            if(p.isOp()){
                p.setGameMode(GameMode.CREATIVE);
            }
        }
        if (cmd.getName().equalsIgnoreCase("gms")) {
            Player p = (Player) Sender;
            if(p.isOp()){
                p.setGameMode(GameMode.SURVIVAL);
            }
        }
        if (cmd.getName().equalsIgnoreCase("gmsp")) {
            Player p = (Player) Sender;
            if(p.isOp()){
                p.setGameMode(GameMode.SPECTATOR);
            }
        }
        if (cmd.getName().equalsIgnoreCase("gm")) {
            Player p = (Player) Sender;
            String cr = "1";
            String su = "0";
            if(p.isOp() ){
                if(args[0].equalsIgnoreCase(cr)){
                    p.setGameMode(GameMode.CREATIVE);
                }
                if(args[0].equalsIgnoreCase(su)){
                    p.setGameMode(GameMode.SURVIVAL);
                }
            }
        }
        if (cmd.getName().equalsIgnoreCase("heal")) {
            Player p = (Player) Sender;
            Player pv = null;
            if(p.isOp() ){
                p.setHealth(20);
            }
        }
        if (cmd.getName().equalsIgnoreCase("heal")) {
            Player p = (Player) Sender;
            Player pv = null;
            if(p.isOp() ){
                p.setHealth(20);

            }
        }
        if (cmd.getName().equalsIgnoreCase("day")) {
            Player p = (Player) Sender;
            Player pv = null;
            if(p.isOp() ){
                Bukkit.getWorld(p.getWorld().getName()).setTime(0);
            }
        }
        if (cmd.getName().equalsIgnoreCase("night")) {
            Player p = (Player) Sender;
            Player pv = null;
            if(p.isOp() ){
                Bukkit.getWorld(p.getWorld().getName()).setTime(14000);
            }
        }
        if (cmd.getName().equalsIgnoreCase("setwarp")) {
            Player p = (Player) Sender;
            Player pv = null;
            this.tt = new File("plugins/Vakardia/Data/warp/list.yml");
            this.ttmodif = YamlConfiguration.loadConfiguration(tt);
            this.data = new File("plugins/Vakardia/Data/warp/"+args[0]+".yml");
            this.datamodif = YamlConfiguration.loadConfiguration(data);
            String axi = ttmodif.getString("warp.list");

            if(p.isOp() ){
                if(!data.exists()){
                    datamodif.set("warp.x", p.getLocation().getX());
                    datamodif.set("warp.y", p.getLocation().getY());
                    datamodif.set("warp.z", p.getLocation().getZ());
                    datamodif.set("warp.name", args[0]);
                    if(tt.exists()){
                        ttmodif.set("warp.list",axi+","+args[0]);
                    }else{
                        ttmodif.set("warp.list",args[0]);
                    }

                    try {
                        datamodif.save(data);
                        ttmodif.save(tt);
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }else{
                    datamodif.set("warp.x", p.getLocation().getX());
                    datamodif.set("warp.y", p.getLocation().getY());
                    datamodif.set("warp.z", p.getLocation().getZ());
                    try {
                        datamodif.save(data);
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        }
        if (cmd.getName().equalsIgnoreCase("warplist")) {
            Player p = (Player) Sender;
            Player pv = null;
            this.tt = new File("plugins/Vakardia/Data/warp/list.yml");
            this.ttmodif = YamlConfiguration.loadConfiguration(tt);
            String axi = ttmodif.getString("warp.list");
            if(p.isOp() ){
                p.sendMessage("voici tous les warps : " + axi);
            }
        }
        if (cmd.getName().equalsIgnoreCase("warp")) {
            Player p = (Player) Sender;
            Player pv = null;
            this.tt = new File("plugins/Vakardia/Data/warp/list.yml");
            this.ttmodif = YamlConfiguration.loadConfiguration(tt);
            this.data = new File("plugins/Vakardia/Data/warp/"+args[0]+".yml");
            this.datamodif = YamlConfiguration.loadConfiguration(data);
            double x = datamodif.getDouble("warp.x");
            double y = datamodif.getDouble("warp.y");
            double z = datamodif.getDouble("warp.z");
            String axi = ttmodif.getString("warp.list");
            Location l = new Location(Bukkit.getWorld(p.getWorld().getName()),x,y,z);
            if(p.isOp() ){
                if (data.exists()) {
                    p.teleport(l);
                }else{
                    p.sendMessage("il n'existe pas !");
                }
            }
        }
        if (cmd.getName().equalsIgnoreCase("back")) {
            Player p = (Player) Sender;
            Player pv = null;
            this.data = new File("plugins/Vakardia/Data/joueur/"+p.getPlayer().getUniqueId()+".yml");
            this.datamodif = YamlConfiguration.loadConfiguration(data);
            double x = datamodif.getDouble("Joueur.back.x");
            double y = datamodif.getDouble("Joueur.back.y");
            double z = datamodif.getDouble("Joueur.back.z");
            World d = p.getWorld();
            Location l = new Location(Bukkit.getWorld(p.getWorld().getName()),x,y,z);
            if(p.isOp() ){
                p.teleport(l);
            }
        }

        if (cmd.getName().equalsIgnoreCase("tp")) {
            Player p = (Player) Sender;
            Player target = Bukkit.getPlayerExact(args[1]);
            Player pb = Bukkit.getPlayerExact(args[0]);
            Location tpback = pb.getLocation();
            this.data = new File("plugins/Vakardia/Data/joueur/"+pb.getPlayer().getUniqueId()+".yml");
            this.datamodif = YamlConfiguration.loadConfiguration(data);
            if(p.isOp() ){
                if(args[1].isEmpty()){
                    p.teleport(pb);
                }else{
                    datamodif.set("Joueur.back.x", p.getLocation().getX());
                    datamodif.set("Joueur.back.y", p.getLocation().getY());
                    datamodif.set("Joueur.back.z", p.getLocation().getZ());
                    try {
                        datamodif.save(data);
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    pb.teleport(target);
                }

            }
        }
        if (cmd.getName().equalsIgnoreCase("speedfly")) {
            Player p = (Player) Sender;
            if(p.isOp() ){
                if(args[0].equalsIgnoreCase("10")){
                    p.setFlySpeed(1.0f);
                }
                if(args[0].equalsIgnoreCase("9")){
                    p.setFlySpeed(0.9f);
                }
                if(args[0].equalsIgnoreCase("8")){
                    p.setFlySpeed(0.8f);
                }
                if(args[0].equalsIgnoreCase("7")){
                    p.setFlySpeed(0.7f);
                }
                if(args[0].equalsIgnoreCase("6")){
                    p.setFlySpeed(0.6f);
                }
                if(args[0].equalsIgnoreCase("5")){
                    p.setFlySpeed(0.5f);
                }
                if(args[0].equalsIgnoreCase("4")){
                    p.setFlySpeed(0.4f);
                }
                if(args[0].equalsIgnoreCase("3")){
                    p.setFlySpeed(0.3f);
                }
                if(args[0].equalsIgnoreCase("2")){
                    p.setFlySpeed(0.2f);
                }
                if(args[0].equalsIgnoreCase("1")){
                    p.setFlySpeed(0.1f);
                }
                if(args[0].equalsIgnoreCase("0")){
                    p.setFlySpeed(0.0f);
                }
            }
        }
        if (cmd.getName().equalsIgnoreCase("speedWalk")) {
            Player p = (Player) Sender;
            if(p.isOp() ){
                if(args[0].equalsIgnoreCase("10")){
                    p.setWalkSpeed(1.0f);
                }
                if(args[0].equalsIgnoreCase("9")){
                    p.setWalkSpeed(0.9f);
                }
                if(args[0].equalsIgnoreCase("8")){
                    p.setWalkSpeed(0.8f);
                }
                if(args[0].equalsIgnoreCase("7")){
                    p.setWalkSpeed(0.7f);
                }
                if(args[0].equalsIgnoreCase("6")){
                    p.setWalkSpeed(0.6f);
                }
                if(args[0].equalsIgnoreCase("5")){
                    p.setWalkSpeed(0.5f);
                }
                if(args[0].equalsIgnoreCase("4")){
                    p.setWalkSpeed(0.4f);
                }
                if(args[0].equalsIgnoreCase("3")){
                    p.setWalkSpeed(0.3f);
                }
                if(args[0].equalsIgnoreCase("2")){
                    p.setWalkSpeed(0.2f);
                }
                if(args[0].equalsIgnoreCase("1")){
                    p.setWalkSpeed(0.1f);
                }
                if(args[0].equalsIgnoreCase("0")){
                    p.setWalkSpeed(0.0f);
                }
            }
        }





        return false;
    }
}
