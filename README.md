# Sort Visualizer

## Description
The project is a spring-boot web server with the purpose of sorting list of numbers and generating the animations that represent
a step change in the algorithm.

## How to build

Go to the root of the project:

* **Compile and run unit tests:** mvn clean install / mvn install

## How to run

Go to the root of the project:

**mvn spring-boot:run**

### End-points

The general url **http://localhost:3000**

The web server has two end-points:

* **/sort/{sortAlgorithm}:** HTTP POST: It sorts the list of numbers passed.
    * Input: An array of numbers in JSON passed as the body of the request
    * Output: The corresponding sorted array in JSON
Example input body:
```bash
[1,4,3,5,6,7]
```
Example output body:
```bash
[1,3,4,5,6,7]
```
* **/sort/{sortAlgorithm}/animations:** HTTP POST: It computes the corresponding animations that an
array of rectangles has to do to visualize each step of the selected algorithm
    * Input: An array of numbers in JSON passed as the body of the request
    * Output: A list JSON objects animations 
    
Example input body:
```bash
[1,4,3,5,6,7]
```
Example output body:
```bash
[
    {
        "firstIndexToCompare": 2,
        "secondIndexToCompare": 3,
        "leftValueToSwap": 6,
        "rightValueToSwap": 3
    },
    {
        "firstIndexToCompare": 3,
        "secondIndexToCompare": 4,
        "leftValueToSwap": 6,
        "rightValueToSwap": 2
    }
]
```


**{sortAlgorithm} =** one of the following:
* QuickSort
* SelectionSort
* BubbleSort
* MergeSort