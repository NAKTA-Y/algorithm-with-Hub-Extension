class Solution {
    fun solution(park: Array<String>, routes: Array<String>): IntArray {
        var x = 0
        var y = 0
        val height = park.size
        val width = park[0].length

        // find start point
        outerLoop@
        for (i in 0 until  height) {
            for (j in 0 until width) {
                if (park[i][j] == 'S') {
                    x = i;
                    y = j;
                    break@outerLoop
                }
            }
        }

        // 명령어 loop
        for (route in routes) {
            // 방향과 횟수 나누기
            val split = route.split(" ")
            val command = split[0]
            val count = split[1].toInt()

            // 이동
            val backupX = x
            val backupY = y
            if (command == "E") {
                for (moveY in y + 1..y + count) {
                    if (moveY >= width || park[x][moveY] == 'X') {
                        y = backupY
                        break
                    }
                    y = moveY
                }
            } else if (command == "W") {
                for (moveY in y - 1 downTo y - count) {
                    if (moveY < 0 || park[x][moveY] == 'X') {
                        y = backupY
                        break
                    }
                    y = moveY
                }
            } else if (command == "N") {
                for (moveX in x - 1 downTo x - count) {
                    if (moveX < 0 || park[moveX][y] == 'X') {
                        x = backupX
                        break
                    }
                    x = moveX
                }
            } else {
                for (moveX in x + 1..x + count) {
                    if (moveX >= height || park[moveX][y] == 'X') {
                        x = backupX
                        break
                    }
                    x = moveX
                }
            }
        }

        return intArrayOf(x, y)
    }
}