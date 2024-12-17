#!/bin/bash

# Define the directory or files to check
# Here we check all `.java` files in the `src` folder. Adjust as needed.
DIRECTORY="./src"
FILE_EXTENSION="java"  # Change to check other types (e.g., "py" for Python files)

# Find files with trailing whitespace and list them
echo "Checking for coding style issues in *.$FILE_EXTENSION files within $DIRECTORY..."
echo ""

# Flag to indicate if any issues were found
#found_trailing_whitespace=false
#found_paranthesys_issue=false
found_issue=false
#found_if_for_paranthesys_issue=false
#found_no_space_parameters=false

# Loop through each file and check for issues
while IFS= read -r file; do

    # Check for trailing whitespaces in each file
    if grep -Hn "[[:blank:]]$" "$file"; then
        found_issue=true
        echo "Trailing whitespaces found! Please fix the issues above."

    fi

    # Check for more than 100 characters in each line
    if grep -Hn "^.\{100,\}$" "$file"; then
        found_issue=true
        echo "More than 100 characters in a line"

    fi

    # Check for missing space between method declaration and {
    if grep -Hn "(*){" "$file"; then
        found_issue=true
        echo "No space between method declaration and {"

    fi

    # Check for missing space between if/for and (
    if grep -Hn "if(" "$file"; then
        found_issue=true
        echo "No space between if/for and ("
    fi

    if grep -Hn "for(" "$file"; then
        found_issue=true
        echo "No space between if/for and ("
    fi

    # Check for missing space inside if/for parameters
    if grep -Hn "if ([A-Za-z.0-9]*[><]" "$file"; then
        found_issue=true
        echo "No space between if/for components"
    fi

    if grep -Hn "if ([A-Za-z.0-9]*==" "$file"; then
        found_issue=true
        echo "No space between if/for components"
    fi

    if grep -Hn "if ([A-Za-z.0-9]*!=" "$file"; then
        found_issue=true
        echo "No space between if/for components"
    fi

    if grep -Hn "if ([A-Za-z.0-9]*>=" "$file"; then
        found_issue=true
        echo "No space between if/for components"
    fi

    if grep -Hn "if ([A-Za-z.0-9]*<=" "$file"; then
        found_issue=true
        echo "No space between if/for components"
    fi

    if grep -Hn "if ([A-Za-z.0-9]*&&" "$file"; then
        found_issue=true
        echo "No space between if/for components"
    fi

    if grep -Hn "if ([A-Za-z.0-9]*||" "$file"; then
        found_issue=true
        echo "No space between if/for components"
    fi

    if grep -Hn "[<>][0-9A-Za-z.]" "$file"; then
        found_issue=true
        echo "No space between if/for components"
    fi

    if grep -Hn ">=[0-9A-Za-z.]" "$file"; then
        found_issue=true
        echo "No space between if/for components"
    fi

    if grep -Hn "<=[0-9A-Za-z.]" "$file"; then
        found_issue=true
        echo "No space between if/for components"
    fi

    if grep -Hn "==[0-9A-Za-z.]" "$file"; then
        found_issue=true
        echo "No space between if/for components"
    fi

    if grep -Hn "!=[0-9A-Za-z.]" "$file"; then
        found_issue=true
        echo "No space between if/for components"
    fi

    if grep -Hn "&&[0-9A-Za-z.]" "$file"; then
        found_issue=true
        echo "No space between if/for components"
    fi

    if grep -Hn "||[0-9A-Za-z.]" "$file"; then
        found_issue=true
        echo "No space between if/for components"
    fi

    if grep -Hn ";[A-Za-z.0-9]" "$file"; then
        found_issue=true
        echo "No space between if/for components"
    fi

    if grep -Hn "[A-Za-z.0-9]=" "$file"; then
        found_issue=true
        echo "No space between components"
    fi

    if grep -Hn "=[A-Za-z.0-9]" "$file"; then
        found_issue=true
        echo "No space between components"
    fi

    if grep -Hn "[A-Za-z.0-9]+=" "$file"; then
        found_issue=true
        echo "No space between components"
    fi

    if grep -Hn "+=[A-Za-z.0-9]" "$file"; then
        found_issue=true
        echo "No space between components"
    fi

    if grep -Hn "\-=[A-Za-z.0-9]" "$file"; then
        found_issue=true
        echo "No space between components"
    fi

    if grep -Hn "[A-Za-z.0-9]\-=" "$file"; then
        found_issue=true
        echo "No space between components"
    fi

    if grep -Hn "\*=[A-Za-z.0-9]" "$file"; then
        found_issue=true
        echo "No space between components"
    fi

    if grep -Hn "[A-Za-z.0-9]\*=" "$file"; then
        found_issue=true
        echo "No space between components"
    fi

    if grep -Hn "/=[A-Za-z.0-9]" "$file"; then
        found_issue=true
        echo "No space between components"
    fi

    if grep -Hn "[A-Za-z.0-9]/=" "$file"; then
        found_issue=true
        echo "No space between components"
    fi

    if grep -Hn "=[A-Za-z.0-9]+" "$file"; then
        found_issue=true
        echo "No space between components"
    fi

    if grep -Hn "[A-Za-z.0-9]\-[A-Za-z.0-9]" "$file"; then
        found_issue=true
        echo "No space between components"
    fi

    if grep -Hn "\-[A-Za-z.0-9]" "$file"; then
        found_issue=true
        echo "No space between components"
    fi

    if grep -Hn "+[A-Za-z.0-9]" "$file"; then
        found_issue=true
        echo "No space between components"
    fi

done < <(find "$DIRECTORY" -type f -name "*.$FILE_EXTENSION")

if [ "$found_issue" = false ]; then
    echo "No coding style issues found. Great job!"
fi