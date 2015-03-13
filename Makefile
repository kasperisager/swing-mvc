GITHUB_REPO="kasperisager/swing-mvc"

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

doc.deploy: doc
	cd doc && \
	git init . && \
	git add . && \
	git commit -m "Update documentation."; \
	git push "git@github.com:$(GITHUB_REPO).git" master:gh-pages --force && \
	rm -rf .git

clean:
	@rm -rf ${OUT}/
	@rm -rf ${DOC}/

.PHONY: compile run doc doc.deploy clean
