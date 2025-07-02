.PHONY: build test

build:
	mvn clean install

test:
	mvn test