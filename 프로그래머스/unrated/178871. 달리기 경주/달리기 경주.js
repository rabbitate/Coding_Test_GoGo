function solution(players, callings) {
    var answer = [];
    var ranking = {};
    var player = {};
    
    for(let i = 0; i < players.length; i++) {
        player[i] = players[i];
        ranking[players[i]] = i;
    }
    
    for(let i = 0; i < callings.length; i++) {
        const target = callings[i];
        const prev = player[ranking[target]-1];
        
        ranking[target] -= 1;
        ranking[prev] += 1;
        player[ranking[target]] = target;
        player[ranking[prev]] = prev;
    }
    
    for(let i = 0; i < players.length; i++) {
        answer[i] = player[i];
    }
        
    return answer;
}