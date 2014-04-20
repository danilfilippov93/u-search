# -*- makefile -*-
TARGET:=cppsocketstest
SOURCES=cppsocketstest.cpp main.cpp
HEADERS=cppsocketstest.h
LIBS+=-lcppunit -lcppsockets

include ../../config.mk

$(TARGET): $(OBJECTS)
	mkdir -p $(DESTDIR)/test
	$(CC) $(CFLAGS) $(INCLUDEPATH) $(DEFINES) -o $(DESTDIR)/test/cppsocketstest $(OBJECTS) $(LIBS)

clean:
	$(RM) *.o *.d *.gcov *.gcda *.gcno
