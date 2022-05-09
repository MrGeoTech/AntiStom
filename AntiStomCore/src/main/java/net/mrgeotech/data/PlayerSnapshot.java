package net.mrgeotech.data;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

public record PlayerSnapshot(
        double x,
        double y,
        double z,
        double pitch,
        double yaw,
        double walkingSpeed,
        double flySpeed,
        double swimSpeed,
        double additionalSpeedMultipliers,
        double fallDistance,
        double iceVelocity,
        double vehicleMaxSpeed,
        int latency,
        int ticksSinceLastBoost,
        boolean isOnSoulSand,
        boolean isOnSlime,
        boolean isOnHoney,
        boolean isOnGround,
        boolean isInCobWebs,
        boolean isInPowderedSnow,
        boolean isInUpBubbleColumn,
        boolean isInDownBubbleColumn,
        boolean isInWater,
        boolean isInLava,
        boolean isInVehicle,
        boolean isSpectatingOtherPlayer,
        boolean isEating,
        boolean isCrouching,
        boolean isSprinting,
        boolean isSwimming,
        boolean isJumping,
        boolean isFlying,
        boolean isGliding,
        boolean isClimbing,
        boolean isUsingTrident,
        boolean isUsingShield,
        boolean canSprint,
        boolean canFly,
        boolean wasMovedByPiston,
        boolean hasGravity,
        @NotNull PlayerGamemode gamemode,
        @Nullable Map<MovementEffect, Byte> effects) {
}
