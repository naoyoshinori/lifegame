import spock.lang.Specification

/**
 * Created by naoyuki on 2013/12/15.
 */
class NeighborsTest extends Specification {

    def repeatTwoGreetingCells(neighborStatus, targetNumberOfHi) {
        Cell cell = new Cell(Cell.ALIVE)
        Cell neighbor = new Cell(neighborStatus)

        neighbor.addNeighbor(cell)

        2.times {
            cell.refresh()
            neighbor.sayHi()
            cell.tick()
        }

        cell.getNumberOfHi() == targetNumberOfHi
    }

    def "隣のセルの状態と挨拶した回数をテストする"() {
        given:

        expect:
        repeatTwoGreetingCells(Cell.ALIVE, 1)
        repeatTwoGreetingCells(Cell.DEAD, 0)
    }

    def changeMindCells(initialStatus, numberOfLivingNeighbors, targetStatus) {
        Cell cell = new Cell(initialStatus)

        cell.refresh()
        numberOfLivingNeighbors.times {
            def neighbor = new Cell(Cell.ALIVE)
            neighbor.addNeighbor(cell)
            neighbor.sayHi()
        }
        cell.changeMind()
        cell.tick()
        cell.isAlive() == targetStatus
    }

    def "セルの状態と生きているセルの状態をテストする"() {
        given:
        expect:
        changeMindCells(Cell.ALIVE, 1, Cell.DEAD)
        changeMindCells(Cell.ALIVE, 2, Cell.ALIVE)
        changeMindCells(Cell.ALIVE, 3, Cell.ALIVE)
        changeMindCells(Cell.ALIVE, 4, Cell.DEAD)
        changeMindCells(Cell.DEAD, 1, Cell.DEAD)
        changeMindCells(Cell.DEAD, 2, Cell.DEAD)
        changeMindCells(Cell.DEAD, 3, Cell.ALIVE)
        changeMindCells(Cell.DEAD, 4, Cell.DEAD)
    }

}
