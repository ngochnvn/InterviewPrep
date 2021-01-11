## To come back later:
Segment Tree: https://leetcode.com/problems/create-sorted-array-through-instructions/solution/

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
### Other

#### Check is Prime 
Runtime is still O(N) but more optimized than checking 1 to N.
High level:
* less than 0 -> return false
* if it's 2 -> return true
* if it's odd -> return false
* else for all odd number i from 3 -> sqrt(n):
  * if n % i == 0 -> return false
* Otherwise return true
```
public boolean isPrime(int n) {
  if (n < 2) {
    return false; //0,1 and negative is not considered prime
  }
  if (n == 2) {
    return true;
  }
  
  if (n % 2 == 0) {
    return false;
  }
  
  for (int n = 3; i <= Math.sqrt(n); i=i+2) {
    if (n % i == 0) {
      return false;
    }
  }
  return false;
}
```

### Data structures

#### Priority Queue
* Constructor: initial capacity + comparator
  * use Comparator.ComparingInt(x, y) for int
* add
* poll
* peek