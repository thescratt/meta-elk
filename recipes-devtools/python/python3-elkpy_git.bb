SUMMARY = "A simple wrapper for controlling sushi over gRPC via a python script"
HOMEPAGE = "https://github.com/elk-audio/elkpy"
SECTION = "devel/python"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=e49f4652534af377a713df3d9dec60cb"

SRC_URI = "git://github.com/elk-audio/elkpy;protocol=https;nobranch=1"
SRCREV = "91e178596252d1998892c546dd086982f85be831"

S = "${WORKDIR}/git"

inherit setuptools3

RDEPENDS_${PN} = "\
    sushi \
    python3-grpcio \
    python3-grpcio-tools \
    python3-protobuf \
    liberation-fonts \
"
do_install_append(){
    rm -r ${D}${PYTHON_SITEPACKAGES_DIR}/tests
}

BBCLASSEXTEND = "native nativesdk"
