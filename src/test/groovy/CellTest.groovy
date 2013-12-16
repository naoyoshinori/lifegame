import spock.lang.Specification

/**
 * Created by naoyuki on 2013/12/15.
 */
class CellTest extends Specification {

    def changeStatusCells(initialStatus, numberOfLivingNeighbors, targetStatus) {
        def cell = new Cell(initialStatus)
        cell.setNumberOfLivingNeighbors(numberOfLivingNeighbors)
        cell.tick()
        cell.isAlive() == targetStatus
    }

    def "生きている隣のセルとセルの状態をテストする"() {
        given:
        expect:
        changeStatusCells(Cell.ALIVE, 1, Cell.DEAD)
        changeStatusCells(Cell.ALIVE, 2, Cell.ALIVE)
        changeStatusCells(Cell.ALIVE, 3, Cell.ALIVE)
        changeStatusCells(Cell.ALIVE, 4, Cell.DEAD)
        changeStatusCells(Cell.DEAD, 1, Cell.DEAD)
        changeStatusCells(Cell.DEAD, 2, Cell.DEAD)
        changeStatusCells(Cell.DEAD, 3, Cell.ALIVE)
        changeStatusCells(Cell.DEAD, 4, Cell.DEAD)
    }
}
