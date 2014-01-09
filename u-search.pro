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
    servers.dat     \
    database.dat    \
    README          \
    config.mk       \
    Makefile        \
    AUTHORS
