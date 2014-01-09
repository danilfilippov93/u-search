# -*- makefile -*-
TARGET:=serverqueuetest
SOURCES=serverqueuetest.cpp main.cpp $(SRCDIR)/scheduler/serverqueue.cpp
HEADERS=serverqueuetest.h
LIBS+=-lcppunit

include ../../config.mk

$(TARGET): $(OBJECTS)
	mkdir -p $(DESTDIR)/test
	$(CC) $(CFLAGS) $(INCLUDEPATH) $(DEFINES) -o $(DESTDIR)/test/serverqueuetest $(OBJECTS) $(LIBS)

clean:
	rm -rf $(DESTDIR)/test/serverqueuetest *.o *.d *.gcov *.gcda *.gcno
