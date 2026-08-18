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
Invalid command. Valid commands: todo, deadline, event, list, mark, unmark, bye
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
  [D][ ] return book (by: Sunday)
Now you have 2 tasks in the list.
____________________________________________________________
____________________________________________________________
Got it. I've added this task:
  [E][ ] project meeting (from: Mon 2pm to: 4pm)
Now you have 3 tasks in the list.
____________________________________________________________
____________________________________________________________
 1. [T][ ] read book
 2. [D][ ] return book (by: Sunday)
 3. [E][ ] project meeting (from: Mon 2pm to: 4pm)
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
  [D][ ] return book (by: Sunday)
Now you have 2 tasks in the list.
____________________________________________________________
____________________________________________________________
Got it. I've added this task:
  [E][ ] project meeting (from: Mon 2pm to: 4pm)
Now you have 3 tasks in the list.
____________________________________________________________
____________________________________________________________
Nice! I've marked this task as done:
  [D][X] return book (by: Sunday)
____________________________________________________________
____________________________________________________________
Nice! I've marked this task as done:
  [E][X] project meeting (from: Mon 2pm to: 4pm)
____________________________________________________________
____________________________________________________________
 1. [T][ ] read book
 2. [D][X] return book (by: Sunday)
 3. [E][X] project meeting (from: Mon 2pm to: 4pm)
____________________________________________________________
____________________________________________________________
OK, I've marked this task as not done yet:
  [D][ ] return book (by: Sunday)
____________________________________________________________
____________________________________________________________
OK, I've marked this task as not done yet:
  [E][ ] project meeting (from: Mon 2pm to: 4pm)
____________________________________________________________
____________________________________________________________
 1. [T][ ] read book
 2. [D][ ] return book (by: Sunday)
 3. [E][ ] project meeting (from: Mon 2pm to: 4pm)
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
A deadline should include a description and a due date. Example usage: deadline <description> /by <date>
____________________________________________________________
____________________________________________________________
An event should include a description, a start date and end date. Example usage: event <description> /from <start-date> /to <end-date>
____________________________________________________________
____________________________________________________________
____________________________________________________________
