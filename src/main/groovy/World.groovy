import groovy.util.logging.Slf4j

/**
 * Created by naoyuki on 2013/12/15.
 */
@Slf4j
class World {

    static ALLOCATED = true
    static UNALLOCATED = false

    def width = 0
    def height = 0
    def area = [][]
    def allocatedArea = UNALLOCATED

    def World(width, height) {
        this.width = width
        this.height = height
    }

    def newArea() {
        allocatedArea = (width > 0 && height > 0)

        if (!allocatedArea) return

        area = [height]
        (0..height).each { y ->
            area[y] = [width]
            (0..width).each { x ->
                area[y][x] = new Cell(Cell.ALIVE)
            }
        }
    }

    def initializeArea() {
        checkAllocatedArea()

        (0..height-1).each { y ->
            (0..width-1).each { x ->
                initializeCell(y, x)
            }
        }
    }

    def initializeCell(_y, _x) {
        checkAreaOfRange(_y, _x)

        Cell cell = area[_y][_x]
        (-1..1).each { yi ->
            (-1..1).each { xi ->
                def y = _y + yi
                def x = _x + xi
                if (y >= 0 && y < height && x >= 0 && x < width && !(yi == 0 && xi == 0)) {
                    Cell neighbor = area[y][x]
                    cell.addNeighbor(neighbor)
                }
            }
        }
    }

    def hasAllocatedArea() {
        allocatedArea
    }

    def Cell getCell(y, x) {
        checkAreaOfRange(y, x)

        area[y][x]
    }

    private checkAllocatedArea() {
        if (!allocatedArea) throw new UnallocatedAreaException()
    }

    private checkAreaOfRange(y, x) {
        checkAllocatedArea()
        if (y < 0 || y >= height || x < 0 || x >= width) throw new AreaOutOfRangeException()
    }
}
