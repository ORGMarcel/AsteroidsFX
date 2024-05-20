package dk.sdu.mmmi.enemysystem;

import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.enemy.Enemy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnemyControlSystemTest {

    private EnemyControlSystem enemyControlSystem;
    private GameData gameData;
    private World world;
    private Enemy enemy;

    @BeforeEach
    void setUp() {
        enemyControlSystem = new EnemyControlSystem();
        gameData = new GameData();
        world = new World();
        enemy = new Enemy();
        world.addEntity(enemy);
    }

    @Test
    void process() {
        double initialX = enemy.getX();
        double initialY = enemy.getY();

        enemyControlSystem.process(gameData, world);

        assertNotEquals(initialX, enemy.getX());
        assertNotEquals(initialY, enemy.getY());
    }
}
