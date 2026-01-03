package model.game.space;

import CrossyRoad.model.Position;
import CrossyRoad.model.game.space.LoaderSpaceBuilder;
import CrossyRoad.model.game.space.Space;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class LoaderSpaceBuilderTest {
    private LoaderSpaceBuilder loader;
    private Space space;

    @BeforeEach
    public void setUp() throws IOException {
        this.loader = new LoaderSpaceBuilder(1);
        this.space = loader.createSpace();
    }

    @Test
    public void testGetWidth() {
        assertEquals(20, space.getWidth());
    }

    @Test
    public void testGetHeight() {
        assertEquals(6, space.getHeight());
    }

    @Test
    public void testCreateWalls() {
        assertEquals(48, space.getWalls().size());
    }

    @Test
    public void testCreateChicken() {
        assertNotNull(space.getChicken());
        assertEquals(new Position(1, 1), space.getChicken().getPosition());
    }

    @Test
    public void testCreateBushes() {
        assertEquals(4, space.getBushes().size());
    }

    @Test
    public void testCreateRiver() {
        assertEquals(12, space.getRiver().size());
    }

    @Test
    public void testCreateLog() {
        assertEquals(1, space.getLogs().size());
    }

    @Test
    public void testCreateCar() {
        assertEquals(1, space.getCars().size());
    }

    @Test
    public void testCreateTruck() {
        assertEquals(1, space.getTruck().size());
    }

    @Test
    public void testCreateEndline() {
        assertEquals(3, space.getEndlines().size());
    }

    @Test
    public void testCreateCoin() {
        assertEquals(1, space.getCoins().size(), "There should be exactly 1 coin in the level");
        assertEquals(new Position(15, 3), space.getCoins().get(0).getPosition());
    }

    @Test
    void testNoChickenThrowsSpecificException() {
        LoaderSpaceBuilder builder;
        try {
            builder = new LoaderSpaceBuilder(10);
        } catch (IOException e) {
            return;
        }
        assertThrows(
                IllegalStateException.class,
                builder::createSpace,
                "Should throw IllegalStateException, not IndexOutOfBounds or generic Exception"
        );
    }

    @Test
    void testChickenNotFoundAfterFullSearch() throws IOException {
        LoaderSpaceBuilder builder = new LoaderSpaceBuilder(10);
        Exception exception = assertThrows(IllegalStateException.class, builder::createSpace);
        assertTrue(exception.getMessage().contains("No chicken found"));
    }

    @Test
    void testChickenNotFoundInExistingFile() {
        LoaderSpaceBuilder builder;
        try {
            builder = new LoaderSpaceBuilder(99);
        } catch (IOException e) {
            fail("The test file lvl99.lvl is missing from resources!");
            return;
        }
        Exception exception = assertThrows(IllegalStateException.class, builder::createSpace);
        assertTrue(exception.getMessage().contains("No chicken found"));
    }
    @Test
    void testLoadNonExistingLevelThrowsIOException() {
        int nonExistentLevel = -1;

        Exception exception = assertThrows(IOException.class, () -> {
            new LoaderSpaceBuilder(nonExistentLevel);
        });
        String expectedMessage = "Ficheiro de nível não encontrado dentro do JAR";
        assertTrue(exception.getMessage().contains(expectedMessage));
    }
}