#makefilebegins
JFLAGS = -g
JC = javac
JVM = java
FILE =

.SUFFIXES: .java .class

.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
    	Cuenta.java \
    	CuentaCorriente.java \
    	CuentaDeAhorro.java \
    	CuentaVista.java \
    	DepósitoAPlazo.java \
		FondoMutuo.java \
		FormaDeAhorro.java \
		ReadFile.java \
		Tarjeta.java 

MAIN = ReadFile

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class

jar: $(CLASSES:.java=.class)
	jar cvf jabank.jar $(CLASSES:.java=.class)
