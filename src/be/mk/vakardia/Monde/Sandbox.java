package be.mk.vakardia.Monde;

import be.mk.vakardia.Vakardia;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerPortalEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

import java.util.ArrayList;
import java.util.List;

public class Sandbox implements Listener {
    @Deprecated
    @EventHandler
    public void onbreak(BlockBreakEvent e) {
        if (e.getPlayer().getWorld().getName().equals("Med2")) {

                int du = e.getPlayer().getItemInHand().getDurability();
                int res = du--;
                Location loc = new Location(Bukkit.getWorld(e.getBlock().getWorld().getName()), e.getBlock().getLocation().getX(), e.getBlock().getLocation().getY() , e.getBlock().getLocation().getZ(), 0f, 0f);
                String ck = e.getBlock().getWorld().getChunkAt(loc).toString();
                List<String> comp = new ArrayList<String>();
                comp.add("Location{world=CraftWorld{name=Med2},x=3318,y=75,z=3282,pitch=0.0,yaw=0.0}");
                comp.add("Location{world=CraftWorld{name=Med2},x=3318,y=75,z=3283,pitch=0.0,yaw=0.0}");
                comp.add("Location{world=CraftWorld{name=Med2},x=3318,y=75,z=3284,pitch=0.0,yaw=0.0}");
                comp.add("Location{world=CraftWorld{name=Med2},x=3318,y=75,z=3285,pitch=0.0,yaw=0.0}");
                comp.add("Location{world=CraftWorld{name=Med2},x=3318,y=75,z=3286,pitch=0.0,yaw=0.0}");

                comp.add("Location{world=CraftWorld{name=Med2},x=3319,y=75,z=3283,pitch=0.0,yaw=0.0}");
                comp.add("Location{world=CraftWorld{name=Med2},x=3319,y=75,z=3284,pitch=0.0,yaw=0.0}");
                comp.add("Location{world=CraftWorld{name=Med2},x=3319,y=75,z=3285,pitch=0.0,yaw=0.0}");
                comp.add("Location{world=CraftWorld{name=Med2},x=3319,y=75,z=3286,pitch=0.0,yaw=0.0}");

                comp.add("Location{world=CraftWorld{name=Med2},x=3322,y=75,z=3285,pitch=0.0,yaw=0.0}");
                comp.add("Location{world=CraftWorld{name=Med2},x=3322,y=75,z=3286,pitch=0.0,yaw=0.0}");
                comp.add("Location{world=CraftWorld{name=Med2},x=3322,y=75,z=3287,pitch=0.0,yaw=0.0}");
                comp.add("Location{world=CraftWorld{name=Med2},x=3322,y=75,z=3288,pitch=0.0,yaw=0.0}");
                comp.add("Location{world=CraftWorld{name=Med2},x=3322,y=75,z=3289,pitch=0.0,yaw=0.0}");
                comp.add("Location{world=CraftWorld{name=Med2},x=3322,y=75,z=3290,pitch=0.0,yaw=0.0}");

                comp.add("Location{world=CraftWorld{name=Med2},x=3323,y=76,z=3285,pitch=0.0,yaw=0.0}");
                comp.add("Location{world=CraftWorld{name=Med2},x=3323,y=76,z=3286,pitch=0.0,yaw=0.0}");
                comp.add("Location{world=CraftWorld{name=Med2},x=3323,y=76,z=3287,pitch=0.0,yaw=0.0}");
                comp.add("Location{world=CraftWorld{name=Med2},x=3323,y=76,z=3288,pitch=0.0,yaw=0.0}");
                comp.add("Location{world=CraftWorld{name=Med2},x=3323,y=76,z=3289,pitch=0.0,yaw=0.0}");
                comp.add("Location{world=CraftWorld{name=Med2},x=3323,y=76,z=3290,pitch=0.0,yaw=0.0}");

                comp.add("Location{world=CraftWorld{name=Med2},x=3324,y=76,z=3284,pitch=0.0,yaw=0.0}");
                comp.add("Location{world=CraftWorld{name=Med2},x=3324,y=76,z=3285,pitch=0.0,yaw=0.0}");
                comp.add("Location{world=CraftWorld{name=Med2},x=3324,y=76,z=3286,pitch=0.0,yaw=0.0}");
                comp.add("Location{world=CraftWorld{name=Med2},x=3324,y=76,z=3287,pitch=0.0,yaw=0.0}");
                comp.add("Location{world=CraftWorld{name=Med2},x=3324,y=76,z=3288,pitch=0.0,yaw=0.0}");
                comp.add("Location{world=CraftWorld{name=Med2},x=3324,y=76,z=3289,pitch=0.0,yaw=0.0}");

                comp.add("Location{world=CraftWorld{name=Med2},x=3323,y=75,z=3283,pitch=0.0,yaw=0.0}");
                comp.add("Location{world=CraftWorld{name=Med2},x=3323,y=75,z=3284,pitch=0.0,yaw=0.0}");
                comp.add("Location{world=CraftWorld{name=Med2},x=3323,y=75,z=3285,pitch=0.0,yaw=0.0}");
                comp.add("Location{world=CraftWorld{name=Med2},x=3323,y=75,z=3286,pitch=0.0,yaw=0.0}");
                comp.add("Location{world=CraftWorld{name=Med2},x=3323,y=75,z=3287,pitch=0.0,yaw=0.0}");
                comp.add("Location{world=CraftWorld{name=Med2},x=3323,y=75,z=3288,pitch=0.0,yaw=0.0}");
                comp.add("Location{world=CraftWorld{name=Med2},x=3323,y=75,z=3289,pitch=0.0,yaw=0.0}");
                comp.add("Location{world=CraftWorld{name=Med2},x=3323,y=75,z=3290,pitch=0.0,yaw=0.0}");
                comp.add("Location{world=CraftWorld{name=Med2},x=3323,y=75,z=3291,pitch=0.0,yaw=0.0}");

                comp.add("Location{world=CraftWorld{name=Med2},x=3324,y=75,z=3285,pitch=0.0,yaw=0.0}");
                comp.add("Location{world=CraftWorld{name=Med2},x=3324,y=75,z=3286,pitch=0.0,yaw=0.0}");
                comp.add("Location{world=CraftWorld{name=Med2},x=3324,y=75,z=3287,pitch=0.0,yaw=0.0}");
                comp.add("Location{world=CraftWorld{name=Med2},x=3324,y=75,z=3288,pitch=0.0,yaw=0.0}");
                comp.add("Location{world=CraftWorld{name=Med2},x=3324,y=75,z=3289,pitch=0.0,yaw=0.0}");
                comp.add("Location{world=CraftWorld{name=Med2},x=3324,y=75,z=3290,pitch=0.0,yaw=0.0}");
                comp.add("Location{world=CraftWorld{name=Med2},x=3324,y=75,z=3291,pitch=0.0,yaw=0.0}");
                comp.add("Location{world=CraftWorld{name=Med2},x=3324,y=75,z=3292,pitch=0.0,yaw=0.0}");
                comp.add("Location{world=CraftWorld{name=Med2},x=3324,y=75,z=3293,pitch=0.0,yaw=0.0}");

                comp.add("Location{world=CraftWorld{name=Med2},x=3325,y=75,z=3284,pitch=0.0,yaw=0.0}");
                comp.add("Location{world=CraftWorld{name=Med2},x=3325,y=75,z=3285,pitch=0.0,yaw=0.0}");
                comp.add("Location{world=CraftWorld{name=Med2},x=3325,y=75,z=3286,pitch=0.0,yaw=0.0}");
                comp.add("Location{world=CraftWorld{name=Med2},x=3325,y=75,z=3287,pitch=0.0,yaw=0.0}");
                comp.add("Location{world=CraftWorld{name=Med2},x=3325,y=75,z=3288,pitch=0.0,yaw=0.0}");
                comp.add("Location{world=CraftWorld{name=Med2},x=3325,y=75,z=3289,pitch=0.0,yaw=0.0}");
                comp.add("Location{world=CraftWorld{name=Med2},x=3325,y=75,z=3290,pitch=0.0,yaw=0.0}");
                comp.add("Location{world=CraftWorld{name=Med2},x=3325,y=75,z=3291,pitch=0.0,yaw=0.0}");
                comp.add("Location{world=CraftWorld{name=Med2},x=3325,y=75,z=3292,pitch=0.0,yaw=0.0}");

                //comp.add("Location{world=CraftWorld{name=Med2},x=,y=,z=,pitch=0.0,yaw=0.0}");

                if (comp.contains(loc)) {
                    Material m = e.getBlock().getType();
                    Block b = e.getBlock();
                    if (m.equals(Material.LOG)) {
                        b.setType(Material.AIR);
                        //e.getPlayer().getItemInHand().setDurability((short) res);
                        //e.getPlayer().getInventory().addItem(new ItemStack(Material.LOG, 1));
                        Bukkit.getScheduler().runTaskLater(Vakardia.getPluginInstance(), new Runnable() {
                            @Override
                            public void run() {
                                b.setType(m);
                            }
                        }, 120 * 20L);
                    }

                }

        }
    }

}
