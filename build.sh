#!/bin/bash
mkdir -p out
# Find all java files and compile them
find src -name "*.java" > sources.txt
javac -d out @sources.txt
rm sources.txt

if [ $? -eq 0 ]; then
    echo "Compilation successful. Running Main..."
    java -cp out Main
else
    echo "Compilation failed."
fi
