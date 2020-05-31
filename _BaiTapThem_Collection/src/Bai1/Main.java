package Bai1;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

// 1 2 3 4 5                        N = 1
// 2 3 4 5 1 1
// 3 4 5 1 1 2 2                    N = 3
// 4 5 1 1 2 2 3 3
// 5 1 1 2 2 3 3 4 4
// 1 1 2 2 3 3 4 4 5 5              N = 6
// 1 2 2 3 3 4 4 5 5 1 1
// 2 2 3 3 4 4 5 5 1 1 1 1
// 2 3 3 4 4 5 5 1 1 1 1 2 2
// 3 3 4 4 5 5 1 1 1 1 2 2 2 2
// 3 4 4 5 5 1 1 1 1 2 2 2 2 3 3
// 4 4 5 5 1 1 1 1 2 2 2 2 3 3 3 3
// 4 5 5 1 1 1 1 2 2 2 2 3 3 3 3 4 4
// 5 5 1 1 1 1 2 2 2 2 3 3 3 3 4 4 4 4
// 5 1 1 1 1 2 2 2 2 3 3 3 3 4 4 4 4 5 5
// 1 1 1 1 2 2 2 2 3 3 3 3 4 4 4 4 5 5 5 5    N = 16

public class Main {
    public static void main(String[] args) {

        Queue<Integer> numberQueue = new ArrayDeque<>();

        insertNumberToQueue(numberQueue, 5);

        play(numberQueue);
    }

    public static void insertNumberToQueue(Queue<Integer> queue, int amout) {
        for (int i = 1; i <= amout; i++) {
            queue.add(i);
        }
    }

    public static void play(Queue<Integer> queue) {
        // tao mang de add vao queue
        Integer[] intArray = {1, 2, 3, 4, 5};
        Scanner input = new Scanner(System.in);
        System.out.print("\n--> How many times do you want to play? - ");
        int n = input.nextInt();

        if (n == 0) {
            System.out.println("Game over!");
            System.exit(-1);
        } else {
            if (n != 1) {
                // xoa phan tu dau tien
                for (int i = 0; i < n - 1; i++) {
                    Integer firstElement = queue.poll();

                    //them 2 phan tu dau vao phia sau queue
                    for (int j = 0; j < 2; j++) {
                        queue.add(firstElement);
                    }
                }
            }

            System.out.print(
                    "\n => Your number queue: " + queue +
                            "\n => Your first number in your queue: " + queue.element() +
                            "\n\n --> Continue? [y/n]: "
            );

            input.nextLine();

            String choose = input.nextLine();
            if (choose.equalsIgnoreCase("y")) {
                //khoi tao lai queue de continue
                play(new ArrayDeque<>(Arrays.asList(intArray)));

            } else if (choose.equalsIgnoreCase("n")) {
                System.out.println(" - Game over !");
                System.exit(-1);

            } else {
                System.out.println(" - Oh sorry ! Something wrong !");
                System.exit(-1);
            }
        }
    }
}

