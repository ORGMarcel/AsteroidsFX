package dk.sdu.mmmi.cbse.common.services;

import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;

public interface IEntityProcessingService {

    /**
     *
     * PreCondition: All gamedata must be loaded, and a world must be set.
     * PostCondition: All processes must be terminated.
     *
     * @param gameData
     * @param world
     * @throws NullPointerException
     *
     *
     *
     *
     *
     */
    void process(GameData gameData, World world);
}
