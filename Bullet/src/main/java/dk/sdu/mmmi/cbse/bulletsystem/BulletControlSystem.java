package dk.sdu.mmmi.cbse.bulletsystem;

import dk.sdu.mmmi.cbse.common.bullet.CommonBullet;
import dk.sdu.mmmi.cbse.common.bullet.BulletSPI;
import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;

public class BulletControlSystem implements IEntityProcessingService, BulletSPI {

    @Override
    public void process(GameData gameData, World world) {

        for (Entity bullet : world.getEntities(CommonBullet.class)) {
            //if (gameData.getKeys().isDown(GameKeys.SPACE))
            double changeX = Math.cos(Math.toRadians(bullet.getRotation()));
            double changeY = Math.sin(Math.toRadians(bullet.getRotation()));
            bullet.setX(bullet.getX() + changeX*4);
            bullet.setY(bullet.getY() + changeY*4);

            if (bullet.getX() < 0) {
                world.removeEntity(bullet);
            }

            if (bullet.getX() > gameData.getDisplayWidth()) {
                world.removeEntity(bullet);
            }

            if (bullet.getY() < 0) {
                world.removeEntity(bullet);
            }

            if (bullet.getY() > gameData.getDisplayHeight()) {
                world.removeEntity(bullet);
            }



        }
    }

    @Override
    public Entity createBullet(Entity shooter, GameData gameData) {

        Entity bulletentity = new CommonBullet();
        bulletentity.setPolygonCoordinates(1,-1,1,1,-1,1,-1,-1);
        bulletentity.setRotation(shooter.getRotation());
        bulletentity.setX(shooter.getX());
        bulletentity.setY(shooter.getY());

        return bulletentity;
    }
}
