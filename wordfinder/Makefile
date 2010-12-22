
all: run

run: wordfinder.scala WordFinder.class
	scala WordFinder seasginon

WordFinder.class: wordfinder.scala
	fsc -deprecation wordfinder.scala

clean:
	rm *.class
