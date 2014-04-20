# -*- makefile -*-
TARGET:=libdata_storage
SOURCES = entities.cpp
HEADERS = entities.h

include ../config.mk

LIBS+=-lmysqlclient -lmysqlpp

$(TARGET): $(OBJECTS)
	mkdir -p $(DESTDIR)/lib
	$(CC) $(CFLAGS) $(INCLUDEPATH) $(DEFINES) -shared -o $(DESTDIR)/lib/libdata_storage.so $(OBJECTS) $(LIBS)

clean:
	$(RM) *.o *.d *.gcov *.gcda *.gcno
