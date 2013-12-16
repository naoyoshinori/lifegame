import spock.lang.Specification

/**
 * Created by naoyuki on 2013/12/15.
 */
class WorldTest extends Specification {

    def checkAllocatedAea(width, height, targetHasAllocatedArea) {
        def world = new World(width, height)
        world.newArea()
        world.hasAllocatedArea() == targetHasAllocatedArea
    }

    def "世界の生成をテストする"() {
        given:

        expect:
        checkAllocatedAea(0, 0, World.UNALLOCATED)
        checkAllocatedAea(0, 1, World.UNALLOCATED)
        checkAllocatedAea(1, 0, World.UNALLOCATED)
        checkAllocatedAea(1, 1, World.ALLOCATED)
    }

    def initializeCells(width, height, y, x, numberOfNeighbors) {
        def world = new World(width, height)
        world.newArea()
        world.initializeCell(y, x)
        world.getCell(y, x).getNumberOfNeighbors() == numberOfNeighbors
    }

    def "隣接するセルの数をテストする"() {
        given:

        expect:
        initializeCells(3, 3, 0, 0, 3)
        initializeCells(3, 3, 0, 1, 5)
        initializeCells(3, 3, 0, 2, 3)
        initializeCells(3, 3, 1, 0, 5)
        initializeCells(3, 3, 1, 1, 8)
        initializeCells(3, 3, 1, 2, 5)
        initializeCells(3, 3, 2, 0, 3)
        initializeCells(3, 3, 2, 1, 5)
        initializeCells(3, 3, 2, 2, 3)
    }

    def "隣のセルの数を数える5"() {
        given:
        def world = new World(3, 3)
        world.newArea()
        world.initializeArea()

        expect:
        world.getCell(0, 0).getNumberOfNeighbors() == 3
        world.getCell(0, 1).getNumberOfNeighbors() == 5
        world.getCell(0, 2).getNumberOfNeighbors() == 3
        world.getCell(1, 0).getNumberOfNeighbors() == 5
        world.getCell(1, 1).getNumberOfNeighbors() == 8
    }
}
