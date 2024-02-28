import dk.sdu.mmmi.Collision.CollisionControlSystem;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;


module Collision {
    requires Common;
    requires Asteroid;
    requires CommonBullet;
    provides  IEntityProcessingService with CollisionControlSystem;
}