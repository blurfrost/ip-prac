# UI Test Plan

This file contains test cases for the Baby application. Each test case specifies the aim, inputs, and expected output.

## Test Case 1

aim: Test adding a single todo task and listing it
inputs:
- todo read book
- list
expected_output:
____________________________________________________________
 ____    _    ____ __   __
| __ )  / \  | __ )\ \ / /
|  _ \ / _ \ |  _ \ \ V /
| |_) / ___ \| |_) | | |
|____/_/   \_\____/  |_|

Hello! I'm Baby.
What can I do for you?
____________________________________________________________
____________________________________________________________
Got it. I've added this task:
  [T][ ] read book
Now you have 1 tasks in the list.
____________________________________________________________
____________________________________________________________
 1. [T][ ] read book
____________________________________________________________

## Test Case 2

aim: Test marking a task as done
inputs:
- todo read book
- todo return book
- todo buy bread
- list
- mark 2
- list
expected_output:
____________________________________________________________
 ____    _    ____ __   __
| __ )  / \  | __ )\ \ / /
|  _ \ / _ \ |  _ \ \ V /
| |_) / ___ \| |_) | | |
|____/_/   \_\____/  |_|

Hello! I'm Baby.
What can I do for you?
____________________________________________________________
____________________________________________________________
Got it. I've added this task:
  [T][ ] read book
Now you have 1 tasks in the list.
____________________________________________________________
____________________________________________________________
Got it. I've added this task:
  [T][ ] return book
Now you have 2 tasks in the list.
____________________________________________________________
____________________________________________________________
Got it. I've added this task:
  [T][ ] buy bread
Now you have 3 tasks in the list.
____________________________________________________________
____________________________________________________________
 1. [T][ ] read book
 2. [T][ ] return book
 3. [T][ ] buy bread
____________________________________________________________
____________________________________________________________
Nice! I've marked this task as done:
  [T][X] return book
____________________________________________________________
____________________________________________________________
 1. [T][ ] read book
 2. [T][X] return book
 3. [T][ ] buy bread
____________________________________________________________

## Test Case 3

aim: Test unmarking a task
inputs:
- todo read book
- todo return book
- list
- mark 1
- unmark 1
- list
expected_output:
____________________________________________________________
 ____    _    ____ __   __
| __ )  / \  | __ )\ \ / /
|  _ \ / _ \ |  _ \ \ V /
| |_) / ___ \| |_) | | |
|____/_/   \_\____/  |_|

Hello! I'm Baby.
What can I do for you?
____________________________________________________________
____________________________________________________________
Got it. I've added this task:
  [T][ ] read book
Now you have 1 tasks in the list.
____________________________________________________________
____________________________________________________________
Got it. I've added this task:
  [T][ ] return book
Now you have 2 tasks in the list.
____________________________________________________________
____________________________________________________________
 1. [T][ ] read book
 2. [T][ ] return book
____________________________________________________________
____________________________________________________________
Nice! I've marked this task as done:
  [T][X] read book
____________________________________________________________
____________________________________________________________
OK, I've marked this task as not done yet:
  [T][ ] read book
____________________________________________________________
____________________________________________________________
 1. [T][ ] read book
 2. [T][ ] return book
____________________________________________________________

## Test Case 4

aim: Test invalid input handling
inputs:
- read book
- todo borrow book
- list
expected_output:
____________________________________________________________
 ____    _    ____ __   __
| __ )  / \  | __ )\ \ / /
|  _ \ / _ \ |  _ \ \ V /
| |_) / ___ \| |_) | | |
|____/_/   \_\____/  |_|

Hello! I'm Baby.
What can I do for you?
____________________________________________________________
____________________________________________________________
Invalid command: 'read book'. Valid commands: todo, deadline, event, list, mark, unmark, bye
____________________________________________________________
____________________________________________________________
Got it. I've added this task:
  [T][ ] borrow book
Now you have 1 tasks in the list.
____________________________________________________________
____________________________________________________________
 1. [T][ ] borrow book
____________________________________________________________

## Test Case 5

aim: Test deadline and event commands
inputs:
- todo read book
- deadline return book /by Sunday
- event project meeting /from Mon 2pm /to 4pm
- list
expected_output:
____________________________________________________________
 ____    _    ____ __   __
| __ )  / \  | __ )\ \ / /
|  _ \ / _ \ |  _ \ \ V /
| |_) / ___ \| |_) | | |
|____/_/   \_\____/  |_|

Hello! I'm Baby.
What can I do for you?
____________________________________________________________
____________________________________________________________
Got it. I've added this task:
  [T][ ] read book
Now you have 1 tasks in the list.
____________________________________________________________
____________________________________________________________
Got it. I've added this task:
  [D][ ] return book (by: 23 aug 2026 0000)
