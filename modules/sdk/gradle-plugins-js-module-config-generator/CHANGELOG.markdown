# Liferay Gradle Plugins JS Module Config Generator Change Log

## 1.0.1 - 2015-07-23

### Dependencies
- [LPS-51081]: Update the com.liferay.gradle.util dependency to version 1.0.14.

## 1.0.3 - 2015-08-18

### Dependencies
- [LPS-51081]: Update the com.liferay.gradle.util dependency to version 1.0.17.
- [LPS-51081]: Update the com.liferay.gradle.util dependency to version 1.0.16.
- [LPS-51081]: Update the com.liferay.gradle.util dependency to version 1.0.15.

## 1.0.4 - 2015-08-25

### Commits
- [LPS-51081]: Update "gradle-plugins-js-module-config-generator" to use
"gradle-plugins-node" (a90cd02ccd)

### Dependencies
- [LPS-51081]: Update the com.liferay.gradle.plugins.node dependency to version
1.0.0.

## 1.0.5 - 2015-08-31

### Dependencies
- [LPS-58260]: Update the com.liferay.gradle.plugins.node dependency to version
1.0.1.

## 1.0.7 - 2015-09-08

### Dependencies
- [LPS-58467]: Update the com.liferay.gradle.plugins.node dependency to version
1.0.2.

## 1.0.8 - 2015-09-09

### Dependencies
- [LPS-58467]: Update the com.liferay.gradle.plugins.node dependency to version
1.0.3.

## 1.0.9 - 2015-09-14

### Dependencies
- [LPS-58609]: Update the com.liferay.gradle.plugins.node dependency to version
1.0.4.

## 1.0.10 - 2015-09-15

### Dependencies
- [LPS-58655]: Update the com.liferay.gradle.plugins.node dependency to version
1.0.5.

## 1.0.11 - 2015-09-17

### Dependencies
- [LPS-58655]: Update the com.liferay.gradle.plugins.node dependency to version
1.0.6.

## 1.0.15 - 2015-12-21

### Dependencies
- [LPS-61527]: Update the com.liferay.gradle.plugins.node dependency to version
1.0.9.

## 1.0.16 - 2016-01-12

### Dependencies
- [LPS-61754]: Update the com.liferay.gradle.plugins.node dependency to version
1.0.10.

## 1.0.17 - 2016-01-26

### Dependencies
- [LPS-62504]: Update the com.liferay.gradle.plugins.node dependency to version
1.0.11.

## 1.0.18 - 2016-01-28

### Dependencies
- [LPS-62671]: Update the com.liferay.gradle.plugins.node dependency to version
1.0.12.

## 1.0.20 - 2016-03-18

### Commits
- [LPS-63943]: This is done automatically now (f1e42382d9)
- [LPS-62883]: Update gradle-plugins/build.gradle (20fc2457e6)

## 1.0.22 - 2016-04-21

### Dependencies
- [LPS-65245]: Update the com.liferay.gradle.plugins.node dependency to version
1.0.13.

## 1.0.23 - 2016-06-07

### Dependencies
- [LPS-66410]: Update the com.liferay.gradle.plugins.node dependency to version
1.0.14.

## 1.0.24 - 2016-06-09

### Dependencies
- [LPS-66410]: Update the com.liferay.gradle.plugins.node dependency to version
1.0.15.

## 1.0.25 - 2016-07-01

### Dependencies
- [LPS-65749]: Update the com.liferay.gradle.plugins.node dependency to version
1.0.16.

## 1.0.26 - 2016-08-01

### Dependencies
- [LPS-66906]: Update the com.liferay.gradle.plugins.node dependency to version
1.0.17.

## 1.0.27 - 2016-08-05

### Dependencies
- [LPS-66906]: Update the com.liferay.gradle.plugins.node dependency to version
1.0.18.

## 1.0.28 - 2016-08-09

### Dependencies
- [LPS-66906]: Update the com.liferay.gradle.plugins.node dependency to version
1.0.19.

## 1.0.29 - 2016-08-11

### Dependencies
- [LPS-67544]: Update the com.liferay.gradle.plugins.node dependency to version
1.0.20.

## 1.0.30 - 2016-08-15

### Dependencies
- [LPS-66906]: Update the com.liferay.gradle.plugins.node dependency to version
1.0.21.

## 1.0.31 - 2016-08-27

### Commits
- [LPS-67658]: Configure GradleTest in gradle-plugins-js-module-config-generator
(15749d4b1f)
- [LPS-67658]: Need "compileOnly" to keep dependencies out of "compile"
(4a3cd0bc9d)
- [LPS-67658]: These plugins must work with Gradle 2.5+ (5b963e363d)

### Dependencies
- [LPS-67023]: Update the com.liferay.gradle.plugins.node dependency to version
1.0.22.

