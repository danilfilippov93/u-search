# -*- makefile -*-
TARGET:=libcppsockets

HEADERS = socketaddress.h	\
		  abstractsocket.h	\
		  datasocket.h		\
		  tcplistener.h		\
		  tcpsocket.h		\
		  udpsocket.h

SOURCES = socketaddress.cpp		\
		  abstractsocket.cpp	\
		  datasocket.cpp		\
		  tcplistener.cpp		\
		  tcpsocket.cpp			\
		  udpsocket.cpp			\

include ../config.mk

$(TARGET): $(OBJECTS)
	mkdir -p $(DESTDIR)/lib
	$(CC) $(CFLAGS) $(INCLUDEPATH) $(DEFINES) -shared -o $(DESTDIR)/lib/libcppsockets.so $(OBJECTS)

clean:
	$(RM) *.o *.d *.gcov *.gcda *.gcno
