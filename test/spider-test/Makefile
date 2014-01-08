# -*- makefile -*-
TARGET:=spidertest
HEADERS=spidertest.h
SOURCES=spidertest.cpp main.cpp
SOURCES+=$(SRCDIR)/spider/spider.cpp
SOURCES+=$(SRCDIR)/spider/servermanager.cpp
SOURCES+=$(SRCDIR)/scheduler/schedulerserver.cpp
SOURCES+=$(SRCDIR)/scheduler/serverqueue.cpp
LIBS+=-lcppunit -lsmbclient -lmysqlpp -ldata_storage -lmagic

include ../../config.mk

$(TARGET): $(OBJECTS)
	mkdir -p $(DESTDIR)/test
	$(CC) $(CFLAGS) $(INCLUDEPATH) $(DEFINES) -o $(DESTDIR)/test/spidertest $(OBJECTS) $(LIBS)

clean:
	rm -rf $(DESTDIR)/test/spidertest *.o *.d *.gcov *.gcda *.gcno
