# Makefile for running the linter test

.PHONY: linter

linter:
	@bash tests/linter.sh test

build:
	javac -d bin $(shell find src -name "*.java")

clean:
	rm -rf bin/*