# Makefile for running the linter test

.PHONY: linter

linter:
	@bash tests/linter.sh test
