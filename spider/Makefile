# -*- makefile -*-
TARGET:=spider
HEADERS=spider.h servermanager.h
SOURCES=spider.cpp servermanager.cpp main.cpp
LIBS+=-lsmbclient -lmysqlpp -lmysqlclient -ldata_storage -lmagic

include ../config.mk

$(TARGET): $(OBJECTS)
	mkdir -p $(DESTDIR)/bin
	$(CC) $(CFLAGS) $(INCLUDEPATH) $(DEFINES) -o $(DESTDIR)/bin/spider $(OBJECTS) $(LIBS)

clean:
	rm -rf $(DESTDIR)/bin/spider *.o *.d *.gcov *.gcda *.gcno
