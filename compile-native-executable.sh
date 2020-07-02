#!/usr/bin/env bash

ARTIFACT=${1}
MAIN_CLASS=${2}
VERSION=${3}

JAR="${ARTIFACT}-${VERSION}.jar"

rm -rf target
mkdir -p target/native-executable
mvn -ntp package
rm -f "$ARTIFACT"
cd target/native-executable || exit
jar -xvf ../"$JAR"
cp -R META-INF BOOT-INF/classes

LIB_PATH=$(find BOOT-INF/lib | tr '\n' ':')
CP=BOOT-INF/classes:$LIB_PATH

time native-image \
  --verbose \
  -H:EnableURLProtocols=http \
  -H:+RemoveSaturatedTypeFlows \
  -H:Name="$ARTIFACT" \
  -Dspring.native.verbose=true \
  -Dspring.native.remove-jmx-support=true \
  -Dspring.native.remove-spel-support=true \
  -Dspring.native.remove-yaml-support=true \
  -cp "$CP" "$MAIN_CLASS"
