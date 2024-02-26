package dk.sdu.mmmi.Collision;
import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;

public class CollisionControlSystem implements IEntityProcessingService {
    @Override
    public void process(GameData gameData, World world) {

    }

    private boolean entityCollision(Entity eBullet, Entity eAsteroid) {

        double x1 = eBullet.getX();
        double y1 = eBullet.getY();
        double x2 = eAsteroid.getX();
        double y2 = eAsteroid.getY();

        double result = Math.sqrt(((x1-x2)*(x1-x2)) - (y1-y2)*(y1-y2));
        double[] bulletCoordinates = eBullet.getPolygonCoordinates();
        double[] asteroidCoordinates = eAsteroid.getPolygonCoordinates();


        if (result <

        return true;
    }
}
