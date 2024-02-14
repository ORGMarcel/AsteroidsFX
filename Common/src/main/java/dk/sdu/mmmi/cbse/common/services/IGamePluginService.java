package dk.sdu.mmmi.cbse.common.services;

import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;

public interface IGamePluginService {

    /**
     *
     * PreCondition: Game or no game.
     * PostCondition: Game or no game.
     *
     * @param gameData
     * @param world
     * @throws IllegalStateException
     *
     *
     *
     *
     *
     */
    void start(GameData gameData, World world);

    void stop(GameData gameData, World world);
}
