package dsa_revision.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GraphCreateAdjList {

  public static void main(String[] args) {
    //take the number of node and then add in LL and then take the edges and get the u v and vice varsa put those
    // Tring the tickets for diwali very hard from mumbai to bhopal now lets hope for the best

    System.out.println("Enter the number of vertex");
    Scanner scanner = new Scanner(System.in);
    int vertex = scanner.nextInt();

    System.out.println("Enter the number of vertex");
    int edges = scanner.nextInt();

    List<List<Integer>> list = new ArrayList<>();

    for (int i = 0; i <= vertex; i++) {
      list.add(new ArrayList<>());
    }

    System.out.println("Please enter the edges between the node");

    for (int i = 1; i <=edges; i++) {
      int u = scanner.nextInt();
      int v = scanner.nextInt();

      if (list.get(u) == null) list.add(u, new ArrayList<>());
      if (list.get(v) == null) list.add(v, new ArrayList<>());

      list.get(u).add(v);
      list.get(v).add(u);
    }

    System.out.println("The Adjacency Looks like this  " + list);
  }
}
