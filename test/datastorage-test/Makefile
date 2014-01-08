# -*- makefile -*-
TARGET:=datastoragetest
SOURCES=datastoragetest.cpp main.cpp
HEADERS=datastoragetest.h
LIBS+=-lcppunit -lmysqlclient -lmysqlpp -ldata_storage

include ../../config.mk

$(TARGET): $(OBJECTS)
	mkdir -p $(DESTDIR)/test
	$(CC) $(CFLAGS) $(INCLUDEPATH) $(DEFINES) -o $(DESTDIR)/test/datastoragetest $(OBJECTS) $(LIBS)

clean:
	rm -rf $(DESTDIR)/test/datastoragetest *.o *.d *.gcov *.gcda *.gcno
