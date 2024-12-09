SUMMARY = "Thread and Worker INterface for Elk Audio OS"
DESCRIPTION = "Support library for managing realtime threads and worker pools"
HOMEPAGE = "https://github.com/elk-audio/twine"

LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=e49f4652534af377a713df3d9dec60cb"

# if DISTRO features has evl, then twine depends on libevl, else it depends on xenomai-lib
DEPENDS += "\
    ${@bb.utils.contains('DISTRO_FEATURES', 'evl', 'libevl', 'xenomai-lib', d)} \
"

# The specific version should be overidden in the meta-product layers
PV = "1.0.0"

SRC_URI = "gitsm://github.com/elk-audio/twine;protocol=https;branch=develop"

# SRCREV should be mentioned in the product layer as it will be specific to that.
SRCREV = "be2191a80c83a01d211ae501af04a1acfd6cee22"

S = "${WORKDIR}/git"

inherit cmake

EXTRA_OECMAKE += "\
    -DTWINE_WITH_TESTS=FALSE \
    -DXENOMAI_BASE_DIR=${WORKDIR}/recipe-sysroot/usr/xenomai \
"

EXTRA_OECMAKE += "\
    ${@bb.utils.contains('DISTRO_FEATURES', 'evl', '-DTWINE_WITH_EVL=TRUE', '-DTWINE_WITH_XENOMAI=TRUE', d)} \
"
