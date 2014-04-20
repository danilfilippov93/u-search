# -*- makefile -*-
SRCDIR:= $(shell dirname $(realpath $(lastword $(MAKEFILE_LIST))))

CC:=g++

ifneq ($(VERBOSE),yes)
MAKEFLAGS += -s
endif  # VERBOSE

WARNING_FLAGS += -Wall -Wundef -Wwrite-strings -Wpointer-arith -Wformat-nonliteral  \
                 -Wextra -pedantic -Woverloaded-virtual -Wctor-dtor-privacy         \
                 -Wnon-virtual-dtor -Wold-style-cast -Wconversion -Wsign-conversion \
                 -Winit-self -Wunreachable-code -Wtype-limits
CFLAGS+=$(WARNING_FLAGS) --std=gnu++11 -D_GLIBCXX_USE_NANOSLEEP -MD

ifeq ($(DEBUG),yes)
CFLAGS+=-g -O0 -DMSS_DEBUG
DESTDIR:=$(SRCDIR)/build/debug
DEFINES+=-DMSS_DEBUG
else  # DEBUG
CFLAGS+=-O2
DESTDIR:=$(SRCDIR)/build/release
endif  # DEBUG

INCLUDEPATH+=-I$(SRCDIR)
LIBS+=-L$(DESTDIR)/lib

ifeq ($(TEST_COVERAGE),yes)
CFLAGS+=--coverage -O0 -ftest-coverage
LIBS+=-lgcov
endif  # TEST_COVERAGE

OBJECTS:=$(SOURCES:.cpp=.o)

.SUFFIXES: .cpp

.cpp.o:
	$(CC) -c $(CFLAGS) $(INCLUDEPATH) $(DEFINES) -fPIC $< -o $@

all: $(TARGET)
	@echo SUCCESS: $(TARGET)

-include *.d

.DELETE_ON_ERROR:

.PHONY: all $(TARGET) clean
