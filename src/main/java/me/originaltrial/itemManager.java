package me.originaltrial;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;
import java.util.List;

public class itemManager implements Listener {
    // Array pentru toti mobii
    public static ArrayList<ItemStack> mobs = new ArrayList<ItemStack>();
    // Liste cu nume de mobi care nu au deja capul in joc + cea colorata
    public static String[] mobList = {"Blaze", "CaveSpider", "Chicken", "Cow", "Enderman", "Ghast", "Golem", "LavaSlime", "MushroomCow", "Ocelot", "Pig", "PigZombie", "Sheep", "Slime", "Spider", "Squid", "Villager"};
    public static String[] mobName = {"&eBlaze", "&3Cave Spider", "&7Chicken", "&fCow", "&5Enderman", "&fGhast", "&fGolem", "&4Magma Slime", "&cMushroom Cow", "&6Ocelot", "&dPig", "&dZombified Piglin", "&fSheep", "&aSlime", "&4Spider", "&1Squid", "&aVillager"};
    public static Inventory mobGUI;
    public static void init() { // Functia de initializare, aceasta clasa nu ruleaza cod de una singura, trebuie ajutata de la pornire
        mobs();
        mobGUI();
    }
    public static void mobGUI() { // Initializarea meniului GUI
        mobGUI = Bukkit.createInventory(null, 27, "Spawn a mob");
        int i = 0;
        for (ItemStack mob : mobs) {
            mobGUI.setItem(i, mob);
            i++;
        }
    }
    public static void mobs() { // Initializarea mobilor pentru a putea fi pusi in GUI
        ItemStack temp;
        SkullMeta meta;
        List<String> lore = new ArrayList<>();
        for (int i = 0; i <= 16; ++i) { // Toti mobii care nu au capuri din fabrica
            temp = new ItemStack(Material.PLAYER_HEAD, 1);
            meta = (SkullMeta) temp.getItemMeta();
            String owner = "MHF_" + mobList[i];
            meta.setOwner(owner);
            meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', mobName[i]));
            lore.clear();
            lore.add(ChatColor.translateAlternateColorCodes('&', "Click to spawn a(n) " + mobName[i]));
            meta.setLore(lore);
            temp.setItemMeta(meta);
            mobs.add(temp);
        }
        temp = new ItemStack(Material.SKELETON_SKULL, 1); // Skeleton
        ItemMeta meta2 = temp.getItemMeta();
        meta2.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fSkeleton"));
        lore.clear();
        lore.add(ChatColor.translateAlternateColorCodes('&', "Click to spawn a(n) &fSkeleton"));
        meta2.setLore(lore);
        temp.setItemMeta(meta2);
        mobs.add(temp);
        temp = new ItemStack(Material.WITHER_SKELETON_SKULL, 1); // Wither Skeleton
        meta2 = temp.getItemMeta();
        meta2.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&8Wither Skeleton"));
        lore.clear();
        lore.add(ChatColor.translateAlternateColorCodes('&', "Click to spawn a(n) &8Wither Skeleton"));
        meta2.setLore(lore);
        temp.setItemMeta(meta2);
        mobs.add(temp);
        temp = new ItemStack(Material.ZOMBIE_HEAD, 1); // Zombie
        meta2 = temp.getItemMeta();
        meta2.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&2Zombie"));
        lore.clear();
        lore.add(ChatColor.translateAlternateColorCodes('&', "Click to spawn a(n) &2Zombie"));
        meta2.setLore(lore);
        temp.setItemMeta(meta2);
        mobs.add(temp);
        temp = new ItemStack(Material.CREEPER_HEAD, 1); // Creeper
        meta2 = temp.getItemMeta();
        meta2.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&aCreeper"));
        lore.clear();
        lore.add(ChatColor.translateAlternateColorCodes('&', "Click to spawn a(n) &aCreeper"));
        meta2.setLore(lore);
        temp.setItemMeta(meta2);
        mobs.add(temp);
        temp = new ItemStack(Material.DRAGON_HEAD, 1); // Ender Dragon
        meta2 = temp.getItemMeta();
        meta2.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&5Ender Dragon"));
        lore.clear();
        lore.add(ChatColor.translateAlternateColorCodes('&', "Click to spawn a(n) &5Ender Dragon"));
        meta2.setLore(lore);
        temp.setItemMeta(meta2);
        mobs.add(temp);
    }

