import dk.sdu.mmmi.cbse.AsteroidPlugin;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;
import dk.sdu.mmmi.cbse.AsteroidControlSystem;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;


module Asteroid {
    exports dk.sdu.mmmi.cbse;
    requires Common;
    requires CommonBullet;
    uses dk.sdu.mmmi.cbse.common.bullet.BulletSPI;
    provides  IGamePluginService with AsteroidPlugin;
    provides IEntityProcessingService with AsteroidControlSystem, dk.sdu.mmmi.cbse.EntityProcessor;
}