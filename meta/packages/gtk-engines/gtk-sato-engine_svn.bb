SECTION = "x11/base"
DESCRIPTION = "Sato theme engine for GTK"
LICENSE = "LGPL"
DEPENDS = "gtk+"
PV = "0.0+svn${SRCDATE}"

SRCDATE="20061221"

SRC_URI = "svn://svn.o-hand.com/repos/sato/trunk;module=gtk-engine;proto=http"
S = "${WORKDIR}/gtk-engine"

PACKAGES += "gtk-engine-sato"
FILES_${PN} = "${libdir}/gtk-2.0/*/engines/*.so"
FILES_${PN}-dev = "${libdir}/gtk-2.0/*/engines/*"

inherit autotools  pkgconfig

do_configure_prepend() {
	for i in `ls gtk-common`; do
		ln -sf ../gtk-common/$i gtk2-engine/$i
	done
}

