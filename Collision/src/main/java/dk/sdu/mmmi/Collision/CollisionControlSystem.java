package dk.sdu.mmmi.Collision;
import dk.sdu.mmmi.asteroidsystem.Asteroid;
import dk.sdu.mmmi.cbse.common.bullet.Bullet;
import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;
import dk.sdu.mmmi.cbse.playersystem.Player;

import java.util.Arrays;

public class CollisionControlSystem implements IEntityProcessingService {
    @Override
    public void process(GameData gameData, World world) {
        for (Entity bullet : world.getEntities(Bullet.class)) {
            for (Entity asteroid : world.getEntities(Asteroid.class)) {
                if (entityCollision(bullet, asteroid)) {
                    System.out.println(asteroid.getHitPoints());
                    asteroid.setHitPoints(asteroid.getHitPoints() - 1);
                    System.out.println(asteroid.getHitPoints());

                    if (asteroid.getHitPoints() < 1) {
                        world.removeEntity(asteroid);
                    }
                    world.removeEntity(bullet);
                }

            }

        }
        for (Entity player : world.getEntities(Player.class)) {
            for (Entity asteroid : world.getEntities(Asteroid.class)) {
                if (entityCollision(player, asteroid)) {
                    world.removeEntity(player);
                    world.removeEntity(asteroid);

                }
            }
        }
    }


    public boolean entityCollision(Entity eBullet, Entity eAsteroid) {

        double x1 = eBullet.getX();
        double y1 = eBullet.getY();
        double x2 = eAsteroid.getX();
        double y2 = eAsteroid.getY();

        double result = Math.sqrt(((x1-x2)*(x1-x2)) + (y1-y2)*(y1-y2));
        double[] bulletCoordinates = eBullet.getPolygonCoordinates();
        double[] asteroidCoordinates = eAsteroid.getPolygonCoordinates();
        double maxBullet = Arrays.stream(bulletCoordinates).max().orElse(-1);
        double maxAsteroid = Arrays.stream(asteroidCoordinates).max().orElse(-1);


        if (result<maxAsteroid+maxBullet) {
            return true;
        }
        else {
            return false;
        }
    }
}
