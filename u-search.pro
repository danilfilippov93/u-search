TEMPLATE = subdirs
SUBDIRS +=          \
    cppsockets      \
    data-storage    \
    spider          \
    scheduler       \
    test
HEADERS += common-inl.h \
           config.h
OTHER_FILES +=      \
    servers.conf    \
    database.conf   \
    spider.conf     \
    README          \
    config.mk       \
    Makefile        \
    AUTHORS
