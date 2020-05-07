# Sorting Algorithm Performance Evaluator <!-- omit in toc -->
>Sorting algorithm perfomance assessment developer tool

- [Introduction](#introduction)
- [Aim and purpose](#aim-and-purpose)
  - [Research questions](#research-questions)
- [Database](#database)
- [Tasks](#tasks)
- [Test Driven Development](#test-driven-development)
- [Method](#method)
  - [Create the development environment](#create-the-development-environment)
  - [Diagrams](#diagrams)
  - [IntelliJ project](#intellij-project)
  - [Github repository](#github-repository)
  - [GitKraken management](#gitkraken-management)
  - [Peer-Programming](#peer-programming)
  - [Research on the selected algorithms](#research-on-the-selected-algorithms)
  - [Algorithms implementation](#algorithms-implementation)
  - [Database implementation](#database-implementation)
  - [Experiment. Data collection. Analyze](#experiment-data-collection-analyze)
  - [Results](#results)
- [Velocity](#velocity)
  - [First iteration](#first-iteration)
  - [Second iteration](#second-iteration)
  - [Third iteration](#third-iteration)


## Introduction

Sorting, as intended as the operation of alphabetizing, categorizing, arranging or putting items in a pre-defined ordered sequence, is a “key fundamental operation in the field of computer science” (Idrees, 2016) as it adds “usefulness”(Idrees, 2016) to the data. A sorting algorithm takes a number of items, typically an array or a list, and outputs a permutation of that input that is sorted. All sorting algorithms, by intrinsic nature, are problem specific and its choice highly depends on the properties of the manipulated data, the system requirements and against any possible operations that might be performed upon it. Having a clear understanding of the problem’s specifics and details is a fundamental requirement in the decision of the sorting algorithm; however, in some scenarios where the problem’s complexity is high or inherently difficult, the choice of a sorting algorithm, in terms of performance and systems’ required deliverables, might take a nontrivial role. For this reason, in such scenarios, a direct simulation and evaluation of different sorting algorithms, in a testing environment, with the aim of comparing the performance in a simulated scenario, characterized by real world problems’ specifics, might represent the breakthrough towards the resolution of the problem.
Currently available algorithms evaluators lack the most important features that are required by current industry standard and state of the art workflows. The current paper outlines the design and implementation of a sorting algorithm evaluator that provides a user-settable testing environment that allows real-time cloud simulations of the provided data over custom system requirements. Every evaluator is carried out in a node cluster, allowing end system requirements hardware simulation, language specific performance testing and easy horizontal and vertical cluster scaling.

## Aim and purpose

### Research questions

1. What commonly used sorting algorithm performs the best at sorting primitive datatypes?
2. What commonly used sorting algorithm performs the best at sorting non-primitive datatypes?
3. Serial Sort versus Parallel Sort – Which one is better and when?

## Database

For the following project a relational database MySQL v5.7 and the following ER and EER have been designed to fullfil the system requirements

![ER Rev1A](./assets/DB/SAPEvaluatorDB_ER_medium.PNG)
 
![EER Rev1A](./assets/DB/SAPEvaluatorDB_EER_Model_REV1A.PNG)


## Tasks

First draft - _Total 104hrs_.
- [x] ![PRM1 04/30/2020](./assets/labels/prm1-label.png) **`104 HRS`**:bookmark:
  - [x]  Create project's structure and working tools (Setup working environment)
    - [x]  ~~Github Repo Setup~~
    - [x]  ~~Github Readme~~
    - [x]  ~~Github License~~
    - [x]  ~~Github KIB~~
    - [x]  ~~GitkrakenGlo Github KIB Sync~~
    - [x]  ~~GitGlow TaskLink & Sync~~
    - [x]  ~~KIB Tasks & Labels~~
    - [x]  ~~KIB M#1 Milestone setup~~
    - [x]  ~~Timeline Setup w/ milestones~~
    - [x]  ~~Team members invitation to KIB & Working setup~~ 
  
- [x] ![PRM2 05/07/2020](./assets/labels/prm2-label.png) **`104 HRS`**:bookmark:
  - [x] Project setup **`7 HRS`**
    - [x] ~~Project boilerplate~~
    - [x] ~~Dependency management~~
    - [x] ~~JUnit integration~~
    - [x] ~~Maven integration~~
  - [x] Algorithm implementation (Min.1) **`13 HRS`**
    - [x] ~~Quick Sort~~
    - [x] ~~Merge Sort~~
    - [ ] Shell Sort
    - [ ] Heap Sort
  - [x] ~~Unit testing~~ **`23 HRS`**
  - [x] ~~Database Mocks~~ **`15 HRS`**
  - [x] ~~Meeting planning & TO DO definition~~ **`16 HRS`**
  - [x] ~~Preparation for (each) release~~ **`16 HRS`**
  - [x] ~~Run testing and assure working deployable version~~ **`3 HRS`**
  - [x] ~~Code refactoring, Git revisioning, readme and miscs chores~~ **`11 HRS`**

- [x] ![PRM3 14/07/2020](./assets/labels/prm3-label.png) **`104 HRS`**:bookmark:
  - [ ] Database
    - [x] ~~DB Design and ER, EER~~
    - [x] ~~Translation of EER into logical model~~
    - [x] ~~Database creation (hosting::gearhost)~~
    - [ ] Java DB Entity Classes - 1:1 table mapping
    - [ ] Database adapter | Hibernate or MySQL Connector
  - [ ] Algorithm implementation
    - [ ] Quick Sort Median-of-three __comparator__
    - [ ] Shell Sort
    - [ ] Heap Sort
  - [ ] Implement possibility to test both, average and worst case scenarios
  - [ ] Velocity
  - [ ] Meeting planning & TO DO definition **`16 HRS`**
  - [ ] Preparation for (each) release **`16 HRS`**
  - [ ] Run testing and assure working deployable version **`3 HRS`**
  - [ ] Code refactoring, readme and miscs chores **`11 HRS`**

## Test Driven Development

At the beginning of the project the requirements and objectives of the first sprint were analyzed. Entities were built and the relationships between them was established. Based on these data the unit tests were built. Methods were developed and automatic testing was used.

## Method

### Create the development environment 
### Diagrams
### IntelliJ project
### Github repository
### GitKraken management
### Peer-Programming
### Research on the selected algorithms
### Algorithms implementation
### Database implementation
### Experiment. Data collection. Analyze
### Results

## Velocity
The division of the tasks was done in accordance with the estimated working time for a person (26 hours). At the end of each sprint, considering the ideal hours and those necessary to complete the tasks, the velocity was evaluated individually and for the team.
At the end of the project, the velocity is evaluated for the whole project. It is used to estimate the impact of peer-programming on individual and team efficiency.

### First iteration

| Team Member           | Ideal Hours   | Real Time  |    Velocity |
| ----------------------| -------------:|-----------:|------------:|
| Vincenzo Buono        |            26 |         26 |        1.00 |
| Nemanja Negovanovic   |            26 |         25 |        1.04 |
| Alex Oachesu          |            26 |         30 |        0.87 |
| Christopher Schroter  |            26 |         26 |        1.00 |
| **Team**              |       **104** |    **107** | **0.97avg** |

### Second iteration

| Team Member           | Ideal Hours   | Real Time  |    Velocity |
| ----------------------| -------------:|-----------:|------------:|
| Vincenzo Buono        |            26 |         37 |        0.70 |
| Nemanja Negovanovic   |            26 |         26 |        1.00 |
| Alex Oachesu          |            26 |         32 |        0.81 |
| Christopher Schroter  |            26 |         28 |        0.93 |
| **Team**              |       **104** |    **119** | **0.85avg** |

### Third iteration

| Team Member           | Ideal Hours   | Real Time  | Velocity |
| ----------------------| -------------:|-----------:|---------:|
| Vincenzo Buono        |               |            |          |
| Nemanja Negovanovic   |               |            |          |
| Alex Oachesu          |               |            |          |
| Christopher Schroter  |               |            |          |
| Team                  |               |            |          |
