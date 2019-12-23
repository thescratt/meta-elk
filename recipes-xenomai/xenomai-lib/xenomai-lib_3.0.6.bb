DESCRIPTION = "Provides userspace xenomai support and libraries needed to for \
real-time applications using the xenomai RTOS implementation (3.0.6)"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://debian/copyright;md5=b845d61ada88e4a5e0df2b2b74272db7 \
                    file://kernel/cobalt/COPYING;md5=073dc31ccb2ebed70db54f1e8aeb4c33 \
                    file://kernel/cobalt/rtdm/COPYING;md5=c99f6e66e37d1cb50ad8be4f5be2ea5d \
                    file://kernel/cobalt/posix/COPYING;md5=073dc31ccb2ebed70db54f1e8aeb4c33 \
                    file://lib/trank/COPYING;md5=68ad62c64cc6c620126241fd429e68fe \
                    file://lib/copperplate/COPYING;md5=68ad62c64cc6c620126241fd429e68fe \
                    file://lib/vxworks/COPYING;md5=68ad62c64cc6c620126241fd429e68fe \
                    file://lib/cobalt/COPYING;md5=68ad62c64cc6c620126241fd429e68fe \
                    file://lib/smokey/COPYING;md5=68ad62c64cc6c620126241fd429e68fe \
                    file://lib/psos/COPYING;md5=68ad62c64cc6c620126241fd429e68fe \
                    file://lib/alchemy/COPYING;md5=68ad62c64cc6c620126241fd429e68fe \
                    file://lib/analogy/COPYING;md5=68ad62c64cc6c620126241fd429e68fe \
                    file://lib/boilerplate/COPYING;md5=68ad62c64cc6c620126241fd429e68fe \
                    file://lib/boilerplate/iniparser/LICENSE;md5=124f16654dec67923ad76a803e102463 \
                    file://include/COPYING;md5=79ed705ccb9481bf9e7026b99f4e2b0e"

UDEV_RULES_DIR = "/etc/udev/rules.d"

SRC_URI = "https://gitlab.denx.de/Xenomai/xenomai/-/archive/v${PV}/xenomai-v${PV}.tar.gz;name=xenolib"
SRC_URI[xenolib.md5sum] = "baf014ba32fd97be7512961163e40109"
SRC_URI[xenolib.sha256sum] = "79fa86c56e8a1a9715c70aaf715bc5feb7779fcabb60c158e8487027477e3424"
SRC_URI += "file://rtdm.rules"

S = "${WORKDIR}/xenomai-v${PV}"

inherit pkgconfig autotools

prefix = "/usr/xenomai"

# Specify any options you want to pass to the configure script using EXTRA_OECONF:
EXTRA_OECONF = "--enable-smp --with-core=cobalt"

do_install_append() {
    install -d ${D}${UDEV_RULES_DIR}
    install -m 0644 ${WORKDIR}/rtdm.rules ${D}${UDEV_RULES_DIR}
}
    
FILES_${PN} += "/dev"
FILES_${PN} += "/usr/xenomai/lib/*"
FILES_${PN} += "usr/xenomai/demo/*"
FILES_${PN} += "${UDEV_RULES_DIR}/*"

INSANE_SKIP_${PN} += "ldflags"

