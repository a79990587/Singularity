package org.infinitystudio.singularity.tile.machine;

import org.infinitystudio.singularity.api.resource.Resource;
import org.infinitystudio.singularity.tile.SingularityBaseInventory;

/**
 * @author Blealtan
 */
public abstract class TileBaseMachine extends SingularityBaseInventory {

    private boolean runningState;
    private TileBaseMachine centralBlock;

    public TileBaseMachine() {
        super();
        runningState = false;
        centralBlock = null;
    }

    /**
     * Get the central block controlling this machine.
     *
     * @param refresh Whether to find the central block. Should only be called when block placement has changed.
     * @return The central block controlling this machine.
     */
    public TileBaseMachine getCentralBlock(boolean refresh) {
        if (refresh) {
            /* TODO: Check for central blocks around and ask them
               TODO: to refresh their dispatching list (if refresh == true).
               TODO: Confirm the size and shape of the multi-block like structure.
               */
        }
        return centralBlock;
    }

    /**
     * Get the machine's running state.
     *
     * @return True if running correctly, false opposite.
     */
    public boolean getRunningState() {
        return runningState;
    }

    /**
     * Set the machine's running state.
     *
     * @param b True if to run correctly, false opposite.
     */
    public void setRunningState(boolean b) {
        runningState = b;
    }

    /**
     * Get the Resource used per tick.
     *
     * @return Resource used per tick.
     */
    public abstract Resource getResourceUsage();
}
