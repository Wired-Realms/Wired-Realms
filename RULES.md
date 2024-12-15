# Commit Rules
- Before commiting anything, always run `make linter` for linter checks
- Any new feature will have its own branch
- Always pull changes from the upper branch before trying to merge commits
- Commit message will look like: `[type]: Description`
- Branches will be named: `type/name`
- Always use imperative tense
- Language: `English`

## Commit Types
- feat: Adds new functionalities
- fix: Fixes a bug
- docs: Creates or modifies a documentation
- style: Changes that do not affect the logic of the program (eg: changing a color etc.)
- refactor: Refactorings code, but does not change the logic of the program (eg: linter etc.)
- test: Adds or modifies tests

### Example
- [fix]: Repair button
- [style]: Adjust navbar alignment

## Branch Types
- feature/name
- bugfix/name
- experiment/name
- release/name
- hotfix/name

### Branch management
- When a `bug is fixed`, the related `branch is deleted`
- Release branch is created for a finished version of the program
- Hotfix branches are created from the release branches to fix small things fast

### Linter
- Lines should be shorter than `100 characters per line`
- Always live one `empty line` at the end of the program
- Keep code format uniform (eg: curly braces placement)
- Never let `trailing whitespaces`