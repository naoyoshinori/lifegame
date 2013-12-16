/**
 * Created by naoyuki on 2013/12/15.
 */
class Cell {

    static ALIVE = true
    static DEAD = false

    def status = ALIVE
    def numberOfLivingNeighbors = 0
    def neighbors = []
    def numberOfHi = 0

    static aliveCell() {
        new Cell(ALIVE)
    }

    static deadCell() {
        new Cell(DEAD)
    }

    def Cell(initialStatus) {
        status = initialStatus
    }

    def setNumberOfLivingNeighbors(numberOfLivingNeighbors) {
        this.numberOfLivingNeighbors = numberOfLivingNeighbors
    }

    def getNumberOfHi() {
        this.numberOfHi
    }

    def tick() {
        status = ( (status && numberOfLivingNeighbors == 2) || numberOfLivingNeighbors == 3 )
    }

    def isAlive() {
        status
    }

    def sayHi() {
        if (status) {
            neighbors.each { neighbor ->
                neighbor.hi()
            }
        }
    }

    def hi() {
        numberOfHi++
    }

    def addNeighbor(neighbor) {
        this.neighbors << neighbor
    }

    def refresh() {
        this.numberOfHi = 0
    }

    def changeMind() {
        setNumberOfLivingNeighbors(numberOfHi)
    }

    def getNumberOfNeighbors() {
        this.neighbors.size()
    }

}
