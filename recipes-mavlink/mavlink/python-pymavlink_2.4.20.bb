
SUMMARY = "Python MAVLink code"
HOMEPAGE = "https://github.com/ArduPilot/pymavlink/"
AUTHOR = " <>"
LICENSE = "LGPL-3.0"
LIC_FILES_CHKSUM = "file://setup.py;md5=d36eae6874388f8a88e51d217621c52e"

SRC_URI = "https://files.pythonhosted.org/packages/35/7d/6cae5eb8beeb4e8cbe87339902bc4aaba4ba61dca6880718972acd92b34f/pymavlink-2.4.20.tar.gz"
SRC_URI[md5sum] = "023951b8af1d15a4ce6e47796f61cce4"
SRC_URI[sha256sum] = "41d6259a50d9cd51fcb44ac6760033e858d3fcbee37b176ebeb7df29512a31f6"

S = "${WORKDIR}/pymavlink-2.4.20"

BBCLASSEXTEND = "native nativesdk"

DEPENDS = "python3-pip-native python3-wheel-native"
RDEPENDS:${PN} = "${PYTHON_PN}-future ${PYTHON_PN}-lxml"

inherit setuptools3
