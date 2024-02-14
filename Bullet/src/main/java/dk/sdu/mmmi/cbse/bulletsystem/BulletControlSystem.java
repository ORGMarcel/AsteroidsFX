package dk.sdu.mmmi.cbse.bulletsystem;

import dk.sdu.mmmi.cbse.common.bullet.Bullet;
import dk.sdu.mmmi.cbse.common.bullet.BulletSPI;
import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.GameKeys;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;

public class BulletControlSystem implements IEntityProcessingService, BulletSPI {

    @Override
    public void process(GameData gameData, World world) {

        for (Entity bullet : world.getEntities(Bullet.class)) {
            //if (gameData.getKeys().isDown(GameKeys.SPACE))
            double changeX = Math.cos(Math.toRadians(bullet.getRotation()));
            double changeY = Math.sin(Math.toRadians(bullet.getRotation()));
            bullet.setX(bullet.getX() + changeX);
            bullet.setY(bullet.getY() + changeY);



        }
    }

    @Override
    public Entity createBullet(Entity shooter, GameData gameData) {

        Entity bulletentity = new Bullet();
        bulletentity.setPolygonCoordinates(-5,-5,10,0,-5,5);
        bulletentity.setRotation(shooter.getRotation());
        bulletentity.setX(shooter.getX());
        bulletentity.setY(shooter.getY());

        return bulletentity;
    }
}
