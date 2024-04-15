package dk.sdu.mmmi.Collision;
import dk.sdu.mmmi.cbse.HelloWorld;
import dk.sdu.mmmi.cbse.common.bullet.Bullet;
import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;

import java.util.Arrays;

public class CollisionControlSystem implements IEntityProcessingService {
    @Override
    public void process(GameData gameData, World world) {
        for (Entity entity1 : world.getEntities()) {
            for (Entity entity2 : world.getEntities()) {
                if (entityCollision(entity1, entity2)) {
                    System.out.println(entity2.getHitPoints());
                    entity2.setHitPoints(entity2.getHitPoints() - 1);
                    System.out.println(entity2.getHitPoints());

                    if (entity2.getHitPoints() < 1) {
                        world.removeEntity(entity2);
                    }
                    world.removeEntity(entity1);
                }

            }

        }
        for (Entity player : world.getEntities(HelloWorld.class)) {
            for (Entity asteroid : world.getEntities(HelloWorld.class)) {
                if (entityCollision(player, asteroid)) {
                    world.removeEntity(player);
                    world.removeEntity(asteroid);

                }
            }
        }
    }


    private boolean entityCollision(Entity eBullet, Entity eAsteroid) {

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
