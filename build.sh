#!/bin/bash

# Define source and output directories
SRC_DIR="src"
BIN_DIR="bin"

# Create the bin directory if it doesn't exist
mkdir -p $BIN_DIR

# Compile all Java files
javac -d $BIN_DIR $(find $SRC_DIR -name '*.java')

# Instructions to run the main program
echo "Build completed."
echo "To run the program, use the following command:"
echo "java -cp $BIN_DIR Main"