## 2.0.0 - 2016-09-20

### Dependencies
- [LPS-67653]: Update the com.liferay.gradle.plugins.node dependency to version
1.1.0.

### Description
- [LPS-67573]: Make most methods private in order to reduce API surface.

## 2.0.1 - 2016-10-03

### Commits
- [LPS-68231]: Test plugins with Gradle 3.1 (49ec4cdbd8)

### Description
- [LPS-68485]: The up-to-date check for `ConfigJSModulesTask` tasks is incorrect
(files are modified in-place) and it has been disabled.

## 2.0.2 - 2016-10-06

### Dependencies
- [LPS-68564]: Update the com.liferay.gradle.plugins.node dependency to version
1.2.0.

## 2.0.3 - 2016-10-10

### Description
- [LPS-68618]: All `ConfigJSModulesTask` instances now depend on `npmInstall`.

## 2.0.4 - 2016-10-21

### Dependencies
- [LPS-66906]: Update the com.liferay.gradle.plugins.node dependency to version
1.3.0.

## 2.1.0 - 2016-11-03

### Description
- [LPS-68298]: Add property `customDefine` to all tasks that extend
`ConfigJSModulesTask` in order to use custom `define(...)` calls in the JS
files.

## 2.1.1 - 2016-11-04

### Description
- [LPS-68298]: Replace `define(...)` calls only at the beginning of a line, or
with if preceded by spaces or tabs.

## 2.1.2 - 2016-11-29

### Commits
- [LPS-69259]: Test plugins with Gradle 3.2.1 (72873ed836)
- [LPS-69259]: Test plugins with Gradle 3.2 (dec6105d3d)

### Dependencies
- [LPS-69445]: Update the com.liferay.gradle.plugins.node dependency to version
1.4.0.

## 2.1.3 - 2016-12-08

### Dependencies
- [LPS-69618]: Update the com.liferay.gradle.plugins.node dependency to version
1.4.1.

## 2.1.4 - 2016-12-14

### Dependencies
- [LPS-69677]: Update the com.liferay.gradle.plugins.node dependency to version
1.4.2.

## 2.1.5 - 2016-12-21

### Dependencies
- [LPS-69802]: Update the com.liferay.gradle.plugins.node dependency to version
1.5.0.

## 2.1.6 - 2016-12-29

### Dependencies
- [LPS-69920]: Update the com.liferay.gradle.plugins.node dependency to version
1.5.1.

## 2.1.7 - 2017-02-09

### Commits
- [LPS-70060]: Test plugins with Gradle 3.3 (09bed59a42)

### Dependencies
- [LPS-69920]: Update the com.liferay.gradle.plugins.node dependency to version
1.5.2.

## 2.1.8 - 2017-02-23

### Dependencies
- [LPS-70819]: Update the com.liferay.gradle.plugins.node dependency to version
2.0.0.

## 2.1.9 - 2017-03-08

### Description
- [LPS-68405]: Change the default value of the `ConfigJSModulesTask`'s
`customDefine` property to `Liferay.Loader`.
- [LPS-68405]: Leverage the new `--namespace` argument to replace the
`define(...)` calls.
- [LPS-68405]: Update the default version of `liferay-module-config-generator`
to 1.2.1.

## 2.1.10 - 2017-03-09

### Dependencies
- [LPS-70634]: Update the com.liferay.gradle.plugins.node dependency to version
2.0.1.

## 2.1.11 - 2017-03-13

### Dependencies
- [LPS-71222]: Update the com.liferay.gradle.plugins.node dependency to version
2.0.2.

## 2.1.12 - 2017-04-11

### Dependencies
- [LPS-71826]: Update the com.liferay.gradle.plugins.node dependency to version
2.1.0.

## 2.1.13 - 2017-04-25

### Dependencies
- [LPS-72152]: Update the com.liferay.gradle.plugins.node dependency to version
2.2.0.

## 2.1.14 - 2017-05-03

### Dependencies
- [LPS-72340]: Update the com.liferay.gradle.plugins.node dependency to version
2.2.1.

## 2.1.15 - 2017-07-07

### Dependencies
- [LPS-73472]: Update the com.liferay.gradle.plugins.node dependency to version
2.3.0.

## 2.1.16 - 2017-07-17

### Dependencies
- [LPS-73472]: Update the com.liferay.gradle.plugins.node dependency to version
3.0.0.

## 2.1.17 - 2017-08-24

### Description
- [LPS-74343]: Explicitly set the `ConfigJSModulesTask`'s `sourceDir` property
as required.

## 2.1.18 - 2017-08-29

### Dependencies
- [LPS-73070]: Update the com.liferay.gradle.plugins.node dependency to version
3.1.0.

## 2.1.19 - 2017-09-18

