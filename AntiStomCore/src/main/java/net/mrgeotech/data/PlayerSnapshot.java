package net.mrgeotech.data;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public record PlayerSnapshot(
        double x,
        double y,
        double z,
        double walkingSpeed,
        double flySpeed,
        double swimSpeed,
        double additionalSpeedMultipliers,
        int latency,
        boolean isOnSoulSand,
        boolean isOnSlime,
        boolean isOnHoney,
        boolean isOnGround,
        boolean isInCobWebs,
        boolean isEating,
        boolean isCrouching,
        boolean isSwimming,
        boolean isJumping,
        boolean isFlying,
        boolean canSprint,
        boolean canFly,
        @NotNull PlayerGamemode gamemode,
        @Nullable MovementEffect[] effects) {
}