Now you have 2 tasks in the list.
____________________________________________________________
____________________________________________________________
Got it. I've added this task:
  [E][ ] project meeting (from: 24 aug 2026 0000 to: 4pm)
Now you have 3 tasks in the list.
____________________________________________________________
____________________________________________________________
 1. [T][ ] read book
 2. [D][ ] return book (by: 23 aug 2026 0000)
 3. [E][ ] project meeting (from: 24 aug 2026 0000 to: 4pm)
____________________________________________________________

## Test Case 6

aim: Test mark/unmark with deadline and event
inputs:
- todo read book
- deadline return book /by Sunday
- event project meeting /from Mon 2pm /to 4pm
- mark 2
- mark 3
- list
- unmark 2
- unmark 3
- list
expected_output:
____________________________________________________________
 ____    _    ____ __   __
| __ )  / \  | __ )\ \ / /
|  _ \ / _ \ |  _ \ \ V /
| |_) / ___ \| |_) | | |
|____/_/   \_\____/  |_|

Hello! I'm Baby.
What can I do for you?
____________________________________________________________
____________________________________________________________
Got it. I've added this task:
  [T][ ] read book
Now you have 1 tasks in the list.
____________________________________________________________
____________________________________________________________
Got it. I've added this task:
  [D][ ] return book (by: 23 aug 2026 0000)
Now you have 2 tasks in the list.
____________________________________________________________
____________________________________________________________
Got it. I've added this task:
  [E][ ] project meeting (from: 24 aug 2026 0000 to: 4pm)
Now you have 3 tasks in the list.
____________________________________________________________
____________________________________________________________
Nice! I've marked this task as done:
  [D][X] return book (by: 23 aug 2026 0000)
____________________________________________________________
____________________________________________________________
Nice! I've marked this task as done:
  [E][X] project meeting (from: 24 aug 2026 0000 to: 4pm)
____________________________________________________________
____________________________________________________________
 1. [T][ ] read book
 2. [D][X] return book (by: 23 aug 2026 0000)
 3. [E][X] project meeting (from: 24 aug 2026 0000 to: 4pm)
____________________________________________________________
____________________________________________________________
OK, I've marked this task as not done yet:
  [D][ ] return book (by: 23 aug 2026 0000)
____________________________________________________________
____________________________________________________________
OK, I've marked this task as not done yet:
  [E][ ] project meeting (from: 24 aug 2026 0000 to: 4pm)
____________________________________________________________
____________________________________________________________
 1. [T][ ] read book
 2. [D][ ] return book (by: 23 aug 2026 0000)
 3. [E][ ] project meeting (from: 24 aug 2026 0000 to: 4pm)
____________________________________________________________

## Test Case 7

aim: Test mark/unmark with todo task
inputs:
- todo read book
- mark 1
- list
- unmark 1
- list
expected_output:
____________________________________________________________
 ____    _    ____ __   __
| __ )  / \  | __ )\ \ / /
|  _ \ / _ \ |  _ \ \ V /
| |_) / ___ \| |_) | | |
|____/_/   \_\____/  |_|

Hello! I'm Baby.
What can I do for you?
____________________________________________________________
____________________________________________________________
Got it. I've added this task:
  [T][ ] read book
Now you have 1 tasks in the list.
____________________________________________________________
____________________________________________________________
Nice! I've marked this task as done:
  [T][X] read book
____________________________________________________________
____________________________________________________________
 1. [T][X] read book
____________________________________________________________
____________________________________________________________
OK, I've marked this task as not done yet:
  [T][ ] read book
____________________________________________________________
____________________________________________________________
 1. [T][ ] read book
____________________________________________________________

## Test Case 8

aim: Test todo, deadline, event without arguments showing usage
inputs:
- todo
- deadline
- event
- list
expected_output:
____________________________________________________________
 ____    _    ____ __   __
| __ )  / \  | __ )\ \ / /
|  _ \ / _ \ |  _ \ \ V /
| |_) / ___ \| |_) | | |
|____/_/   \_\____/  |_|

Hello! I'm Baby.
What can I do for you?
____________________________________________________________
____________________________________________________________
A todo should include a description of the task. Example usage: todo <description>
____________________________________________________________
____________________________________________________________
A deadline should include a description and a due date. Example usage: deadline <description> /by <date> (supports: dd MMM yyyy[ hhmm], dd/MM/yyyy[ hhmm], dd-MM-yyyy[ hhmm])
____________________________________________________________
____________________________________________________________
An event should include a description, a start date and end date. Example usage: event <description> /from <date> /to <date> (supports: dd MMM yyyy[ hhmm], dd/MM/yyyy[ hhmm], dd-MM-yyyy[ hhmm])
____________________________________________________________
____________________________________________________________
____________________________________________________________

