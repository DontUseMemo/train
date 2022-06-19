function solution(arr1,arr2) {
    let answer = [];
    let arr_blank = [];
    for(let i=0; i<arr1.length; i++) {
        for(let j=0; j<arr2.length; j++) {
            arr_blank.push(arr1[i][j]+arr2[i][j]);
        }
        answer.push(arr_blank);
        arr_blank = [];
    }
    return answer
}