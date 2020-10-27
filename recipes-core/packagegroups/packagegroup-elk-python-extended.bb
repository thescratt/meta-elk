SUMMARY = "Extended python packages deployed in Elk Audio OS devices"
HOMEPAGE = "https://github.com/elk-audio/meta-elk"
LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

inherit packagegroup

RDEPENDS_packagegroup-elk-python-extended = "\
    python3-six \
    python3-setuptools \
    python3-pyftdi \
    python3-smbus2 \
    python3-elkpy \
    python3-werkzeug \
    python3-requests \
    python3-apscheduler \
    python3-json-rpc \
    python3-pytz \
"