### Dependencies
- [LPS-74770]: Update the com.liferay.gradle.plugins.node dependency to version
3.1.1.

## 2.1.20 - 2017-09-28

### Dependencies
- [LPS-74933]: Update the com.liferay.gradle.plugins.node dependency to version
3.2.0.

## 2.1.21 - 2017-10-10

### Dependencies
- [LPS-75175]: Update the com.liferay.gradle.plugins.node dependency to version
3.2.1.

## 2.1.22 - 2017-11-20

### Dependencies
- [LPS-75965]: Update the com.liferay.gradle.plugins.node dependency to version
4.0.0.

## 2.1.23 - 2018-01-02

### Dependencies
- [LPS-74904]: Update the com.liferay.gradle.plugins.node dependency to version
4.0.1.

## 2.1.24 - 2018-01-17

### Commits
- [LPS-76644]: Enable Gradle plugins publishing (8bfdfd53d7)

### Dependencies
- [LPS-76644]: Update the com.liferay.gradle.plugins.node dependency to version
4.0.2.

## 2.1.25 - 2018-02-08

### Dependencies
- [LPS-69802]: Update the com.liferay.gradle.plugins.node dependency to version
4.1.0.

## 2.1.26 - 2018-02-13

### Dependencies
- [LPS-77996]: Update the com.liferay.gradle.plugins.node dependency to version
4.2.0.

## 2.1.27 - 2018-03-15

### Commits
- [LPS-77425]: Partial revert of d25f48516a9ad080bcbd50e228979853d3f2dda5
(60d3a950d6)
- [LPS-77425]: Increment all major versions (d25f48516a)

### Dependencies
- [LPS-78741]: Update the com.liferay.gradle.plugins.node dependency to version
4.3.0.
- [LPS-77425]: Update the com.liferay.gradle.plugins.node dependency to version
4.2.0.

## 2.1.28 - 2018-03-22

### Dependencies
- [LPS-78741]: Update the com.liferay.gradle.plugins.node dependency to version
4.3.1.

## 2.1.29 - 2018-03-30

### Dependencies
- [LPS-78741]: Update the com.liferay.gradle.plugins.node dependency to version
4.3.2.

## 2.1.30 - 2018-04-05

### Dependencies
- [LPS-78741]: Update the com.liferay.gradle.plugins.node dependency to version
4.3.3.

## 2.1.31 - 2018-05-07

### Dependencies
- [LPS-75530]: Update the com.liferay.gradle.plugins.node dependency to version
4.3.4.

## 2.1.32 - 2018-06-08

### Dependencies
- [LPS-82310]: Update the com.liferay.gradle.plugins.node dependency to version
4.3.5.

## 2.1.33 - 2018-06-22

### Dependencies
- [LPS-82568]: Update the com.liferay.gradle.plugins.node dependency to version
4.4.0.

## 2.1.34 - 2018-10-03

### Commits
- [LPS-71117]: Test plugins with Gradle up to 3.5.1 (c3e12d1cf3)

### Dependencies
- [LPS-85959]: Update the com.liferay.gradle.plugins.node dependency to version
4.4.1.

## 2.1.35 - 2018-10-09

### Dependencies
- [LPS-85959]: Update the com.liferay.gradle.plugins.node dependency to version
4.4.2.

## 2.1.36 - 2018-10-22

### Dependencies
- [LPS-86576]: Update the com.liferay.gradle.plugins.node dependency to version
4.4.3.

## 2.1.37 - 2018-11-16

### Commits
- [LPS-87192]: Set the Eclipse task property gradleVersion (040b2abdee)
- [LPS-87192]: Add variable gradleVersion (no logic changes) (2f7c0b2fe4)
- [LPS-85609]: Fix for CI (test only 4.10.2) (4eed005731)
- [LPS-85609]: Test plugins up to Gradle 4.10.2 (60905bc960)
- [LPS-86589]: Test Gradle plugins from Gradle 2.14.1 to 3.5.1 (6df521a506)

### Dependencies
- [LPS-87465]: Update the com.liferay.gradle.plugins.node dependency to version
4.5.0.
- [LPS-87466]: Update the com.liferay.gradle.plugins.node dependency to version
4.4.4.

## 2.1.38 - 2019-01-07

### Commits
- [LPS-85609]: Simplify gradleTest (a8b0feff31)
- [LPS-85609]: Use Gradle 4.10.2 (9aa90f8961)

### Dependencies
- [LPS-87479]: Update the com.liferay.gradle.plugins.node dependency to version
4.6.0.
- [LPS-87466]: Update the com.liferay.gradle.plugins.node dependency to version
4.5.1.

## 2.1.39 - 2019-01-09

### Dependencies
- [LPS-88909]: Update the com.liferay.gradle.plugins.node dependency to version
4.6.1.

