MAIN_PKG="app"
MAIN_JAVA="app/App.java"
MAIN_CLASS="${MAIN_PKG}.App"

SRC="src"
OUT="out"
DOC="doc"

compile:
	@mkdir -p ${OUT}/
	@javac \
		-Xlint:unchecked \
		-d ${OUT}/ \
		-sourcepath ${SRC} \
		${SRC}/${MAIN_JAVA}

run: compile
	@java \
		-cp ${CLASSPATH}:${OUT}/ \
		${MAIN_CLASS}

doc: compile
	@javadoc \
		-d ${DOC}/ \
		-sourcepath ${SRC}/ \
		-subpackages ${MAIN_PKG} \
		-notimestamp \
		-nodeprecatedlist \
		-notree \
		-nohelp \
		-nonavbar

clean:
	@rm -rf ${OUT}/
	@rm -rf ${DOC}/
