function smallestEvenDigit(n) {
    n = (n < 0) ? -1 * n : n;
    let s = n.toString()
    return smallestDigitRecur(s, s.length() - 1, 8);
}
const  smallestEvenDigitRecur = (s,index,smallest) => {
    let value = s[index].charCodeAt(0);  
    if(index == 0){
        if(value % 2 == 0){
            return (smallest < value) ? smallest : value;
        }
        return smallest;
    }
    if(value < smallest && value % 2 == 0){
        smallest = value;
    }
    return smallestEvenDigitRecur(s, index - 1, smallest);
}

console.log(smallestEvenDigit(2346))