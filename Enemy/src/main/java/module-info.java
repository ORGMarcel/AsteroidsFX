import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;
import dk.sdu.mmmi.enemysystem.EnemyControlSystem;
import dk.sdu.mmmi.enemysystem.EnemyPlugin;


module Enemy {
    exports dk.sdu.mmmi.enemysystem;
    requires Common;
    requires CommonBullet;
    requires CommonEnemy;
    uses dk.sdu.mmmi.cbse.common.bullet.BulletSPI;
    provides  IGamePluginService with EnemyPlugin;
    provides  IEntityProcessingService with EnemyControlSystem;
}