const readline = require('readline');
const fs = require('fs');

const rl = readline.createInterface({
    input: fs.createReadStream('input.txt'),
    output: process.stdout
});

let input = [];
rl.on('line', function (line) {
    input.push(line)
})
    .on('close', function () {
        solution(input);
        process.exit();
    });

function solution(input) {
    let answer = [];

    iter = input[Symbol.iterator]();

    let T = iter.next().value;

    for (let test_case = 1; test_case <= T; test_case++) {
        let speed = 0;
        let distance = 0;

        let N = iter.next().value;

        for (let i = 0; i < N; i++) {
            let line = iter.next().value.split(' ');
            let command = parseInt(line[0]);
            let acceleration = parseInt(line[1]);

            if (command === 1) speed += acceleration;
            else if (command === 2) speed -= acceleration;

            if (speed < 0) speed = 0;

            distance += speed
        }

        answer.push(['#', test_case, ' ', distance, '\n'].join(''))
    }

    console.log(answer.join(''))
}

