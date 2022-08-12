const getLongestAscendingSequence = (data) => {
    let longest = 1
    let longestArr = []
    for (let i = 0; i + 1 < data.length; i++) {
        if (data[i] <= data[i + 1]) {
            longest++;
        } else {
            longestArr.push(longest)
            longest = 1;
        }
    }
    longest = Math.max(...longestArr);
    let sequence = []
    for (let i = 0; i + 1 < data.length; i++) {
        if (data[i] <= data[i + 1] ) {
            sequence.push(data[i])
            sequence.push(data[i + 1])
        }
        else if (data[i] <= data[i + 1] && i + 1 === data.length - 1) {
           
        } else {
            sequence = []
        }

        if(sequence.length === longest){
            return sequence
        }
        console.log(sequence)
    }
    return sequence
}

console.log(getLongestAscendingSequence([70, 70, 20, 10, 80, 20]))