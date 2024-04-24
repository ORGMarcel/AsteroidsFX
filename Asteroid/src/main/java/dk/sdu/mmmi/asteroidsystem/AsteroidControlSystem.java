package dk.sdu.mmmi.asteroidsystem;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;
import dk.sdu.mmmi.asteroid.Asteroid;

import java.util.Random;

public class AsteroidControlSystem implements IEntityProcessingService {

    @Override
    public void process(GameData gameData, World world) {

        Random random = new Random();
        int randomInt  = random.nextInt(100);

        for (Entity asteroid : world.getEntities(Asteroid.class)) {

                double changeX = Math.cos(Math.toRadians(asteroid.getRotation()));
                double changeY = Math.sin(Math.toRadians(asteroid.getRotation()));
                asteroid.setX(asteroid.getX() + changeX*0.5);
                asteroid.setY(asteroid.getY() + changeY*0.5);

                if (asteroid.getHitPoints()==7){

                    Entity asteroidSmall = new Asteroid();
                    asteroidSmall.setPolygonCoordinates(-10, 0, -7, -7, 0, -10, 7, -7);
                    asteroidSmall.setX(asteroid.getX());
                    asteroidSmall.setY(asteroid.getY());
                    asteroidSmall.setRotation(asteroid.getRotation()+90);
                    asteroidSmall.setHitPoints(6);
                    world.addEntity(asteroidSmall);

                    Entity asteroidSmall1 = new Asteroid();
                    asteroidSmall1.setPolygonCoordinates(-10, 0, -7, -7, 0, -10, 7, -7);
                    asteroidSmall1.setX(asteroid.getX());
                    asteroidSmall1.setY(asteroid.getY());
                    asteroidSmall1.setRotation(asteroid.getRotation()-90);
                    asteroidSmall1.setHitPoints(6);
                    world.addEntity(asteroidSmall1);

                    world.removeEntity(asteroid);
                }

                if (asteroid.getHitPoints()==3) {
                    Entity asteroidSmallest = new Asteroid();
                    asteroidSmallest.setPolygonCoordinates(-5, 0, -3, -4, 0, -8, 3, -2);
                    asteroidSmallest.setX(asteroid.getX());
                    asteroidSmallest.setY(asteroid.getY());
                    asteroidSmallest.setRotation(asteroid.getRotation()+90);
                    asteroidSmallest.setHitPoints(2);
                    world.addEntity(asteroidSmallest);

                    Entity asteroidSmallest1 = new Asteroid();
                    asteroidSmallest1.setPolygonCoordinates(-5, 0, -3, -4, 0, -8, 3, -2);
                    asteroidSmallest1.setX(asteroid.getX());
                    asteroidSmallest1.setY(asteroid.getY());
                    asteroidSmallest1.setRotation(asteroid.getRotation()-90);
                    asteroidSmallest1.setHitPoints(2);
                    world.addEntity(asteroidSmallest1);

                    world.removeEntity(asteroid);


                }

        }
        if (randomInt ==1) {
            world.addEntity(AsteroidPlugin.createAsteroid(gameData));
        }

    }
}
