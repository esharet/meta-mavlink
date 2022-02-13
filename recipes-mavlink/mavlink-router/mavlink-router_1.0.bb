DESCRIPTION = "Route Mavlink packets between endpoints"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=93888867ace35ffec2c845ea90b2e16b"

SRC_URI = "gitsm://github.com/mavlink-router/mavlink-router.git;protocol=https"
SRCREV = "3d6600153ebee0650b94f336afe1d5bb0701bf0d"
SRC_URI += "file://mavlink-routerd.sh"
SRC_URI += "file://0001-remove-systemd-dep.patch"
SRC_URI += "file://main.conf"

S = "${WORKDIR}/git"
PR = "r2"

inherit autotools meson python3native pkgconfig 

#PACKAGECONFIG ??= "${@bb.utils.filter('DISTRO_FEATURES', 'systemd', d)}"
#PACKAGECONFIG[systemd] = "--enable-systemd --with-systemdsystemunitdir=${systemd_unitdir}/system/,--disable-systemd"

do_install_append () {
    install -D -m 0755 ${WORKDIR}/mavlink-routerd.sh ${D}${sysconfdir}/init.d/mavlink-routerd.sh

    install -d ${D}${sysconfdir}/mavlink-router/config.d
    install -m 0644 ${WORKDIR}/main.conf ${D}${sysconfdir}/mavlink-router/main.conf

    install -d ${D}/var/lib/mavlink-router/
}

# we don't want to remove init script to retain backward compatibility since this is
# called from external scripts
python rm_sysvinit_initddir (){
}

DEPENDS = "python3 python3-future"
#SYSTEMD_SERVICE_${PN} = "mavlink-router.service"