## Test Case 9

aim: Test whitespace normalization in commands
inputs:
-    list    
- todo        fun stuff
- deadline    homework /by     Thurs
- event    pitch /from tmr    /to 21 aug 2026 0000
- mark       3   
- unmark 3   
- list
- todo
- deadline
- event
- list
expected_output:
____________________________________________________________
 ____    _    ____ __   __
| __ )  / \  | __ )\ \ / /
|  _ \ / _ \ |  _ \ \ V /
| |_) / ___ \| |_) | | |
|____/_/   \_\____/  |_|

Hello! I'm Baby.
What can I do for you?
____________________________________________________________
____________________________________________________________
____________________________________________________________
____________________________________________________________
Got it. I've added this task:
  [T][ ] fun stuff
Now you have 1 tasks in the list.
____________________________________________________________
____________________________________________________________
Got it. I've added this task:
  [D][ ] homework (by: Thurs)
Now you have 2 tasks in the list.
____________________________________________________________
____________________________________________________________
Got it. I've added this task:
  [E][ ] pitch (from: tmr to: 21 aug 2026 0000)
Now you have 3 tasks in the list.
____________________________________________________________
____________________________________________________________
Nice! I've marked this task as done:
  [E][X] pitch (from: tmr to: 21 aug 2026 0000)
____________________________________________________________
____________________________________________________________
OK, I've marked this task as not done yet:
  [E][ ] pitch (from: tmr to: 21 aug 2026 0000)
____________________________________________________________
____________________________________________________________
 1. [T][ ] fun stuff
 2. [D][ ] homework (by: Thurs)
 3. [E][ ] pitch (from: tmr to: 21 aug 2026 0000)
____________________________________________________________
____________________________________________________________
A todo should include a description of the task. Example usage: todo <description>
____________________________________________________________
____________________________________________________________
A deadline should include a description and a due date. Example usage: deadline <description> /by <date> (supports: dd MMM yyyy[ hhmm], dd/MM/yyyy[ hhmm], dd-MM-yyyy[ hhmm])
____________________________________________________________
____________________________________________________________
An event should include a description, a start date and end date. Example usage: event <description> /from <date> /to <date> (supports: dd MMM yyyy[ hhmm], dd/MM/yyyy[ hhmm], dd-MM-yyyy[ hhmm])
____________________________________________________________
____________________________________________________________
 1. [T][ ] fun stuff
 2. [D][ ] homework (by: Thurs)
 3. [E][ ] pitch (from: tmr to: 21 aug 2026 0000)
____________________________________________________________

## Test Case 13

aim: Test deleting a task
inputs:
- todo read book
- deadline homework /by Sunday
- event meeting /from Mon 2pm /to 4pm
- list
- delete 2
- list
- mark 2
- list
expected_output:
____________________________________________________________
 ____    _    ____ __   __
| __ )  / \  | __ )\ \ / /
|  _ \ / _ \ |  _ \ \ V /
| |_) / ___ \| |_) | | |
|____/_/   \_\____/  |_|

Hello! I'm Baby.
What can I do for you?
____________________________________________________________
____________________________________________________________
Got it. I've added this task:
  [T][ ] read book
Now you have 1 tasks in the list.
____________________________________________________________
____________________________________________________________
Got it. I've added this task:
  [D][ ] homework (by: 23 aug 2026 0000)
Now you have 2 tasks in the list.
____________________________________________________________
____________________________________________________________
Got it. I've added this task:
  [E][ ] meeting (from: 24 aug 2026 0000 to: 4pm)
Now you have 3 tasks in the list.
____________________________________________________________
____________________________________________________________
 1. [T][ ] read book
 2. [D][ ] homework (by: 23 aug 2026 0000)
 3. [E][ ] meeting (from: 24 aug 2026 0000 to: 4pm)
____________________________________________________________
____________________________________________________________
OK, I've deleted this task:
  [D][ ] homework (by: 23 aug 2026 0000)
Now you have 2 tasks in the list.
____________________________________________________________
____________________________________________________________
 1. [T][ ] read book
 2. [E][ ] meeting (from: 24 aug 2026 0000 to: 4pm)
____________________________________________________________
____________________________________________________________
Nice! I've marked this task as done:
  [E][X] meeting (from: 24 aug 2026 0000 to: 4pm)
____________________________________________________________
____________________________________________________________
 1. [T][ ] read book
 2. [E][X] meeting (from: 24 aug 2026 0000 to: 4pm)
____________________________________________________________

## Test Case 14

aim: Test delete without arguments showing usage
inputs:
- delete
- list
expected_output:
____________________________________________________________
 ____    _    ____ __   __
| __ )  / \  | __ )\ \ / /
|  _ \ / _ \ |  _ \ \ V /
| |_) / ___ \| |_) | | |
|____/_/   \_\____/  |_|