    @EventHandler
    public static void mobsMenu (InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        if (event.getClickedInventory().equals(mobGUI)) {
            event.setCancelled(true);
            if (event.getCurrentItem() == null) return; // Orice nu e item
            Location loc = player.getLocation();
            if (event.getCurrentItem().getItemMeta().getDisplayName().equals(mobs.get(0).getItemMeta().getDisplayName())) { // Blaze
                player.getWorld().spawnEntity(loc, EntityType.BLAZE);
                player.closeInventory();
            }
            if (event.getCurrentItem().getItemMeta().getDisplayName().equals(mobs.get(1).getItemMeta().getDisplayName())) { // Cave Spider
                player.getWorld().spawnEntity(loc, EntityType.CAVE_SPIDER);
                player.closeInventory();
            }
            if (event.getCurrentItem().getItemMeta().getDisplayName().equals(mobs.get(2).getItemMeta().getDisplayName())) { // Chicken
                player.getWorld().spawnEntity(loc, EntityType.CHICKEN);
                player.closeInventory();
            }
            if (event.getCurrentItem().getItemMeta().getDisplayName().equals(mobs.get(3).getItemMeta().getDisplayName())) { // Cow
                player.getWorld().spawnEntity(loc, EntityType.COW);
                player.closeInventory();
            }
            if (event.getCurrentItem().getItemMeta().getDisplayName().equals(mobs.get(4).getItemMeta().getDisplayName())) { // Enderman
                player.getWorld().spawnEntity(loc, EntityType.ENDERMAN);
                player.closeInventory();
            }
            if (event.getCurrentItem().getItemMeta().getDisplayName().equals(mobs.get(5).getItemMeta().getDisplayName())) { // Ghast
                player.getWorld().spawnEntity(loc, EntityType.GHAST);
                player.closeInventory();
            }
            if (event.getCurrentItem().getItemMeta().getDisplayName().equals(mobs.get(6).getItemMeta().getDisplayName())) { // Golem
                player.getWorld().spawnEntity(loc, EntityType.IRON_GOLEM);
                player.closeInventory();
            }
            if (event.getCurrentItem().getItemMeta().getDisplayName().equals(mobs.get(7).getItemMeta().getDisplayName())) { // Magma Cube
                player.getWorld().spawnEntity(loc, EntityType.MAGMA_CUBE);
                player.closeInventory();
            }
            if (event.getCurrentItem().getItemMeta().getDisplayName().equals(mobs.get(8).getItemMeta().getDisplayName())) { // Mushroom Cow
                player.getWorld().spawnEntity(loc, EntityType.MUSHROOM_COW);
                player.closeInventory();
            }
            if (event.getCurrentItem().getItemMeta().getDisplayName().equals(mobs.get(9).getItemMeta().getDisplayName())) { // Ocelot
                player.getWorld().spawnEntity(loc, EntityType.OCELOT);
                player.closeInventory();
            }
            if (event.getCurrentItem().getItemMeta().getDisplayName().equals(mobs.get(10).getItemMeta().getDisplayName())) { // Pig
                player.getWorld().spawnEntity(loc, EntityType.PIG);
                player.closeInventory();
            }
            if (event.getCurrentItem().getItemMeta().getDisplayName().equals(mobs.get(11).getItemMeta().getDisplayName())) { // Zombified Piglin
                player.getWorld().spawnEntity(loc, EntityType.ZOMBIFIED_PIGLIN);
                player.closeInventory();
            }
            if (event.getCurrentItem().getItemMeta().getDisplayName().equals(mobs.get(12).getItemMeta().getDisplayName())) { // Sheep
                player.getWorld().spawnEntity(loc, EntityType.SHEEP);
                player.closeInventory();
            }
            if (event.getCurrentItem().getItemMeta().getDisplayName().equals(mobs.get(13).getItemMeta().getDisplayName())) { // Slime
                player.getWorld().spawnEntity(loc, EntityType.SLIME);
                player.closeInventory();
            }
            if (event.getCurrentItem().getItemMeta().getDisplayName().equals(mobs.get(14).getItemMeta().getDisplayName())) { // Spider
                player.getWorld().spawnEntity(loc, EntityType.SPIDER);
                player.closeInventory();
            }
            if (event.getCurrentItem().getItemMeta().getDisplayName().equals(mobs.get(15).getItemMeta().getDisplayName())) { // Squid
                player.getWorld().spawnEntity(loc, EntityType.SQUID);
                player.closeInventory();
            }
            if (event.getCurrentItem().getItemMeta().getDisplayName().equals(mobs.get(16).getItemMeta().getDisplayName())) { // Villager
                player.getWorld().spawnEntity(loc, EntityType.VILLAGER);
                player.closeInventory();
            }
            if (event.getCurrentItem().getItemMeta().getDisplayName().equals(mobs.get(17).getItemMeta().getDisplayName())) { // Skeleton
                player.getWorld().spawnEntity(loc, EntityType.SKELETON);
                player.closeInventory();
            }
            if (event.getCurrentItem().getItemMeta().getDisplayName().equals(mobs.get(18).getItemMeta().getDisplayName())) { // Wither Skeleton
                player.getWorld().spawnEntity(loc, EntityType.WITHER_SKELETON);
                player.closeInventory();
            }
            if (event.getCurrentItem().getItemMeta().getDisplayName().equals(mobs.get(19).getItemMeta().getDisplayName())) { // Zombie
                player.getWorld().spawnEntity(loc, EntityType.ZOMBIE);
                player.closeInventory();
            }
            if (event.getCurrentItem().getItemMeta().getDisplayName().equals(mobs.get(20).getItemMeta().getDisplayName())) { // Creeper
                player.getWorld().spawnEntity(loc, EntityType.CREEPER);
                player.closeInventory();
            }
            if (event.getCurrentItem().getItemMeta().getDisplayName().equals(mobs.get(21).getItemMeta().getDisplayName())) { // Ender Dragon
                player.getWorld().spawnEntity(loc, EntityType.ENDER_DRAGON);
                player.closeInventory();
            }
        }
    }

}
