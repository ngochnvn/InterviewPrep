### Binary Search

```
binarySearch(int[] arr, int start, int end, int target) {
  while (start <= end) {
    int mid = (end - start) / 2 + start;
    if (arr[mid] < target) {
      start = mid + 1;
    } else {
      end = mid - 1;
    }
  }
  return arr[start];    
}
```

### Graph

#### DFS 

```
public void dfs(Node start, Set<Node> visited, Graph graph) {
  visited.add(start);
  for (Node neighbor: graph.getNeighbors(start) { 
    if (visited.contains(neighbor)) {
      dfs(neighbor, end, visited, graph);
    }
  }
}
```


#### BFS with level

```
public Node bfs(Node start, Graph graph) {
  Queue<Node> queue = new LinkedList<>();
  queue.add(startNode);
  int level = 0;
  Set<Node> visisted = new HashSet<>();

  while (!queue.isEmpty()) {
      level++;
      Queue<Node> nextLevel = new LinkedList<>();
      Node current = queue.remove();

      for (Node neighbor: graph.getNeighbors(current)) {
          if (!visisted.contains(neighbor)) {
              nextLevel.add(neighbor);
          }         
      }
  }
}

```

### Data structures

#### Priority Queue
* Constructor: initial capacity + comparator
  * use Comparator.ComparingInt(x, y) for int
* add
* poll
* peek