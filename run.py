#! /usr/bin/env python
import os
path='/Users/Yanou/Documents/workspace/KillBob'
pom=f'{path}/pom.xml'
log=f'{path}/mvn.log'
mvn=f'(mvn -f {pom} clean ; mvn -f {pom} package)  > {path}/mvn.log'
clean_log=f'(tail -n +$(grep -n "BUILD FAILURE" {log} | cut -d: -f1) {log} ; echo "\n======================\n")'
jar=f'java -jar {path}/target/killbob.jar'
os.system(mvn)
os.system(clean_log)
os.system(jar)
kJSHDBVKAJHSDBV