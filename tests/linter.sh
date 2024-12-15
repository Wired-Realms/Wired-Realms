#!/bin/bash

# Define the directory or files to check
# Here we check all `.java` files in the `src` folder. Adjust as needed.
DIRECTORY="../src"
FILE_EXTENSION="java"  # Change to check other types (e.g., "py" for Python files)

# Find files with trailing whitespace and list them
echo "Checking for coding style issues in *.$FILE_EXTENSION files within $DIRECTORY..."
echo ""

# Flag to indicate if any issues were found
found_trailing_whitespace=false
found_paranthesys_issue=false
found_issue=false

# Loop through each file and check for trailing whitespaces
while IFS= read -r file; do

    # Check for trailing whitespaces in each file
    if grep -Hn "[[:blank:]]$" "$file"; then
        found_trailing_whitespace=true
        found_issue=true
    fi

    # Check for missing space between method declaration and {
    if grep -Hn "(*){" "$file"; then
	    found_paranthesys_issue=true
        found_issue=true
    fi
    if [ "$found_trailing_whitespace" = true ]; then
        echo "Trailing whitespaces found! Please fix the issues above."
    fi

    if [ "$found_paranthesys_issue" = true ]; then
        echo "No space between method declaration and {"
    fi
done < <(find "$DIRECTORY" -type f -name "*.$FILE_EXTENSION")

if [ "$found_issue" = false ]; then
    echo "No coding style issues found. Great job!"
fi

# Print result based on whether issues were found
#if [ "$found_trailing_whitespace" = true ]; then
#    echo "Trailing whitespaces found! Please fix the issues above."
#fi

#if [ "$found_paranthesys_issue" = true ]; then
#    echo "No space between method declaration and {"
#fi
