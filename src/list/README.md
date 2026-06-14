# 📋 List — Complete Revision Guide

> A `List` is an **ordered, index-based collection** that allows **duplicate elements**.  
> Package: `java.util`

---

## 📌 Table of Contents

1. [What is a List?](#1-what-is-a-list)
2. [List Implementations](#2-list-implementations)
3. [ArrayList](#3-arraylist)
4. [LinkedList](#4-linkedlist)
5. [Vector](#5-vector)
6. [Stack](#6-stack)
7. [Creating a List](#7-creating-a-list)
8. [Core Methods](#8-core-methods)
9. [Iterating a List](#9-iterating-a-list)
10. [Sorting a List](#10-sorting-a-list)
11. [Searching in a List](#11-searching-in-a-list)
12. [Sublist & Slicing](#12-sublist--slicing)
13. [Converting List ↔ Array](#13-converting-list--array)
14. [List vs Array](#14-list-vs-array)
15. [ArrayList vs LinkedList](#15-arraylist-vs-linkedlist)
16. [Thread Safety](#16-thread-safety)
17. [Time Complexity](#17-time-complexity)
18. [Common Interview Questions](#18-common-interview-questions)

---

## 1. What is a List?

- **Ordered** — elements maintain insertion order.
- **Index-based** — elements are accessed by index (0, 1, 2, …).
- **Allows duplicates** — same value can appear multiple times.
- **Allows `null`** — most implementations permit null values.

```
List (interface)
 ├── ArrayList
 ├── LinkedList
 ├── Vector
 │    └── Stack
 └── CopyOnWriteArrayList (concurrent)
```

---

## 2. List Implementations

| Class | Backed By | Thread-Safe | Allows Null | Order |
|---|---|---|---|---|
| `ArrayList` | Dynamic Array | ❌ | ✅ | Insertion |
| `LinkedList` | Doubly Linked List | ❌ | ✅ | Insertion |
| `Vector` | Dynamic Array | ✅ | ✅ | Insertion |
| `Stack` | Vector | ✅ | ✅ | LIFO |
| `CopyOnWriteArrayList` | Array (copy-on-write) | ✅ | ✅ | Insertion |

---

## 3. ArrayList

The most widely used List implementation.

```java
import java.util.ArrayList;
import java.util.List;

List<String> list = new ArrayList<>();
list.add("Apple");
list.add("Banana");
list.add("Cherry");

System.out.println(list.get(0)); // Apple
System.out.println(list.size()); // 3
```

**Key features:**
- Backed by a **resizable array** (default capacity: 10).
- `O(1)` random access by index.
- `O(n)` insertion/deletion in the middle.
- **Not thread-safe**.
- Grows by **50%** when capacity is exceeded.

```java
// Initial capacity
List<Integer> list = new ArrayList<>(50);
```

---

## 4. LinkedList

Backed by a **doubly linked list**; also implements `Deque`.

```java
import java.util.LinkedList;

LinkedList<String> ll = new LinkedList<>();
ll.add("A");
ll.addFirst("Z");   // insert at head
ll.addLast("M");    // insert at tail

System.out.println(ll.getFirst()); // Z
System.out.println(ll.getLast());  // M
ll.removeFirst();
ll.removeLast();
```

**Key features:**
- `O(1)` insertion/deletion at head and tail.
- `O(n)` random access by index.
- More memory overhead (stores prev/next pointers).
- Best for frequent add/remove at ends.

---

## 5. Vector

Legacy synchronized list (prefer `ArrayList` + explicit sync or `CopyOnWriteArrayList` in modern code).

```java
import java.util.Vector;

Vector<Integer> v = new Vector<>();
v.add(10);
v.add(20);
v.add(30);
System.out.println(v.get(1)); // 20
```

**Key features:**
- Synchronized (thread-safe) — but slower.
- Grows by **100%** (doubles) when capacity exceeded.
- Mostly legacy — avoid in new code.

---

## 6. Stack

Extends `Vector`. Follows **LIFO** (Last In, First Out).

```java
import java.util.Stack;

Stack<Integer> stack = new Stack<>();
stack.push(1);
stack.push(2);
stack.push(3);

System.out.println(stack.peek()); // 3 (top, no remove)
System.out.println(stack.pop());  // 3 (remove top)
System.out.println(stack.isEmpty()); // false
```

> 💡 Prefer `Deque` (`ArrayDeque`) over `Stack` in modern code for better performance.

---

## 7. Creating a List

```java
// Empty list
List<String> l1 = new ArrayList<>();

// With initial elements (fixed-size, immutable)
List<String> l2 = List.of("A", "B", "C");

// Mutable with initial elements
List<String> l3 = new ArrayList<>(List.of("A", "B", "C"));

// From array
String[] arr = {"X", "Y", "Z"};
List<String> l4 = new ArrayList<>(Arrays.asList(arr));

// Fixed-size mutable list from array
List<String> l5 = Arrays.asList("P", "Q", "R");
```

---

## 8. Core Methods

```java
List<String> list = new ArrayList<>(List.of("Apple", "Banana", "Cherry"));

// Add
list.add("Date");              // add at end
list.add(1, "Avocado");       // add at index

// Get
String s = list.get(0);       // "Apple"

// Update
list.set(0, "Apricot");       // replace at index 0

// Remove
list.remove("Banana");        // remove by value
list.remove(2);               // remove by index

// Check
boolean has = list.contains("Cherry");  // true
int idx = list.indexOf("Cherry");       // first occurrence
int lidx = list.lastIndexOf("Cherry");  // last occurrence
boolean empty = list.isEmpty();

// Size
int size = list.size();

// Clear
list.clear();

// Add all
list.addAll(List.of("X", "Y", "Z"));
list.addAll(1, List.of("A", "B")); // insert all at index

// Retain / Remove all
list.retainAll(List.of("X", "Y")); // keep only these
list.removeAll(List.of("X"));      // remove these
```

---

## 9. Iterating a List

```java
List<String> list = List.of("One", "Two", "Three");

// 1. for loop
for (int i = 0; i < list.size(); i++) {
    System.out.println(list.get(i));
}

// 2. enhanced for-each
for (String item : list) {
    System.out.println(item);
}

// 3. Iterator
Iterator<String> it = list.iterator();
while (it.hasNext()) {
    System.out.println(it.next());
}

// 4. ListIterator (bidirectional)
ListIterator<String> lit = list.listIterator(list.size());
while (lit.hasPrevious()) {
    System.out.println(lit.previous()); // reverse order
}

// 5. forEach + lambda
list.forEach(item -> System.out.println(item));

// 6. Stream
list.stream().forEach(System.out::println);
```

---

## 10. Sorting a List

```java
List<Integer> nums = new ArrayList<>(List.of(5, 3, 8, 1, 4));

// Natural order
Collections.sort(nums);
// or
nums.sort(Comparator.naturalOrder());

// Reverse order
nums.sort(Comparator.reverseOrder());

// Custom comparator (by string length)
List<String> words = new ArrayList<>(List.of("Banana", "Apple", "Kiwi"));
words.sort(Comparator.comparingInt(String::length));

// Multiple comparators
words.sort(Comparator.comparingInt(String::length)
                     .thenComparing(Comparator.naturalOrder()));
```

---

## 11. Searching in a List

```java
List<String> list = new ArrayList<>(List.of("Apple", "Banana", "Cherry"));

// Linear search
int idx = list.indexOf("Banana");       // 1
int last = list.lastIndexOf("Banana");  // 1

// Binary search (list must be sorted)
Collections.sort(list);
int pos = Collections.binarySearch(list, "Cherry"); // index

// Stream search
Optional<String> found = list.stream()
    .filter(s -> s.startsWith("B"))
    .findFirst();
found.ifPresent(System.out::println); // Banana
```

---

## 12. Sublist & Slicing

```java
List<Integer> list = new ArrayList<>(List.of(0, 1, 2, 3, 4, 5));

// subList(fromIndex inclusive, toIndex exclusive)
List<Integer> sub = list.subList(1, 4); // [1, 2, 3]

// Note: subList is a VIEW — changes reflect in original
sub.clear();                             // removes indices 1-3 from original
System.out.println(list);               // [0, 4, 5]
```

---

## 13. Converting List ↔ Array

```java
// List → Array
List<String> list = new ArrayList<>(List.of("A", "B", "C"));
String[] arr = list.toArray(new String[0]);

// Array → List (fixed-size)
String[] arr2 = {"X", "Y", "Z"};
List<String> fixed = Arrays.asList(arr2);   // fixed size!

// Array → Mutable List
List<String> mutable = new ArrayList<>(Arrays.asList(arr2));

// Stream → List
List<String> fromStream = Stream.of("P", "Q").collect(Collectors.toList());
```

---

## 14. List vs Array

| Feature | Array | List |
|---|---|---|
| Size | Fixed | Dynamic |
| Type | Primitive + Object | Object only |
| Methods | Limited | Rich API |
| Performance | Faster | Slightly overhead |
| Null | Allowed | Allowed |

---

## 15. ArrayList vs LinkedList

| Operation | ArrayList | LinkedList |
|---|---|---|
| `get(i)` | `O(1)` ✅ | `O(n)` ❌ |
| `add(end)` | `O(1)` amortized | `O(1)` |
| `add(middle)` | `O(n)` | `O(n)` |
| `remove(middle)` | `O(n)` | `O(n)` |
| `add/remove first` | `O(n)` ❌ | `O(1)` ✅ |
| Memory | Less | More (pointers) |

**Rule of thumb:**
- Use **`ArrayList`** for frequent reads.
- Use **`LinkedList`** for frequent insertions/deletions at ends.

---

## 16. Thread Safety

```java
// 1. Collections.synchronizedList
List<String> syncList = Collections.synchronizedList(new ArrayList<>());

// 2. CopyOnWriteArrayList (best for read-heavy scenarios)
List<String> cowList = new CopyOnWriteArrayList<>();
cowList.add("A");
cowList.add("B");

// Safe to iterate while another thread modifies
for (String s : cowList) {
    System.out.println(s);
}
```

---

## 17. Time Complexity

| Operation | ArrayList | LinkedList |
|---|---|---|
| Access `get(i)` | O(1) | O(n) |
| Search | O(n) | O(n) |
| Insert (end) | O(1)* | O(1) |
| Insert (middle) | O(n) | O(n) |
| Delete (end) | O(1) | O(1) |
| Delete (middle) | O(n) | O(n) |

*Amortized O(1); O(n) on resize.

---

## 18. Common Interview Questions

| Question | Short Answer |
|---|---|
| Difference between `ArrayList` and `LinkedList`? | Array-backed vs node-based; random access vs efficient end operations |
| Can List store primitives? | No — use wrapper types (`Integer`, `Double`, etc.) |
| What is `ConcurrentModificationException`? | Thrown when list is modified while iterating with Iterator |
| How to make a list immutable? | `List.of(...)` or `Collections.unmodifiableList(list)` |
| What is `fail-fast` iterator? | Iterator that throws CME when collection is structurally modified |
| Difference `remove(int)` vs `remove(Object)`? | Index-based vs value-based removal |
| How to remove duplicates from a List? | Convert to `LinkedHashSet`, then back to `List` |
| What is a `subList` and its pitfall? | A live view of original — changes to sub affect original |

---

> 📁 This file is part of the **collection-Complete-Revision** project.  
> See also: [Set README](../set/README.md)
