package net.mrgeotech;

import net.minestom.server.MinecraftServer;
import net.minestom.server.entity.GameMode;
import net.minestom.server.entity.Player;
import net.minestom.server.extensions.Extension;
import net.minestom.server.instance.block.Block;
import net.minestom.server.potion.PotionEffect;
import net.minestom.server.potion.TimedPotion;
import net.mrgeotech.check.Recorder;
import net.mrgeotech.data.MovementEffect;
import net.mrgeotech.data.PlayerGamemode;
import net.mrgeotech.data.PlayerSnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AntiStom extends Extension {

    @Override
    public void initialize() {
        MinecraftServer.getSchedulerManager().buildTask(() -> {
            MinecraftServer.getConnectionManager().getOnlinePlayers().forEach(player -> Recorder.addSnapshot(toSnapshot(player)));
        });
    }

    @Override
    public void terminate() {

    }

    public static PlayerSnapshot toSnapshot(Player player) {
        Block blockBelow = player.getInstance().getBlock(player.getPosition().sub(0, 1, 0));
        Block blockIn = player.getInstance().getBlock(player.getPosition());
        return new PlayerSnapshot(player.getPosition().x(),
                player.getPosition().y(),
                player.getPosition().z(),
                player.getPosition().pitch(),
                player.getPosition().yaw(),
                1,
                player.getFlyingSpeed(),
                1,
                0,
                0,
                0,
                0,
                player.getLatency(),
                0,
                blockBelow == Block.SOUL_SAND,
                blockBelow == Block.SLIME_BLOCK,
                blockBelow == Block.HONEY_BLOCK,
                player.isOnGround(),
                blockIn == Block.COBWEB,
                blockIn == Block.POWDER_SNOW,
                blockIn == Block.BUBBLE_COLUMN,
                blockIn == Block.BUBBLE_COLUMN,
                blockIn == Block.WATER,
                blockIn == Block.LAVA || blockIn == Block.LAVA_CAULDRON,
                player.getVehicle() != null,
                false,
                player.isEating(),
                player.isSneaking(),
                player.isSprinting(),
                false,
                player.getVelocity().y() > 0,
                player.isFlying(),
                false,
                false,
                false,
                false,
                true,
                player.isAllowFlying(),
                false,
                !player.hasNoGravity(),
                toPlayerGamemode(player.getGameMode()),
                toMovementEffects(player.getActiveEffects()));
    }

    public static Map<MovementEffect, Byte> toMovementEffects(List<TimedPotion> timedPotions) {
        Map<MovementEffect, Byte> effects = new HashMap<>();
        for (TimedPotion timedPotion : timedPotions) {
            if (timedPotion.getPotion().effect() == PotionEffect.SPEED)
                effects.put(MovementEffect.SPEED, timedPotion.getPotion().amplifier());
            else if (timedPotion.getPotion().effect() == PotionEffect.SLOWNESS)
                effects.put(MovementEffect.SLOWNESS, timedPotion.getPotion().amplifier());
            else if (timedPotion.getPotion().effect() == PotionEffect.JUMP_BOOST)
                effects.put(MovementEffect.JUMP_BOOST, timedPotion.getPotion().amplifier());
            else if (timedPotion.getPotion().effect() == PotionEffect.LEVITATION)
                effects.put(MovementEffect.LEVITATION, timedPotion.getPotion().amplifier());
            else if (timedPotion.getPotion().effect() == PotionEffect.SLOW_FALLING)
                effects.put(MovementEffect.SLOW_FALLING, timedPotion.getPotion().amplifier());
            else if (timedPotion.getPotion().effect() == PotionEffect.DOLPHINS_GRACE)
                effects.put(MovementEffect.DOLPHINS_GRACE, timedPotion.getPotion().amplifier());
        }
        return effects;
    }

    public static PlayerGamemode toPlayerGamemode(GameMode gameMode) {
        return PlayerGamemode.valueOf(gameMode.name());
    }

}
