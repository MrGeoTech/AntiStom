package net.mrgeotech.check;

import net.mrgeotech.data.PlayerSnapshot;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;

public class Recorder {

    private final static String FILE_NAME = "results.txt";

    private static List<PlayerSnapshot> snapshots;

    public static void addSnapshot(PlayerSnapshot snapshot) {
        snapshots.add(snapshot);
    }

    public static Runnable getSaveRunnable() {
        return () -> {
            try {
                List<PlayerSnapshot> playerSnapshots = snapshots;
                StringBuilder builder = new StringBuilder();
                for (PlayerSnapshot snapshot : playerSnapshots) {
                    builder.append(snapshot.x()).append(",")
                            .append(snapshot.y()).append(",")
                            .append(snapshot.z()).append(",")
                            .append(snapshot.pitch()).append(",")
                            .append(snapshot.yaw()).append(",")
                            .append(snapshot.walkingSpeed()).append(",")
                            .append(snapshot.flySpeed()).append(",")
                            .append(snapshot.swimSpeed()).append(",")
                            .append(snapshot.additionalSpeedMultipliers()).append(",")
                            .append(snapshot.fallDistance()).append(",")
                            .append(snapshot.iceVelocity()).append(",")
                            .append(snapshot.vehicleMaxSpeed()).append(",")
                            .append(snapshot.latency()).append(",")
                            .append(snapshot.ticksSinceLastBoost()).append(",")
                            .append(snapshot.isOnSoulSand()).append(",")
                            .append(snapshot.isOnSlime()).append(",")
                            .append(snapshot.isOnHoney()).append(",")
                            .append(snapshot.isOnGround()).append(",")
                            .append(snapshot.isInCobWebs()).append(",")
                            .append(snapshot.isInPowderedSnow()).append(",")
                            .append(snapshot.isInUpBubbleColumn()).append(",")
                            .append(snapshot.isInDownBubbleColumn()).append(",")
                            .append(snapshot.isInWater()).append(",")
                            .append(snapshot.isInLava()).append(",")
                            .append(snapshot.isInVehicle()).append(",")
                            .append(snapshot.isSpectatingOtherPlayer()).append(",")
                            .append(snapshot.isEating()).append(",")
                            .append(snapshot.isCrouching()).append(",")
                            .append(snapshot.isSprinting()).append(",")
                            .append(snapshot.isSwimming()).append(",")
                            .append(snapshot.isJumping()).append(",")
                            .append(snapshot.isFlying()).append(",")
                            .append(snapshot.isGliding()).append(",")
                            .append(snapshot.isClimbing()).append(",")
                            .append(snapshot.isUsingTrident()).append(",")
                            .append(snapshot.isUsingShield()).append(",")
                            .append(snapshot.canSprint()).append(",")
                            .append(snapshot.canFly()).append(",")
                            .append(snapshot.wasMovedByPiston()).append(",")
                            .append(snapshot.hasGravity()).append("\n");
                }
                BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME));
                writer.write(builder.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        };
    }

}
