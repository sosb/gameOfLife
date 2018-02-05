package game;

import org.junit.Assert;
import org.junit.Test;

public class GameOfLifeTest {

    @Test
    public void testDead() {
        boolean[][] area = {{false}};
        Assert.assertArrayEquals(area, GameOfLife.tick(area));
    }

    @Test
    public void testAlive() {
        boolean[][] area = {{true}};
        Assert.assertArrayEquals(new boolean[][]{{false}}, GameOfLife.tick(area));
    }

    @Test
    public void testTwoLong() {
        boolean[][] area = {{true, false}};
        Assert.assertArrayEquals(new boolean[][]{{false, false}}, GameOfLife.tick(area));
    }

    @Test
    public void testThreeLong() {
        boolean[][] area = {{true, true, true}};
        Assert.assertArrayEquals(new boolean[][]{{false, true, false}}, GameOfLife.tick(area));
    }

    @Test
    public void test2() {
        boolean[][] area = {
                {false, true, false},
                {false, true, false},
                {false, true, false}};

        final boolean[][] expected = {
                {false, false, false},
                {true, true, true},
                {false, false, false}};

        Assert.assertArrayEquals(expected, GameOfLife.tick(area));
    }

    @Test
    public void test3() {
        boolean[][] area = {
                {false, true, false},
                {true, true, false},
                {false, true, false}};

        final boolean[][] expected = {
                {true, true, false},
                {true, true, true},
                {true, true, false}};
        Assert.assertArrayEquals(expected, GameOfLife.tick(area));
    }

    @Test
    public void test4() {
        boolean[][] area = {
                {false, true, false, true},
                {true, false, false, false},
                {false, true, false, true}};

        final boolean[][] expected = {
                {false, false, false, false},
                {true, true, false, false},
                {false, false, false, false}};
        Assert.assertArrayEquals(expected, GameOfLife.tick(area));
    }

}
