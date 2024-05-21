package dk.sdu.mmmi.enemysystem;

import dk.sdu.mmmi.cbse.common.bullet.BulletSPI;
import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;
import dk.sdu.mmmi.commonenemy.CommonEnemy;

import java.util.Collection;
import java.util.Random;
import java.util.ServiceLoader;

import static java.util.stream.Collectors.toList;


public class EnemyControlSystem implements IEntityProcessingService {

    @Override
    public void process(GameData gameData, World world) {

        Random random = new Random();
        int randomInt;
        int randomInt2;

        for (Entity enemy : world.getEntities(CommonEnemy.class)) {

            randomInt = random.nextInt(2);
            randomInt2 = random.nextInt(10);

            if(randomInt==0) {
                enemy.setRotation(enemy.getRotation()-5);
            }
            if(randomInt==1) {
                enemy.setRotation(enemy.getRotation()+5);
            }
            if (true) {
                double changeX = Math.cos(Math.toRadians(enemy.getRotation()));
                double changeY = Math.sin(Math.toRadians(enemy.getRotation()));
                enemy.setX(enemy.getX() + changeX);
                enemy.setY(enemy.getY() + changeY);
            }
            if(randomInt2 == 1) {
                getBulletSPIs().stream().findFirst().ifPresent(
                        spi -> {world.addEntity(spi.createBullet(enemy, gameData));}
                );
            }

            if (enemy.getX() < 0) {
                enemy.setRotation(enemy.getRotation()+180);
            }

            if (enemy.getX() > gameData.getDisplayWidth()) {
                enemy.setRotation(enemy.getRotation()+180);
            }

            if (enemy.getY() < 0) {
                enemy.setRotation(enemy.getRotation()+180);
            }

            if (enemy.getY() > gameData.getDisplayHeight()) {
                enemy.setRotation(enemy.getRotation()+180);
            }


        }
    }

    private Collection<? extends BulletSPI> getBulletSPIs() {
        return ServiceLoader.load(BulletSPI.class).stream().map(ServiceLoader.Provider::get).collect(toList());
    }
}