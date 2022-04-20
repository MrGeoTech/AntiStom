package net.mrgeotech.check;

import net.mrgeotech.data.PlayerSnapshot;

public class PlayerChecker {

    public static final double DEFAULT_BLOCKS_PER_MILLISECOND = 0.0045;
    public static final double CROUCH_BLOCKS_PER_MILLISECOND = DEFAULT_BLOCKS_PER_MILLISECOND / 2;
    public static final double SPRINT_BLOCKS_PER_MILLISECOND = DEFAULT_BLOCKS_PER_MILLISECOND * 0.35;
    public static final double FLYING_BLOCKS_PER_MILLISECOND = DEFAULT_BLOCKS_PER_MILLISECOND * 2.6;
    public static final double SPRINT_FLY_BLOCKS_PER_MILLISECOND = FLYING_BLOCKS_PER_MILLISECOND * 2;

    public static void checkMovement(PlayerSnapshot previous, PlayerSnapshot current) {

    }

}
