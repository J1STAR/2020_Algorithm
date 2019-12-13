import sys

def solution():
    answer_list = []

    sys.stdin = open("input.txt", encoding='utf-8', mode='r')

    T = int(input())

    for test_case in range(1, T + 1):
        answer = ['#', str(test_case), ' ', '\n']

        speed = 0
        distance = 0

        N = int(input())
        for i in range(N):
            split_line = input().split()
            if len(split_line) == 1:
                command = split_line
            else:
                command, acceleration = map(int, split_line)

            if command == 1:
                speed += acceleration
            elif command == 2:
                speed -= acceleration

            if speed < 0:
                speed = 0

            distance += speed

        answer.insert(3, str(distance))
        answer_list.append(''.join(answer))

    return ''.join(answer_list)


if __name__ == '__main__':
    print(solution())
