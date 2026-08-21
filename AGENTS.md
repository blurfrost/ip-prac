# Project context

This repository is a starter template for a greenfield Java project used in an introductory software engineering course in an undergraduate computer science program. Students use it as the starting point for their own projects.

# Default user context

Unless the user says otherwise, assume that you are assisting a student working on a project in this repository. If the user identifies themselves as an instructor or another project stakeholder, adapt your response to that role.

# Student profile

* Prior knowledge: Basic Java and OOP concepts.
* Level of programming experience: 3 Years
* IDE and level of expertise: VS Code

# Guidance for interacting with users

* Explain the rationale for significant actions: what you did and why.
* Keep explanations brief but instructive, supporting learning through responsible use of AI. For example:

  * When suggesting a Git command, briefly explain what it does.
  * Add explanatory Javadoc comments to all classes and to nontrivial methods and fields when their purpose or behavior is not obvious.
  * Make generated code as self-explanatory as possible, and include explanatory comments where they improve understanding.
  * When faced with a design choice, choose the simplest option that is sufficient for the requirements, while briefly explaining relevant more advanced alternatives.

# Project-specific requirements

## Java version:

Ensure that Java 25 is used when running the application or build tasks. On macOS, use `sdk use java 25.0.3.fx-zulu` to switch to Java 25 if needed.

## Git

Use lightweight tags unless the user requests an annotated tag.
When proposing or creating a commit message, include enough detail to explain the rationale for the change.
After each prompt given, do not commit or push unless explicitly asked.

## After code updates

After each code change to the application:

1. Review the test plan at `test/ui-test-plan.md` to ensure it covers all new features and behavior changes
2. Update the test plan as needed to add test cases for new functionality
3. Run the test-ui skill to validate all tests pass:
   ```bash
   python3 .opencode/skills/test-ui/scripts/run-ui-tests.py test/ui-test-plan.md java -cp build/libs/duke.jar baby.Baby
   ```
4. Report test results and fix any failing tests
5. Compare the uncommitted changes (WORKTREE) with the most recent commit (HEAD). Use the /present-changes-visually skill to create a new `[relevant-change-name].html` file in the `_temp` folder.

The `test-ui` project-specific skill is located at `.opencode/skills/test-ui/`.

## Enums to Consider When Adding Features

When implementing new features, consider whether existing or new enums can improve the code. Enums provide type safety, make code more maintainable, and centralize configuration.

| Feature Area | Potential Enum | Notes |
|-------------|----------------|-------|
| Task types | `TaskType` | Implemented - Todo, Deadline, Event with command word, icon, and usage message |
| All commands | `CommandType` | Could replace all `input.equals()` checks in Baby.java |
| Date fields | `DateField` | For parsing `/by`, `/from`, `/to` in deadline/event commands |
| Task status | `ResponseStatus` | Could support more than done/not done (e.g., pending, in-progress, cancel) |
| Priority levels | `Priority` | Future feature for task importance levels |

**How to use this table:**
1. When adding new features, consult this table for relevant enum ideas
2. Add new enums to the table as they're implemented
3. Review the table when refactoring to identify where enums could replace magic strings
