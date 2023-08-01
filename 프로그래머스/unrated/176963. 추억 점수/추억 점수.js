function solution(name, yearning, photo) {
    var nameYearning = {};
    var answer = [];
    var memoryScore = 0;
    
    name.forEach((e, index) => nameYearning[e] = yearning[index]);
    photo.forEach((e, index) => {
        e.forEach(e => {
            if(nameYearning[e] === undefined) {
                memoryScore += 0;
            } else {
                memoryScore += nameYearning[e];
            }
        });
        answer[index] = memoryScore;
        memoryScore = 0;
    });
    
    return answer;
}