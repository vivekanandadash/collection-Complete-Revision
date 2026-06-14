# 🔷 Set — Complete Revision Guide

> A `Set` is a collection that **does not allow duplicate elements**.  
> Package: `java.util`

---

## 📌 Table of Contents

1. [What is a Set?](#1-what-is-a-set)
2. [Set Implementations](#2-set-implementations)
3. [HashSet](#3-hashset)
4. [LinkedHashSet](#4-linkedhashset)
5. [TreeSet](#5-treeset)
6. [EnumSet](#6-enumset)
7. [CopyOnWriteArraySet](#7-copyonwritearrayset)
8. [Creating a Set](#8-creating-a-set)
9. [Core Methods](#9-core-methods)
10. [Iterating a Set](#10-iterating-a-set)
11. [Set Operations (Union, Intersection, Difference)](#11-set-operations-union-intersection-difference)
12. [Sorting a Set](#12-sorting-a-set)
13. [Converting Set ↔ List ↔ Array](#13-converting-set--list--array)
14. [HashSet Internal Working](#14-hashset-internal-working)
15. [TreeSet — NavigableSet Methods](#15-treeset--navigableset-methods)
16. [Thread Safety](#16-thread-safety)
17. [Time Complexity](#17-time-complexity)
18. [Common Interview Questions](#18-common-interview-questions)

---

## 1. What is a Set?

- **No duplicates** — adding an existing element has no effect.
- **At most one `null`** — depends on the implementation.
- **No index** — elements cannot be accessed by position.
- Extends the `Collection` interface.

```
Set (interface)
 ├── HashSet
 │    └── LinkedHashSet
 ├── TreeSet (also implements SortedSet, NavigableSet)
 ├── EnumSet
 └── CopyOnWriteArraySet (concurrent)
```

---

## 2. Set Implementations

| Class | Order | Null | Thread-Safe | Backed By |
|---|---|---|---|---|
| `HashSet` | ❌ No order | ✅ One null | ❌ | HashMap |
| `LinkedHashSet` | ✅ Insertion order | ✅ One null | ❌ | LinkedHashMap |
| `TreeSet` | ✅ Sorted (natural/comparator) | ❌ No null | ❌ | TreeMap (Red-Black Tree) |
| `EnumSet` | ✅ Enum declaration order | ❌ No null | ❌ | Bit vector |
| `CopyOnWriteArraySet` | ✅ Insertion order | ✅ | ✅ | CopyOnWriteArrayList |

---

## 3. HashSet

The most commonly used Set — backed by a **HashMap**.

```java
import java.util.HashSet;
import java.util.Set;

Set<String> set = new HashSet<>();
set.add("Mango");
set.add("Apple");
set.add("Banana");
set.add("Apple");  // duplicate — ignored

System.out.println(set);        // [Banana, Apple, Mango] (order varies)
System.out.println(set.size()); // 3
```

**Key features:**
- `O(1)` for add, remove, contains (average).
- **No guaranteed order** of elements.
- Allows **one null** element.
- Default capacity: **16**, load factor: **0.75**.

```java
// Custom capacity and load factor
Set<String> set = new HashSet<>(32, 0.5f);
```

---

## 4. LinkedHashSet

Extends `HashSet` and maintains **insertion order**.

```java
import java.util.LinkedHashSet;

Set<String> lhs = new LinkedHashSet<>();
lhs.add("Zebra");
lhs.add("Apple");
lhs.add("Mango");
lhs.add("Apple"); // duplicate — ignored

System.out.println(lhs); // [Zebra, Apple, Mango] — insertion order preserved
```

**Key features:**
- Backed by a **LinkedHashMap**.
- Slightly more memory than `HashSet` (doubly linked list overhead).
- Best when you need uniqueness **and** insertion order.

---

## 5. TreeSet

Stores elements in **sorted (ascending) order** by default.  
Implements `SortedSet` and `NavigableSet`.

```java
import java.util.TreeSet;

TreeSet<Integer> ts = new TreeSet<>();
ts.add(50);
ts.add(10);
ts.add(30);
ts.add(20);

System.out.println(ts); // [10, 20, 30, 50]

// Custom sort — descending
TreeSet<Integer> desc = new TreeSet<>(Comparator.reverseOrder());
desc.addAll(List.of(5, 3, 8, 1));
System.out.println(desc); // [8, 5, 3, 1]
```

**Key features:**
- Backed by a **Red-Black Tree**.
- `O(log n)` for add, remove, contains.
- **Does not allow null** (throws `NullPointerException`).
- Elements must be `Comparable` or a `Comparator` must be provided.

---

## 6. EnumSet

Highly efficient Set **only for enum types**.

```java
import java.util.EnumSet;

enum Day { MON, TUE, WED, THU, FRI, SAT, SUN }

EnumSet<Day> weekdays = EnumSet.of(Day.MON, Day.TUE, Day.WED, Day.THU, Day.FRI);
EnumSet<Day> weekend  = EnumSet.of(Day.SAT, Day.SUN);
EnumSet<Day> allDays  = EnumSet.allOf(Day.class);
EnumSet<Day> noDays   = EnumSet.noneOf(Day.class);

System.out.println(weekdays); // [MON, TUE, WED, THU, FRI]
```

**Key features:**
- Backed by a **bit vector** — extremely fast.
- Maintains enum declaration order.
- **Null not allowed**.
- All elements must belong to the same enum type.

---

## 7. CopyOnWriteArraySet

Thread-safe Set backed by `CopyOnWriteArrayList`.

```java
import java.util.concurrent.CopyOnWriteArraySet;

Set<String> cowSet = new CopyOnWriteArraySet<>();
cowSet.add("A");
cowSet.add("B");

// Safe for concurrent iteration + modification
for (String s : cowSet) {
    cowSet.add("C"); // no ConcurrentModificationException
}
```

**Key features:**
- Thread-safe without explicit synchronization.
- Iteration is on a **snapshot** — writes create a new copy.
- Best for **read-heavy** concurrent scenarios.
- Expensive for frequent writes.

---

## 8. Creating a Set

```java
// Empty mutable
Set<String> s1 = new HashSet<>();

// Immutable (Java 9+)
Set<String> s2 = Set.of("A", "B", "C");

// Mutable copy from immutable
Set<String> s3 = new HashSet<>(Set.of("A", "B", "C"));

// From List (removes duplicates)
List<String> list = List.of("X", "Y", "X", "Z");
Set<String> s4 = new HashSet<>(list);

// From array
String[] arr = {"P", "Q", "R"};
Set<String> s5 = new HashSet<>(Arrays.asList(arr));
```

---

## 9. Core Methods

```java
Set<String> set = new HashSet<>(Set.of("Apple", "Banana", "Cherry"));

// Add
set.add("Date");              // returns true if added, false if duplicate
set.addAll(List.of("Elderberry", "Fig")); // add multiple

// Remove
set.remove("Banana");         // returns true if removed
set.removeAll(Set.of("Cherry", "Date")); // remove multiple
set.retainAll(Set.of("Apple", "Fig"));   // keep only intersection

// Check
boolean has  = set.contains("Apple");   // true
boolean empty = set.isEmpty();
int size      = set.size();

// Clear
set.clear();

// Iterate
set.forEach(System.out::println);
```

---

## 10. Iterating a Set

```java
Set<String> set = new LinkedHashSet<>(Set.of("One", "Two", "Three"));

// 1. enhanced for-each
for (String s : set) {
    System.out.println(s);
}

// 2. Iterator
Iterator<String> it = set.iterator();
while (it.hasNext()) {
    String s = it.next();
    if (s.equals("Two")) it.remove(); // safe removal during iteration
}

// 3. forEach + lambda
set.forEach(s -> System.out.println(s));

// 4. Stream
set.stream()
   .filter(s -> s.length() > 3)
   .forEach(System.out::println);
```

---

## 11. Set Operations (Union, Intersection, Difference)

```java
Set<Integer> a = new HashSet<>(Set.of(1, 2, 3, 4, 5));
Set<Integer> b = new HashSet<>(Set.of(4, 5, 6, 7, 8));

// Union (A ∪ B)
Set<Integer> union = new HashSet<>(a);
union.addAll(b);
System.out.println("Union: " + union); // [1,2,3,4,5,6,7,8]

// Intersection (A ∩ B)
Set<Integer> intersection = new HashSet<>(a);
intersection.retainAll(b);
System.out.println("Intersection: " + intersection); // [4, 5]

// Difference (A - B)
Set<Integer> difference = new HashSet<>(a);
difference.removeAll(b);
System.out.println("Difference: " + difference); // [1, 2, 3]

// Symmetric Difference (A △ B) — in either but not both
Set<Integer> symDiff = new HashSet<>(union);
symDiff.removeAll(intersection);
System.out.println("Symmetric Diff: " + symDiff); // [1,2,3,6,7,8]

// Subset check
boolean isSubset = a.containsAll(Set.of(1, 2)); // true
```

---

## 12. Sorting a Set

```java
// TreeSet — always sorted
Set<String> sorted = new TreeSet<>(Set.of("Banana", "Apple", "Cherry"));
System.out.println(sorted); // [Apple, Banana, Cherry]

// Sort any Set into a List
Set<String> set = new HashSet<>(Set.of("Banana", "Apple", "Cherry"));
List<String> sortedList = new ArrayList<>(set);
Collections.sort(sortedList);

// Stream sorted
set.stream()
   .sorted()
   .forEach(System.out::println);
```

---

## 13. Converting Set ↔ List ↔ Array

```java
Set<String> set = new HashSet<>(Set.of("A", "B", "C"));

// Set → List
List<String> list = new ArrayList<>(set);

// Set → Array
String[] arr = set.toArray(new String[0]);

// List → Set (removes duplicates)
List<String> listWithDups = new ArrayList<>(List.of("X", "Y", "X"));
Set<String> uniqueSet = new HashSet<>(listWithDups);

// Array → Set
String[] arr2 = {"P", "Q", "R", "P"};
Set<String> fromArr = new HashSet<>(Arrays.asList(arr2));
```

---

## 14. HashSet Internal Working

Understanding **how HashSet prevents duplicates**:

1. When `add(element)` is called, `element.hashCode()` is computed.
2. The hash determines the **bucket** (array index).
3. If the bucket is empty → element is placed.
4. If not empty → `equals()` is called on each element in that bucket.
5. If `equals()` returns `true` → **duplicate detected**, element not added.
6. If `equals()` returns `false` → element added to the chain (**collision**).

```java
// Always override BOTH hashCode() and equals() for custom objects
class Student {
    int id;
    String name;

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student s = (Student) o;
        return id == s.id && name.equals(s.name);
    }
}
```

> ⚠️ If you override `equals()` but not `hashCode()`, two logically equal objects may end up in different buckets — breaking the Set contract.

---

## 15. TreeSet — NavigableSet Methods

`TreeSet` implements `NavigableSet`, providing powerful navigation methods:

```java
TreeSet<Integer> ts = new TreeSet<>(List.of(10, 20, 30, 40, 50));

// Boundaries
System.out.println(ts.first());      // 10 (smallest)
System.out.println(ts.last());       // 50 (largest)

// Neighbors
System.out.println(ts.lower(30));    // 20 (strictly less than)
System.out.println(ts.floor(30));    // 30 (less than or equal)
System.out.println(ts.higher(30));   // 40 (strictly greater than)
System.out.println(ts.ceiling(30));  // 30 (greater than or equal)

// Polling (remove + return)
System.out.println(ts.pollFirst());  // 10 (removes smallest)
System.out.println(ts.pollLast());   // 50 (removes largest)

// Views
SortedSet<Integer> head = ts.headSet(35);        // [20, 30] (< 35)
SortedSet<Integer> tail = ts.tailSet(25);        // [30, 40] (>= 25)
SortedSet<Integer> sub  = ts.subSet(20, 40);     // [20, 30] (20 <= x < 40)

// Reverse
NavigableSet<Integer> rev = ts.descendingSet();
```

---

## 16. Thread Safety

```java
// 1. Collections.synchronizedSet
Set<String> syncSet = Collections.synchronizedSet(new HashSet<>());

// Manual sync required during iteration
synchronized (syncSet) {
    for (String s : syncSet) {
        System.out.println(s);
    }
}

// 2. CopyOnWriteArraySet — no manual sync needed
Set<String> cowSet = new CopyOnWriteArraySet<>();

// 3. ConcurrentSkipListSet — concurrent + sorted (like concurrent TreeSet)
Set<Integer> skipSet = new ConcurrentSkipListSet<>();
```

---

## 17. Time Complexity

| Operation | HashSet | LinkedHashSet | TreeSet |
|---|---|---|---|
| `add(e)` | O(1) avg | O(1) avg | O(log n) |
| `remove(e)` | O(1) avg | O(1) avg | O(log n) |
| `contains(e)` | O(1) avg | O(1) avg | O(log n) |
| Iteration | O(n) | O(n) | O(n) |
| First/Last | — | — | O(log n) |

> HashSet can degrade to O(n) in worst case (many hash collisions).

---

## 18. Common Interview Questions

| Question | Short Answer |
|---|---|
| How does `HashSet` check for duplicates? | Uses `hashCode()` for bucket, then `equals()` for comparison |
| Can a `Set` contain `null`? | `HashSet`/`LinkedHashSet` — yes (one null). `TreeSet`/`EnumSet` — no |
| Difference between `HashSet` and `TreeSet`? | HashSet is unordered O(1); TreeSet is sorted O(log n) |
| What if `hashCode()` not overridden? | Two equal objects may go to different buckets — set stores duplicates |
| `LinkedHashSet` vs `HashSet`? | Same performance; LinkedHashSet maintains insertion order |
| How to remove duplicates from a List? | `new LinkedHashSet<>(list)` (preserves order) |
| What is `SortedSet`? | Sub-interface of Set that guarantees sorted order (`TreeSet`) |
| What is `NavigableSet`? | Extends `SortedSet` with navigation methods (lower, floor, ceiling, higher) |
| When to use `EnumSet`? | When all elements are from the same enum — fastest Set implementation |

---

> 📁 This file is part of the **collection-Complete-Revision** project.  
> See also: [List README](../list/README.md)
