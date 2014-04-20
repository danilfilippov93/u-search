# -*- makefile -*-
TARGET:=u-search
include config.mk

libcppsockets:
	+cd $(SRCDIR)/cppsockets && $(MAKE)

spider: copyfiles libdata_storage
	+cd $(SRCDIR)/spider && $(MAKE)

scheduler:
	+cd $(SRCDIR)/scheduler && $(MAKE)

libdata_storage:
	+cd $(SRCDIR)/data-storage && $(MAKE)

core: libcppsockets libdata_storage spider scheduler

test: core
	+cd $(SRCDIR)/test && $(MAKE)

copyfiles:
	mkdir -p $(DESTDIR)/etc/u-search
	if [ ! -e $(DESTDIR)/etc/u-search/database.conf ]; \
	then cp config/database.conf $(DESTDIR)/etc/u-search; fi
	if [ ! -e $(DESTDIR)/etc/u-search/servers.conf ]; \
	then cp config/servers.conf $(DESTDIR)/etc/u-search; fi
	if [ ! -e $(DESTDIR)/etc/u-search/spider.conf ]; \
	then cp config/spider.conf $(DESTDIR)/etc/u-search; fi

$(TARGET): test doc

doc:
	cd $(SRCDIR)/doc && $(MAKE)

help:
	@echo Available modules: libcppsockets spider libdata_storage test copyfiles doc
	@echo Debug mode: DEBUG=yes
	@echo Test coverage: TEST_COVERAGE=yes
	@echo Show build commands: VERBOSE=yes

clobber:
	$(RM) $(SRCDIR)/build

clean:
	cd $(SRCDIR)/spider && make clean
	cd $(SRCDIR)/scheduler && make clean
	cd $(SRCDIR)/cppsockets && make clean
	cd $(SRCDIR)/data-storage && make clean
	cd $(SRCDIR)/test && make clean
	cd $(SRCDIR)/doc && make clean

.PHONY: help doc spider scheduler copyfiles libdata_storage libcppsockets test clobber
