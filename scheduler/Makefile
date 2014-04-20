# -*- makefile -*-
TARGET=scheduler
SOURCES=main.cpp schedulerserver.cpp serverqueue.cpp

include ../config.mk

$(TARGET): $(OBJECTS)
	mkdir -p $(DESTDIR)/bin
	$(CC) $(CFLAGS) $(INCLUDEPATH) $(DEFINES) -o $(DESTDIR)/bin/$(TARGET) $(OBJECTS) $(LDFLAGS)

clean:
	$(RM) *.o *.d *.gcov *.gcda *.gcno