Hello! I'm Baby.
What can I do for you?
____________________________________________________________
____________________________________________________________
A delete command should include a task number. Example usage: delete <task-number>
____________________________________________________________
____________________________________________________________
____________________________________________________________

## Test Case 15

aim: Test delete with invalid index values
inputs:
- todo read book
- delete 0
- delete -1
- delete abc
- list
- delete 10
expected_output:
____________________________________________________________
 ____    _    ____ __   __
| __ )  / \  | __ )\ \ / /
|  _ \ / _ \ |  _ \ \ V /
| |_) / ___ \| |_) | | |
|____/_/   \_\____/  |_|

Hello! I'm Baby.
What can I do for you?
____________________________________________________________
____________________________________________________________
Got it. I've added this task:
  [T][ ] read book
Now you have 1 tasks in the list.
____________________________________________________________
____________________________________________________________
Invalid index: 0. Valid range: 1-1. You have 1 tasks.
____________________________________________________________
____________________________________________________________
Invalid index: -1. Valid range: 1-1. You have 1 tasks.
____________________________________________________________
____________________________________________________________
Invalid index: abc. Valid range: 1-1. You have 1 tasks.
____________________________________________________________
____________________________________________________________
 1. [T][ ] read book
____________________________________________________________
____________________________________________________________
Task 10 not found. Valid range: 1-1. You have 1 tasks.
____________________________________________________________

## Test Case 16

aim: Test deadline date formats - all formats should store as dd MMM yyyy hhmm
inputs:
- deadline task1 /by 12 Oct 2025
- deadline task2 /by Oct 12 2025 0900
- deadline task3 /by 12/10/2025
- deadline task4 /by 12-10-2025 1430
- list
expected_output:
____________________________________________________________
 ____    _    ____ __   __
| __ )  / \  | __ )\ \ / /
|  _ \ / _ \ |  _ \ \ V /
| |_) / ___ \| |_) | | |
|____/_/   \_\____/  |_|

Hello! I'm Baby.
What can I do for you?
____________________________________________________________
____________________________________________________________
Got it. I've added this task:
  [D][ ] task1 (by: 12 oct 2025 0000)
Now you have 1 tasks in the list.
____________________________________________________________
____________________________________________________________
Got it. I've added this task:
  [D][ ] task2 (by: 12 oct 2025 0900)
Now you have 2 tasks in the list.
____________________________________________________________
____________________________________________________________
Got it. I've added this task:
  [D][ ] task3 (by: 12 oct 2025 0000)
Now you have 3 tasks in the list.
____________________________________________________________
____________________________________________________________
Got it. I've added this task:
  [D][ ] task4 (by: 12 oct 2025 1430)
Now you have 4 tasks in the list.
____________________________________________________________
____________________________________________________________
 1. [D][ ] task1 (by: 12 oct 2025 0000)
 2. [D][ ] task2 (by: 12 oct 2025 0900)
 3. [D][ ] task3 (by: 12 oct 2025 0000)
 4. [D][ ] task4 (by: 12 oct 2025 1430)
____________________________________________________________

## Test Case 17

aim: Test event date formats with different input styles
inputs:
- event meeting /from 12/10/2025 0900 /to 13/10/2025 1700
- event workshop /from Oct 20 2025 /to 21 Oct 2025 1800
- event conference /from 25-10-2025 /to 26-10-2025
- list
expected_output:
____________________________________________________________
 ____    _    ____ __   __
| __ )  / \  | __ )\ \ / /
|  _ \ / _ \ |  _ \ \ V /
| |_) / ___ \| |_) | | |
|____/_/   \_\____/  |_|

Hello! I'm Baby.
What can I do for you?
____________________________________________________________
____________________________________________________________
Got it. I've added this task:
  [E][ ] meeting (from: 12 oct 2025 0900 to: 13 oct 2025 1700)
Now you have 1 tasks in the list.
____________________________________________________________
____________________________________________________________
Got it. I've added this task:
  [E][ ] workshop (from: 20 oct 2025 0000 to: 21 oct 2025 1800)
Now you have 2 tasks in the list.
____________________________________________________________
____________________________________________________________
Got it. I've added this task:
  [E][ ] conference (from: 25 oct 2025 0000 to: 26 oct 2025 0000)
Now you have 3 tasks in the list.
____________________________________________________________
____________________________________________________________
 1. [E][ ] meeting (from: 12 oct 2025 0900 to: 13 oct 2025 1700)
 2. [E][ ] workshop (from: 20 oct 2025 0000 to: 21 oct 2025 1800)
 3. [E][ ] conference (from: 25 oct 2025 0000 to: 26 oct 2025 0000)
____________________________________________________________
