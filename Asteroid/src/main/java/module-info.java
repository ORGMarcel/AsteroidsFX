import dk.sdu.mmmi.asteroidsystem.AsteroidPlugin;
import dk.sdu.mmmi.asteroidsystem.Asteroid;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;
import dk.sdu.mmmi.asteroidsystem.AsteroidControlSystem;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;


module Asteroid {
    exports dk.sdu.mmmi.asteroidsystem;
    requires Common;
    requires Enemy;
    provides  IGamePluginService with AsteroidPlugin;
    provides  IEntityProcessingService with AsteroidControlSystem;
}