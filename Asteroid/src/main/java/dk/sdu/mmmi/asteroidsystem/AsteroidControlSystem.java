package dk.sdu.mmmi.asteroidsystem;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;
import dk.sdu.mmmi.asteroidsystem.Asteroid;

import java.util.Random;

public class AsteroidControlSystem implements IEntityProcessingService {

    @Override
    public void process(GameData gameData, World world) {

        Random random = new Random();
        int randomInt;
        int randomInt2;

        for (Entity asteroid : world.getEntities(Asteroid.class)) {

                double changeX = Math.cos(Math.toRadians(asteroid.getRotation()));
                double changeY = Math.sin(Math.toRadians(asteroid.getRotation()));
                asteroid.setX(asteroid.getX() + changeX*4);
                asteroid.setY(asteroid.getY() + changeY*4);



            if (asteroid.getX() < 0) {
                asteroid.setX(1);
            }

            if (asteroid.getX() > gameData.getDisplayWidth()) {
                asteroid.setX(gameData.getDisplayWidth()-1);
            }

            if (asteroid.getY() < 0) {
                asteroid.setY(1);
            }

            if (asteroid.getY() > gameData.getDisplayHeight()) {
                asteroid.setY(gameData.getDisplayHeight()-1);
            }


        }
    }
}
