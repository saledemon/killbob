#! /usr/bin/env python
import os
import sys

path=sys.path[0]

to_trim = ""
log=f'{path}/mvn.log'
pom=f'{path}/pom.xml'
jar=f'{path}/target/killbob.jar'

def pathToTrim():
	global to_trim
	src_path=f'{path}/src/main/java/'
	previous = 0
	for idx, s in enumerate(src_path):
		if s == "/":
			to_trim += src_path[previous:idx] + '\\/'
			previous=idx+1

def execute():
	pathToTrim()

	mvn=f'(mvn -f {pom} clean ; mvn -f {pom} package) > {log}'
	build_fail=f'(grep \'\.java\' {log}  | grep -Fv \'INFO\' | sort | uniq | sed \'s/{to_trim}//\' ; echo "\n============\n")'
	jarx=f'java -jar {jar}'

	os.system(mvn)
	os.system(build_fail)
	os.system(jarx)

execute()