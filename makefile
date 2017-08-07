SRCDIR = src
BINDIR = bin

JAVAC = javac
JFLAGS = -g -d $(BINDIR)

# define general build rule for java sources
.SUFFIXES:  .java  .class

.java.class:
	$(JAVAC)  $(JFLAGS)  $<

all:
	javac $(JFLAGS) $(SRCDIR)/*.java

clean:
	@rm -f  $(BINDIR)/*.class
	@rm -f $(BINDIR)/*/*.class
	@rm -Rf doc
