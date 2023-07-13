package DFS;

import java.util.*;

record Position(int x, int y) {
	@Override
	public boolean equals(Object obj) {
		if (obj == null) return false;
		if (!(obj instanceof Position)) return false;
		if (obj == this) return true;
		return this.x == ((Position) obj).x && this.y == ((Position) obj).y;
	}
}

 public class Maze {

	 private static final int[][] maze =  {
			 {0, 0, 1, 0 , 0},
			 {1, 0, 1, 0, 0 },
			 {0, 0, 0, 1, 0 },
			 {0, 1, 0, 1, 1 },
			 {0, 0, 0, 0, 0 }

	 };
	public static void main(String[] args) {
		   List<Position> path= findPath();
		   path.forEach(p -> System.out.println(p.x()+ " " + p.y()));
	  }

	  private static List<Position> findPath() {
		   List<Position> path = new ArrayList<>();
		   if (dfs(new Position(0, 0), path)) {
		    			   return path;
		   }
		   return new ArrayList<>();
	  }

	 private static boolean dfs(Position pos, List<Position> path) {
		 if (isOutBound(pos) || isWall(pos) || path.contains(pos)) {
			 return false;
		 }
		 path.add(pos);
		 if (pos.x() == 4 && pos.y() == 4 && !isWall(pos)) {
			 return true;
		 }

		 for (Position neighbour : getNeighbours(pos)) {
			 if (dfs(neighbour, path)) {
				 return true;
			 }
		 }
		 path.remove(path.size() - 1);
		 return false;
	 }

	  private static boolean isOutBound(Position pos) {
		  int x = pos.x();
		  int y = pos.y();
		  if (x<0 || x>4 || y<0 || y>4) return true;
		  return false;
	  }

	 private static boolean isWall(Position pos) {
		 int x = pos.x();
		 int y = pos.y();

		 return maze[x][y] == 1;
	 }

	 private static List<Position> getNeighbours(Position pos) {
		 List<Position> neighbours = new ArrayList<>();
		 neighbours.add(new Position(pos.x() - 1, pos.y()));
		 neighbours.add(new Position(pos.x() + 1, pos.y()));
		 neighbours.add(new Position(pos.x(), pos.y() - 1));
		 neighbours.add(new Position(pos.x(), pos.y() + 1));
		 return neighbours;
	 }
 }