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
    public enum MobsEnum {
        BLAZE ("BLAZE", "§eBlaze", "MHF_Blaze", false),
        CAVE_SPIDER ("CAVE_SPIDER", "§3Cave Spider", "MHF_CaveSpider", false),
        CHICKEN ("CHICKEN", "§7Chicken", "MHF_Chicken", false),
        COW ("COW", "§fCow", "MHF_Cow", false),
        ENDERMAN ("ENDERMAN", "§5Enderman", "MHF_Enderman", false),
        GHAST ("GHAST", "§fGhast", "MHF_Ghast", false),
        IRON_GOLEM ("IRON_GOLEM", "§fGolem", "MHF_Golem", false),
        MAGMA_CUBE ("MAGMA_CUBE", "§4Magma Cube", "MHF_LavaSlime", false),
        MUSHROOM_COW ("MUSHROOM_COW", "§cMushroom Cow", "MHF_MushroomCow", false),
        OCELOT ("OCELOT", "§6Ocelot", "MHF_Ocelot", false),
        PIG ("PIG", "§dPig", "MHF_Pig", false),
        ZOMBIFIED_PIGLIN ("ZOMBIFIED_PIGLIN", "§dZombified Piglin", "MHF_PigZombie", false),
        SHEEP ("SHEEP", "§fSheep", "MHF_Sheep", false),
        SLIME ("SLIME", "§aSlime", "MHF_Slime", false),
        SPIDER ("SPIDER", "§4Spider", "MHF_Spider", false),
        SQUID ("SQUID", "§1Squid", "MHF_Squid", false),
        VILLAGER ("VILLAGER", "§aVillager", "MHF_Villager", false),
        SKELETON ("SKELETON", "§fSkeleton", "SKELETON_SKULL", true),
        WITHER_SKELETON ("WITHER_SKELETON", "§8Wither Skeleton", "WITHER_SKELETON_SKULL", true),
        ZOMBIE ("ZOMBIE", "§2Zombie", "ZOMBIE_HEAD", true),
        CREEPER ("CREEPER", "§aCreeper", "CREEPER_HEAD", true),
        ENDER_DRAGON ("ENDER_DRAGON", "§5Ender Dragon", "DRAGON_HEAD", true);


        private final String ID, displayName, mobName;
        private final boolean isDefault;

        MobsEnum(String ID, String s1, String s2, Boolean b3) {
            this.ID = ID;
            this.displayName = s1;
            this.mobName = s2;
            this.isDefault = b3;
        }
    }
    // Array pentru toti mobii
    public static ArrayList<ItemStack> mobs = new ArrayList<ItemStack>();
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
        for (MobsEnum m : MobsEnum.values()) {
            mobs.add(mobGenerator(m.isDefault, m.displayName, m.mobName));
        }
    }

    @EventHandler
    public static void mobsMenu (InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        if (event.getClickedInventory().equals(mobGUI)) {
            event.setCancelled(true);
            if (event.getCurrentItem() == null) return; // Orice nu e item
            Location loc = player.getLocation();
            for (MobsEnum m : MobsEnum.values()) {
                if (event.getCurrentItem().getItemMeta().getDisplayName().equals(m.displayName)) {
                    player.getWorld().spawnEntity(loc, EntityType.valueOf(m.ID));
                    player.closeInventory();
                }
            }
        }
    }

    public static ItemStack mobGenerator(Boolean bool, String displayName, String mobName) {
        ItemStack temp = null;
        List<String> lore = new ArrayList<>();
        if (bool == true) {
            temp = new ItemStack(Material.getMaterial(mobName), 1);
            ItemMeta meta2 = temp.getItemMeta();
            meta2.setDisplayName(displayName);
            lore.add(ChatColor.translateAlternateColorCodes('&', "Click to spawn a(n) " + displayName));
            meta2.setLore(lore);
            temp.setItemMeta(meta2);
        } else if (bool == false) {
            temp = new ItemStack(Material.PLAYER_HEAD, 1);
            SkullMeta meta = (SkullMeta) temp.getItemMeta();
            meta.setOwner(mobName);
            meta.setDisplayName(displayName);
            lore.add(ChatColor.translateAlternateColorCodes('&', "Click to spawn a(n) " + displayName));
            meta.setLore(lore);
            temp.setItemMeta(meta);
        }
        return temp;
    }
}
