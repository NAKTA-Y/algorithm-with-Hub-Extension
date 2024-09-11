class Solution {
    fun solution(players: Array<String>, callings: Array<String>): Array<String> {
        var playerMap: MutableMap<String, Int> = HashMap<String, Int>()

        // 플레이어 저장
        for (i in 0 until players.size)
            playerMap.put(players[i], i)

        // callings에 따라 players 스왑
        // playerMap에서 정보 꺼내야함
        for (calling in callings) {
            val index = playerMap.getValue(calling)
            val lead = players[index-1]

            players[index] = lead
            players[index-1] = calling

            playerMap.put(calling, index-1)
            playerMap.put(lead, index)
        }

        // players copy to answer
        return players
    }
}
