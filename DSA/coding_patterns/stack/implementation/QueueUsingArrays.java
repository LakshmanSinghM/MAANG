// 
// NO need in reallife using this approach/method so i am skipping

// package coding_patterns.stack.implementation;

// class Queue {
//     int start = -1;
//     int end = -1;
//     int size;
//     int currentSize;
//     int queue[];

//     Queue(int size) {
//         this.queue = new int[size];
//     }

//     void push(int n) {
//         if (currentSize == 0) {
//             start++;
//             end++;
//             queue[start] = n;
//         } else {
//             end = (end + 1) % size;
//             queue[end] = n;
//             end++;
//             currentSize++;
//         }
//     }

//     void printQueue() {
//         for (int i = start; i <= currentSize; i++)
//             System.out.print(queue[i] + " ");

//         System.out.println();
//     }
// }

// public class QueueUsingArrays {

//     public static void main(String[] args) {
//         Queue queue = new Queue(5);
//         queue.push(2);
//         queue.push(4);
//         queue.push(3);
//         queue.printQueue();
//     }
// }