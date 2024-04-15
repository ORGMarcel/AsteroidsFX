
import dk.sdu.mmmi.cbse.PlayerControlSystem;
import dk.sdu.mmmi.cbse.PlayerPlugin;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;

module Player {
    exports dk.sdu.mmmi.cbse;
    requires Common;
    requires CommonBullet;   
    uses dk.sdu.mmmi.cbse.common.bullet.BulletSPI;
    provides IGamePluginService with PlayerPlugin;
    provides IEntityProcessingService with PlayerControlSystem, dk.sdu.mmmi.cbse.EntityProcessor;
    
}
