package dk.sdu.mmmi.asteroidsystem;

import dk.sdu.mmmi.asteroid.CommonAsteroid;
import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;
import java.util.Random;

public class AsteroidPlugin implements IGamePluginService {

    private Entity asteroid;

    public AsteroidPlugin() {
    }

    @Override
    public void start(GameData gameData, World world) {

        // Add entities to the world
        asteroid = createAsteroid(gameData);
        world.addEntity(asteroid);
    }

    public static Entity createAsteroid(GameData gameData) {

        Random randomAsteroidPlacement = new Random();
        int randomAsteroidInt = randomAsteroidPlacement.nextInt(gameData.getDisplayWidth());
        Entity asteroid = new CommonAsteroid();
        asteroid.setPolygonCoordinates(10, 0, 7, 7, 0, 10, -7, 7, -10, 0, -7, -7, 0, -10, 7, -7);
        asteroid.setX(randomAsteroidInt);
        asteroid.setY(0);
        asteroid.setRotation(90);
        asteroid.setHitPoints(10);



        return asteroid;
    }

    @Override
    public void stop(GameData gameData, World world) {
        // Remove entities
        world.removeEntity(asteroid);
    }
}

