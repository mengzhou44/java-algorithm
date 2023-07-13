package BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class ShortestPathBFS {
	private int numVertices;
	private List<List<Integer>> adjList;

	public ShortestPathBFS(int numVertices) {
		this.numVertices = numVertices;
		adjList = new ArrayList<>(numVertices);
		for (int i = 0; i < numVertices; i++) {
			adjList.add(new ArrayList<>());
		}
	}

	public void addEdge(int u, int v) {
		adjList.get(u).add(v);
		adjList.get(v).add(u);
	}

	public List<Integer> shortestPath(int start, int target) {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[numVertices];
		LinkedList<Integer>[] parent = new LinkedList[numVertices];

		queue.offer(start);
		visited[start] = true;
		parent[start] = new LinkedList<>();
		parent[start].addLast(start);

		while (!queue.isEmpty()) {
			int current = queue.poll();

			if (current == target) {
				return parent[current];
			}

			for (int neighbor : adjList.get(current)) {
				if (!visited[neighbor]) {
					queue.offer(neighbor);
					visited[neighbor] = true;
					parent[neighbor] = new LinkedList<>(parent[current]);
					parent[neighbor].addLast(neighbor);
				}
			}
		}

		// No path found
		return new ArrayList<>();
	}

	public static void main(String[] args) {
		int numVertices = 7;
		ShortestPathBFS graph = new ShortestPathBFS(numVertices);

		// Adding edges to the graph
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 3);
		graph.addEdge(1, 4);
		graph.addEdge(2, 5);
		graph.addEdge(2, 6);

		int start = 0;
		int target = 6;
		List<Integer> shortestPath = graph.shortestPath(start, target);

		if (shortestPath.isEmpty()) {
			System.out.println("No path exists from " + start + " to " + target);
		} else {
			System.out.println("Shortest path from " + start + " to " + target + ": " + shortestPath);
		}
	}
}
