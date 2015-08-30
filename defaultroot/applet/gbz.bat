@echo off
set JKS_PATH=D:\cruisecontrol-bin-2.4.1-A6\projects\A6\Êý×ÖÇ©Ãû\ufgov.jks
set JAVA_HOME=c:\jdk1.6.0
set PATH=%JAVA_HOME%\bin;%PATH% 
cd D:\cruisecontrol-bin-2.4.1-52\projects\GB53\target\defaultroot\applet
@echo del /s /q .pack.gz
for %%i in (*.jar) do zip -q -d %%i META-INF/*.DSA META-INF/*.SF META-INF/*.RSA
@echo 2
for %%i in (*.jar) do pack200 --repack %%i
@echo 3
for %%i in (*.jar) do jarsigner -storepass 111111 -keystore %JKS_PATH% %%i ufgov
@echo 2
for %%i in (*.jar) do pack200 --repack %%i
@echo 3
for %%i in (*.jar) do jarsigner -storepass 111111 -keystore %JKS_PATH% %%i ufgov
@echo 4
for %%i in (*.jar) do pack200 %%i.pack.gz %%i
@echo 5
@echo del /s /q *.jar

set JAVA_HOME=C:\bea\jdk142_11
set PATH=%JAVA_HOME%\bin;%PATH% 