## 2.1.40 - 2019-01-09

### Dependencies
- [LPS-87479]: Update the com.liferay.gradle.plugins.node dependency to version
4.6.2.

## 2.1.41 - 2019-01-14

### Dependencies
- [LPS-89126]: Update the com.liferay.gradle.plugins.node dependency to version
4.6.3.

## 2.1.42 - 2019-01-16

### Dependencies
- [LPS-88909]: Update the com.liferay.gradle.plugins.node dependency to version
4.6.4.

## 2.1.43 - 2019-01-24

### Dependencies
- [LPS-89436]: Update the com.liferay.gradle.plugins.node dependency to version
4.6.5.

## 2.1.44 - 2019-02-04

### Dependencies
- [LPS-89916]: Update the com.liferay.gradle.plugins.node dependency to version
4.6.6.

## 2.1.45 - 2019-02-20

### Dependencies
- [LPS-90945]: Update the com.liferay.gradle.plugins.node dependency to version
4.6.7.

## 2.1.46 - 2019-03-20

### Dependencies
- [LPS-91967]: Update the com.liferay.gradle.plugins.node dependency to version
4.6.8.

## 2.1.47 - 2019-04-03

### Dependencies
- [LPS-93258]: Update the com.liferay.gradle.plugins.node dependency to version
4.6.9.

## 2.1.48 - 2019-04-10

### Dependencies
- [LRDOCS-6412]: Update the com.liferay.gradle.plugins.node dependency to version
4.6.10.

## 2.1.49 - 2019-04-11

### Dependencies
- [LPS-91967]: Update the com.liferay.gradle.plugins.node dependency to version
4.6.11.

## 2.1.50 - 2019-04-25

### Dependencies
- [LPS-77425]: Update the com.liferay.gradle.plugins.node dependency to version
4.6.12.

## 2.1.51 - 2019-05-01

### Dependencies
- [LPS-91967]: Update the com.liferay.gradle.plugins.node dependency to version
4.6.13.

## 2.1.52 - 2019-05-06

### Dependencies
- [LPS-91967]: Update the com.liferay.gradle.plugins.node dependency to version
4.6.14.

## 2.1.53 - 2019-05-06

### Dependencies
- [LPS-94947]: Update the com.liferay.gradle.plugins.node dependency to version
4.6.15.

## 2.1.54 - 2019-05-24

### Dependencies
- [LPS-88909]: Update the com.liferay.gradle.plugins.node dependency to version
4.6.16.

## 2.1.56 - 2019-06-10

### Dependencies
- [LPS-93220]: Update the com.liferay.gradle.plugins.node dependency to version
4.6.17.

## 2.1.57 - 2019-06-21

### Dependencies
- [LPS-96247]: Update the com.liferay.gradle.plugins.node dependency to version
4.6.18.

## 2.1.58 - 2019-08-13

### Dependencies
- [LPS-99740]: Update the com.liferay.gradle.plugins.node dependency to version
4.6.19.

## 2.1.59 - 2019-08-14

### Dependencies
- [LPS-99774]: Update the com.liferay.gradle.plugins.node dependency to version
4.7.0.

## 2.1.60 - 2019-08-19

### Dependencies
- [LPS-99977]: Update the com.liferay.gradle.plugins.node dependency to version
4.7.1.

## 2.1.61 - 2019-08-21

### Dependencies
- [LPS-100168]: Update the com.liferay.gradle.plugins.node dependency to version
4.8.0.

## 2.1.62 - 2019-08-24

### Dependencies
- [LPS-100168]: Update the com.liferay.gradle.plugins.node dependency to version
4.9.0.

## 2.1.63 - 2019-08-28

### Dependencies
- [LPS-100163]: Update the com.liferay.gradle.plugins.node dependency to version
5.0.0.

## 2.1.64 - 2019-09-16

### Dependencies
- [LRQA-52072]: Update the com.liferay.gradle.plugins.node dependency to version
5.1.0.

## 2.1.65 - 2019-09-18

### Dependencies
- [LPS-101470]: Update the com.liferay.gradle.plugins.node dependency to version
5.1.1.

## 2.1.66 - 2019-09-19

### Dependencies
- [LPS-101470]: Update the com.liferay.gradle.plugins.node dependency to version
5.1.2.

## 2.1.67 - 2019-10-16

### Dependencies
- [LPS-102367]: Update the com.liferay.gradle.plugins.node dependency to version
6.0.0.

## 2.1.68 - 2019-10-21

### Dependencies
- [LPS-102367]: Update the com.liferay.gradle.plugins.node dependency to version
6.0.1.

## 2.1.69 - 2019-10-23

### Dependencies
- [LPS-103580]: Update the com.liferay.gradle.plugins.node dependency to version
7.0.0.