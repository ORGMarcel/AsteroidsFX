import dk.sdu.mmmi.Collision.CollisionControlSystem;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;


module Collision {
    requires Common;
    requires Asteroid;
    requires CommonBullet;
    requires Player;
    provides  IEntityProcessingService with CollisionControlSystem;
}